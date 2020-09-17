package com.vld.moneytracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BalanceFragment extends Fragment {

    private String type;

    public static BalanceFragment createBalanceFragment(String type){
        Bundle bundle = new Bundle();
        bundle.putString(AddItemActivity.TYPE_KEY, type);

        BalanceFragment fragment = new BalanceFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        type = bundle.getString(AddItemActivity.TYPE_KEY, Item.TYPE_BALANCE);

        if (type.equals(Item.TYPE_UNKNOWN)) {
            throw new IllegalArgumentException("Unknown type");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_balance, container, false);
    }
}
