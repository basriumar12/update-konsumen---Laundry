package com.samyotech.laundry.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.laundry.R;
import com.samyotech.laundry.databinding.AdapterOperationalBinding;
import com.samyotech.laundry.databinding.AdapterPreviewBinding;
import com.samyotech.laundry.model.CurrencyDTO;
import com.samyotech.laundry.model.OperationalDto;
import com.samyotech.laundry.model.OperationalDto;
import com.samyotech.laundry.preferences.SharedPrefrence;
import com.samyotech.laundry.utils.AppFormat;

import java.util.ArrayList;
import java.util.List;

public class OperationalAdapter extends RecyclerView.Adapter<OperationalAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    AdapterOperationalBinding binding;
    Context kContext;
    List<OperationalDto> servicesDTOArrayList;
    CurrencyDTO currencyDTO;
    private SharedPrefrence prefrence;

    public OperationalAdapter(Context kContext, ArrayList<OperationalDto> servicesDTOArrayList) {
        this.kContext = kContext;
        this.servicesDTOArrayList = servicesDTOArrayList;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_operational, parent, false);
        return new MyViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        binding.tvDate.setText("Hari : " + servicesDTOArrayList.get(position).getHari());
        binding.tvTime.setText("Jam Buka : " + servicesDTOArrayList.get(position).getJamBuka() + " Jam Tutup: " + servicesDTOArrayList.get(position).getJamTutup());
    }

    @Override
    public int getItemCount() {
        return servicesDTOArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AdapterOperationalBinding binding;

        public MyViewHolder(@NonNull AdapterOperationalBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
