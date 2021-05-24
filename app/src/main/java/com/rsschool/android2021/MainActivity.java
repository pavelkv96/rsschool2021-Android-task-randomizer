package com.rsschool.android2021;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements OnFragmentCallback, FragmentOnAttachListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFirstFragment(0);
    }

    @Override
    public void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        getSupportFragmentManager().addFragmentOnAttachListener(this);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, firstFragment);
        transaction.commitNow();
    }

    @Override
    public void openSecondFragment(int min, int max) {
        final Fragment secondFragment = SecondFragment.newInstance(min, max);
        getSupportFragmentManager().addFragmentOnAttachListener(this);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, secondFragment);
        transaction.commitNow();
    }

    @Override
    public void onAttachFragment(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Fragment fragment) {
        if (fragment instanceof FirstFragment) {
            ((FirstFragment) fragment).setOnFragmentListener(this);
        } else if (fragment instanceof SecondFragment) {
            ((SecondFragment) fragment).setOnFragmentListener(this);
        } else
            throw new UnsupportedOperationException("Un support fragment: " + fragment.toString());
    }
}
