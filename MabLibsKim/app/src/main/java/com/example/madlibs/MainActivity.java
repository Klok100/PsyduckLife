package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendInfo(View v){

        int num1, num2;

        try {

            //getting a reference to my edit text fields
            EditText myName = (EditText) findViewById(R.id.editName);
            EditText myAdj = (EditText) findViewById(R.id.editAdj);
            RadioButton buttonMale = (RadioButton) findViewById(R.id.buttonMale);
            RadioButton buttonFemale = (RadioButton) findViewById(R.id.buttonFemale);
            RadioGroup selectGender = (RadioGroup) findViewById(R.id.selectGender);
            String version = "-1";

            if (selectGender.getCheckedRadioButtonId() == -1) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Please select your gender",
                        Toast.LENGTH_SHORT);

                toast.show();
            }

            else {
                if (buttonMale.isChecked()) {
                    version = "0";
                } else {
                    version = "1";
                }

                // extracting the test from those edit text fields
                String myNameStr = myName.getText().toString();
                String myAdjStr = myAdj.getText().toString();



                else if (myAdjStr.equals(""))
                {
                    num1 = 0;
                    num2 = 50/num1;
                }if (myNameStr.equals(""))
                {
                    num1 = 0;
                    num2 = 50/num1;
                }

                // creating the intent object so I can send the data
                Intent intent = new Intent(this, FillActivity.class);

                // putting data from edit text fields into intent to send to other activity
                //MY_NAME and MY_AGE are constants in InfoActivity class
                intent.putExtra(FillActivity.MY_NAME, myNameStr);
                intent.putExtra(FillActivity.MY_ADJ, myAdjStr);
                intent.putExtra(FillActivity.MY_VERSION, version);

                // loads the next activity
                startActivity(intent);
            }

        }

        catch(Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please make sure to fill in all of the information.",
                    Toast.LENGTH_SHORT);

            toast.show();
        }

    }

    public void create(View v)
    {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Coming soon!!",
                Toast.LENGTH_SHORT);

        toast.show();
    }
}

