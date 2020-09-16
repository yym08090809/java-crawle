package Jsoup;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;

/**
 * @author 李松柏
 * @createTime 2020/9/16 20:19
 * @description 解析字符串
 */
public class JsoupString {
    @Test
    public void testJsoupString() throws Exception {
        //读取文件获取
        String html = FileUtils.readFileToString(new File("G:\\bigdata\\爬虫damo\\itcast-crawle-rfirst\\src\\main\\resources\\html\\xiaolitongxue.html"), "UTF-8");

        //    解析字符串
        Document document = Jsoup.parse(html);

        //获取title的内容
        Element title = document.getElementsByTag("title").first();
        System.out.println(title.text());
        Element body = document.body();
        System.out.println(body.firstElementSibling());

    }

}
