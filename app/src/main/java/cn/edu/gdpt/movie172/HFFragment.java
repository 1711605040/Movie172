package cn.edu.gdpt.movie172;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.PieChartView;

public class HFFragment extends Fragment {
    PieChartView chart;
    PieChartData chartData;

    public HFFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cn, container, false);
        chart = view.findViewById(R.id.chart);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = "http://apicloud.mob.com/boxoffice/day/query?key=2b5fb6ee3ab58&area=CN";
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Response execute = okHttpClient.newCall(new Request.Builder().get().url(s).build()).execute();
                    final Data data = new Gson().fromJson(execute.body().string(), Data.class);
                    ArrayList<SliceValue> entries = new ArrayList<>();
                    Float test = (Float) (Float.parseFloat(data.getResult().get(0).getCur())+ Float.parseFloat(data.getResult().get(1).getCur())+ Float.parseFloat(data.getResult().get(2).getCur())+ Float.parseFloat(data.getResult().get(3).getCur())+ Float.parseFloat(data.getResult().get(4).getCur())+ Float.parseFloat(data.getResult().get(5).getCur())+ Float.parseFloat(data.getResult().get(6).getCur())+ Float.parseFloat(data.getResult().get(7).getCur())+ Float.parseFloat(data.getResult().get(8).getCur())+ Float.parseFloat(data.getResult().get(9).getCur()));
                    Float one= (Float) (Float.parseFloat(data.getResult().get(0).getCur())/test);
                    Float two= (Float) (Float.parseFloat(data.getResult().get(1).getCur())/test);
                    Float three= (Float) (Float.parseFloat(data.getResult().get(2).getCur())/test);
                    Float four= (Float) (Float.parseFloat(data.getResult().get(3).getCur())/test);
                    Float five= (Float) (Float.parseFloat(data.getResult().get(4).getCur())/test);
                    Float six= (Float) (Float.parseFloat(data.getResult().get(5).getCur())/test);
                    Float seven= (Float) (Float.parseFloat(data.getResult().get(6).getCur())/test);
                    Float eight= (Float) (Float.parseFloat(data.getResult().get(7).getCur())/test);
                    Float nine= (Float) (Float.parseFloat(data.getResult().get(8).getCur())/test);
                    Float ten= Float.parseFloat(data.getResult().get(9).getCur())/test;
                    for (int i=0;i<10;i++){
                        switch (i+1){
                            case 1:
                                SliceValue sliceValue1=new SliceValue(i+1,ChartUtils.COLOR_BLUE);
                                sliceValue1.setTarget(one);
                                sliceValue1.setLabel(data.getResult().get(0).getName());
                                entries.add(sliceValue1);
                                break;
                            case 2:
                                SliceValue sliceValue2=new SliceValue(i+1,ChartUtils.COLOR_GREEN);
                                sliceValue2.setTarget(two);
                                sliceValue2.setLabel(data.getResult().get(1).getName());
                                entries.add(sliceValue2);
                                break;
                            case 3:
                                SliceValue sliceValue3=new SliceValue(i+1,ChartUtils.COLOR_ORANGE);
                                sliceValue3.setTarget(three);
                                sliceValue3.setLabel(data.getResult().get(2).getName());
                                entries.add(sliceValue3);
                                break;
                            case 4:
                                SliceValue sliceValue4=new SliceValue(i+1,ChartUtils.COLOR_RED);
                                sliceValue4.setTarget(four);
                                sliceValue4.setLabel(data.getResult().get(3).getName());
                                entries.add(sliceValue4);
                                break;
                            case 5:
                                SliceValue sliceValue5=new SliceValue(i+1,ChartUtils.COLOR_VIOLET);
                                sliceValue5.setTarget(five);
                                sliceValue5.setLabel(data.getResult().get(4).getName());
                                entries.add(sliceValue5);
                                break;
                            case 6:
                                SliceValue sliceValue6=new SliceValue(i+1,ChartUtils.COLOR_ORANGE);
                                sliceValue6.setTarget(six);
                                sliceValue6.setLabel(data.getResult().get(5).getName());
                                entries.add(sliceValue6);
                                break;
                            case 7:
                                SliceValue sliceValue7=new SliceValue(i+1,ChartUtils.COLOR_GREEN);
                                sliceValue7.setTarget(seven);
                                sliceValue7.setLabel(data.getResult().get(6).getName());
                                entries.add(sliceValue7);
                                break;
                            case 8:
                                SliceValue sliceValue8=new SliceValue(i+1,ChartUtils.COLOR_ORANGE);
                                sliceValue8.setTarget(eight);
                                sliceValue8.setLabel(data.getResult().get(7).getName());
                                entries.add(sliceValue8);
                                break;
                            case 9:
                                SliceValue sliceValue9=new SliceValue(i+1,ChartUtils.COLOR_BLUE);
                                sliceValue9.setTarget(nine);
                                sliceValue9.setLabel(data.getResult().get(8).getName());
                                entries.add(sliceValue9);
                                break;
                            case 10:
                                SliceValue sliceValue10=new SliceValue(i+1,ChartUtils.COLOR_RED);
                                sliceValue10.setTarget(ten);
                                sliceValue10.setLabel(data.getResult().get(9).getName());
                                entries.add(sliceValue10);
                                break;
                        }
                    }
                    chartData=new PieChartData(entries);
                    chartData.setHasLabels(true);
                    chartData.setHasLabelsOnlyForSelected(false);
                    chartData.setHasLabelsOutside(false);
                    chart.setPieChartData(chartData);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            chart.startDataAnimation();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        }).start();
        return view;
    }
}