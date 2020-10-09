package vn.poly.edu.qlsachpn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vn.poly.edu.qlsachpn.adapter.LoaiSachSpinnerAdapter;
import vn.poly.edu.qlsachpn.adapter.NguoiDungAdapter;
import vn.poly.edu.qlsachpn.model.NguoiDung;
import vn.poly.edu.qlsachpn.model.TheLoaiSach;
import vn.poly.edu.qlsachpn.sqlite.MySqlite;
import vn.poly.edu.qlsachpn.sqlite.TypeBookDAO;
import vn.poly.edu.qlsachpn.sqlite.UserDAO;

public class QLTheLoaiActivity extends AppCompatActivity {


    TheLoaiSach theLoaiSach = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_the_loai);

        Spinner spinner = findViewById(R.id.spinner);

        final List<TheLoaiSach> theLoaiSaches = new
                TypeBookDAO(new MySqlite(this)).getAllTypeBooks();

        TheLoaiSach vuiLongChon =
                new TheLoaiSach("-1", "--Vui long chon--", "-1", "-1");
        theLoaiSaches.add(0, vuiLongChon);


        LoaiSachSpinnerAdapter sachSpinnerAdapter =
                new LoaiSachSpinnerAdapter(theLoaiSaches);

        spinner.setAdapter(sachSpinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    theLoaiSach = theLoaiSaches.get(i);
                else {
                    theLoaiSach = null;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void save(View view) {
        if (theLoaiSach == null) {
            Toast.makeText(this,
                    "Ban chua chon the loai sach", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,
                    "Ban da chon the loai sach", Toast.LENGTH_SHORT).show();
        }
    }
}