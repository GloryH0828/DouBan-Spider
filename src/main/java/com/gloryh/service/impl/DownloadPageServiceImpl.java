package com.gloryh.service.impl;

import com.gloryh.service.IDownloadPageService;
import com.gloryh.utils.GetPageContentUtil;

/**
 * 电影详情页信息下载接口实现类
 *
 * @author 黄光辉
 * @since 2020/8/19
 **/
public class DownloadPageServiceImpl implements IDownloadPageService {
    /**
     * 返回网页的上下文信息
     * @param url
     * @return content
     */
    @Override
    public String downloadMovieInfo(String url) {

        return GetPageContentUtil.getPageContent(url);
    }
}
