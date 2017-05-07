package com.example.liuhaiyang.materialdesignanimation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liuhaiyang.materialdesignanimation.R;
import com.example.liuhaiyang.materialdesignanimation.model.ShareElementModel;

import java.util.List;

/**
 * Created by liuhaiyang on 2017/5/5.
 */

public class ShareElementAdapter extends RecyclerView.Adapter<ShareElementAdapter.MyViewHolder> {

    private List<ShareElementModel> mDatas;
    private Context mContext;
    private OnElementItemClickListener mListener;

    public ShareElementAdapter(Context context) {
        this.mContext = context;
    }

    public void setmDatas(List<ShareElementModel> datas) {
        this.mDatas = datas;
        notifyDataSetChanged();
    }

    public void setLoaclListener(OnElementItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {

        return mDatas.size();
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_shareelement, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mImgIv.setBackgroundResource(mDatas.get(position).imgRecorce);
        holder.mNameTv.setText(mDatas.get(position).name);
        holder.mItemRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener == null) {
                    return;
                }
                mListener.onElementItemClick(holder.mImgIv,holder.mNameTv, mDatas.get(position));
            }
        });
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout mItemRl;
        TextView mNameTv;
        ImageView mImgIv;

        MyViewHolder(View view) {
            super(view);
            mItemRl = (RelativeLayout) view.findViewById(R.id.rl_item);
            mNameTv = (TextView) view.findViewById(R.id.tv_name);
            mImgIv = (ImageView) view.findViewById(R.id.iv_img);
        }
    }

    public interface OnElementItemClickListener {
        void onElementItemClick(ImageView imageView,TextView textView, ShareElementModel model);
    }
}
