package com.bawei.zhoukao3_a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/6/23/0023.
 */
public class Second extends Activity {

    private TextView second_tianQi;
    private TextView second_wenDu;
    private TextView second_shiJian;
    private ListView second_listView;
    private Bean.ResultBean.FutureBean future;
    private List<Bean.ResultBean.FutureBean> list;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);


        TextView second_DiQu = (TextView) findViewById(R.id.second_DiQu);

        second_listView = (ListView) findViewById(R.id.second_ListView);


        Intent intent = getIntent();
        String string = intent.getStringExtra("diqu");

        second_DiQu.setText(string);


        try {

            String s = new HttpAsyncTask().execute("").get();

            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            future = bean.getResult().getFuture();

            list = new ArrayList<Bean.ResultBean.FutureBean>();
            list.add(future);

            ListAdapter adapter = new ListAdapter();
            second_listView.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }


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

            view = View.inflate(Second.this, R.layout.second_listview, null);
            second_shiJian = (TextView) view.findViewById(R.id.second_ShiJian);
            second_tianQi = (TextView) view.findViewById(R.id.second_TianQi);
            second_wenDu = (TextView) view.findViewById(R.id.second_WenDu);


            second_tianQi.setText(list.get(i).getDay_20170624().getWeather());
            second_tianQi.setText(list.get(i).getDay_20170625().getWeather());
            second_wenDu.setText(list.get(i).getDay_20170624().getTemperature());
            second_wenDu.setText(list.get(i).getDay_20170625().getTemperature());
            second_shiJian.setText(list.get(i).getDay_20170624().getDate());
            second_shiJian.setText(list.get(i).getDay_20170625().getDate());

            return view;
        }
    }


}
