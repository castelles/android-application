package com.example.teste_api_recarga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this,PlansListActivity.class);

        idPlan =findViewById(R.id.plan_id);
        operadora = findViewById(R.id.operadora);
        idPlanRecharge = findViewById(R.id.idplan);
        phone = findViewById(R.id.phone);

        RechargeApplication app = (RechargeApplication) getApplication();
        planService = app.getPlansService();
        receivePlans();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuPlans) {
            //overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
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
