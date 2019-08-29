import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.text.Document;

/**
 * @author younghe
 * @date 2019/8/28 - 下午4:46
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
        HttpGet httpget = new HttpGet("https://www.cnblogs.com/"); // 创建httpget实例

        CloseableHttpResponse response = httpclient.execute(httpget); // 执行get请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
        String content = EntityUtils.toString(entity, "utf-8");
//        System.out.println("网页内容："+EntityUtils.toString(entity, "utf-8")); // 指定编码打印网页内容
        response.close(); // 关闭流和释放系统资源

        org.jsoup.nodes.Document doc = Jsoup.parse(content); //解析网页，得到文档对象
        Elements elements = doc.getElementsByTag("title"); //获得tag是title的所有DOM元素
        Element element = elements.get(0); //获取第1个元素
        String s = element.text();
        System.out.println("网页标题是：    " + s);

        Element element1 = doc.getElementById("site_nav_top");
        String s1 = element1.text();
        System.out.println("开始：\n"+ s1 +"\n结束");
    }
}
