package neodoggy.KyoufuAllBK;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class getWorldRank {
    public static String getRank(String score) throws IOException {
        Scanner hashIN=new Scanner(new File("lib\\usr\\hash.txt"));
        String usrn=hashIN.nextLine();
        usrn=usrn.replace(':','_');
        hashIN.close();
        URL url=new URL("http://dreamlo.com/lb/_wAopJsIf060e3ZAAOBeUAm2a71pqFW0Cod2l_6XvieQ/add/"+usrn+"/"+score);
        URLConnection connection = url.openConnection();
        try (BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        FileUtils.copyURLToFile(new URL("http://dreamlo.com/lb/6470aafc8f40bb7d84f03bbe/json"), new File("lib\\json\\rank.json"));
        Scanner input=new Scanner(new File("lib\\json\\rank.json"));
        JSONObject object=new JSONObject(input.nextLine());
        input.close();
        Map<String,Object> rankMap=object.toMap();
        String rank="25+";
        List<Map>rankList=(List<Map>)((Map)((Map)rankMap.get("dreamlo")).get("leaderboard")).get("entry");
        for(int i=rankList.size()-1;i>=0;i--){
            if(rankList.get(i).get("name").equals(usrn)){
                rank=String.valueOf(i+1);
                break;
            }
//            if((Integer.parseInt(score))>(Integer.parseInt((String)rankList.get(i).get("score")))){
//                rank=String.valueOf(i+1);
//            }
        }
        return rank;
    }
}
