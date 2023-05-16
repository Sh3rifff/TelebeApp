package az.sharif.maintask.view.registerFragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import az.sharif.maintask.R
import az.sharif.maintask.databinding.FragmentRegister1Binding
import az.sharif.maintask.model.RegisterModel
import az.sharif.maintask.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterFragment1 : Fragment(R.layout.fragment_register1) {

    private lateinit var binding: FragmentRegister1Binding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegister1Binding.bind(view)
        navController = Navigation.findNavController(view)

        binding.materialButton.setOnClickListener {
        }


        val retrofit = Retrofit.Builder().baseUrl("http://10.50.0.61:8000/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val apiService = retrofit.create(ApiService::class.java)

        binding.materialButton.setOnClickListener {

            val registerData = RegisterModel(
                binding.name.text.toString(),
                binding.lastName.text.toString(),
                binding.email.text.toString(),
                binding.password.text.toString(),
                binding.password2.text.toString(),
            )
            val call = apiService.register(registerData)

            call.enqueue(object : Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>
                ) {
                }
                override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                    t.printStackTrace()
                }
            })
            navController.navigate(RegisterFragment1Directions.actionRegisterFragmentToRegisterFragment2())

        }

    }
}