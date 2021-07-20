import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.*;

public class Convert {
    List<Map<String,Object>> jsonData = new ArrayList<>();
    public List<Map<String,Object>> convertData(String data) throws Exception{

        JSONObject result = new JSONObject(data.substring(5,data.length()));
        JSONArray searchList    = result.getJSONObject("result").getJSONArray("searchList");
        String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";

        for( int i=0; i <searchList.length();i++){
            Map<String,Object> tmp = new HashMap<>();
            JSONObject blogInfo = (JSONObject) searchList.get(i);
            String blogId = blogInfo.get("blogId").toString();
            String logNo = blogInfo.get("logNo").toString();

            String blogLink     = "https://blog.naver.com/PostView.naver?blogId=" + blogId  +"&logNo=" + logNo;

            Document contentDoc = Jsoup.connect(blogLink).get();
            Elements contents   = contentDoc.getElementsByTag("div").select(".se-main-container");
            String content      = contents.text();
            String tmpDate     = blogInfo.get("addDate").toString();

            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(Long.parseLong(tmpDate)));


            tmp.put("link", blogLink);
            tmp.put("title", blogInfo.get("title").toString().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
            tmp.put("date", date);
            tmp.put("nickname", blogInfo.get("nickName").toString().replaceAll(match,""));
            tmp.put("content", content.replaceAll(match,""));

            jsonData.add(tmp);
        }


        return jsonData;
    }
}
