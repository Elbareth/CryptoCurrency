package com.example.cryptocurrencies.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class CryptoCurrencyService {

    public JsonArray getJSONFromURL(String sURL){
        URL url;
        try {
            url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            return root.getAsJsonArray();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
