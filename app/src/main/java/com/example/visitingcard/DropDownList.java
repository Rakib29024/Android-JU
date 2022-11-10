package com.example.visitingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class DropDownList extends AppCompatActivity {

    Spinner countrySpiner,citySpiner;
    String[] countryList;
    String[] cityList;
    String selectedItem;
    TextView result;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drop_down_list);
        countrySpiner=findViewById(R.id.country);
//        citySpiner=findViewById(R.id.city);
//        result=findViewById(R.id.result);
        submitBtn=findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DropDownList.this,CountryInformation.class);
                in.putExtra("info",selectedItem);
                startActivity(in);
//                result.setText(selectedItem);
            }
        });

        getCountryListToDD();
//      getCityListDD();
    }


    private void getCountryListToDD() {
        ArrayAdapter<String> cityAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.country_list));
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpiner.setAdapter(cityAdapter);


        countrySpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                selectedItem = parent.getItemAtPosition(position).toString();

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


    }

//    private void getCountryListToDD() {
//        ArrayAdapter<String> countryAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,countryList);
//        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        countrySpiner.setAdapter(countryAdapter);
//
//    }

}