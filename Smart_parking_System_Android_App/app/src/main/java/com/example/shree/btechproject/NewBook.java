package com.example.shree.btechproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewBook extends AppCompatActivity {
    Button but5,but6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        but5=(Button)findViewById(R.id.but5);
        but6=(Button)findViewById(R.id.but6);
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(NewBook.this,Slot1.class);
                Bundle b = new Bundle();

                //Inserts a String value into the mapping of this Bundle
                b.putString("but5", but5.getText().toString());

                //Add the bundle to the intent.
                i1.putExtras(b);

                startActivity(i1);
            }
        });
    }
}
