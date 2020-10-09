package vn.poly.edu.qlsachpn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.List;
import java.util.Random;

import vn.poly.edu.qlsachpn.adapter.LoaiSachSpinnerAdapter;
import vn.poly.edu.qlsachpn.model.TheLoaiSach;
import vn.poly.edu.qlsachpn.sqlite.MySqlite;
import vn.poly.edu.qlsachpn.sqlite.TypeBookDAO;

public class QLTheLoaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_the_loai);

        Spinner spinner = findViewById(R.id.spinner);
        TypeBookDAO typeBookDAO = new TypeBookDAO(new MySqlite(this));
        List<TheLoaiSach> theLoaiSaches = typeBookDAO.getAllTypeBooks();


        for (int i = 0; i < 100; i++) {
            TheLoaiSach theLoaiSach =
                    new TheLoaiSach(String.valueOf(new Random().nextInt()),
                            String.valueOf(new Random().nextInt()),
                            String.valueOf(new Random().nextInt()),
                            String.valueOf(new Random().nextInt()));
            typeBookDAO.addTypeBook(theLoaiSach);
        }
        LoaiSachSpinnerAdapter sachSpinnerAdapter =
                new LoaiSachSpinnerAdapter(theLoaiSaches);

        spinner.setAdapter(sachSpinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}