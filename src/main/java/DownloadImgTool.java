import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author younghe
 * @date 2019/8/29 - 下午7:28
 */

/*
* java根据图片的url地址下载图片到本地
*/
    
public class DownloadImgTool {

    public static void main(String[] args) {
        String url = "http://photocdn.sohu.com/20100527/Img272388686.jpg";
        String path="/Users/younghe/Desktop/downloadImgPackage/img.jpg";
        downloadPicture(url,path);
    }

    //链接url下载图片
    private static void downloadPicture(String urlList,String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
