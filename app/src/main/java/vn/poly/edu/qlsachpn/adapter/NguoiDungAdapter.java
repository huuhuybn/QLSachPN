package vn.poly.edu.qlsachpn.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import vn.poly.edu.qlsachpn.R;
import vn.poly.edu.qlsachpn.model.NguoiDung;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nguoi_dung,
                viewGroup, false);

        TextView tvName = view.findViewById(R.id.tvName);
        tvName.setText(nguoiDungList.get(i).username + " - "+nguoiDungList.get(i).ten);

        return view;
    }
}
