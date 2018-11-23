package com.cykj.survey;

import android.app.Application;
import android.content.Context;

import com.cykj.survey.base.config.AppComponent;
import com.cykj.survey.base.config.DaggerAppComponent;
import com.cykj.survey.base.config.InteractorModule;

/**
 * Application类
 */
public class App extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        setDraggerConfig();
    }

    public AppComponent component(){
        return component;
    }

    public static App get(Context context){
        return (App) context.getApplicationContext();
    }

    /**
     * 初始化Dragger，DaggerAppComponent是自动生成，需要Rebuild
     */
    private void setDraggerConfig() {
        component = DaggerAppComponent.builder().interactorModule(new InteractorModule())
                .build();
        component.inject(this);
    }
}
