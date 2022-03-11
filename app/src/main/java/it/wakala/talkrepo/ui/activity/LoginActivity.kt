package it.wakala.talkrepo.ui.activity

import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import androidx.activity.viewModels
import it.wakala.talkrepo.base.ABaseActivity
import it.wakala.talkrepo.base.StatefulData
import it.wakala.talkrepo.databinding.ActivityLoginBinding
import it.wakala.talkrepo.databinding.ActivityMainBinding
import it.wakala.talkrepo.ext.getStringText
import it.wakala.talkrepo.extension.setUpNavController
import it.wakala.talkrepo.ui.uimodel.ErrorField
import it.wakala.talkrepo.ui.uimodel.ErrorField.*
import it.wakala.talkrepo.ui.viewmodel.LoginViewModel
import timber.log.Timber

@AndroidEntryPoint
class LoginActivity : ABaseActivity<ActivityLoginBinding>() {

    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(loginViewModel) {
            loginLiveData.observe(this@LoginActivity) { result ->
                val data = result.getOrNull()
                when (data) {
                    is StatefulData.Loading -> {
                        Timber.d("Logging in...")
                    }
                    is StatefulData.Success -> {
                        MainActivity.startActivity(this@LoginActivity)
                    }
                    else -> {

                    }
                }
            }

            inputFieldValidationLiveData.observe(this@LoginActivity) {
                val data = it.getOrNull()
                when (data) {
                    is StatefulData.Success -> {
                        when (data.result.errorField) {
                            MAIL -> {
                                binding.mailEt.error = data.result.message
                            }
                            NAME -> {
                                binding.nameEt.error = data.result.message
                            }
                            SURNAME -> {
                                binding.surnameEt.error = data.result.message
                            }
                        }
                    }
                }
            }
        }

        binding.loginButton.setOnClickListener {
            loginViewModel.validateInputFields(
                binding.mailEt.getStringText(),
                binding.nameEt.getStringText(),
                binding.surnameEt.getStringText()
            )
        }

    }

    override fun setBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

}