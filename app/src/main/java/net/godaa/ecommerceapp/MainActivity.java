package net.godaa.ecommerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;


import com.godaa.ecommerceapp.databinding.ActivityMainBinding;

import net.godaa.ecommerceapp.auth.signIn.SignInViewModel;

import net.godaa.ecommerceapp.utils.Constants;
import net.godaa.ecommerceapp.utils.PreferencesManager;

public class MainActivity extends AppCompatActivity {

    private SignInViewModel loginViewModel;
    private ActivityMainBinding binding;
    private PreferencesManager preferencesManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loginViewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        preferencesManager = new PreferencesManager(this);
        binding.btnSubmit.setOnClickListener(v -> signIn());
    }


    private void signIn() {
        String email = "ahmed";
        String password = "password";

        loginViewModel.getLoginResponseData(email, password)
                .observe(this, signInResponse -> {
                    preferencesManager.putString(Constants.KEY_TOKEN, signInResponse.getToken());
                });

        String token = preferencesManager.getString(Constants.KEY_TOKEN);
        Toast.makeText(MainActivity.this, "" + token, Toast.LENGTH_SHORT).show();


    }
}