package vn.poly.edu.qlsachpn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.poly.edu.qlsachpn.adapter.NguoiDungAdapter;
import vn.poly.edu.qlsachpn.model.NguoiDung;
import vn.poly.edu.qlsachpn.sqlite.MySqlite;
import vn.poly.edu.qlsachpn.sqlite.UserDAO;

public class QLNguoiDungActivity extends AppCompatActivity {

    private ListView listView;
    private MySqlite mySqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_l_nguoi_dung);
        listView = findViewById(R.id.lvList);

        mySqlite = new MySqlite(this);
        UserDAO userDAO = new UserDAO(mySqlite);


        List<NguoiDung> nguoiDungList = userDAO.getAllUsers();

        NguoiDungAdapter nguoiDungAdapter = new NguoiDungAdapter(nguoiDungList);

        listView.setAdapter(nguoiDungAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_user) {

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(QLNguoiDungActivity.this);
            View view = LayoutInflater.from(this).inflate(R.layout.alert_add_user, null);
            builder.setView(view);

            final EditText editTextTextPersonName = view.findViewById(R.id.editTextTextPersonName);
            final EditText editTextTextPersonName2 = view.findViewById(R.id.editTextTextPersonName2);
            final EditText editTextTextPersonName3 = view.findViewById(R.id.editTextTextPersonName3);
            final EditText editTextTextPersonName4 = view.findViewById(R.id.editTextTextPersonName4);
            Button btn_save = view.findViewById(R.id.button);
            Button btn_cancel = view.findViewById(R.id.button2);

            final AlertDialog alertDialog = builder.show();

            btn_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String username = editTextTextPersonName.getText().toString().trim();
                    String password = editTextTextPersonName2.getText().toString().trim();
                    String name = editTextTextPersonName3.getText().toString().trim();
                    String phone = editTextTextPersonName4.getText().toString().trim();


                    


                }
            });

            btn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();
                }
            });

        }
        return super.onOptionsItemSelected(item);
    }
}