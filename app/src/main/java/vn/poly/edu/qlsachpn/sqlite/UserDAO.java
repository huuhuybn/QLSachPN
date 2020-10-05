package vn.poly.edu.qlsachpn.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vn.poly.edu.qlsachpn.model.NguoiDung;

public class UserDAO {
    private SQLiteDatabase sqLiteDatabase;

    public UserDAO(MySqlite mySqlite) {
        sqLiteDatabase = mySqlite.getWritableDatabase();
    }

    // them
    public long insertUser(NguoiDung nguoiDung) {
        if (!checkExistUser(nguoiDung.username)) {

            // ghép cặp giá trị với tên
            ContentValues contentValues = new ContentValues();
            contentValues.put("username", nguoiDung.username);
            contentValues.put("name", nguoiDung.ten);
            contentValues.put("password", nguoiDung.password);
            contentValues.put("numberPhone", nguoiDung.sdt);

            // gọi câu lênh insert - kiểm tra kết quả
            return sqLiteDatabase.insert("user", null, contentValues);

        } else return -1;

    }

    // sua
    public int updateUser(NguoiDung nguoiDung) {
        // ghép cặp giá trị với tên
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", nguoiDung.ten);
        contentValues.put("password", nguoiDung.password);
        contentValues.put("numberPhone", nguoiDung.sdt);

        // gọi câu lênh insert - kiểm tra kết quả
        return sqLiteDatabase.update("user",
                contentValues, "username=?",
                new String[]{nguoiDung.username});
    }

    // xoa
    public int delUser(String id) {
        return sqLiteDatabase.delete("user", "username=?",
                new String[]{id});
    }

    // lay danh sach

    public List<NguoiDung> getAllUsers() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String select = "SELECT * FROM user";

        Cursor cursor = sqLiteDatabase.rawQuery(select, null);

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                String username = cursor.getString(0);
                String ten = cursor.getString(1);
                String password = cursor.getString(2);
                String sdt = cursor.getString(3);

                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.ten = ten;
                nguoiDung.password = password;
                nguoiDung.sdt = sdt;
                nguoiDung.username = username;

                nguoiDungList.add(nguoiDung);

                cursor.moveToNext();
            }
            cursor.close();

        }

        return nguoiDungList;
    }

    //  check ton tai cua username

    public boolean checkExistUser(String username) {

        // kiem tra user da tồn tại hay chưa ?
        String compare = "SELECT * FROM user WHERE username='"
                + username + "'";

        Log.e("CAU LENH", compare);

        Cursor cursor = sqLiteDatabase.rawQuery(compare, null);

        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }

}
