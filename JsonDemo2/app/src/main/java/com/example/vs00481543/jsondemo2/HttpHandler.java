package com.example.vs00481543.jsondemo2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by VS00481543 on 11-09-2017.
 */

public class HttpHandler {

    public HttpHandler()
    {

    }

    public String makeServiceCall(String urlReq)
    {
        String res=null;
        try{
            URL mUrl=new URL(urlReq);
            HttpURLConnection httpURLConnection=(HttpURLConnection) mUrl.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
            res=convertStreamToString(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return res;
    }

    private String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb=new StringBuilder();

        String i;
        try{
            while((i=bufferedReader.readLine())!=null)
            {
                sb.append(i).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }



}
