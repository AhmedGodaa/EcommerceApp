package net.godaa.ecommerceapp.auth.signUp;

public class SignUpRepo {


//    public LiveData<RegisterApiResponse> getRegisterResponseData(User user) {
//        final MutableLiveData<RegisterApiResponse> mutableLiveData = new MutableLiveData<>();
//
//        RetrofitClient.getInstance().getApi().createUser(user).enqueue(new Callback<RegisterApiResponse>() {
//            @Override
//            public void onResponse(retrofit2.Call<RegisterApiResponse> call, Response<RegisterApiResponse> response) {
//                Log.d(TAG, "onResponse: Succeeded");
//
//                RegisterApiResponse registerApiResponse = response.body();
//
//                if (response.body() != null) {
//                    mutableLiveData.setValue(registerApiResponse);
//                    Log.d(TAG, response.body().getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<RegisterApiResponse> call, Throwable t) {
//                Log.d(TAG, t.getMessage());
//            }
//        });
//        return mutableLiveData;
//    }

}
