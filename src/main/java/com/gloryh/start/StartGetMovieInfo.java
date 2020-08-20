package com.gloryh.start;

import com.gloryh.entity.MovieInfo;
import com.gloryh.service.IDownloadPageService;
import com.gloryh.service.IProcessPageService;
import com.gloryh.service.IStorageService;
import com.gloryh.service.impl.DownloadPageServiceImpl;
import com.gloryh.service.impl.ProcessPageServiceImpl;
import com.gloryh.service.impl.StorageServiceImpl;
import lombok.Getter;
import lombok.Setter;

/**
 * 启动获取电影信息服务
 *
 * @author 黄光辉
 * @since 2020/8/19
 */
public class StartGetMovieInfo {
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
  public static void getMovieInfo(String url) {
    StartGetMovieInfo getMovieInfo =new StartGetMovieInfo();
    //在此加载接口的实现类
    getMovieInfo.setIDownloadPageService(new DownloadPageServiceImpl());
    getMovieInfo.setIProcessPageService(new ProcessPageServiceImpl());
    getMovieInfo.setIStorageService(new StorageServiceImpl());
    // 第一步，写入url
    //第二步，调用方法获取网页上下文
    String content =getMovieInfo.download(url);
    //第三步，解析网页上下文文件，只保留自己有用的信息，存储在MovieInfo实体类中
    MovieInfo movieInfo = getMovieInfo.process(content);
    //第四步，将MovieInfo中的信息存储至数据库中
    getMovieInfo.addMovieInfo(movieInfo);
   //第五步，系统休眠，防止被封
    try {
      Thread.sleep(1000*3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
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
  public MovieInfo process(String content){
    return this.iProcessPageService.processMovieInfo(content);
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
