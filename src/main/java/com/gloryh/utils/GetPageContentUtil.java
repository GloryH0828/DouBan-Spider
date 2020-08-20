package com.gloryh.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.Closeable;
import java.io.IOException;

/**
 * 获取网页上下文信息的工具类
 *
 * @author 黄光辉
 * @since 2020/8/19
 */
public class GetPageContentUtil {
  /**
   * @param url
   * @return content
   */
  public static String getPageContent(String url) {
    HttpClientBuilder builder = HttpClients.custom();
    CloseableHttpClient client = builder.build();

    // HttpGet 请求页面
    HttpGet request = new HttpGet(url);
    // 在这里写一些header防止被认为是机器人
    request.setHeader(
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36 Edg/83.0.478.58");
    // 存储页面内容
    String content = null;
    CloseableHttpResponse response = null;

    try {
      response = client.execute(request);
      HttpEntity entity = response.getEntity();
      content = EntityUtils.toString(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return content;
  }
}
