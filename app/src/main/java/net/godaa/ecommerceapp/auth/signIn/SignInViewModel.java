package net.godaa.ecommerceapp.auth.signIn;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class SignInViewModel extends ViewModel {
    private final SignInRepo signInRepo;


    public SignInViewModel() {
        signInRepo = new SignInRepo();

    }

    public LiveData<SignInResponse> getLoginResponseData(String email, String password) {
        return signInRepo.getLoginResponseData(email, password);
    }

}
