package it.wakala.talkrepo.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import it.wakala.talkrepo.BuildConfig
import it.wakala.talkrepo.LogHelper
import it.wakala.talkrepo.R
import it.wakala.talkrepo.base.ABaseActivity
import it.wakala.talkrepo.base.StatefulData
import it.wakala.talkrepo.databinding.ActivityLoginBinding
import it.wakala.talkrepo.ext.getStringText
import it.wakala.talkrepo.ui.uimodel.ErrorField.*
import it.wakala.talkrepo.ui.viewmodel.LoginViewModel
import it.wakala.talkrepo.utils.ResolverDebugFieldLoginCredential
import it.wakala.talkrepo.utils.extension.setStatusBarColor

@AndroidEntryPoint
class LoginActivity : ABaseActivity<ActivityLoginBinding>() {

    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor(R.color.marvel_blu)

        binding.mailEt.setOnEditorActionListener { textView, action, _ ->
            if (action == EditorInfo.IME_ACTION_DONE) {
                val imm: InputMethodManager = textView.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(textView.windowToken, 0)

                with(binding) {
                    binding.container.clearFocus()
                    loginViewModel.validateInputFields(mailEt.getStringText(), nameEt.getStringText(), surnameEt.getStringText())
                }

            }
            false
        }

        with(loginViewModel) {
            loginLiveData.observe(this@LoginActivity) { result ->
                when (result.getOrNull()) {
                    is StatefulData.Loading -> {
                        LogHelper.d(LoginActivity::class.java.name,"Logging in...")
                    }
                    is StatefulData.Success -> {
                        MainActivity.startActivity(this@LoginActivity)
                        finish()
                    }
                    else -> {
                        //do nothing here
                    }
                }

                errorLiveData.observe(this@LoginActivity) {
                    Toast.makeText(this@LoginActivity, "Wrong credentials", Toast.LENGTH_SHORT).show()
                }

            }

            inputFieldValidationLiveData.observe(this@LoginActivity) {
                when (val data = it.getOrNull()) {
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
                    else -> {
                        //do nothing here
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

        fillDebugField()

    }

    /*
     * ABaseActivity method
     */

    override fun setBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    /*
     * private method
     */

    private fun fillDebugField(){
        if(BuildConfig.DEBUG){
            binding.nameEt.setText(ResolverDebugFieldLoginCredential.getName(this))
            binding.surnameEt.setText(ResolverDebugFieldLoginCredential.getSurname(this))
            binding.mailEt.setText(ResolverDebugFieldLoginCredential.getMail(this))
        }
    }

}