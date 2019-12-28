package com.dialnsearch.test;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.dialnsearch.test.Adapter.MyAdapter;
import com.dialnsearch.test.Adapter.MyCustomPagerAdapter;
import com.dialnsearch.test.Adapter.VerticalRecycleViewAdapter;
import com.dialnsearch.test.Adapter.WhatNewAdapter;
import com.dialnsearch.test.Model.Data;
import com.dialnsearch.test.Model.HorizontalModel;
import com.dialnsearch.test.Model.VerticalModel;
import com.dialnsearch.test.Model.WhatNew;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //https://github.com/MukeshKumar009/EcomSample/tree/master/app
    ViewPager viewPager;
    int images[] = {R.drawable.images1, R.drawable.images2, R.drawable.images3, R.drawable.images4};
    MyCustomPagerAdapter myCustomPagerAdapter;
    private static final String HI = "http://www.json-generator.com/api/json/get/cejcxXrxHC?indent=2";
    private static final String HI2 = "http://www.json-generator.com/api/json/get/cgtcSOYEwO?indent=2";
    private static final String JSON_URL = "http://www.json-generator.com/api/json/get/cpRcGcVOdK?indent=2";
    private RecyclerView rv,rv2,rv3;
    private List<Data>list_datas;
    private List<Data> list_data;
    private List<WhatNew> list_data1;
    private MyAdapter adapter;
    private WhatNewAdapter whatNewAdapter;

    //private MyNameAdapter myNameAdapter;
    private JsonArrayRequest request,request2,request3;
    private RequestQueue requestQueue;
    //VerticalRecycleViewAdapter adapter;
    //ArrayList<VerticalModel> arrayListVertical;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        myCustomPagerAdapter = new MyCustomPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
        rv=(RecyclerView)findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false));
        list_datas=new ArrayList<>();
        list_data=new ArrayList<>();
        list_data1=new ArrayList<>();
        rv2=(RecyclerView)findViewById(R.id.recyclerView2);
        rv2.setHasFixedSize(true);
        rv2.setLayoutManager(new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false));
        rv2=(RecyclerView)findViewById(R.id.recyclerView2);

        rv3=(RecyclerView)findViewById(R.id.recyclerView3);
        rv3.setHasFixedSize(true);
        rv3.setLayoutManager(new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false));
        getData();
        getData2();
        getData3();
    }

    private void getData3() {

        request3=new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for (int i=0; i<response.length(); i++){
                    try {
                        JSONObject ob=response.getJSONObject(i);
                        WhatNew movie =new WhatNew();
                        movie.setOriginalprice(ob.getInt("original price"));
                        movie.setDiscountedprice(ob.getInt("discounted price"));
                        movie.setSave(ob.getString("save"));
                        movie.setName(ob.getString("name"));
                        movie.setImgurl(ob.getString("imgurl"));

                        list_data1.add(movie);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupData3(list_data1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request3);
    }

    private void setupData3(List<WhatNew> list_datas) {
        whatNewAdapter=new WhatNewAdapter(list_datas,this);
        rv3.setAdapter(whatNewAdapter);
        Log.d("Demo", "WhatNewAdapter"+list_datas);
        Log.d("Demo", "WhatNewAdapter"+rv3);
    }

    private void getData2() {

        request2=new JsonArrayRequest(HI2, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for (int i=0; i<response.length(); i++){
                    try {
                        JSONObject ob=response.getJSONObject(i);
                        Data listData1 =new Data(ob.getString("imgurl"));
                        list_data.add(listData1);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupData2( list_data);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request2);
    }

    private void setupData2(List<Data>  list_data) {

        adapter=new MyAdapter( list_data,this);
        rv2.setAdapter(adapter);
    }


    private void getData() {
        request=new JsonArrayRequest(HI, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;

                for (int i=0; i<response.length(); i++){

                    try {
                        JSONObject ob=response.getJSONObject(i);

                        Data listData =new Data(ob.getString("imgurl"));
                        list_datas.add(listData);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setupData(list_datas);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    private void setupData(List<Data> list_datas) {
        adapter=new MyAdapter(list_datas,this);
        rv.setAdapter(adapter);
        Log.d("Demo", "setupData"+list_datas);
        Log.d("Demo", "rv"+rv);
    }
}
