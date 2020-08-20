package com.gloryh.entity;

import lombok.Data;

/**
 * 记录电影详情页显示的信息
 *
 * @author 黄光辉
 * @since 2020/8/19
 **/
@Data
public class MovieInfo {
    /**
     * 电影名
     */
    private String movieName;
    /**
     * 导演名
     */
    private String director;
    /**
     * 编剧名
     */
    private String scenarist;
    /**
     * 主演
     */
    private String mainActor;
    /**
     * 电影类型
     */
    private String type;
    /**
     * 制片国家
     */
    private String country;
    /**
     * 语言
     */
    private String language;
    /**
     * 上映时间
     */
    private String time;
    /**
     * 片长
     */
    private String length;
    /**
     * 别名
     */
    private String anotherName;
    /**
     * 剧情简介
     */
    private String summary;
    /**
     * 评分
     */
    private String score;
    /**
     * 编号
     */
    private int id;
}
