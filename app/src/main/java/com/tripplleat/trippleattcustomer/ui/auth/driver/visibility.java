package com.tripplleat.trippleattcustomer.ui.auth.driver;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tripplleat.trippleattcustomer.R;

public class visibility extends AppCompatActivity {

    RadioButton radioButton;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_product_loose);

        radioButton = findViewById(R.id.rb_loose_add_product);
        radioGroup  = findViewById(R.id.units);

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    radioGroup.setVisibility(buttonView.VISIBLE);
                }

            }
        });


    }
}
