package com.aas.siperpus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    // Deklarasi
    private EditText edtJudul, edtPengarang, edtTahun;
    private RadioButton rbHorror, rbFantasy, rbRomance;
    private Button btnSubmit;
    private DatabaseHelper dbHelper;

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

        // Membuat object db helper
        dbHelper = new DatabaseHelper(this);

        // Membuat aksi onClick pada button submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deklarasi variable
                String judul, pengarang, tahun, genre;

                // Mengambil value dari layout
                judul = edtJudul.getText().toString();
                pengarang = edtPengarang.getText().toString();
                tahun = edtTahun.getText().toString();

                // Mengambil value radio button
                if(rbHorror.isChecked()){
                    genre = rbHorror.getText().toString();
                } else if(rbFantasy.isChecked()){
                    genre = rbFantasy.getText().toString();
                } else if (rbRomance.isChecked()){
                    genre = rbRomance.getText().toString();
                } else {
                    genre = "";
                }

                // Proses insert data
                dbHelper.insertData(judul, pengarang, tahun, genre);

                Toast.makeText(InsertActivity.this, "Insert Successful",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}
