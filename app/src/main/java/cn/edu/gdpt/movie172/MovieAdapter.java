package cn.edu.gdpt.movie172;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MovieBean> mvb;
    public  void  setData(List<MovieBean>mvb){
        this.mvb=mvb;
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hk,viewGroup,false);

        return null;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int i) {
    final  MovieBean bean=mvb.get(i);
        ((MovieViewHolder) viewHolder).movie_name.setText(bean.getMovie_name());
        ((MovieViewHolder) viewHolder).daysOfHK.setText(bean.getDaysOfHK());
        ((MovieViewHolder) viewHolder).sumOfWeekHK.setText(bean.getSumOfWeekHK());
        ((MovieViewHolder) viewHolder).weekPeriodOfHK.setText(bean.getWeekPeriodOfHK());
    }

    @Override
    public int getItemCount() {
        return mvb==null?0:mvb.size();
    }
    public  class  MovieViewHolder extends RecyclerView.ViewHolder{
           private TextView movie_name,daysOfHK,sumOfWeekHK,weekPeriodOfHK;
        public MovieViewHolder( View itemView) {
            super(itemView);
            movie_name=itemView.findViewById(R.id.movie_name);
            daysOfHK=itemView.findViewById(R.id.daysOfHK);
            sumOfWeekHK=itemView.findViewById(R.id.sumOfWeekHK);
            weekPeriodOfHK=itemView.findViewById(R.id.weekPeriodOfHK);
        }
    }
}
