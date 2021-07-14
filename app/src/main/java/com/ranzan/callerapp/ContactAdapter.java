package com.ranzan.callerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private ArrayList<Contact> contactArrayList;
    private OnItemClicked onItemClicked;

    public ContactAdapter(ArrayList<Contact> contactArrayList, OnItemClicked onItemClicked) {
        this.contactArrayList = contactArrayList;
        this.onItemClicked = onItemClicked;
    }

    @NonNull

    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ContactViewHolder(view, onItemClicked);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactArrayList.get(position);
        holder.setData(contact);

    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }
}
