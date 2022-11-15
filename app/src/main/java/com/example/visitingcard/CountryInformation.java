package com.example.visitingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class CountryInformation extends AppCompatActivity {

    TextView nameView,officialNameView,nativeNameView,capitalView,currenciesView,populationView,areaView;
    String Url="https://restcountries.com/v3.1/name/";
//    String Url1 ="http://universities.hipolabs.com/search?name=middle";

    String official_name,native_name,currencies="",capital="",area,map,population,flag;

    ImageView flagImage;
    WebView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_information);




        String country=getIntent().getStringExtra("info");
        nameView=findViewById(R.id.name);
        officialNameView=findViewById(R.id.officialName);
        nativeNameView=findViewById(R.id.nativeName);
        capitalView=findViewById(R.id.capital);
        currenciesView=findViewById(R.id.currencies);
        populationView=findViewById(R.id.population);
        areaView=findViewById(R.id.area);


        nameView.setText(country);

        Url=Url+country;
        universityList();
    }

    public void universityList() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray arrayData=new JSONArray(response);
                    JSONObject objData=arrayData.getJSONObject(0);

                    //name
                    JSONObject nameObj=objData.getJSONObject("name");
                    official_name=nameObj.getString("official");
                    officialNameView.setText(official_name);

                    //native name
                    JSONObject nativeObj=nameObj.getJSONObject("nativeName");
                    Iterator<String> item = nativeObj.keys(); //This should be the iterator you want.
                    while(item.hasNext()){
                        String key = item.next();
                        JSONObject nativeName=nativeObj.getJSONObject(key);
                        native_name=nativeName.getString("official");
                    }
                    nativeNameView.setText(native_name);

                    //currencies

                    JSONObject currenciesObj=objData.getJSONObject("currencies");
                    Iterator<String> currenciesItem=currenciesObj.keys();

                    while(currenciesItem.hasNext()){
                        String key=currenciesItem.next();
                        JSONObject currencieName=currenciesObj.getJSONObject(key);
                        currencies+=key+"("+ currencieName.getString("symbol")+") ";
                    }
                    currenciesView.setText(currencies);

                    //capital
                    JSONArray capitalArray=objData.getJSONArray("capital");
                    if(capitalArray.length()>0){
                        for (int i=0;i<capitalArray.length();i++){
                            capital+=capitalArray.getString(i)+" ,";

                        }

                    }
                    capitalView.setText(capital);
                    //area
                    area=objData.getString("area");
                    areaView.setText(area);

                    //map
                    JSONObject mapObj=objData.getJSONObject("maps");
                    map=mapObj.getString("googleMaps");
                    setMap(map);

                    //population
                    population=objData.getString("population");
                    populationView.setText(population);

                    //flag
                    JSONObject flagsObj=objData.getJSONObject("flags");
                    flag=flagsObj.getString("png");
                    setFlagImage(flag);




                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void setMap(String map) {
        mapView=findViewById(R.id.map);
        mapView.setWebViewClient(new WebViewClient());
        mapView.getSettings().setJavaScriptEnabled(true);
        mapView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mapView.loadUrl(map);
    }

    private void setFlagImage(String flagUrl) {
        flagImage=findViewById(R.id.flag);
        Glide.with(this).load(flagUrl).into(flagImage);

    }
}