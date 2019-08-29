import org.apache.http.HttpEntity;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
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
public class DemoRandomUrl {

    public static void main(String[] args) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
        HttpGet httpget = new HttpGet("https://www.zhihu.com/question/40463441"); // 创建httpget实例

        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        httpget.setConfig(defaultConfig);

        CloseableHttpResponse response = httpclient.execute(httpget); // 执行get请求
        HttpEntity entity = response.getEntity(); // 获取返回实体
        String content = EntityUtils.toString(entity, "utf-8");
        response.close(); // 关闭流和释放系统资源

        Document doc = Jsoup.parse(content); //解析网页，得到文档对象

        Elements selElements = doc.select("#js-initialData ");


        for (Element e : selElements) {
            System.out.println("\n标题："+e.text());
        }

//        System.out.println("============================================================");

//        Elements hrefElements = doc.select("a[href]");
//
//        for (Element e : hrefElements) {
//            System.out.println(e.toString());
//        }

    }

}
