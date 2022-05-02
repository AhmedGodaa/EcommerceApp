package net.godaa.ecommerceapp.auth.signIn;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import net.godaa.ecommerceapp.network.ApiClient;
import net.godaa.ecommerceapp.network.ApiService;
import net.godaa.ecommerceapp.utils.Constants;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInRepo {

    private static final String TAG = SignInRepo.class.getSimpleName();


    private ApiService apiService;

    public SignInRepo() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }


    public LiveData<SignInResponse> getLoginResponseData(String email, String password) {
        final MutableLiveData<SignInResponse> mutableLiveData = new MutableLiveData<>();
        apiService.signIn(email, password).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                SignInResponse signInResponse;
                String token = response.headers().get(Constants.KEY_AUTHORIZATION);
                signInResponse = response.body();
                Objects.requireNonNull(signInResponse).setToken(token);


                mutableLiveData.setValue(signInResponse);

            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());

            }
        });


        return mutableLiveData;
    }

}
