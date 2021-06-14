package com.example.trabalhofinalmobile.authentication.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.trabalhofinalmobile.MovieUtil
import com.example.trabalhofinalmobile.authentication.viewmodel.AuthenticationViewModel
import com.example.trabalhofinalmobile.databinding.ActivityLoginBinding
import com.example.trabalhofinalmobile.home.view.HomeActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding;

    private val viewModel: AuthenticationViewModel by lazy {
        ViewModelProvider(this).get(
            AuthenticationViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btLogin.setOnClickListener {
            val email = binding.etvEmail.text.toString()
            val password = binding.etvPassword.text.toString()

            when {
                MovieUtil.validateEmailPassword(email, password) -> {
                    viewModel.loginEmailPassword(email, password)
                }
                else -> {
                    Snackbar.make(binding.btLogin, "login failed", Snackbar.LENGTH_LONG).show()
                }
            }
        }

        binding.tvLoginRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        initViewModel()
    }

    //observers
    private fun initViewModel() {

        viewModel.stateLogin.observe(this, { state ->
            state?.let {
                navigateHome(it)
            }
        })

        viewModel.stateLogin.observe(this, { loading ->
            loading?.let {
                showErrorMessage("login Failed")
            }
        })
    }

    private fun navigateHome(status: Boolean) {
        when {
            status -> {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(binding.btLogin, message, Snackbar.LENGTH_LONG).show()
    }
}