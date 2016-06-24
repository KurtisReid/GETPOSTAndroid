package com.example.kreid.parsejsonblogspot;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kreid on 6/23/2016.
 */
public class ProcessJSON extends AsyncTask<String, Void, String> {
    protected String doInBackground(String... strings){
        String stream = null;
        String urlString = strings[0];

        HTTPDataHandler hh = new HTTPDataHandler();
        stream = hh.GetHTTPData(urlString);


        // Return the data from specified url
        return stream;
    }

    protected void onPostExecute(String stream){
        TextView tv = (TextView) findViewById(R.id.tv);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        //tv.setText(stream);

        //..........Process JSON DATA................
        if(stream !=null){
            try {
                // Get the full HTTP Data as JSONObject

                JSONArray reader = new JSONArray(stream);
                Log.i("mainActivity", String.valueOf(reader.length()));
                String arr[] = new String[17];
                int j = 0;
                for (int i = 0; i < 2; i++) {

                    Log.i("mainActivity", reader.toString());
                    //Log.i("mainActivity", String.valueOf(i));
                    JSONObject object = reader.getJSONObject(i);
                    JSONArray object1;


                    //Log.i("mainActivity", "jsonObject waetherArray passed !!!!!!!!!!!!!!!!!!");
                    //JSONObject weather_object_0 = weatherArray.getJSONObject(1);
                    arr[j] = object.getString(TAG_effect_on_distance);//finds the string
                    Log.i("mainActivity", "effect_onDistance"+arr[j]);

                    arr[j] = object.getString(TAG_title);
                    Log.i("mainActivity", "title"+arr[j]);
                    j++;
                    arr[j] = object.getString(TAG_type);
                    Log.i("mainActivity", "type"+arr[j]);
                    j++;
                    arr[j] = object.getString(TAG_when);
                    Log.i("mainActivity", arr[j]);
                    j++;
                    //arr[j] = object.getString(TAG_institution);
                    //Log.i("mainActivity", arr[j]);
                    //    j++;
                    arr[j] = object.getString(TAG_where);
                    Log.i("mainActivity", arr[j]);
                    j++;
                    arr[j] = object.getString(TAG_contributes);
                    Log.i("mainActivity", arr[j]);
                    j++;


                    /*
                        String effectOnDistance = object.getString(TAG_effect_on_distance);//finds the string
                        String title = object.getString(TAG_title);
                        String type = object.getString(TAG_type);
                        String when = object.getString(TAG_when);
                        String institution = object.getString(TAG_institution);
                        String where = object.getString(TAG_where);
                        String contributes = object.getString(TAG_contributes);*/
                }
                //tv.setText(tv.getText());
                String label[] = {"title: ", "type: ", "when", "where...", "contributes: "};
                tv.append("\t\t\teffectOnDistance..." + arr[0] + "\n");

                for (int k = 0; k < 5; k++){
                    tv.append("\t\t\t" + label[k] + arr[k] + "\n");
                    Log.i("mainActivity",label[k] + arr[k]);


                }
                for (int k = 0; k < 5; k++){
                    tv2.append("\t\t\t" + label[k] + arr[k+5] + "\n");
                    Log.i("mainActivity","tv2  " + label[k] + arr[k+5]);


                }

                //tv.setText(tv.getText() + "\t\t\t" + stream);

                // process other data as this way..............
                //}

            }catch(JSONException e){
                e.printStackTrace();
            }

        } // if statement end
    }

    // onPostExecute() end
} // ProcessJSON class end