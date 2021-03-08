package com.example.shree.btechproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ParkHere extends AppCompatActivity {
    Button but1,but2,but3,but4,but6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_here);
        Intent intent = getIntent();
       // String markerTitle= intent.getExtras().getString("markertitle");
        but1=(Button)findViewById(R.id.but1);
        but2=(Button)findViewById(R.id.but2);
        but3=(Button)findViewById(R.id.but3);
        but4=(Button)findViewById(R.id.but4);
        but6=(Button)findViewById(R.id.but6);


        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParkHere.this,NewBook.class);
                startActivity(i);
            }
        });
    }
}
