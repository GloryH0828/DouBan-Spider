package com.gloryh.service.impl;

import com.gloryh.entity.MovieInfo;
import com.gloryh.service.IStorageService;
import com.gloryh.utils.JDBCUtil;

/**
 * 数据存储接口实现类
 *
 * @author 黄光辉
 * @since 2020/8/20
 */
public class StorageServiceImpl implements IStorageService {
  @Override
  public int addMovieInfo(MovieInfo movieInfo) {
    // 编写数据库操作语句
    String sql =
        "INSERT INTO movie_info(" +
                "movie_name," +
                "movie_director," +
                "movie_scenarist," +
                "movie_main_actor," +
                "movie_type," +
                "movie_country," +
                "movie_language," +
                "movie_time," +
                "movie_length," +
                "movie_another_name," +
                "movie_summary," +
                "movie_score)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    //匹配数据库语句中的字段
    Object params[]={
            movieInfo.getMovieName(),
            movieInfo.getDirector(),
            movieInfo.getScenarist(),
            movieInfo.getMainActor(),
            movieInfo.getType(),
            movieInfo.getCountry(),
            movieInfo.getLanguage(),
            movieInfo.getTime(),
            movieInfo.getLength(),
            movieInfo.getAnotherName(),
            movieInfo.getSummary(),
            movieInfo.getScore()
    };
    // 调用工具类方法
    Object key = JDBCUtil.insert(sql, params);
    System.out.println("已将电影------"+movieInfo.getMovieName()+"---的信息存入数据库");
    return Integer.valueOf(key.toString()).intValue();
  }
}
