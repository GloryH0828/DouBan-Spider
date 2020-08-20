package com.gloryh.service;

import com.gloryh.entity.MovieInfo;

/**
 * 数据存储接口，用于将数据存储到数据库中
 *
 * @author 黄光辉
 * @since 2020/8/20
 **/
public interface IStorageService {
    public int addMovieInfo(MovieInfo movieInfo);
}
