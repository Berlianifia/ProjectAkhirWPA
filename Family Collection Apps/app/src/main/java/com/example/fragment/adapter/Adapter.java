package com.example.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;
import com.example.fragment.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<Contact> userList;
    public Adapter(ArrayList<Contact> userList) {
        this.userList = userList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.from(parent.getContext()).
                inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact=userList.get(position);
        holder.imageView.setImageResource(contact.getImage());
        holder.txtNama.setText(contact.getNama());
        holder.txtWaktu.setText(contact.getWaktu());
        holder.txtPesan.setText(contact.getPesan());
    }
    @Override
    public int getItemCount() {
        return userList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtNama;
        private TextView txtWaktu;
        private TextView txtPesan;
        public ViewHolder( View itemView){
            super(itemView);
            imageView =itemView.findViewById(R.id.imageview1);
            txtNama =itemView.findViewById(R.id.textview);
            txtWaktu=itemView.findViewById(R.id.textview2);
            txtPesan=itemView.findViewById(R.id.textview3);
        }
    }
}

