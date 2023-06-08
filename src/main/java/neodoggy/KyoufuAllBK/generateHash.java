package neodoggy.KyoufuAllBK;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.Security;

public class generateHash {
    public static void genHash() throws IOException {
        File hasF=new File("lib\\usr\\hash.txt");
        String hash="";
        if(hasF.length()==0){
            hash= String.valueOf(System.currentTimeMillis());
            byte[] bytesToDigest = hash.getBytes();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bytesToDigest);
                byte[] digest = messageDigest.digest();

                hash=bytesToHex(digest);
                // 輸出 MD5 Hash：18:50:1F:84:0C:FE:2A:10:CE:89:B0:94:8E:FA:A0:42
                System.out.println(bytesToHex(digest));
            } catch (Exception e) {
                e.printStackTrace();
            }
            FileWriter fw=new FileWriter("lib\\usr\\hash.txt");
            fw.write(hash);
            fw.close();
        }
    }

    public static String bytesToHex(byte[] b) {
        StringBuffer sb = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length()==1){
                sb.append("0").append(stmp);
            }
            else{
                sb.append(stmp);
            }
            if(n < b.length - 1){
                sb.append(":");
            }
        }
        return sb.toString().toUpperCase();
    }
}
