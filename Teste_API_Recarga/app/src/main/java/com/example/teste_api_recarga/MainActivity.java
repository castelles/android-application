package com.example.teste_api_recarga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teste_api_recarga.App.RechargeApplication;
import com.example.teste_api_recarga.Callback.CreatePlansCallback;
import com.example.teste_api_recarga.Callback.GetPlansCallback;
import com.example.teste_api_recarga.Model.Plan;
import com.example.teste_api_recarga.Model.Recharge;
import com.example.teste_api_recarga.Service.PlanService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText idPlan, operadora, idPlanRecharge, phone;
    private PlanService planService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idPlan =findViewById(R.id.plan_id);
        operadora = findViewById(R.id.operadora);
        idPlanRecharge = findViewById(R.id.idplan);
        phone = findViewById(R.id.phone);

        RechargeApplication app = (RechargeApplication) getApplication();
        planService = app.getPlansService();
        receivePlans();


    }

    public void receivePlans() {
        Call<List<Plan>> call = planService.plans();
        call.enqueue(new GetPlansCallback(this));
    }

    public void createPlan(View view) {
        planService.createPlan(new Plan(operadora.getText().toString(),
                Integer.parseInt(idPlan.getText().toString())))
                .enqueue(new CreatePlansCallback());
        operadora.setText("");
        idPlan.setText("");
    }

    public void makeRecharge(View view) {
        planService.makeRecharge(new Recharge(phone.getText().toString(),
                Integer.parseInt(idPlanRecharge.getText().toString())))
                .enqueue(new CreatePlansCallback());
        phone.setText("");
        idPlanRecharge.setText("");
    }
}
