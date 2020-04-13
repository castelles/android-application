package com.example.teste_api_recarga.Callback;

import android.util.Log;

import com.example.teste_api_recarga.MainActivity;
import com.example.teste_api_recarga.Model.Plan;
import com.example.teste_api_recarga.PlansListActivity;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPlansCallback implements Callback<List<Plan>>
{

    private MainActivity activity;

    public GetPlansCallback(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onResponse(Call<List<Plan>> call, Response<List<Plan>> response) {
        Log.i("Teste R",response.toString());
        if (response.isSuccessful()) {
            Log.i("Teste IF",Integer.toString(response.code()));
            List<Plan> list= response.body();
            Log.i("Teste Plan",response.body().get(3).getOperadora());
            PlansListActivity.setPlanslist(list);
        }
    }

    @Override
    public void onFailure(Call<List<Plan>> call, Throwable t) {
        Log.i("Teste Failure",t.getMessage());
        activity.receivePlans();
    }
}
