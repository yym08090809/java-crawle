package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 李松柏
 * @createTime 2020/9/16 20:07
 * @description 解析Url
 * 虽然使用Jsoup可以替代HttpClient直接发起请求解析数据，
 * 但是往往不会这样用，因为实际的开发过程中，需要使用到多线程，连接池，代理等等方式，
 * 而jsoup对这些的支持并不是很好，所以我们一般把jsoup仅仅作为Html解析工具使用
 */
public class JsoupUrl {
    @Test
    public void testJsoupUrl() throws IOException {
        //    解析url地址
        //URL url, int timeoutMillis
        Document document = Jsoup.parse(new URL("http://www.lisongbai.top/"), 1000000);


        //获取title的内容
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());

    }
}
