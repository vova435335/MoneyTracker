package com.vld.moneytracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> data = new ArrayList<>();

    public void setData(List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addItem(Item item){
        data.add(0, item);
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = data.get(position);
        holder.applyData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Item item) {
            title.setText(item.name);
            price.setText(String.format(itemView.getResources().getString(R.string.price), item.price));
        }
    }
}
