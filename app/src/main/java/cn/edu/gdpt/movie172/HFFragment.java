package cn.edu.gdpt.movie172;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.PullToRefreshView;

import java.util.List;

public class HFFragment extends Fragment {
    private PullToRefreshView mPullToRefreshView;
    private WrapRecyclerView recycleView;
    private MHandler mHandler;
    private MovieAdapter adapter;
    public HFFragment() {

    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_hf,container,false);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    class MHandler extends Handler {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            switch (msg.what) {
                case 1:
                    if (msg.obj != null) {
                        String vlResult = (String) msg.obj;
                        //使用Gson解析数据
                        List<MovieBean> pythonList = JsonParse.getInstance().
                                getPythonList(vlResult);
//                        Toast.makeText(getApplicationContext(),String.valueOf(pythonList.size()),Toast.LENGTH_LONG).show();
                        adapter.setData(pythonList);//适配器数据赋值
                    }
                    break;
            }
        }
}
