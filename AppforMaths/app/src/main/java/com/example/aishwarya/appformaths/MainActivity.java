package com.example.aishwarya.appformaths;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private RadioGroup maths;
    private Button submit,clear;
    private RadioButton select;
    private int firstNumber=0;
    private int secondNumber=0;
    private EditText n1;
    private EditText n2;
    private int result=0;
    String value1,value2;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb1=(RadioButton)findViewById(R.id.add);
        rb2=(RadioButton)findViewById(R.id.subtract);
        rb3=(RadioButton)findViewById(R.id.multiply);
        rb4=(RadioButton)findViewById(R.id.divide);
        addListenerOnButton();
        Button clear=(Button) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText et1=(EditText) findViewById(R.id.firstNumber);
                et1.setText("");
                EditText et2=(EditText) findViewById(R.id.secondNumber);
                et2.setText("");
                TextView resultBox=(TextView)findViewById(R.id.resultBox);
                resultBox.setText("");

            }
        });

    }

    public void addListenerOnButton(){
       maths=(RadioGroup)findViewById(R.id.radioMaths);
        submit=(Button)findViewById(R.id.calculateButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=maths.getCheckedRadioButtonId();
                select=(RadioButton)findViewById(selectedId);
                TextView resultBox=(TextView)findViewById(R.id.resultBox);
                n1=(EditText)findViewById(R.id.firstNumber);
                 n2=(EditText)findViewById(R.id.secondNumber);
                value1=n1.getText().toString();
                value2=n2.getText().toString();
                firstNumber=Integer.parseInt(value1);
                secondNumber=Integer.parseInt(value2);
                if(rb1.isChecked()==true)
                {
                    result=firstNumber+secondNumber;
                    resultBox.setText("Result= " + String.valueOf(result));
                }
                else if(rb2.isChecked()==true)
                {
                    result=firstNumber-secondNumber;
                    resultBox.setText("Result= " + String.valueOf(result));
                }
                else if(rb3.isChecked()==true)
                {
                    result=firstNumber*secondNumber;
                    resultBox.setText("Result= " + String.valueOf(result));
                }
                else if(rb4.isChecked()==true) {
                    if (secondNumber == 0) {
                        resultBox.setText("Error");
                    } else {
                        result = firstNumber / secondNumber;
                        resultBox.setText("Result= " + String.valueOf(result));
                    }
                }



            }
        }
        );
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
