package cn.market.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	public static List<String> getFile(String urlPath){
        System.out.println("Start to get file from URL...");
        List<String> contents = new ArrayList<String>();

        URL url;
        try {
            url = new URL(urlPath);
            URLConnection conn = url.openConnection();
            conn.connect();
            HttpURLConnection httpConn = (HttpURLConnection)conn;
            if(httpConn.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(),"UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String line;
                while((line = br.readLine()) != null){
                    System.out.println(line);
                    contents.add(line);
                }
            }else{
                System.out.println("Cannot connect to the "+urlPath);
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Finished getting the contents from URL...");
        return contents;
    }
}
