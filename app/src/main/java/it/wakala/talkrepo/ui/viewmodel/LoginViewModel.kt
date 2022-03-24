package it.wakala.talkrepo.ui.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.wakala.talkrepo.R
import it.wakala.talkrepo.base.ABaseViewModel
import it.wakala.talkrepo.base.StatefulData
import it.wakala.talkrepo.entity.LoginEntity
import it.wakala.talkrepo.ext.postLoading
import it.wakala.talkrepo.ext.postSuccess
import it.wakala.talkrepo.ui.uimodel.ErrorField
import it.wakala.talkrepo.ui.uimodel.InputValidationUiModel
import it.wakala.talkrepo.ui.uimodel.LoginUiModel
import it.wakala.talkrepo.ui.uimodel.toUiModel
import it.wakala.talkrepo.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val loginUseCase: LoginUseCase
) : ABaseViewModel(application) {

    val loginLiveData = MutableLiveData<Result<StatefulData<LoginUiModel>>>()
    val inputFieldValidationLiveData =
        MutableLiveData<Result<StatefulData<InputValidationUiModel>>>()

    private fun login(mail: String, name: String, surname: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            loginLiveData.postLoading()
            val loginKeys = loginUseCase.execute(LoginUseCase.Params(mail, name, surname))
            loginLiveData.postSuccess(loginKeys.toUiModel())
        }
    }

    fun validateInputFields(mail: String, name: String, surname: String) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            when {
                mail.isEmpty() -> {
                    inputFieldValidationLiveData.postSuccess(
                        InputValidationUiModel(getApplication<Application>().getString(R.string.mail_error), ErrorField.MAIL)
                    )
                }
                name.isEmpty() -> {
                    inputFieldValidationLiveData.postSuccess(
                        InputValidationUiModel(getApplication<Application>().getString(R.string.name_error), ErrorField.NAME)
                    )
                }
                surname.isEmpty() -> {
                    inputFieldValidationLiveData.postSuccess(
                        InputValidationUiModel(getApplication<Application>().getString(R.string.surname_error), ErrorField.SURNAME)
                    )
                }
                else -> {
                    login(mail, name, surname)
                }
            }
        }
    }

}