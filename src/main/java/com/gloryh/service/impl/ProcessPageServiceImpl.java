package com.gloryh.service.impl;

import com.gloryh.entity.MovieInfo;
import com.gloryh.service.IProcessPageService;
import com.gloryh.utils.LoadPropertiesUtil;
import com.gloryh.utils.ParseContentUtil;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.util.ArrayList;
import java.util.List;

/**
 * 网页上下文文件解析接口实现类
 *
 * @author 黄光辉
 * @since 2020/8/19
 */
public class ProcessPageServiceImpl implements IProcessPageService {
  /**
   * @param content
   * @return MovieInfo
   */
  @Override
  public MovieInfo processMovieInfo(String content) {
    MovieInfo movieInfo = new MovieInfo();
    // htmlCleaner解析，Xpath读取参数
    HtmlCleaner htmlCleaner = new HtmlCleaner();
    TagNode tagNode = htmlCleaner.clean(content);
    /**
     * 调用工具类处理信息 Xpath提取出来方便代码优化 LoadPropertiesTools.getMovie("parseSummary") 写一个正则表达式匹配字段
     * LoadPropertiesTools.getMovie("regex") Xpath 和 正则表达式均通过配置类定义，读取方式如上。即调用配置加载工具类获取
     */
    /**
     * 电影名
     */
    String name =ParseContentUtil.getFieldByRegex(
            tagNode,
            LoadPropertiesUtil.getProperty("nameXpath"),
            "");
    System.out.println("正在抓取电影：---"+name+"---的信息");
    /** 剧情简介 */
    String summary =
        ParseContentUtil.getFieldByRegex(
            tagNode,
            LoadPropertiesUtil.getProperty("summaryXpath"),
            "");
    /** 导演 */
    String director =
        ParseContentUtil.getFieldByRegex(
            tagNode,
            LoadPropertiesUtil.getProperty("directorXpath"),
                "");
    /** 编剧 */
    String scenarist=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("scenaristXpath"),
                    "");
    /** 主演 */
    String mainActor=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("mainActorXpath"),
                    "");
    /** 电影类型 */
    String type=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("typeXpath"),
                    "");
    /** 制片国家 */
    String country=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("movieXpath"),
                    LoadPropertiesUtil.getProperty("countryRegex"));
    /** 语言 */
    String language=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("movieXpath"),
                    LoadPropertiesUtil.getProperty("languageRegex"));
    /** 上映时间 */
    String time=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("timeXpath"),
                    LoadPropertiesUtil.getProperty("timeRegex"));
    /** 片长 */
    String length=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("lengthXpath"),
                    LoadPropertiesUtil.getProperty("lengthRegex"));
    /** 别名 */
    String anotherName=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("movieXpath"),
                    LoadPropertiesUtil.getProperty("anotherNameRegex"));
    /** 评分 */
    String score=
            ParseContentUtil.getFieldByRegex(
                    tagNode,
                    LoadPropertiesUtil.getProperty("scoreXpath"),
                    "");
    movieInfo.setAnotherName(anotherName);
    movieInfo.setCountry(country);
    movieInfo.setDirector(director);
    movieInfo.setLanguage(language);
    movieInfo.setLength(length);
    movieInfo.setMainActor(mainActor);
    movieInfo.setMovieName(name);
    movieInfo.setScenarist(scenarist);
    movieInfo.setScore(score);
    movieInfo.setSummary(summary);
    movieInfo.setTime(time);
    movieInfo.setType(type);
    System.out.println("电影：-------"+name+"---的信息抓取成功");
    return movieInfo;
  }

  @Override
  public List<String> processMovieList(String content) {
    List<String> urlList = new ArrayList<>();
    // htmlCleaner解析，Xpath读取参数
    HtmlCleaner htmlCleaner = new HtmlCleaner();
    TagNode tagNode = htmlCleaner.clean(content);
    /**
     * 调用工具类处理信息 Xpath提取出来方便代码优化 LoadPropertiesTools.getMovie("parseSummary") 写一个正则表达式匹配字段
     * LoadPropertiesTools.getMovie("regex") Xpath 和 正则表达式均通过配置类定义，读取方式如上。即调用配置加载工具类获取
     */
    try {
     Object[] evalute= tagNode.evaluateXPath(LoadPropertiesUtil.getProperty("movieNameXpath"));
      if (evalute.length>0) {
        for (Object object : evalute){
          TagNode node = (TagNode) object;
          String url = node.getAttributeByName("href");
          urlList.add(url);
        }
      }
    } catch (XPatherException e) {
      e.printStackTrace();
    }
    return urlList;
  }
}
