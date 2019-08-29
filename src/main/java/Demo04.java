import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;


/**
 * @author younghe
 * @date 2019/8/28 - 下午4:46
 */
public class Demo04 {

    public static void main(String[] args) throws Exception {

        File input = new File("/Users/younghe/Desktop/v1.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        //title & VideoSrc
        Element e = doc.selectFirst(".html5-video-container video");
        String videoTitle = e.attr("title");
        String src = e.attr("src");

        //posterUrl
        String posterStr = doc.selectFirst("#img-preload").selectFirst("img").attr("src");

        System.out.println("标题:    " + videoTitle);
        System.out.println("播放链接: " + src);
        System.out.println("海报链接: " + posterStr);

    }
}
