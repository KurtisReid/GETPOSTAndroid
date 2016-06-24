package com.example.kreid.parsejsonblogspot;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by kreid on 6/23/2016.
 */
public class putJson extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... strings) {
        try {
            String PostData = "'{\"AccountType\": \"flashline\",\"apikey\": \"8675309\", \"id\" : \"22\"}'";
            URL url = new URL("http://10.0.2.2:8081/inputKnowledgeItemsPOST");
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            Log.i("MainActivity", "HttpURLConnection successful");
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");
            Log.i("MainActivity","method = POST");
            OutputStreamWriter out = new OutputStreamWriter(
                    httpCon.getOutputStream());
            Log.i("MainActivity","outputStreamWriter");
            out.write(PostData);
            Log.i("MainActivity","PostData Written");
            out.close();
            httpCon.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
