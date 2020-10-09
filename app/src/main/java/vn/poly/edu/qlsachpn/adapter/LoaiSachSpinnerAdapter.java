package vn.poly.edu.qlsachpn.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vn.poly.edu.qlsachpn.R;
import vn.poly.edu.qlsachpn.model.TheLoaiSach;

public class LoaiSachSpinnerAdapter extends BaseAdapter {

    public LoaiSachSpinnerAdapter(List<TheLoaiSach> theLoaiSaches) {
        this.theLoaiSaches = theLoaiSaches;
    }

    private List<TheLoaiSach> theLoaiSaches;


    @Override
    public int getCount() {
        return theLoaiSaches.size();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.my_spinner_row, viewGroup, false);

        TextView tvContent = view.findViewById(R.id.textView);

        TheLoaiSach theLoaiSach = theLoaiSaches.get(i);
        tvContent.setText(theLoaiSach.tenTheLoai);
        return view;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
