package cn.edu.gdpt.movie172;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    RadioGroup radioGroup;
    TextView tv_main_ttitle;
    List<Fragment> alFragment=new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
        initListener();
    }

    private void initListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                switch (i){
                    case 0:
                        radioGroup.check(R.id.rb_home);
                        tv_main_ttitle.setText("内地票房");
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_count);
                        tv_main_ttitle.setText("香港票房");
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_video);
                        tv_main_ttitle.setText("周末票房（内地）");
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_me);
                        tv_main_ttitle.setText("周末票房（北美）");
                        break;
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        viewPager.setCurrentItem(0,false);break;
                    case R.id.rb_count:
                        viewPager.setCurrentItem(1,false);break;
                    case R.id.rb_video:
                        viewPager.setCurrentItem(2,false);break;
                    case R.id.rb_me:
                        viewPager.setCurrentItem(3,false);break;
                }
            }
        });
    }

    private void initViewPager() {
        alFragment.add(new CNFragment());
        alFragment.add(new  HFFragment());
        alFragment.add(new USFragment());
        alFragment.add(new ZMFragment());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return alFragment.get(i);
            }

            @Override
            public int getCount() {
                return alFragment.size();
            }
        });
        viewPager.setCurrentItem(0);
    }

    private void initView() {
        tv_main_ttitle=findViewById(R.id.tv_main_title);
        tv_main_ttitle.setText("首页");
        viewPager=findViewById(R.id.viewPager);
        radioGroup=findViewById(R.id.radioGroup);
    }
}
