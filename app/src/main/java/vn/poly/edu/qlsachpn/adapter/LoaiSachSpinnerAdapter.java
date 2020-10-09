package vn.poly.edu.qlsachpn.adapter;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

import vn.poly.edu.qlsachpn.R;
import vn.poly.edu.qlsachpn.model.TheLoaiSach;

public class LoaiSachSpinnerAdapter implements SpinnerAdapter {

    private List<TheLoaiSach> theLoaiSaches;

    public LoaiSachSpinnerAdapter(List<TheLoaiSach> theLoaiSaches) {
        this.theLoaiSaches = theLoaiSaches;
    }

    // hang khi mo spinner
    @Override
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.spinner_row, viewGroup, false);
        TextView tvContent = view.findViewById(R.id.tvContent);
        tvContent.setText(getItem(i).maTheLoai +
                " - " + getItem(i).tenTheLoai);
        return view;
    }

    // hang khi dong spinner

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.spinner_row_default, viewGroup, false);

        TextView tvSelected = view.findViewById(R.id.tvSelected);
        tvSelected.setText(getItem(i).maTheLoai +
                " - " + getItem(i).tenTheLoai);

        
        return view;
    }

    @Override
    public int getCount() {
        return theLoaiSaches.size();
    }


    @Override
    public TheLoaiSach getItem(int i) {
        return theLoaiSaches.get(i);
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public int getItemViewType(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }
}
