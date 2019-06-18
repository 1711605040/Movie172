package cn.edu.gdpt.movie172;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.ArrayList;


public class ZMFragment extends Fragment {
    BarChart chart_bar;
    public ZMFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_zm, container, false);
        chart_bar=view.findViewById(R.id.chart_bar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = "http://apicloud.mob.com/boxoffice/day/query?key=2b5fb6ee3ab58&area=CN";
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Response execute = okHttpClient.newCall(new Request.Builder().get().url(s).build()).execute();
                    final Data data = new Gson().fromJson(execute.body().string(), Data.class);
                    final String[] name=new String[]{data.getResult().get(0).getName(),data.getResult().get(1).getName(),data.getResult().get(2).getName(),data.getResult().get(3).getName(),data.getResult().get(4).getName(),data.getResult().get(5).getName(),data.getResult().get(6).getName(),data.getResult().get(7).getName(),data.getResult().get(8).getName(),data.getResult().get(9).getName()};
                    Float[] salary=new Float[]{Float.valueOf(data.getResult().get(0).getSum()),Float.valueOf(data.getResult().get(1).getSum()),Float.valueOf(data.getResult().get(2).getSum()),Float.valueOf(data.getResult().get(3).getSum()),Float.valueOf(data.getResult().get(4).getSum()),Float.valueOf(data.getResult().get(5).getSum()),Float.valueOf(data.getResult().get(6).getSum()),Float.valueOf(data.getResult().get(7).getSum()),Float.valueOf(data.getResult().get(8).getSum()),Float.valueOf(data.getResult().get(9).getSum())};
                    XAxis xBarAxis=chart_bar.getXAxis();
                    xBarAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                    xBarAxis.setValueFormatter(new IndexAxisValueFormatter(){
                        @Override
                        public String getFormattedValue(float value) {
                            return name[(int)value];
                        }
                    });
                    ArrayList<BarEntry> yBarVals=new ArrayList<>();
                    for (int i=0;i<salary.length;i++){
                        yBarVals.add(new BarEntry(i,salary[i]));
                    }
                    BarDataSet barDataSet=new BarDataSet(yBarVals,"总票房（万元）");
                    barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                    ArrayList<IBarDataSet> dataBarSets=new ArrayList<>();
                    dataBarSets.add(barDataSet);
                    BarData barData=new BarData(dataBarSets);
                    chart_bar.setData(barData);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

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
