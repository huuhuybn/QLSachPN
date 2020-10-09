package vn.poly.edu.qlsachpn.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.poly.edu.qlsachpn.model.NguoiDung;
import vn.poly.edu.qlsachpn.model.TheLoaiSach;

public class TypeBookDAO {

    private MySqlite mySqlite;

    public TypeBookDAO(MySqlite mySqlite) {
        this.mySqlite = mySqlite;
    }


    // add        String theLoaiSach = "Create table TheLoai(maTheLoai text primary key," +
    //                "tenTheLoai text,viTri Text,moTa text)";

    public boolean addTypeBook(TheLoaiSach theLoaiSach) {
        // xin quyen 1
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        // ghép cặp giá trị vào tên cột 2
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai", theLoaiSach.maTheLoai);
        contentValues.put("moTa", theLoaiSach.moTa);
        contentValues.put("tenTheLoai", theLoaiSach.tenTheLoai);
        contentValues.put("viTri", theLoaiSach.viTri);
        // truy vấn 3
        long kq = sqLiteDatabase.insert("TheLoai", null, contentValues);

        if (kq > 0) return true;
        else return false;

    }

    // update
    public boolean updateTheLoai(TheLoaiSach theLoaiSach) {
        // xin quyen 1
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();
        // ghép cặp giá trị vào tên cột 2
        ContentValues contentValues = new ContentValues();
        contentValues.put("maTheLoai", theLoaiSach.maTheLoai);
        contentValues.put("moTa", theLoaiSach.moTa);
        contentValues.put("tenTheLoai", theLoaiSach.tenTheLoai);
        contentValues.put("viTri", theLoaiSach.viTri);
        // truy vấn 3
        long kq = sqLiteDatabase.update("TheLoai", contentValues, "maTheLoai=?",
                new String[]{theLoaiSach.maTheLoai});

        if (kq > 0) return true;
        else return false;

    }

    // del
    public boolean delTypeBook(String id) {
        // xin quyen 1
        SQLiteDatabase sqLiteDatabase = mySqlite.getWritableDatabase();

        // truy vấn 3
        long kq = sqLiteDatabase.delete("TheLoai", "maTheLoai=?",
                new String[]{id});

        if (kq > 0) return true;
        else return false;

    }

    // get all

    public List<TheLoaiSach> getAllTypeBooks() {
        List<TheLoaiSach> theLoaiSaches = new ArrayList<>();
        String sql = "SELECT * FROM TheLoai";
        Cursor cursor = mySqlite.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String maTheLoai = cursor.getString(0);
                String tenTheLoai = cursor.getString(1);
                String viTri = cursor.getString(2);
                String moTa = cursor.getString(3);

                TheLoaiSach theLoaiSach =
                        new TheLoaiSach(maTheLoai, tenTheLoai, viTri, moTa);
                theLoaiSaches.add(theLoaiSach);

                cursor.moveToNext();
            }
        }

        return theLoaiSaches;
    }


    public List<NguoiDung> timKiemUsername(String TimUsername) {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String sql = "SELECT * FROM USER WHERE username LIKE '%" + TimUsername + "%'";
        Cursor cursor = mySqlite.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String username = cursor.getString(0);
                String name = cursor.getString(1);
                String password = cursor.getString(2);
                String std = cursor.getString(3);

                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.username = username;
                nguoiDung.ten = name;
                nguoiDung.password = password;
                nguoiDung.sdt = std;

                nguoiDungList.add(nguoiDung);
                cursor.moveToNext();
            }
        }

        return nguoiDungList;
    }


}
