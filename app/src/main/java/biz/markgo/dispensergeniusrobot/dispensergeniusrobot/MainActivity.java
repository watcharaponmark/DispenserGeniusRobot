package biz.markgo.dispensergeniusrobot.dispensergeniusrobot;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import biz.markgo.dispensergeniusrobot.dispensergeniusrobot.menu.AntihistamineActivity;
import biz.markgo.dispensergeniusrobot.dispensergeniusrobot.menu.DiarrheaActivity;
import biz.markgo.dispensergeniusrobot.dispensergeniusrobot.menu.PainkillerActivity;
import biz.markgo.dispensergeniusrobot.dispensergeniusrobot.menu.TravelSicknessTabletsActivity;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private Button bt_drug1;
    private Button bt_drug2;
    private Button bt_drug3;
    private Button bt_drug4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//#####################################################################################

        bt_drug1 = (Button) findViewById(R.id.bt_drug1);
        bt_drug2 = (Button) findViewById(R.id.bt_drug2);
        bt_drug3 = (Button) findViewById(R.id.bt_drug3);
        bt_drug4 = (Button) findViewById(R.id.bt_drug4);

//#####################################################################################
        bt_drug1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PainkillerActivity.class);
                startActivity(intent);

            }
        });
//#####################################################################################
        bt_drug2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AntihistamineActivity.class);
                startActivity(intent);

            }
        });
//#####################################################################################
        bt_drug3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TravelSicknessTabletsActivity.class);
                startActivity(intent);


            }
        });
//#####################################################################################
        bt_drug4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DiarrheaActivity.class);
                startActivity(intent);

            }
        });
//#####################################################################################
    }

}
