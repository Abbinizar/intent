package com.example.abbinizar.classonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = (TextView)findViewById(R.id.btnObjectReceiver);
        person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Nama : "+ mPerson.getNama()+ ", Email : "+ mPerson.getEmail()+ ", Age : "+mPerson.getAge()+", Location : "+mPerson.getCity();
        tvObject.setText(text);

    }
}
