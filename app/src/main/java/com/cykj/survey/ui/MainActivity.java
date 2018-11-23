package com.cykj.survey.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cykj.survey.App;
import com.cykj.survey.Interactor.WeatherInteractor;
import com.cykj.survey.R;
import com.cykj.survey.base.BaseSubsribe;
import com.cykj.survey.base.api.ConstantApi;
import com.cykj.survey.base.config.AppComponent;
import com.cykj.survey.bean.WeatherResultBean;

import rx.Subscription;

/**
 * 主页
 */
public class MainActivity extends AppCompatActivity {

    private AppComponent component;
    private WeatherInteractor weatherInteractor;
    private EditText city;
    private TextView queryresult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = findViewById(R.id.city);
        queryresult = findViewById(R.id.queryresult);

        //获取到AppComponent组件
        component = App.get(this).component();
        //通过AppComponent拿到WeatherInteractor
        weatherInteractor = component.getWeatherInteractor();
        findViewById(R.id.query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryWeatherData();
            }
        });
    }

    private void queryWeatherData(){
        String content = city.getText().toString();
        //调用查询天气接口的方法
        Subscription subscription = weatherInteractor.queryWeather(ConstantApi.baiduKey, content, new BaseSubsribe<WeatherResultBean>() {
            @Override
            public void onSuccess(WeatherResultBean result) {
                WeatherResultBean.RetDataEntity retData = result.getResult();
                queryresult.setText(retData.getSk().getTemp());

            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                queryresult.setText("查询失败");
            }
        });
    }
}
