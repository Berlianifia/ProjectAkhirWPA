package com.example.fragment.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;
import com.android.volley.toolbox.ImageLoader;
import com.example.fragment.R;
import com.example.fragment.model.Category;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.RecyclerView;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {

    Context context;
    List<Category> mKategoriList;


    public KategoriAdapter(List<Category> mKategoriList, Context context){

        this.mKategoriList = mKategoriList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_data, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {


        Viewholder.txtnama.setText(mKategoriList.get(position).getKategori());

    }

    @Override
    public int getItemCount() {

        return (mKategoriList == null) ? 0 :  mKategoriList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtnama;


        public ViewHolder(View itemView) {

            super(itemView);
            txtnama = (TextView) itemView.findViewById(R.id.txtnama) ;

        }
    }
}
