package it.wakala.talkrepo.ui.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.wakala.talkrepo.base.ABaseViewModel
import it.wakala.talkrepo.base.StatefulData
import it.wakala.talkrepo.entity.LoginEntity
import it.wakala.talkrepo.ext.postLoading
import it.wakala.talkrepo.ext.postSuccess
import it.wakala.talkrepo.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val loginUseCase: LoginUseCase
): ABaseViewModel(application) {

    val loginLiveData = MutableLiveData<Result<StatefulData<LoginEntity>>>()
    val inputFieldValidationLiveData = MutableLiveData<Result<StatefulData<LoginEntity>>>()

    fun login(mail: String, name: String, surname: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            loginLiveData.postLoading()
            val loginKeys = loginUseCase.execute(LoginUseCase.Params(mail, name, surname))
            loginLiveData.postSuccess(loginKeys)
        }
    }

    fun validateInputFields(mail: String, name: String, surname: String) {

    }

}