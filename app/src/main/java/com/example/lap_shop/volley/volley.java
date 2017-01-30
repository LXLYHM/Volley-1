package com.example.lap_shop.volley;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by LAP_SHOP on 26/01/2017.
 */

public class volley extends AppCompatActivity {
    String ResponseOut = "";

    public String getData(String url, Map<String, String> Paramters, int way, Context context) {
        CacheRequest cacheRequest = new CacheRequest(way, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                try {
                    System.out.println("jjjj"+new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers)));
                    ResponseOut=new String(response.data,
                            HttpHeaderParser.parseCharset(response.headers));

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySingleton.getInstance(context).addToRequestQueue(cacheRequest);
//        StringRequest stringRequest = new StringRequest(way, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    //if arabic
//                    String encoding = URLEncoder.encode(response, "ISO-8859-1");
//                    response = URLDecoder.decode(encoding, "UTF-8");
//                    ResponseOut = response;
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(ResponseOut + "jjjj");
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                ResponseOut = error + "";
//                System.out.println(error + "sesds");
//                error.printStackTrace();
//            }
//
//        });
//
//
//        MySingleton.getInstance(context).addToRequestQueue(stringRequest);

        return ResponseOut;
    }


}
