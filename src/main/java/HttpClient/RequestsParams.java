package HttpClient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 李松柏
 * @createTime 2020/9/16 19:43
 * @description 有时候因为网络，或者目标服务器的原因，请求需要更长的时间才能完成，我们需要自定义相关时间
 */
public class RequestsParams {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.baidu.com");

        //设置请求参数
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)//设置创建连接的最长时间
                .setConnectionRequestTimeout(500)//设置获取连接的最长时间
                .setSocketTimeout(10 * 1000)//设置数据传输的最长时间
                .build();

        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求
            response = httpClient.execute(httpGet);

            //判断响应状态码是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                //如果为200表示请求成功，获取返回数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                //打印数据长度
                System.out.println(content);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放连接
            if (response == null) {
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
