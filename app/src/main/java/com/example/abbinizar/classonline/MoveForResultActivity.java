package com.example.abbinizar.classonline;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnChoose;
    private RadioGroup rgNumber;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 110;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        btnChoose = (Button)findViewById(R.id.btnHasil);
        btnChoose.setOnClickListener(this);
        rgNumber = (RadioGroup) findViewById(R.id.rbNumber);


    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btnHasil){
            if (rgNumber.getCheckedRadioButtonId() != 0){
                int value = 0;
                switch (rgNumber.getCheckedRadioButtonId()){
                    case R.id.rb50:
                        value= 50;
                        break;
                    case  R.id.rb100:
                        value= 100;
                        break;
                    case R.id.rb150:
                        value= 150;
                        break;
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();

            }
        }
    }
}
