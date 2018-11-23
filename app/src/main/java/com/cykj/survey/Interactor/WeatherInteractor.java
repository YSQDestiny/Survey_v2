package com.cykj.survey.Interactor;

import com.cykj.survey.base.BaseSubsribe;
import com.cykj.survey.bean.WeatherResultBean;

import rx.Subscription;

/**
 * 获取天气信息接口
 */
public interface WeatherInteractor {

    Subscription queryWeather(String apikey, String cityname, BaseSubsribe<WeatherResultBean> subsribe);

}
