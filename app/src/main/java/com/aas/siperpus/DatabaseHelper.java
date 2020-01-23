package com.aas.siperpus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Deklarasai variable constant
    private static final String DB_NAME = "db_perpus";
    private static final String TABLE_NAME = "tbl_buku";
    private static final String JUDUL = "judul";
    private static final String PENGARANG = "pengarang";
    private static final String TAHUN = "tahun";
    private static final String GENRE = "genre";

    // Create Contructor
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    // Implement method dari extends
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table
        createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
        // Untuk menghapus table bila sudah ada
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Membuat table jika belum ada
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(id integer primary key autoincrement, " + JUDUL + " text, " +
                PENGARANG + " text, " + TAHUN + " text, " + GENRE + "text)");

    }

    // Buat method untuk menampilkan seluruh data
    public String getData() {
        // Deklarasi variable yang dibutuhkan
        String result = "";

        // Membuat akses sqlite
        SQLiteDatabase db = this.getReadableDatabase();

        // Membuat cursor dan rawquery
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME,
                null);

        // Mengambil value dari cursor ke string
        // Checking data dari cursor
        while (cursor.moveToNext()) {
            // Mengambil data
            result += cursor.getInt(0) + "\t | \t" +
                    cursor.getString(1) + "\t | \t" +
                    cursor.getString(2) + "\t | \t" +
                    cursor.getString(3) + "\t | \t" +
                    cursor.getString(4) + "\t | \n";
        }

        // Tutup cursor
        cursor.close();

        // Nilai balik / return statement
        return result;
    }

    // Buat method untuk melakukan insert data
    public void insertData(String judul, String pengarang, String tahun, String genre) {
        // Koneksi dengan sqlite
        SQLiteDatabase db = this.getWritableDatabase();

        // Membuat contentvalues untuk insert
        ContentValues cv = new ContentValues();

        // Proses insert data dengan contentvalues
        cv.put(JUDUL, judul);
        cv.put(PENGARANG, pengarang);
        cv.put(TAHUN, tahun);
        cv.put(GENRE, genre);
        db.insert(TABLE_NAME, null, cv);
    }

    // Implement method dari extends
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Dibiarkan kosong saja
    }
}
