package HttpClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 李松柏
 * @createTime 2020/9/16 19:18
 * @description 爬取传智播客首页
 */
public class Get01 {
    public static void main(String[] args)  {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpGet请求
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求
            response = httpClient.execute(httpGet);
            //判断响应状态码是否为200
            if(response.getStatusLine().getStatusCode() == 200){
                //如果为200表示请求成功，获取返回数据
                String content = EntityUtils.toString(response.getEntity(), "utf-8");
                //打印数据长度
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(response == null){
                try {
                    response.close();
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
