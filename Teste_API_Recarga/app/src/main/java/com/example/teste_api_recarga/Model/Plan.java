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
//    @SerializedName("createdAt")
//    private String createdAt;
//    @SerializedName("updatedAt")
//    private String updatedAt;
//

    public Plan(String operadora, int planId) { //}, String createdAt, String updatedAt) {
        this.operadora = operadora;
        this.planId = planId;
//        this.id = id;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }
//
//    public void setCreatedAt(String createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    public String getOperadora() {
        return operadora;
    }

    public int getPlanId() {
        return planId;
    }

//    public int getId() {
//        return id;
//    }

//    public String getCreatedAt() {
//        return createdAt;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
}
