package com.example.teste_api_recarga.Model;

import com.google.gson.annotations.SerializedName;

public class Recharge {

    @SerializedName("phone")
    String phone;

    @SerializedName("plan_id")
    int planId;

    public Recharge(String phone, int planId) {
        this.phone = phone;
        this.planId = planId;
    }

    public String getPhone() {
        return phone;
    }

    public int getPlanId() {
        return planId;
    }
}
