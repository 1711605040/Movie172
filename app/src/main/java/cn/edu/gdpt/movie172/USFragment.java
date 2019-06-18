package cn.edu.gdpt.movie172;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.w3c.dom.Entity;

import java.util.ArrayList;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.util.ChartUtils;


public class USFragment extends Fragment {
    LineChart chart_Line;
    public USFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_u, container, false);
        chart_Line=view.findViewById(R.id.chart_line);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = "http://apicloud.mob.com/boxoffice/day/query?key=2b5fb6ee3ab58&area=CN";
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Response execute = okHttpClient.newCall(new Request.Builder().get().url(s).build()).execute();
                    final Data data = new Gson().fromJson(execute.body().string(), Data.class);
////                    Float[] salary=new Float[]{50000F,100000F,150000F,2000000F,2500000F,30000000F,3500000F};
////                    ArrayList<Entity> yVasl=new ArrayList<Entity>();
////                    for (int i=0;i<salary.length;i++){
////                        yVasl.add((Entity) new Entry(i,salary[i]));
//                    }
                    final String[] name=new String[]{data.getResult().get(0).getName(),data.getResult().get(1).getName(),data.getResult().get(2).getName(),data.getResult().get(3).getName(),data.getResult().get(4).getName(),data.getResult().get(5).getName(),data.getResult().get(6).getName(),data.getResult().get(7).getName(),data.getResult().get(8).getName(),data.getResult().get(9).getName()};
                    XAxis xAxis=chart_Line.getXAxis();
                    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                    xAxis.setValueFormatter(new IndexAxisValueFormatter(){
                        @Override
                        public String getFormattedValue(float value) {
                            return name[(int)value];
                        }
                    });
                    Float[] salary=new Float[]{Float.valueOf(data.getResult().get(0).getCur()),Float.valueOf(data.getResult().get(1).getCur()),Float.valueOf(data.getResult().get(2).getCur()),Float.valueOf(data.getResult().get(3).getCur()),Float.valueOf(data.getResult().get(4).getCur()),Float.valueOf(data.getResult().get(5).getCur()),Float.valueOf(data.getResult().get(6).getCur()),Float.valueOf(data.getResult().get(7).getCur()),Float.valueOf(data.getResult().get(8).getCur()),Float.valueOf(data.getResult().get(9).getCur())};
                    ArrayList<Entry> yVals=new ArrayList<Entry>();
                    for (int i=0;i<salary.length;i++){
                        yVals.add(new Entry(i,salary[i]));
                    }
                    LineDataSet lineDataSet=new LineDataSet(yVals,"票房（万元）");
                    lineDataSet.setColor(Color.RED);
                    ArrayList<ILineDataSet> dataSets=new ArrayList<>();
                    dataSets.add(lineDataSet);
                    LineData lineData=new LineData(dataSets);
                    chart_Line.setData(lineData);
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
