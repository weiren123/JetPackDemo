package com.wmj.jetpackdemo.ui.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel  extends ViewModel {
   private LoginData data = new LoginData();
   public LoginData  getLoginData(){
       return data;
   }
}
