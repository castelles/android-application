package com.example.teste_api_recarga.Service;

import com.example.teste_api_recarga.Model.Plan;
import com.example.teste_api_recarga.Model.Recharge;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PlanService {

    @POST("plans")
    Call<Void> createPlan(@Body Plan plan);

    @POST("recharge")
    Call<Void> makeRecharge(@Body Recharge recharge);

    @GET("plans")
    Call<List<Plan>> plans();

}
