package com.example.lucky;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
TextView txt;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt=findViewById(R.id.textView3);
        btn=findViewById(R.id.button2);

        Intent i = getIntent();
        String UserName = i.getStringExtra("name");

        int num = random();
        txt.setText(""+num);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedata(UserName,num);
            }
        });


    }
    public void sharedata(String name, int num){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, name + "got lucky !! ");
        i.putExtra(Intent.EXTRA_TEXT, "Its lucky number is : "+num);
        startActivity(Intent.createChooser(i,"Choose Platform"));
    }
    public int random(){
        Random random = new Random();
        int upper_Limit = 1000;
        int RandomNumber = random.nextInt(upper_Limit);
        return RandomNumber;
    }
}