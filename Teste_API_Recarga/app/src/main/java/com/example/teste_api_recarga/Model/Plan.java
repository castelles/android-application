package com.example.teste_api_recarga.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plan {

//    @SerializedName("id")
//    private int id;
    @SerializedName("operator")
    @Expose
    private String operadora;
    @SerializedName("plan")
    private int planId;

    @SerializedName("id")
    private int id;

    public Plan(String operadora, int planId) {
        this.operadora = operadora;
        this.planId = planId;
    }

    public String getOperadora() {
        return operadora;
    }

    public int getPlanId() {
        return planId;
    }
}
