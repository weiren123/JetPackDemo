package com.wmj.jetpackdemo.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.wmj.jetpackdemo.R;
import com.wmj.lib_annotations.RandomInt;
import com.wmj.lib_annotations.RandomString;
import com.wmj.lib_api.RandomUtils;

public class LoginFragment extends Fragment {

    private View btn;
    private EditText name;
    private EditText pwd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);
         btn = view.findViewById(R.id.btn_login);
         name = view.findViewById(R.id.et_account);
         pwd = view.findViewById(R.id.et_pwd);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        LoginData loginData = loginViewModel.getLoginData();
        loginData.observe(getActivity(), new Observer<LoginData>() {
            @Override
            public void onChanged(LoginData loginData) {
                name.setText(loginData.getName());
                pwd.setText(loginData.getPwd());
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.getLoginData().setName("wera");
                loginViewModel.getLoginData().setPwd(String.valueOf(1234));
//                Navigation.findNavController(v).navigate(R.id.mainFragment);
//                Log.e("RandomInt",mRandomInt+"");
//                Log.e("RandomString",mRandomString+"");
            }
        });
    }
}
