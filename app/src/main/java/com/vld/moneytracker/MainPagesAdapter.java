package com.vld.moneytracker;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainPagesAdapter extends FragmentPagerAdapter {

    private static final int PAGE_INCOMES = 0;
    private static final int PAGE_EXPENSES = 1;
    private static final int PAGE_BALANCE = 2;

    private String titles[];

    public MainPagesAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);

        titles = context.getResources().getStringArray(R.array.tab_titles);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case PAGE_INCOMES:
                return ItemsFragment.createItemsFragment(ItemsFragment.TYPE_INCOMES);


            case PAGE_EXPENSES:
                return ItemsFragment.createItemsFragment(ItemsFragment.TYPE_EXPENSES);


            case PAGE_BALANCE:
                return BalanceFragment.createBalanceFragment(ItemsFragment.TYPE_BALANCE);

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
