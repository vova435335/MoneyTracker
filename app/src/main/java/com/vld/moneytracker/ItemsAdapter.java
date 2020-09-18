package com.vld.moneytracker;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> data = new ArrayList<>();
    private ItemsAdapterListener listener = null;

    public void setListener(ItemsAdapterListener listener) {
        this.listener = listener;
    }

    public void setData(List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addItem(Item item) {
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
        holder.bind(item, position, listener, selections.get(position, false));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private SparseBooleanArray selections = new SparseBooleanArray();

    public void toggleSelection(int position){
        if(selections.get(position, false)){
            selections.delete(position);
        } else {
            selections.put(position, true);
        }
        notifyItemChanged(position);
    }

    void clearSelections(){
        selections.clear();
        notifyDataSetChanged();
    }

    int getSelectedItemCount(){
        return selections.size();
    }

    List<Integer> getSelectedItems(){
        List<Integer> items = new ArrayList<>(selections.size());
        for (int i = 0; i < selections.size(); i++){
            items.add(selections.keyAt(i));
        }
        return items;
    }

    Item remove(int pos){
        final Item item = data.remove(pos);
        notifyItemRemoved(pos);
        return item;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(final Item item, final int position, final ItemsAdapterListener listener, boolean selected) {
            title.setText(item.name);
            price.setText(String.format(itemView.getResources().getString(R.string.price), item.price));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(item, position);
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (listener != null) {
                        listener.onItemLongClick(item, position);
                    }
                    return true;
                }
            });

            itemView.setActivated(selected);
        }
    }
}
