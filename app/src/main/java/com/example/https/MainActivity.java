package com.example.https;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private static String url =
            "https://svatru007.pythonanywhere.com/add";
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(getApplicationContext());
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(view -> {
            EditText etNumber1 = findViewById(R.id.etNumber1);
            EditText etNumber2 = findViewById(R.id.etNumber2);
            TextView tvResult = findViewById(R.id.tvResult);
            StringRequest stringRequest = new StringRequest(
                    Request.Method.GET,
                    url + "?a=" + etNumber1.getText() + "&b=" + etNumber2.getText()
                    , new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    tvResult.setText(response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(MainActivity.this, "Error" + error.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            }
            );
            queue.add(stringRequest);

        });

        Button btn1, btn2 , btn3;
        btn1 = findViewById(R.id.whatsapp);
        btn2 = findViewById(R.id.instagram);
        btn3 = findViewById(R.id.youtube);
        btn1.setOnClickListener(View ->{
            Intent intent = getPackageManager().getLaunchIntentForPackage("");
            startActivity(intent);
        });
        btn2.setOnClickListener(View ->{
            Intent intent = getPackageManager().getLaunchIntentForPackage("");
            startActivity(intent);
        });
        btn3.setOnClickListener(View ->{
            Intent intent = getPackageManager().getLaunchIntentForPackage("");
            startActivity(intent);
        });

    }
}