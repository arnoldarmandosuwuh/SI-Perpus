package com.aas.siperpus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Deklarasi
    private TextView tvData;
    private Button btnInsert;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Koneksi dengan layout
        tvData = findViewById(R.id.tv_hasil);
        btnInsert = findViewById(R.id.btn_insert);

        // Memanggil class db helper
        dbHelper = new DatabaseHelper(this);

        // Membuat aksi onClick pada button insert untuk membuka activity insert
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuka activity insert
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Memanggil method getdata dari db helper
        String data = dbHelper.getData();

        // Menampilkan data ke tvData
        tvData.setText(data);
    }
}
