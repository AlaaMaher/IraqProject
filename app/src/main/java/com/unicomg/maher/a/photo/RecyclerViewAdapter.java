package com.unicomg.maher.a.photo;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder>{

    List<PhotoModel> mValues = new ArrayList<>();
    Context mContext;
    protected ItemListener mListener;

    public RecyclerViewAdapter(Context context, List<PhotoModel> values, ItemListener itemListener) {

        mValues = values;
        mContext = context;
        mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

      //  public TextView textView;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        PhotoModel item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            imageView = (ImageView) v.findViewById(R.id.imageOffice);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayoutPhoto);

        }

        public void setData(PhotoModel item) {
            this.item = item;
            imageView.setImageURI(item.getOfficephoto());



            //imageView.setImageResource(item.drawable);
           // relativeLayout.setBackgroundColor(Color.parseColor(item.color));

        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.photo_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position) {
        Uri imageUrl=mValues.get(position).getOfficephoto();
        Picasso.with(mContext).load(imageUrl).resize(93, 60).into(Vholder.imageView);

        //Vholder.setData(mValues.get(position).getOfficephoto());

    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(PhotoModel item);
    }
}