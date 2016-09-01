package com.example.qbclct.expandableview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.qbclct.expandableview.Adapter.ExpandableListAdapter;
import com.example.qbclct.expandableview.Model.SubTopicsModel;
import com.example.qbclct.expandableview.Model.TopicModel;
import com.example.qbclct.expandableview.Model.TopicsResponse;
import com.example.qbclct.expandableview.R;
import com.example.qbclct.expandableview.REST.ApiClient;
import com.example.qbclct.expandableview.REST.ApiInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter expListAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    List<SubTopicsModel> subTopics;
//    DisplayMetrics metrics;

    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface apiInterface = ApiClient.getClient(this).create(ApiInterface.class);
        Call<TopicsResponse> call = apiInterface.getTopics("204");
        call.enqueue(new Callback<TopicsResponse>() {
            @Override
            public void onResponse(Response<TopicsResponse> response, Retrofit retrofit) {
                int statusCode = response.code();
                List<TopicModel> topicModels = response.body().getTopics();
                listDataHeader = new ArrayList<String>();
                listDataChild = new HashMap<String, List<String>>();


                for (TopicModel topicModel : topicModels){
                    listDataHeader.add(topicModel.getName());
                    subTopics = topicModel.getSubTopics();
                    List<String> subTopicsName = new ArrayList<String>();
                    for (SubTopicsModel subTopic : subTopics ){
                        subTopicsName.add(subTopic.getName());
                    }
                    listDataChild.put(topicModel.getName(), subTopicsName);
                }

                expListView = (ExpandableListView) findViewById(R.id.listView);
                expListAdapter = new ExpandableListAdapter(MainActivity.this, listDataHeader, listDataChild);
//                metrics = new DisplayMetrics();
//                getWindowManager().getDefaultDisplay().getMetrics(metrics);
//                int width = metrics.widthPixels;
//                expListView.setIndicatorBounds(width-GetDipsFromPixel(35), width-GetDipsFromPixel(5));
                expListView.setAdapter(expListAdapter);
            }

            @Override
            public void onFailure(Throwable t) {

            }

        });



    }
//    public int GetDipsFromPixel(float pixels)
//    {
//        // Get the screen's density scale
//        final float scale = getResources().getDisplayMetrics().density;
//        // Convert the dps to pixels, based on density scale
//        return (int) (pixels * scale + 0.5f);
//    }
}
