package vn.poly.edu.qlsachpn.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlite extends SQLiteOpenHelper {

    // test github
    public MySqlite(Context context) {
        super(context, "mydata.sql", null, 1);
    }

    // khai bao bang
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String user_table = "CREATE TABLE USER (username char(15) primary key" +
                ",name varchar(50),password varchar" +
                ",numberPhone char)";
        sqLiteDatabase.execSQL(user_table);

//
//        public String maTheLoai;
//        public String tenTheLoai;
//        public String viTri;
//        public String moTa;

        String theLoaiSach = "Create table TheLoai(maTheLoai text primary key," +
                "tenTheLoai text,viTri Text,moTa text)";

        sqLiteDatabase.execSQL(theLoaiSach);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
