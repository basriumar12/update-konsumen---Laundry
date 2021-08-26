package com.samyotech.laundry.ui.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samyotech.laundry.R;
import com.samyotech.laundry.interfaces.Consts;
import com.samyotech.laundry.model.GetCommentDTO;
import com.samyotech.laundry.model.UserDTO;
import com.samyotech.laundry.utils.ProjectUtils;

import java.util.ArrayList;

/**
 * Created by VARUN on 01/01/19.
 */
public class ChatAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<GetCommentDTO> getCommentDTOList;
    private final UserDTO userDTO;
    String mypic = "", otherpic = "";
    private ImageView ivImageD;
    private TextView tvCloseD, tvNameD;
    private Dialog dialogImg;

    public ChatAdapter(Context mContext, ArrayList<GetCommentDTO> getCommentDTOList, UserDTO userDTO, String mypic, String otherpic) {
        this.mContext = mContext;
        this.getCommentDTOList = getCommentDTOList;
        this.userDTO = userDTO;
        this.mypic = mypic;
        this.otherpic = otherpic;

    }

    @Override
    public int getCount() {
        return getCommentDTOList.size();
    }

    @Override
    public Object getItem(int postion) {
        return getCommentDTOList.get(postion);
    }

    @Override
    public long getItemId(int postion) {
        return postion;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        //ViewHolder holder = new ViewHolder();
        GetCommentDTO item = getCommentDTOList.get(position);
        if (!item.getTo_user_id().equalsIgnoreCase(userDTO.getUser_id())) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_view_comment_my, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.adapter_view_comment, parent, false);
        }

        TextView textViewMessage = view.findViewById(R.id.textViewMessage);
        TextView textViewTime = view.findViewById(R.id.textViewTime);
        ImageView media = view.findViewById(R.id.media);
        TextView status = view.findViewById(R.id.status);
        if (item.getIs_read().equals("1")) {
            status.setText("Dibaca");
        } else {
            status.setText("");
        }

        try {


            if (item.getType().equalsIgnoreCase("2")) {
                media.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(Consts.BASE_URL + item.getMedia()).into(media);
            } else {
                media.setVisibility(View.GONE);
            }
        }catch (NullPointerException e){

        }
        textViewMessage.setText(item.getMessage());

        try {
            textViewTime.setText(ProjectUtils.convertTimestampToTime(ProjectUtils.correctTimestamp(Long.parseLong(item.getCreated_at()))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public void dialogshare(int pos) {
        dialogImg = new Dialog(mContext, android.R.style.Theme_Dialog);
        dialogImg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogImg.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialogImg.setContentView(R.layout.dailog_image_view);

/*
        tvCloseD = (TextView) dialogImg.findViewById(R.id.tvCloseD);
        tvNameD = (TextView) dialogImg.findViewById(R.id.tvNameD);

        ivImageD = (ImageView) dialogImg.findViewById(R.id.ivImageD);*/
        dialogImg.show();
        dialogImg.setCancelable(false);

        tvCloseD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogImg.dismiss();

            }
        });

    }


}
