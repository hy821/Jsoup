import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author younghe
 * @date 2019/8/28 - 下午4:46
 */
public class Demo03 {

    public static void main(String[] args) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
        HttpGet httpget = new HttpGet("https://www.cnblogs.com/"); // 创建httpget实例

        CloseableHttpResponse response = httpclient.execute(httpget); // 执行get请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
        String content = EntityUtils.toString(entity, "utf-8");
//        System.out.println("网页内容："+EntityUtils.toString(entity, "utf-8")); // 指定编码打印网页内容
        response.close(); // 关闭流和释放系统资源

        Document doc = Jsoup.parse(content); //解析网页，得到文档对象

//        Elements selElements = doc.select("#post_list .post_item .post_item_body h3 a");
//
//        for (Element e : selElements) {
//            System.out.println("\n博客标题："+e.text());
//        }

//        System.out.println("============================================================");

//        Elements hrefElements = doc.select("a[href]");
//
//        for (Element e : hrefElements) {
//            System.out.println(e.toString());
//        }

        Elements pngElements = doc.select("img[src$=.png]");

        for (Element e : pngElements) {
            System.out.println(e.toString());
        }

    }

}
