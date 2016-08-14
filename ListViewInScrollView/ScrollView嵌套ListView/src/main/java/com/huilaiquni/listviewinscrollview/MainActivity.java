package com.huilaiquni.listviewinscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ScrollView;
import android.widget.TextView;

import com.huilaiquni.listviewinscrollview.ui.widget.ListViewInScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * 自定义的listView
     */
    private ListViewInScrollView listViewInScrollView;

    ArrayList<String> list;

    private TextView tv;

    /**
     * listview的数据适配器
     */
    private Myadapter adapter;

    private ScrollView scrollView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        listViewInScrollView = (ListViewInScrollView)findViewById(R.id.listview);

        scrollView.smoothScrollTo(0,0);
        list = new ArrayList<>();
        initData();

    }

    public void initData() {

        for (int i = 1; i <= 107; i++) {

            list.add("回来娶你 " + i + " 回来娶你");

        }
        Log.e("ListViewInScrollView",""+list.size());
        adapter = new Myadapter();

        listViewInScrollView.setAdapter(adapter);

    }


    public class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = View.inflate(MainActivity.this, R.layout.item_listview, null);
            }
            tv = (TextView) convertView.findViewById(R.id.tv);
            tv.setText(list.get(position));
            return convertView;
        }


        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    }


}
