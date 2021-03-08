package com.example.shree.btechproject;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

/**
 * Created by user on 2/27/2018.
 */

public class LocationConnector {
    public JSONArray getAllData() {
        String HttpUrl = "http://192.168.43.215/prefinalBtechProject/GetLocation/getLatLon.php";
        HttpEntity httpEntity = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(HttpUrl);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray=null;
        if(httpEntity!=null){
            try{
                String entityResponce= EntityUtils.toString(httpEntity);
                Log.e("Entity Responce:",entityResponce);
                jsonArray=new JSONArray(entityResponce);
            }catch (JSONException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return jsonArray;
    }
}
