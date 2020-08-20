package com.gloryh.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 用于加载配置类文件的工具类
 *
 * @author 黄光辉
 * @since 2020/8/19
 */
public class LoadPropertiesUtil {
  /**
   *
   * @param key
   * @return value
   */
  public static String getProperty(String key) {
    Locale locale = Locale.getDefault();
    ResourceBundle bundle = ResourceBundle.getBundle("movieinfo", locale);
    String value = bundle.getString(key);
    return value;
  }
}
