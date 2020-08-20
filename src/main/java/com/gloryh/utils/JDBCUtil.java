package com.gloryh.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MySQL连接和执行代码，手写JDBC工具类
 *
 * @author 黄光辉
 * @since 2020/8/19
 */
public class JDBCUtil {

  public static String driver;
  public static String url;
  public static String name;
  public static String password;

  /** ThreadLocal 事务专用 */
  private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
  // 仅用于加载类时执行一次的静态模块，读取连接MySQL需要的字段
  static {
    // 读取参数
    driver = LoadPropertiesUtil.getProperty("driver");
    url = LoadPropertiesUtil.getProperty("url");
    name = LoadPropertiesUtil.getProperty("name");
    password = LoadPropertiesUtil.getProperty("password");
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      System.out.println("数据库驱动加载失败");
    }
  }

  /**
   * 获取数据库连接
   *
   * @return Connection
   * @throws SQLException
   */
  public static Connection getConnection() throws SQLException {
    Connection connection = tl.get();
    if (connection == null) {
      // 事务未开启
      return DriverManager.getConnection(url, name, password);
    }
    return connection;
  }

  /**
   * 关闭数据库连接
   *
   * @param connection
   * @param statement
   * @param rs
   */
  public static void release(Connection connection, Statement statement, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        Connection conn = tl.get();
        if (conn == connection) {
          return;
        }
        try {
          if (connection != null) {
            connection.close();
          }
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  /**
   * 遍历Object，取出后存入PreparedStatement
   *
   * @param pre
   * @param params
   * @throws SQLException
   */
  private static void fillStatement(PreparedStatement pre, Object... params) throws SQLException {
    if (params != null) {
      for (int i = 0; i < params.length; i++) {
        pre.setObject(i + 1, params[i]);
      }
    }
  }

  /**
   * 将获取到的数据以列表方式存储
   *
   * @param rs
   * @return
   * @throws SQLException
   */
  private static List<Map<String, Object>> ResultSetToList(ResultSet rs) throws SQLException {
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    // 获取表结构
    ResultSetMetaData rsmd = rs.getMetaData();
    // 遍历rs读取数据放到List中
    while (rs.next()) {
      Map<String, Object> map = new HashMap<String, Object>();
      // rsmd.getColumnCount()  字段的总列数
      for (int i = 0; i <= rsmd.getColumnCount(); i++) {
        // 逐个字段读取出来放入map中,以键值形式存入，字段名：rsmd.getColumnName(i)，对应值 rs.getObject(i)
        map.put(rsmd.getColumnName(i), rs.getObject(i));
      }
      list.add(map);
    }
    return list;
  }
  // CRUD操作

  /**
   * 数据库查询操作，使用executeQuery方法
   *
   * @param sql
   * @param params
   * @return
   */
  public static List<Map<String, Object>> select(String sql, Object... params) {
    Connection connection = null;
    PreparedStatement pre = null;
    ResultSet rs = null;
    List<Map<String, Object>> list = null;
    try {
      // 1.获取数据库连接
      connection = getConnection();
      pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      fillStatement(pre, params);
      // 调用executeQuery执行查找操作
      rs = pre.executeQuery();
      list = ResultSetToList(rs);
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      release(connection, pre, rs);
    }
    return list;
  }

  /**
   * 数据库更新/删除操作，使用executeUpdate方法
   *
   * @param sql
   * @param params
   */
  private static void update(String sql, Object... params) {
    Connection connection = null;
    PreparedStatement pre = null;
    // 获取数据库连接
    try {
      connection = getConnection();
      pre = connection.prepareStatement(sql);
      fillStatement(pre, params);
      pre.executeUpdate();
    } catch (Exception throwables) {
      throwables.printStackTrace();
    } finally {
      release(connection, pre, null);
    }
  }

  /**
   * 数据库添加操作，使用executeUpdate方法
   * @param sql
   * @param params
   * @return 主键key
   */
  public static Object insert(String sql, Object... params) {
    Connection connection = null;
    PreparedStatement pre = null;
    ResultSet rs = null;
    Object key = null;
    // 获取数据库连接
    try {
      connection = getConnection();
      pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      fillStatement(pre, params);
      pre.executeUpdate();
      // 返回主键
      rs = pre.getGeneratedKeys();

      if (rs.next()) {
        key = rs.getObject(1);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      // 关闭连接
      release(connection, pre, rs);
    }
    return key;
  }

  /**
   * 用于增加/删除/更新操作的批处理方法，使用addBatch和executeBatch方法，但不返回主键
   * @param sql
   * @param params
   */
  public static void updateBatchByNoKey(String sql,Object[][] params){
    Connection connection=null;
    PreparedStatement pre=null;

    try{
      //获取数据库连接
      connection=getConnection();
      pre =connection.prepareStatement(sql);
      // 处理参数
      if (params != null) {
        // 设置参数
        for (int i = 0; i < params.length; i++) {
          fillStatement(pre,params[i]);
          pre.addBatch();
        }
      }
      pre.executeBatch();
    }catch (SQLException throwables){
      throwables.printStackTrace();;
    }finally{
      //关闭连接
      release(connection,pre,null);
    }
  }

  /**
   * 用于增加/删除/更新操作的批处理方法，使用addBatch和executeBatch方法，但返回主键
   * @param sql
   * @param params
   * @param <T>
   * @return
   */
  public static <T> List<T> updateBatchByKey(String sql,Object[][] params){
    Connection connection =null;
    PreparedStatement pre =null;
    ResultSet rs = null;
    List<T> list =new ArrayList<T>();
      try {
        connection =getConnection();
        pre =connection.prepareStatement(sql ,Statement.RETURN_GENERATED_KEYS);
      // 处理参数
      if (params != null) {
        // 设置参数
        for (int i = 0; i < params.length; i++) {
          fillStatement(pre,params[i]);
          pre.addBatch();
        }
      }
      pre.executeBatch();
      //获取主键
      rs=pre.getGeneratedKeys();
      while (rs.next()){
        list.add((T)rs.getObject(1));
      }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }finally{
        //关闭连接
        release(connection,pre,rs);
      }
      return list;
  }

  /**
   * 查询操作，当不确定返回的值得类型时使用泛型返回
   * @param sql
   * @param params
   * @param <T>
   * @return result 即查询的返回结果
   */
  public static <T> T selectScalar(String sql,Object ...params){
    Connection connection = null;
    PreparedStatement pre=null;
    ResultSet rs=null;
    //由于不确定返回的值的类型，泛型接收返回的值
    T result =null;
    try {
      connection=getConnection();
      pre=connection.prepareStatement(sql);
      fillStatement(pre,params);
      rs=pre.executeQuery();
      if (rs.next()){
        result = (T) rs.getObject(1);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }finally{
      //关闭连接
      release(connection,pre,rs);
    }
    return result;
  }
}
