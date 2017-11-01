package com.vk.amakaev.amazingtariffcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import static com.vk.amakaev.amazingtariffcalc.R.id.textNumber;
import static com.vk.amakaev.amazingtariffcalc.R.id.textPerUnit;

public class MainActivity extends AppCompatActivity {
    EditText textNumber, textPerUnit;
    Button btnOk;
    Button btnCancel;
    Button ruBtn;
    Button enBtn;
    String mLang;
    private Locale mNewLocale;
    TextView txtV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        textNumber = (EditText) findViewById(R.id.textNumber);
        textPerUnit = (EditText) findViewById(R.id.textPerUnit);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        ruBtn = (Button) findViewById(R.id.ru);
         enBtn = (Button) findViewById(R.id.en);

    View.OnClickListener oclBtnOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            String numberOfUnits = textNumber.getText().toString();
            String rateForUnit = textPerUnit.getText().toString();
            float numberOfUnitsFloat = Float.parseFloat(numberOfUnits);
            float rateForUnitFloat = Float.parseFloat(rateForUnit);
            float totalResult = rateForUnitFloat * numberOfUnitsFloat;
            String printResult = String.valueOf(totalResult);
            textNumber.setText("Total amount:");
            textPerUnit.setText(printResult);
        }
    };
    // присвоим обработчик кнопке OK (btnOk)
        btnOk.setOnClickListener(oclBtnOk);


View.OnClickListener clickBtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.en:
                        setLocale("en");
                        break;
                    case R.id.ru:
                        setLocale("ru");
                        break;
                    default:

                }
            }
        };

        ruBtn.setOnClickListener(clickBtn);
        enBtn.setOnClickListener(clickBtn);


    void setLocale(String mLang) {
        Locale newLocale = new Locale(mLang);
        Locale.setDefault(mNewLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = mNewLocale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        //updateTextView();
    }

}

}