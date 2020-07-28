package com.min.multifragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LeftListFragment leftListFragment = new LeftListFragment();
        RightListFragment rightListFragment = new RightListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.left_fragment, leftListFragment, "leftListFragment");//添加leftListFragment并为其设置tag leftListFragment
        transaction.add(R.id.right_fragment, rightListFragment, "rightListFragment");////添加rightListFragment并为其设置tag rightListFragment
        transaction.commit();
    }
}