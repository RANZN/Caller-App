package com.ranzan.callerapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView number;
    private ConstraintLayout cLayout;
    private OnItemClicked onItemClicked;

    public ContactViewHolder(@NonNull View itemView, OnItemClicked onItemClicked) {
        super(itemView);
        this.onItemClicked = onItemClicked;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        name = itemView.findViewById(R.id.tvName);
        number = itemView.findViewById(R.id.tvContact);
        cLayout = itemView.findViewById(R.id.layout);
    }

    protected void setData(Contact contact) {
        name.setText(contact.getName());
        number.setText(contact.getContactNo());
        cLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicked.onItemClicked(contact, getAdapterPosition());
            }
        });
    }
}
