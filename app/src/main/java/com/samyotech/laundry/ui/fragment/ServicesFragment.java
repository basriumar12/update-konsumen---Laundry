package com.samyotech.laundry.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.samyotech.laundry.R;
import com.samyotech.laundry.databinding.FragmentServicesBinding;
import com.samyotech.laundry.https.HttpsRequest;
import com.samyotech.laundry.interfaces.Consts;
import com.samyotech.laundry.interfaces.Helper;
import com.samyotech.laundry.model.PopLaundryDTO;
import com.samyotech.laundry.model.ShopServicesDTO;
import com.samyotech.laundry.ui.activity.ShopAcitivity;
import com.samyotech.laundry.ui.adapter.ServiceAdapter;
import com.samyotech.laundry.utils.ProjectUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServicesFragment extends Fragment {

    String TAG = ServicesFragment.class.getSimpleName();
    FragmentServicesBinding binding;
    PopLaundryDTO popLaundryDTO;
    HashMap<String, String> params = new HashMap<>();
    ArrayList<ShopServicesDTO> shopServicesDTOS = new ArrayList<>();
    GridLayoutManager linearLayoutManager;
    ServiceAdapter serviceAdapter;
    ShopAcitivity serviceAcitivity;
    private Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_services, container, false);

        bundle = this.getArguments();
        popLaundryDTO = (PopLaundryDTO) bundle.getSerializable(Consts.SHOPDTO);
        getSerivces();
        return binding.getRoot();
    }


    private void getSerivces() {

        ProjectUtils.getProgressDialog(getActivity());
        params.put(Consts.SHOP_ID, popLaundryDTO.getShop_id());
        new HttpsRequest(Consts.GETSHOPSERVICES, params, getActivity())
                .stringPost(TAG, new Helper() {
                    @Override
                    public void backResponse(boolean flag, String msg, JSONObject response) throws JSONException {
                        ProjectUtils.pauseProgressDialog();
                        if (flag) {
                            try {
                                shopServicesDTOS = new ArrayList<>();
                                Type getPetDTO = new TypeToken<List<ShopServicesDTO>>() {
                                }.getType();
                                shopServicesDTOS = new Gson().fromJson(response.getJSONArray("data").toString(), getPetDTO);

                                binding.rvServices.setVisibility(View.VISIBLE);
                                binding.ctvnodata.setVisibility(View.GONE);
                                setData();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        } else {
                            binding.rvServices.setVisibility(View.GONE);
                            binding.ctvnodata.setVisibility(View.VISIBLE);
                        }
                    }
                });


    }

    private void setData() {

        linearLayoutManager = new GridLayoutManager(requireContext(), 3);
        binding.rvServices.setLayoutManager(linearLayoutManager);
        serviceAdapter = new ServiceAdapter(getActivity(), shopServicesDTOS,popLaundryDTO);
        binding.rvServices.setAdapter(serviceAdapter);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        serviceAcitivity = (ShopAcitivity) context;
    }


}
