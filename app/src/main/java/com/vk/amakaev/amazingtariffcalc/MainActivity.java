package com.vk.amakaev.amazingtariffcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.vk.amakaev.amazingtariffcalc.R.id.textNumber;
import static com.vk.amakaev.amazingtariffcalc.R.id.textPerUnit;

public class MainActivity extends AppCompatActivity {
    EditText textNumber,textPerUnit;
    Button btnOk;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // найдем View-элементы
        textNumber = (EditText) findViewById(R.id.textNumber);
        textPerUnit = (EditText) findViewById(R.id.textPerUnit);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String  numberOfUnits=textNumber.getText().toString();
                String  rateForUnit=textPerUnit.getText().toString();
                float numberOfUnitsFloat=Float.parseFloat(numberOfUnits);
                float rateForUnitFloat=Float.parseFloat(rateForUnit);
                float totalResult=rateForUnitFloat*numberOfUnitsFloat;
                String printResult=String.valueOf(totalResult);
                textNumber.setText("Total amount:");
                textPerUnit.setText(printResult);
            }
        };
        // присвоим обработчик кнопке OK (btnOk)
        btnOk.setOnClickListener(oclBtnOk);
    }
}
