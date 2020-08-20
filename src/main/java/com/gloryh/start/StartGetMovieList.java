package com.gloryh.start;

import com.gloryh.entity.MovieInfo;
import com.gloryh.service.IDownloadPageService;
import com.gloryh.service.IProcessPageService;
import com.gloryh.service.IStorageService;
import com.gloryh.service.impl.DownloadPageServiceImpl;
import com.gloryh.service.impl.ProcessPageServiceImpl;
import com.gloryh.service.impl.StorageServiceImpl;
import com.gloryh.utils.LoadPropertiesUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 启动获取电影排行榜列表服务
 *
 * @author 黄光辉
 * @since 2020/8/20
 **/
public class StartGetMovieList {
    // 在此调用需要的接口

    @Setter
    @Getter
    private IDownloadPageService iDownloadPageService;
    @Getter
    @Setter
    private IProcessPageService iProcessPageService;
    @Getter
    @Setter
    private IStorageService iStorageService;
    public static void main(String[] args) {
        StartGetMovieList movieList=new StartGetMovieList();
        //在此加载接口的实现类
        movieList.setIDownloadPageService(new DownloadPageServiceImpl());
        movieList.setIProcessPageService(new ProcessPageServiceImpl());
        movieList.setIStorageService(new StorageServiceImpl());
        // 第一步，写入url
        String url = LoadPropertiesUtil.getProperty("leaderBoardUrl");

        //第二步，调用方法获取网页上下文
        String content=movieList.download(url);
        //第三步，解析网页上下文文件，解析出排行榜的电影url
        List<String> urlList = movieList.process(content);
        // 第四步，调用StartGetMovieInfo方法，利用url获取电影详情
          System.out.println("正在获取新片排行榜的电影信息....");
        for ( String infoList : urlList ) {
            StartGetMovieInfo.getMovieInfo(infoList);
        }
        System.out.println("新片排行榜的电影信息获取完成....");
    }

    /**
     *
     * @param url
     * @return content
     */
    public String download(String url){
        return this.iDownloadPageService.downloadMovieInfo(url);
    }

    /**
     *
     * @param content
     * @return MovieInfo
     */
    public List<String> process(String content){
        return this.iProcessPageService.processMovieList(content);
    }

    /**
     *
     * @param movieInfo
     * @return 主键 key
     */
    public int addMovieInfo(MovieInfo movieInfo){
        return this.iStorageService.addMovieInfo(movieInfo);
    }
}
