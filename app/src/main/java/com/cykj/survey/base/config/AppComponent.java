package com.cykj.survey.base.config;

import com.cykj.survey.App;
import com.cykj.survey.Interactor.WeatherInteractor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 声明AppComponent组件
 */
@Singleton
@Component(
        modules = {
                InteractorModule.class,
        }
)
public interface AppComponent {
    void inject(App app);

    WeatherInteractor getWeatherInteractor();
}
