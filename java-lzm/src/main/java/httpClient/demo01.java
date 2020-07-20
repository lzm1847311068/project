package httpClient;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class demo01 {
    public static void main(String[] args) {

        try {
            //构建一个Client
            CloseableHttpClient client = HttpClients.createDefault();
            //构建一个POST请求
            HttpPost post = new HttpPost("http://wx.imegnor.cn/user/login");
            //构建表单参数
            List<NameValuePair> formParams = new ArrayList<NameValuePair>();
            formParams.add(new BasicNameValuePair("account", "15610701514"));
            formParams.add(new BasicNameValuePair("password", "lzm1847311068"));
            //将表单参数转化为“实体”
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
            //将“实体“设置到POST请求里
            post.setEntity(entity);
            //提交POST请求
            HttpResponse response = client.execute(post);
            //拿到返回的HttpResponse的"实体"
            HttpEntity result = response.getEntity();
            ////用httpcore.jar提供的工具类将"实体"转化为字符串打印到控制台
            String content = EntityUtils.toString(result);;
            System.out.println(content);
            if(content.contains("Success")){
                System.out.println("登陆成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void jieDan(){
        System.out.println("");
    }
}
