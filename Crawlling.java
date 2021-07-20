
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawlling {

    public static void main(String[] args) throws Exception {
        Convert convert = new Convert();
        Request request = new Request();
        Dbcon dbcon = new Dbcon();

        List<Map<String,Object>> data = new ArrayList<>();


        for( int i =1; i<160;i++) {
            String keyword = URLEncoder.encode("코로나", "UTF-8");
            String url = "https://section.blog.naver.com/ajax/SearchList.naver?countPerPage=7&currentPage=" + i + "&endDate=&keyword=";
            String subUrl = "&orderBy=sim&startDate=&type=post";


            url = url + keyword + subUrl;

            String xmlStr = request.sendGet(url);

            data = convert.convertData(xmlStr);


        }
        System.out.println(data.size());
        dbcon.insert(data);



    }


}
