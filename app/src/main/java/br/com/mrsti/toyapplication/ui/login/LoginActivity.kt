package br.com.mrsti.toyapplication.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.mrsti.toyapplication.ui.main.MainActivity
import br.com.mrsti.toyapplication.R
import br.com.mrsti.toyapplication.api.RetrofitClient
import br.com.mrsti.toyapplication.api.ToyAPI
import br.com.mrsti.toyapplication.model.LoginRequest
import br.com.mrsti.toyapplication.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener {
            val login: String = etLogin.text.toString()
            val password: String = etPassword.text.toString()

            login(login, password)

        }
    }



    fun login(login: String, password: String) {
        val api = RetrofitClient
                .getInstance()
                .create(ToyAPI::class.java)

        val loginActivity: LoginActivity = this

        if (login == "") {
            Toast.makeText(loginActivity, "Preencha o login.", Toast.LENGTH_SHORT).show()
            return
        }
        if (password == "") {
            Toast.makeText(loginActivity, "Preencha a senha.", Toast.LENGTH_SHORT).show()
            return
        }

        var loginRequest = LoginRequest(login, password)

        api.login(loginRequest)
                .enqueue(object: Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                        if(response?.isSuccessful == true) {
                            startActivity(Intent(loginActivity, MainActivity::class.java))
                            loginActivity.finish()
                        } else {
                            Toast.makeText(loginActivity, "Login/senha inválidos.", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                        Toast.makeText(loginActivity, t?.message, Toast.LENGTH_SHORT).show()
                    }
                }
        )
    }
}