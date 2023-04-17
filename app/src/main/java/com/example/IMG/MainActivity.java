package com.example.IMG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    EditText txtp;
    EditText txtt;
    EditText txta;

    //RadioButton rbh;

    RadioGroup group = null;
    Button btnc;
    TextView tvimg;
    TextView inter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtp=findViewById(R.id.txtp);
        txtt=findViewById(R.id.txtt);
        txta=findViewById(R.id.txta);
        tvimg=findViewById(R.id.txtimg);
        inter=findViewById(R.id.inter);
        btnc=findViewById(R.id.btnc);
        group=findViewById(R.id.group);

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer tai=0;
                Integer poi=0;
                Integer ag=0;
                Integer s=0;
                float img=0;

                    poi = Integer.parseInt(txtp.getText().toString());
                    tai = Integer.parseInt(txtt.getText().toString());
                    ag = Integer.parseInt(txta.getText().toString());



                float imc=(float) (poi / Math.pow(tai/ 100.0,2));
                if(group.getCheckedRadioButtonId()== R.id.rdbHomme){
                    s=1;}
                else if(group.getCheckedRadioButtonId()== R.id.rdbFemme){
                    s=0;}

                if (tai==0 || poi==0 || ag==0) {
                    Toast.makeText(MainActivity.this, "Saisie invalide", Toast.LENGTH_LONG).show();
                } else if ( ag >= 16) {
                    img = (float) ((1.20 * imc) * (0.23 * ag) - (10.8 * s) - 5.4);
                }else

                    img=(float)((1.51 * imc)*(0.70 * ag)-(3.6 * s)+1.4);

                if (s==0){
                    if (img<25){
                        tvimg.setText(img+"%");
                        inter.setText("Trop maigre");

                    } else if (img>30) {
                        tvimg.setText(img+"%");
                        inter.setText("Trop de graisse");

                    }
                    else{
                        inter.setText("Pourcentage normal");
                        tvimg.setText(img+"%");
                    } }else if (s==1){
                    if (img<15){
                        inter.setText("Trop maigre");
                        tvimg.setText(img+"%");
                    } else if (img>15 && img<20) {
                        tvimg.setText(img+"%");
                        inter.setText("Pourcentage normal");

                    }
                    else{
                        tvimg.setText(img+"%");
                        inter.setText("Trop de graisse");

                    }

                }

            }
        });
    }
    }