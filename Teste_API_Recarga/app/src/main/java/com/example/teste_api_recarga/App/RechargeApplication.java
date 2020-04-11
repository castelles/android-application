package com.example.teste_api_recarga.App;

import android.app.Application;

import com.example.teste_api_recarga.Service.PlanService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RechargeApplication extends Application {

    private static final String ACCESS_URL = "http://10.0.2.2:3333/";

    public PlanService getPlansService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ACCESS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PlanService planService = retrofit.create(PlanService.class);
        return planService;
    }
}
