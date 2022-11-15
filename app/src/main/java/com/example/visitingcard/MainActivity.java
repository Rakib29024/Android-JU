package com.example.visitingcard;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView title,mobileView,emailView;
    Button phoneBtn;
    ImageView logoView,qrView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this, DropDownList.class);
                startActivity(in);

            }
        });

        logoClick();
        qrClick();
        phoneClick();
        mobileClick();
        emailClick();
    }


    public void logoClick() {
        logoView=findViewById(R.id.logo);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent softwareSite=new Intent(Intent.ACTION_VIEW);
                softwareSite.setData(Uri.parse("https://www.peoplentech.net"));
                startActivity(softwareSite);
            }
        });
    }

    public void qrClick() {
        qrView=findViewById(R.id.qr);
        qrView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("https://www.peoplentech.com.bd"));
                startActivity(in);
            }
        });
    }

    public void phoneClick() {
        phoneBtn=findViewById(R.id.phoneId);
        phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:"+phoneBtn.getText()));
                startActivity(in);
            }
        });
    }

    public void mobileClick() {
        mobileView=findViewById(R.id.mobile);
        mobileView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:"+mobileView.getText()));
                startActivity(in);;
            }
        });
    }

    public void emailClick() {
        emailView=findViewById(R.id.email);
        emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_SENDTO);
                in.setData(Uri.parse("mailto:"));
                in.putExtra(Intent.EXTRA_EMAIL, emailView.getText());
                in.putExtra(Intent.EXTRA_SUBJECT, "I am Rakib");
                startActivity(in);
            }
        });
    }
}