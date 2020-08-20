package com.gloryh.utils;

import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.util.regex.Pattern;

/**
 * 用于解析网页的工具类，封装后供网页上下文解析接口实现类调用
 *
 * @author 黄光辉
 * @since 2020/8/19
 */
public class ParseContentUtil {
  /**
   *
   * @param tagNode
   * @param xpath
   * @param regex
   * @return summary
   */
  public static String getFieldByRegex(TagNode tagNode, String xpath, String regex) {
    // 根据xpath找到要获取的内容
    Object[] evaluate = new Object[0];
    try {
      evaluate = tagNode.evaluateXPath(xpath);
    } catch (XPatherException e) {
      e.printStackTrace();
    }
    String info="";
    if (evaluate.length > 0) {

      for (Object object :evaluate ) {
        TagNode node =(TagNode)object;
        //在这里可以写正则表达式对需要的信息进行处理
        if(regex!=""){
          Pattern pattern=Pattern.compile(regex);
          //使用工具类进行信息的处理
          info+=RegexUtil.getInfoByRegex(node.getText().toString(), pattern,0);
        }else{
          info+=node.getText().toString();
        }
      }
    }else {
      return "无";
    }
    return info.replace(" ", "");
  }

}
