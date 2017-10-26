package com.example.amit.amitproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{

    TextView textView;
    EditText editText;
    NumberPicker num1;
    private boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.editText);
        textView=(TextView) findViewById(R.id.textView);
        num1=(NumberPicker) findViewById(R.id.num1);
        num1.setMinValue(0);
        num1.setClickable(true);
        num1.setOnValueChangedListener(this);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//              textView.setText("" +editText.getLineCount());
                num1.setMaxValue(Integer.parseInt("" +editText.getLineCount())-1);
                if((editText.getText().length() % 30 == 0) && !flag) {
                    editText.append("\n");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }


    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        String text = editText.getText().toString();
        String subtext = "";
        try {
          subtext  = text.substring(numberPicker.getValue() * 30, ((numberPicker.getValue() * 30)) + 30 ) ;
        } catch (StringIndexOutOfBoundsException e) {
            subtext  = text.substring(numberPicker.getValue() * 30, text.length()) ;
        }

        Toast.makeText(this, "selectedText: " + subtext, Toast.LENGTH_SHORT).show();
    }
}
