package Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.jsoup.Jsoup;
import java.io.File;

/**
 * @author 李松柏
 * @createTime 2020/9/16 20:32
 * @description Dom
 */
public class JsopDom {
    @Test
    public void testJsoupFile() throws Exception {
        //    解析文件
        Document document = Jsoup.parse(new File("G:\\bigdata\\爬虫damo\\itcast-crawle-rfirst\\src\\main\\resources\\html\\xiaolitongxue.html"), "utf-8");

        //1.    根据id查询元素getElementById
        Element elementById = document.getElementById("comments");
        System.out.println("--------------id = comments-----------");
        System.out.println(elementById);
        //2.   根据标签获取元素getElementsByTag
        Elements title = document.getElementsByTag("title");
        System.out.println("--------------tag = title-----------");
        for (Element element : title) {
            System.out.println(element);
        }

        //3.   根据class获取元素getElementsByClass
        Elements comments = document.getElementsByClass("comments");
        System.out.println("--------------class = comments-----------");
        for (Element comment : comments) {
            System.out.println(comment);
        }

        //4.   根据属性获取元素getElementsByAttribute

        System.out.println("--------------attribut = abc-----------");
        Element abc = document.getElementsByAttribute("abc").first();
        Element first = document.getElementsByAttributeValue("class", "city_con").first();
        System.out.println(abc);
        System.out.println(first);

    }
}
