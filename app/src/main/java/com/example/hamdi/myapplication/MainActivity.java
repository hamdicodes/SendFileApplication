package com.example.hamdi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button btnSend , btnRecieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Oluşturduğumuz değişkeni butonlarla ilişkilendiriyoruz.
        btnSend= (Button)findViewById(R.id.btnSend);
        btnRecieve=(Button)findViewById(R.id.btnRecieve);

        //Butonlara tıklama özelliği kazandırıyoruz.
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ardından Intent methodunu kullanarak nereden nereye gideceğini söylüyoruz.  sendFile.class
                Intent intocan = new Intent(MainActivity.this, sendFile.class);
                startActivity(intocan);
            }
        });

        btnRecieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent methodunu kullanarak nereden nereye gideceğini söylüyoruz.
                Intent intocan = new Intent(MainActivity.this, receive_file.class);
                startActivity(intocan);
            }
        });

    }

}
