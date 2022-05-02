package net.godaa.ecommerceapp.network;

import net.godaa.ecommerceapp.auth.signIn.SignInResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("api/login")
    Call<SignInResponse> signIn(@Field("username") String email, @Field("password") String password);


}
