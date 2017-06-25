package com.bawei.zhoukao3_a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);

        list = new ArrayList<String>();
        list.add("北京");
        list.add("天津");
        list.add("上海");
        list.add("西安");
        list.add("太原");
        list.add("成都");
        list.add("大连");
        list.add("丽江");
        list.add("重庆");
        list.add("三亚");


        ListAdapter adapter = new ListAdapter();
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtra("diqu", list.get(i));
                startActivity(intent);

            }
        });

    }


    private class ListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = View.inflate(MainActivity.this, R.layout.listview, null);
            TextView diQu = (TextView) view.findViewById(R.id.diQu);
            diQu.setText(list.get(i));

            return view;
        }
    }


}
