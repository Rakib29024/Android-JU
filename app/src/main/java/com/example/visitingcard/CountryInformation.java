package com.example.visitingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CountryInformation extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_information);


        result=findViewById(R.id.result);
        result.setText(getIntent().getStringExtra("info"));
    }
}