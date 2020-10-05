package vn.poly.edu.qlsachpn.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vn.poly.edu.qlsachpn.R;
import vn.poly.edu.qlsachpn.model.NguoiDung;
import vn.poly.edu.qlsachpn.sqlite.MySqlite;
import vn.poly.edu.qlsachpn.sqlite.UserDAO;

public class NguoiDungAdapter extends BaseAdapter {

    public NguoiDungAdapter(List<NguoiDung> nguoiDungList) {
        this.nguoiDungList = nguoiDungList;
    }

    private List<NguoiDung> nguoiDungList;

    @Override
    public int getCount() {
        return nguoiDungList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nguoi_dung,
                viewGroup, false);

        TextView tvName = view.findViewById(R.id.tvName);
        tvName.setText(nguoiDungList.get(i).username + " - " + nguoiDungList.get(i).ten);

        view.findViewById(R.id.btnDel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDAO userDAO = new UserDAO(new MySqlite(viewGroup.getContext()));
                String username = nguoiDungList.get(i).username;
                boolean ketQua = userDAO.delUser(username);
                if (ketQua) {
                    Toast.makeText(viewGroup.getContext(), "Xoa Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();

                    nguoiDungList.remove(i);
                    notifyDataSetChanged();

                } else {
                    Toast.makeText(viewGroup.getContext(), "Xoa KHONG Thanh Cong!!!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
