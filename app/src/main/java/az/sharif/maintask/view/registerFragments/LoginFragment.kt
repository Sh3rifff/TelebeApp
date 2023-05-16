package az.sharif.maintask.view.registerFragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentLoginBinding
import az.sharif.maintask.model.AuthModel
import az.sharif.maintask.model.LoginModel
import az.sharif.maintask.service.RetrofitHelper
import az.sharif.maintask.view.activities.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        navController = Navigation.findNavController(view)

        binding.registerText.setOnClickListener {
            navController.navigate(LoginFragmentDirections.loginToRegister())
        }

        loginRetrofit()

    }

    private fun loginRetrofit() {

//        val retrofit = Retrofit.Builder().baseUrl("http://10.50.0.61:8000/")
//            .addConverterFactory(GsonConverterFactory.create()).build()
//
//        val apiService = retrofit.create(ApiService::class.java)

        binding.materialButton.setOnClickListener {

            val loginData = LoginModel(
                binding.email.text.toString(), binding.passwordd.text.toString()
            )
//            val call = apiService.login(loginData)

            val call = RetrofitHelper.service.login(loginData)

            call.enqueue(object : Callback<AuthModel> {
                override fun onResponse(call: Call<AuthModel>, response: Response<AuthModel>) {
                    Log.d("TAG", "onResponse: 123 ")
                    if (response.isSuccessful) {
                        val authToken = response.body()
                        val accessToken = authToken?.accessToken
                        if (accessToken != null) {
                            val intent = Intent(requireActivity(), MainActivity::class.java)
                            startActivity(intent)
                        }
                    } else {
                        // user not found
                    }
                }

                override fun onFailure(call: Call<AuthModel>, t: Throwable) {
                    Log.d("Tag", t.message.toString())
                    Log.d("Tag", t.localizedMessage!!.toString())
                }
            })
        }
    }
}