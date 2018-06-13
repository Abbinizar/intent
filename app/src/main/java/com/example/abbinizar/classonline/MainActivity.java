package com.example.abbinizar.classonline;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edPanjang, edLebar, edTinggi;
    private Button bHitung, bPindah, bPindahdata, bPindahobjek, bDial, bResult;
    private TextView tHasil, tvResult;
    private static final String STATE_HASIL = "state_hasil";
    private int REQUEST_CODE = 100;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL , tHasil.getText().toString());
        super.onSaveInstanceState(outState);
    }

    private Button btnMove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edPanjang = (EditText)findViewById(R.id.etPanjang);
        edLebar = (EditText)findViewById(R.id.etLebar);
        edTinggi = (EditText)findViewById(R.id.etTinggi);
        bHitung = (Button)findViewById(R.id.btnHitung);
        tHasil = (TextView)findViewById(R.id.txtHasil);
        bPindah = (Button)findViewById(R.id.btnPindah);
        bPindahdata = (Button)findViewById(R.id.btnPindahdata);
        bPindahobjek = (Button)findViewById(R.id.btnPindahobjek);
        bDial = (Button)findViewById(R.id.btnDial);
        bResult = (Button)findViewById(R.id.btnResult);
        tvResult = (TextView)findViewById(R.id.tv_Hasil);
        bPindah.setOnClickListener(this);
        bPindahobjek.setOnClickListener(this);
        bPindahdata.setOnClickListener(this);
        bDial.setOnClickListener(this);
        bResult.setOnClickListener(this);
        bHitung.setOnClickListener(this);
        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tHasil.setText(hasil);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btnHitung){
            String lenght = edPanjang.getText().toString().trim();
            String widht = edLebar.getText().toString().trim();
            String height = edTinggi.getText().toString().trim();
            boolean isEmpty = false;
            if (TextUtils.isEmpty(lenght)){
                isEmpty = true;
                edPanjang.setError("harus diisi");
            }
            if (TextUtils.isEmpty(widht)){
                isEmpty = true;
                edLebar.setError("harus diisi");
            }
            if (TextUtils.isEmpty(height)){
                isEmpty = true;
                edTinggi.setError("harus diisi");
            }
            if (!isEmpty){
                double l = Double.parseDouble(lenght);
                double w = Double.parseDouble(widht);
                double h = Double.parseDouble(height);
                double volume = l*w*h;
                tHasil.setText(String.valueOf(volume));
            }
        }
        switch (view.getId()){
            case R.id.btnPindah:
                Intent moveIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(moveIntent);
                break;
            case R.id.btnPindahdata:
                Intent moveDataIntent = new Intent(MainActivity.this, MoveDataActivity.class);
                moveDataIntent.putExtra(MoveDataActivity.EXTRA_NAME, "alex" );
                moveDataIntent.putExtra(MoveDataActivity.EXTRA_AGE, 10);
                startActivity(moveDataIntent);
                break;
            case R.id.btnDial:
                String phoneNumber = "082232462529";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhone);
                break;
            case R.id.btnPindahobjek:
                person mPerson = new person();
                mPerson.setNama("abbi");
                mPerson.setAge(21);
                mPerson.setEmail("abbi@gmail.com");
                mPerson.setCity("Banyuwangi");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);
                break;
            case R.id.btnResult:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}

