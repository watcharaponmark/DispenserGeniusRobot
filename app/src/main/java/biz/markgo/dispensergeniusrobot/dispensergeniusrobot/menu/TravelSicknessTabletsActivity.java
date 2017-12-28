package biz.markgo.dispensergeniusrobot.dispensergeniusrobot.menu;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import biz.markgo.dispensergeniusrobot.dispensergeniusrobot.R;

public class TravelSicknessTabletsActivity extends AppCompatActivity {

    private String TAG = TravelSicknessTabletsActivity.class.getSimpleName();
    private ImageView im_back;
    private LinearLayout Layout_send;
    private Button bt_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_sickness_tablets);

        im_back = (ImageView) findViewById(R.id.im_back);
        Layout_send = (LinearLayout) findViewById(R.id.Layout_send);
        bt_send = (Button) findViewById(R.id.bt_send);

//#####################################################################################
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
//#####################################################################################

        Layout_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key = "efCJyJt41Uf6iKOCufxQPYhAhP8pBsNYLPdbK2x1";
                String Thing = "NodeMCU_Servo";
                String Channel = "Servo3";
                String Value = "1";

                Log.e(TAG,"bt_drug2 : servo3-1");
                HttpGetRequest_NodeMCU_Servo httpGetRequest_nodeMCU_servo =new HttpGetRequest_NodeMCU_Servo("1");
                httpGetRequest_nodeMCU_servo.execute(key,Thing,Channel,Value);

                Value = "0";
                HttpGetRequest_NodeMCU_Servo httpGetRequest_nodeMCU_servo_0 =new HttpGetRequest_NodeMCU_Servo("0");
                httpGetRequest_nodeMCU_servo_0.execute(key,Thing,Channel,Value);
                Log.e(TAG,"bt_drug1 : servo3-0");

            }
        });


        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key = "efCJyJt41Uf6iKOCufxQPYhAhP8pBsNYLPdbK2x1";
                String Thing = "NodeMCU_Servo";
                String Channel = "Servo3";
                String Value = "1";

                Log.e(TAG,"bt_drug2 : servo3-1");
                HttpGetRequest_NodeMCU_Servo httpGetRequest_nodeMCU_servo =new HttpGetRequest_NodeMCU_Servo("1");
                httpGetRequest_nodeMCU_servo.execute(key,Thing,Channel,Value);

                Value = "0";
                HttpGetRequest_NodeMCU_Servo httpGetRequest_nodeMCU_servo_0 =new HttpGetRequest_NodeMCU_Servo("0");
                httpGetRequest_nodeMCU_servo_0.execute(key,Thing,Channel,Value);
                Log.e(TAG,"bt_drug1 : servo3-0");

            }
        });

//#####################################################################################

    }
    public class HttpGetRequest_NodeMCU_Servo extends AsyncTask<String, Void, String> {

        private String Servo_status;

        //#####################################################################################
        public HttpGetRequest_NodeMCU_Servo(String Servo_status) {
            this.Servo_status = Servo_status;
        }

        //#####################################################################################
        @Override
        protected String doInBackground(String... params) {
            String Key = params[0];
            String Thing = params[1];
            String Channel = params[2];
            String Value = params[3];

            String Str_URL = "https://api.anto.io/channel/set/" + Key + "/" + Thing + "/" + Channel + "/" + Value;

            String result;
            String inputLine;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(Str_URL);
                //Create a connection
                HttpURLConnection connection = (HttpURLConnection)
                        myUrl.openConnection();
                //Set methods and timeouts
                connection.setRequestMethod("GET");
                connection.setReadTimeout((1000 * 60) * 5);
                connection.setConnectTimeout((1000 * 60) * 5);

                //Connect to our url
                connection.connect();
                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                //Check if the line we are reading is not null
                while ((inputLine = reader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();
                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
                result = null;
            }
            return result;
        }

        //#####################################################################################
        protected void onPostExecute(String result) {

            String err = null;
            String status = "";
            Log.e(TAG, result);
            try {

                JSONObject root = new JSONObject(result);
                status = root.getString("result");

                Log.e(TAG, status);

                if (status.equals("true")) {

                    if (Servo_status.equals("1")) {

                        Toast toast = Toast.makeText(getApplication(), "จ่ายยาเรียบร้อย", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();
                    }

                } else {

                    if (Servo_status.equals("1")) {

                        Toast toast = Toast.makeText(getApplication(), "จ่ายยาไม่สำเร็จเนื่องจากระบบขัดข้อง!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();

                    }
                }


            } catch (JSONException e) {

                e.printStackTrace();
                err = "Exception: " + e.getMessage();

            }
        }
        //#####################################################################################
    }

}
