package com.example.studyapp;

import java.io.Serializable;

public class User implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String login, name, pass;
    private int type;

    public User(String login, String name, String pass, int type) {
        this.login = login;
        this.name = name;
        this.pass = pass;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getType() {
        String acessType = this.type == 1 ? "Aluno" : "Professor";
        return acessType;
    }
}
