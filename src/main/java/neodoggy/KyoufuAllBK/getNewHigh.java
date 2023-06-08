package neodoggy.KyoufuAllBK;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class getNewHigh {
    public static boolean isNewHigh(String score) throws IOException {
        boolean isHigh=false;
        Scanner input=new Scanner(new File("lib\\json\\high.json"));
        JSONObject object=new JSONObject(input.nextLine());
        input.close();
        Map<String,Object> rankMap=object.toMap();
//        System.out.println(rankMap.get("high"));
        if((Integer.parseInt(score))>(Integer.parseInt(rankMap.get("high").toString()))){
            FileWriter fw=new FileWriter("lib\\json\\high.json");
            fw.write("{\"high\":"+score+"}");
            fw.close();
            isHigh=true;
        }
        return isHigh;
    }
}
