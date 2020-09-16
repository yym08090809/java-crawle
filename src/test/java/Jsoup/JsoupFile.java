package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.File;

/**
 * @author 李松柏
 * @createTime 2020/9/16 20:28
 * @description 解析Html文件
 */
public class JsoupFile {
    @Test
    public void testJsoupFile() throws Exception {
        //    解析文件
        Document document = Jsoup.parse(new File("G:\\bigdata\\爬虫damo\\itcast-crawle-rfirst\\src\\main\\resources\\html\\xiaolitongxue.html"), "utf-8");
        //获取title的内容
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());
    }
}
