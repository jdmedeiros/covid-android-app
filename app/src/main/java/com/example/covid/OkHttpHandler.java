package com.example.covid;


import android.os.AsyncTask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHandler extends AsyncTask<String, Void, String> {
    public static List<Resposta> dadosCovid = new ArrayList<>();
    OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... params) {
        Headers.Builder hBuilder = new Headers.Builder();
        hBuilder.add("x-rapidapi-host", "covid-193.p.rapidapi.com");
        hBuilder.add("x-rapidapi-key", "af05b354b2mshaa072c2fcfc7f8fp185dcajsn248fab4d254e");
        Headers headers = hBuilder.build();

        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);
        builder.headers(headers);
        Request request = builder.build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            Covid covid = new ObjectMapper().readValue(s, Covid.class);
            dadosCovid = covid.getResposta();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}