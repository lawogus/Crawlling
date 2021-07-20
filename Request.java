import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Request {
    public String sendGet(String requrl) throws Exception {
        URL url = new URL(requrl);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Referer" ,"https://section.blog.naver.com/Search/Post.naver?pageNo=1&rangeType=ALL&orderBy=sim&keyword=%EC%BD%94%EB%A1%9C%EB%82%98");
        con.setRequestProperty("Cookie" ,"NNB=GTR76LIBLHEGA; NDARK=Y; nx_ssl=2; nid_inf=431058816; NID_AUT=HtinHqPPJmTyhD3H2FtImO9qNwX14A+HzxMGI4ln/+35dqYJWh3zTgHmo1ZlzYVJ; NID_JKL=IF1FavmpH0kw4ILwnhuoP7hX4Hceoz5pcUBLOp1K9Ww=; stat_yn=1; BMR=s=1623817312964&r=https%3A%2F%2Fm.blog.naver.com%2FPostView.naver%3FisHttpsRedirect%3Dtrue%26blogId%3D50after%26logNo%3D220912861796&r2=https%3A%2F%2Fwww.google.com%2F; NaverSuggestUse=use%26unuse; page_uid=hKEaIdprvmsssELTnGNssssssv8-303804; NID_SES=AAABjXGFo4SW3RKuCCg2YF9LsqUG9iQ4T0dkJAUSc//lZFVnpiCAzpnVztEAwEO4PHy/jn3GsTXGU1Fp9vE9qNdargOvFDvmFbpVvNQbZ0hkeIhoeJQsPwqQ4u4+HsdC+gqcGpMzirUxLiOZ5QYc7w0KILrg0bKFHAJcfHLii1qY8u8bLvg3fK0eVaeb2DJV1T94HdPsd0HwLbnjvMQYDmNk/dSlTfXffbYf2QmKOWDDfDB0KmB8PAbHCyXYMbw+ahX+pfNXpYKIql56xBdlsVhZ51uD32HU7X+wg4LRn33HDuYhW/XGmLE3LZ5MNxWJ+kNGSC/1QJYbOvurDVNbxBW/EqaVchy1WxmdtggvosLfR/xK665luBsrAr3x3RPRuxio51hFo2rBxWJ2LqWAlFVxibR8BGE0V2DLbRAKAObmfgTl4MGdiwq8kdZeEDjUS8x51vi8xH/1Cq9dmfZqq8+prSgQzC/4ly165wkCYr01ZEL7RXKiT34nvAheJwNE4VRoZ7xKk39sW8+2nwt/GfVM+UI=; JSESSIONID=41673CC948C8A4241ED19E7C38AD5F3D.jvm1");


        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null){
            response.append(inputLine);

        }

        in.close();

        return response.toString();

    }
}
