package com.example.visitingcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner countrySpiner,citySpiner;
    String[] countryList={"USA","Bangladesh"};
    String[] cityList;
    String selectedItem;
    TextView result;
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drop_down_list);
//        countrySpiner=findViewById(R.id.country);
        citySpiner=findViewById(R.id.city);
        result=findViewById(R.id.result);
        submitBtn=findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(selectedItem);
            }
        });

//        getCountryListToDD();
        getCityListDD();
    }

    private void getCityListDD() {
        ArrayAdapter<String> cityAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.country_list));
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpiner.setAdapter(cityAdapter);


        citySpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
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