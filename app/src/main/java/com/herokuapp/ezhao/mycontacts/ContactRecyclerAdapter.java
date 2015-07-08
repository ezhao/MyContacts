package com.herokuapp.ezhao.mycontacts;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder> {
    private List<ContactInfo> contactList;

    public ContactRecyclerAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View contactView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_contact, viewGroup, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ContactInfo contactInfo = contactList.get(i);
        viewHolder.tvName.setText(contactInfo.name);
        viewHolder.tvEmail.setText(contactInfo.email);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvName;
        protected TextView tvEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        }
    }

}
