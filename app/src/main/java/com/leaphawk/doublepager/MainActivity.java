package com.leaphawk.doublepager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private BTFragmentGridPager.FragmentGridPagerAdapter mFragmentGridPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BTFragmentGridPager mFragmentGridPager = (BTFragmentGridPager) findViewById(R.id.fragmentGridPager);

        //mFragmentGridPager.setPageTransformer(false, new DefaultTransformer());

        mFragmentGridPagerAdapter = new BTFragmentGridPager.FragmentGridPagerAdapter() {

            private int rowCount;
            private int columnCount;

            @Override
            public int rowCount() {
                return rowCount;
            }

            @Override
            public void setRowCount(int rowCount) {
                this.rowCount = rowCount;
            }

            @Override
            public int columnCount(int row) {
                return this.columnCount;
            }

            @Override
            public void setColumnCount(int column) {
                this.columnCount = column;
            }

            @Override
            public Fragment getItem(BTFragmentGridPager.GridIndex index) {

                setColumnCount(4);
                setRowCount(4);
                DemoFragment panelFrag1 = new DemoFragment();
                panelFrag1.setGridIndex(index);

                return panelFrag1;
            }
        };

        mFragmentGridPager.setGridPagerAdapter(mFragmentGridPagerAdapter);

    }
}
