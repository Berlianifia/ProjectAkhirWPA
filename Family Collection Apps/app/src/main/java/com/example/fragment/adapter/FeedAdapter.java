package com.example.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.fragment.R;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    Context context;
    List<DataAdapter> dataAdapters;
    ImageLoader imageLoader;

    public FeedAdapter(List<DataAdapter> getDataAdapter, Context context){

        super();
        this.dataAdapters = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_data_feed, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder Viewholder, int position) {

        DataAdapter dataAdapterOBJ =  dataAdapters.get(position);

        imageLoader = ImageAdapter.getInstance(context).getImageLoader();

        imageLoader.get(dataAdapterOBJ.getimg(),
                ImageLoader.getImageListener(
                        Viewholder.imgvolley1,
                        R.mipmap.ic_launcher,
                        android.R.drawable.ic_dialog_alert
                )
        );

        Viewholder.imgvolley1.setImageUrl(dataAdapterOBJ.getimg(), imageLoader);
        Viewholder.txtnama1.setText(dataAdapterOBJ.getnama());
        Viewholder.txttext1.setText(dataAdapterOBJ.getdeskripsi());


    }

    @Override
    public int getItemCount() {

        return dataAdapters.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtnama1;
        public NetworkImageView imgvolley1;
        public TextView txttext1;

        public ViewHolder(View itemView) {

            super(itemView);

            txtnama1 = (TextView) itemView.findViewById(R.id.txtnama1) ;
            imgvolley1 = (NetworkImageView) itemView.findViewById(R.id.imgvolley1) ;
            txttext1 = (TextView) itemView.findViewById(R.id.txt_text1) ;

        }
    }
}
