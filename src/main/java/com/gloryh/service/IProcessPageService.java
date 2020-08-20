package com.gloryh.service;

import com.gloryh.entity.MovieInfo;

import java.util.List;

/**
 * 网页上下文文件解析接口
 *
 * @author 黄光辉
 * @since 2020/8/19
 **/
public interface IProcessPageService {
    public MovieInfo processMovieInfo(String content);
    public List<String> processMovieList(String content);
}
