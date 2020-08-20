package com.gloryh.utils;

import jdk.nashorn.internal.ir.CallNode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 抽取出一个正则表达式工具类，供解析页面上下文工具类调用调用
 *
 * @author 黄光辉
 * @since 2020/8/19
 */
public class RegexUtil {
  /**
   *
   * @param content
   * @param pattern
   * @param groupId
   * @return summary
   */
  public static String getInfoByRegex(String content, Pattern pattern, int groupId) {
    Matcher matcher = pattern.matcher(content);

    if (matcher.find()) {

      return matcher.group(groupId);
    }
    return "无";
  }
}
