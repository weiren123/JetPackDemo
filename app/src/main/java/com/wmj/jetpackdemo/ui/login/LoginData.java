package com.wmj.jetpackdemo.ui.login;

import androidx.lifecycle.LiveData;

public class LoginData extends LiveData<LoginData> {
    private String name;
    private String pwd;

    public void setName(String name) {
        this.name = name;
        postValue(this);
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        postValue(this);
    }
}
