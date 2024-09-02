package com.example.learningproejct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightInch;
        Button btnSubmit;
          TextView txtResult = findViewById(R.id.result);
          edtWeight = findViewById(R.id.weight);
          edtHeightFt = findViewById(R.id.heightft);
          edtHeightInch = findViewById(R.id.heightinch);
          btnSubmit = findViewById(R.id.submit);

          btnSubmit.setOnClickListener(new View.OnClickListener() {

                                           @Override
                                           public void onClick(View view) {
                                           /* int weight = Integer.parseInt(edtWeight.getText().toString());
                                            int heightFeet = Integer.parseInt(edtHeightFt.getText().toString());
                                            int heightInch = Integer.parseInt(edtHeightInch.getText().toString());

                                            int totalInch = heightFeet*12 + heightInch;
                                            double totalCm = totalInch*(2.53);
                                            double totalM = totalCm/100;
                                            double BMIT = weight / (totalM *totalM);

                                            if(BMIT > 25) {
                                                txtResult.setText("You are over weight");
                                            } else if(BMIT<18) {
                                                txtResult.setText("You are under weight");
                                            } else {
                                                txtResult.setText("You are Healthy");
                                            }
*/
                                               Intent  intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
                                               startActivity(intent);
                                           }
          }

          );
      }
}