package cn.edu.gdpt.movie172;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CNFragment extends Fragment {
    ListView hkListView;
    List<Map<String, Object>> hkList=new ArrayList<>();
    HKAdapter hkAdapter;
    public CNFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_hf, container, false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = "http://apicloud.mob.com/boxoffice/day/query?key=2b5fb6ee3ab58&area=CN";
                    OkHttpClient okHttpClient = new OkHttpClient();
                    Response execute = okHttpClient.newCall(new Request.Builder().get().url(s).build()).execute();
                    final Data data = new Gson().fromJson(execute.body().string(), Data.class);
                    Map<String, Object> map1 = new HashMap<String, Object>();
                    map1.put("name", data.getResult().get(0).getName());
                    map1.put("days", data.getResult().get(0).getDays());
                    map1.put("cur", data.getResult().get(0).getCur());
                    map1.put("sum", data.getResult().get(0).getSum());
                    hkList.add(map1);

                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("name", data.getResult().get(1).getName());
                    map2.put("days", data.getResult().get(1).getDays());
                    map2.put("cur", data.getResult().get(1).getCur());
                    map2.put("sum", data.getResult().get(1).getSum());
                    hkList.add(map2);

                    Map<String, Object> map3 = new HashMap<String, Object>();
                    map3.put("name", data.getResult().get(2).getName());
                    map3.put("days", data.getResult().get(2).getDays());
                    map3.put("cur", data.getResult().get(2).getCur());
                    map3.put("sum", data.getResult().get(2).getSum());
                    hkList.add(map3);

                    Map<String, Object> map4 = new HashMap<String, Object>();
                    map4.put("name", data.getResult().get(3).getName());
                    map4.put("days", data.getResult().get(3).getDays());
                    map4.put("cur", data.getResult().get(3).getCur());
                    map4.put("sum", data.getResult().get(3).getSum());
                    hkList.add(map4);

                    Map<String, Object> map5 = new HashMap<String, Object>();
                    map5.put("name", data.getResult().get(4).getName());
                    map5.put("days", data.getResult().get(4).getDays());
                    map5.put("cur", data.getResult().get(4).getCur());
                    map5.put("sum", data.getResult().get(4).getSum());
                    hkList.add(map5);

                    Map<String, Object> map6 = new HashMap<String, Object>();
                    map6.put("name", data.getResult().get(5).getName());
                    map6.put("days", data.getResult().get(5).getDays());
                    map6.put("cur", data.getResult().get(5).getCur());
                    map6.put("sum", data.getResult().get(5).getSum());
                    hkList.add(map6);

                    Map<String, Object> map7 = new HashMap<String, Object>();
                    map7.put("name", data.getResult().get(6).getName());
                    map7.put("days", data.getResult().get(6).getDays());
                    map7.put("cur", data.getResult().get(6).getCur());
                    map7.put("sum", data.getResult().get(6).getSum());
                    hkList.add(map7);

                    Map<String, Object> map8 = new HashMap<String, Object>();
                    map8.put("name", data.getResult().get(7).getName());
                    map8.put("days", data.getResult().get(7).getDays());
                    map8.put("cur", data.getResult().get(7).getCur());
                    map8.put("sum", data.getResult().get(7).getSum());
                    hkList.add(map8);

                    Map<String, Object> map9 = new HashMap<String, Object>();
                    map9.put("name", data.getResult().get(8).getName());
                    map9.put("days", data.getResult().get(8).getDays());
                    map9.put("cur", data.getResult().get(8).getCur());
                    map9.put("sum", data.getResult().get(8).getSum());
                    hkList.add(map9);

                    Map<String, Object> map10 = new HashMap<String, Object>();
                    map10.put("name", data.getResult().get(9).getName());
                    map10.put("days", data.getResult().get(9).getDays());
                    map10.put("cur", data.getResult().get(9).getCur());
                    map10.put("sum", data.getResult().get(9).getSum());
                    hkList.add(map10);
                    hkAdapter = new HKAdapter(hkList);
                    hkAdapter.setContext(getActivity());
                    hkListView = view.findViewById(R.id.ls_hk);

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hkListView.setAdapter(hkAdapter);
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
