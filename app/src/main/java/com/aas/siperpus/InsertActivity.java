package com.aas.siperpus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class InsertActivity extends AppCompatActivity {

    //Deklarasi
    private EditText edtJudul, edtPengarang, edtTahun;
    private RadioButton rbHorror, rbFantasy, rbRomance;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        // Koneksi dengan layout
        edtJudul = findViewById(R.id.edt_judul);
        edtPengarang = findViewById(R.id.edt_pengarang);
        edtTahun = findViewById(R.id.edt_tahun);
        rbHorror = findViewById(R.id.rb_horror);
        rbFantasy = findViewById(R.id.rb_fantasy);
        rbRomance = findViewById(R.id.rb_romantis);
        btnSubmit = findViewById(R.id.btn_submit);
    }
}
