package cn.edu.gdpt.movie172;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;


public class CNFragment extends Fragment {
    PieChart chart;
    public CNFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cn, container, false);
        chart=view.findViewById(R.id.chart);
        ArrayList<PieEntry> entries=new ArrayList<>();
        entries.add(new PieEntry(4,"月薪8-15K"));
        entries.add(new PieEntry(3,"月薪15-20K"));
        entries.add(new PieEntry(2,"月薪20-30K"));
        entries.add(new PieEntry(1,"月薪30K+"));
        PieDataSet dataSet=new PieDataSet(entries,"月薪");
        dataSet.setColors(new int[]{R.color.color_green,R.color.color_violet,R.color.color_bule,R.color.color_orange},getActivity());
        PieData pieData=new PieData(dataSet);
        chart.setData(pieData);
        chart.setHoleRadius(0f);
        chart.setTransparentCircleRadius(0f);
        dataSet.setDrawValues(false);
        chart.setEntryLabelTextSize(16f);
        return view;
    }
}
