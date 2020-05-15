package com.example.teste_api_recarga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.teste_api_recarga.Model.Plan;

import java.util.ArrayList;
import java.util.List;

public class PlansListActivity extends AppCompatActivity {

    private static List<Plan> planslist;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_list);

        listView = findViewById(R.id.planslist);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,getOp());
        listView.setAdapter(adapter);

    }

    public static void setPlanslist(List<Plan> _planslist) {
        planslist = _planslist;
    }

    public ArrayList<String> getOp() {
        ArrayList<String> operadorasEPlanos = new ArrayList<>();
        if (planslist != null) {
            for (int i = 0; i < planslist.size(); i++) {
                Log.i("Teste aqui", planslist.get(i).getOperadora());
                String current = "";
                current = planslist.get(i).getOperadora() + " - " + planslist.get(i).getPlanId();
                operadorasEPlanos.add(current);
            }
            return operadorasEPlanos;
        }
        operadorasEPlanos.add("Error!");
        return operadorasEPlanos;
    }

    public void goBack(View view) {
        this.finish();
    }
}
