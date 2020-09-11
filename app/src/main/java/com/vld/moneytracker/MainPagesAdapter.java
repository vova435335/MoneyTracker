package com.vld.moneytracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPagesAdapter extends FragmentPagerAdapter {

    public MainPagesAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Bundle bundle = new Bundle();
            bundle.putInt(ItemsFragment.TYPE_KEY, ItemsFragment.TYPE_INCOMES);

            Fragment fragment = new ItemsFragment();
            fragment.setArguments(bundle);

            return fragment;
        } else if (position == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt(ItemsFragment.TYPE_KEY, ItemsFragment.TYPE_EXPENSES);

            Fragment fragment = new ItemsFragment();
            fragment.setArguments(bundle);

            return fragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Доходы";
        } else if (position == 1) {
            return "Расходы";
        }
        return null;
    }
}
