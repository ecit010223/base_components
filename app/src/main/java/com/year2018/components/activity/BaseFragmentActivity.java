package com.year2018.components.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.year2018.components.R;
import com.year2018.components.fragment.NoUIFragment;

/**
 * author：zyh
 * on: 2018/9/27 22:31
 */
public class BaseFragmentActivity extends Activity {

    public static void entry(Context from){
        Intent intent = new Intent(from,BaseFragmentActivity.class);
        from.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_fragment);

        Fragment fragment = new NoUIFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.rl_base_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.add(fragment, "month04.year16.nouifragment");
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Toast.makeText(BaseFragmentActivity.this, "fragment is back", Toast.LENGTH_SHORT).show();
            }
        });
        fragmentTransaction.commit();
    }
}
