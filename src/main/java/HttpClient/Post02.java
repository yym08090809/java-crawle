package HttpClient;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author 李松柏
 * @createTime 2020/9/16 19:34
 * @description post请求带参数
 *
 * 在传智中搜索学习视频，使用POST请求，url地址为：
 * http://yun.itheima.com/search
 * url地址没有参数，参数keys=java放到表单中进行提交
 */
public class Post02 {
    public static void main(String[] args) throws Exception {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpGet请求
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");

        //声明存放参数的List集合
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("keys","java"));

        //创建表单数据Entity
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");

        //设置表单Entity到httpPost请求对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求
            response = httpClient.execute(httpPost);
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
