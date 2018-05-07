package br.com.mrsti.toyapplication.ui.newtoy


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import br.com.mrsti.toyapplication.R
import br.com.mrsti.toyapplication.api.RetrofitClient
import br.com.mrsti.toyapplication.api.ToyAPI
import br.com.mrsti.toyapplication.model.Toy
import kotlinx.android.synthetic.main.fragment_new_toy.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewToyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_toy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btSalvar.setOnClickListener {
            val api = RetrofitClient
                    .getInstance()
                    .create(ToyAPI::class.java)
            val toy = Toy(null,
                    inputDescription.editText?.text.toString(),
                    inputBrand.editText?.text.toString(),
                    inputMinAge.editText?.text.toString().toInt()
                    )

            api.save(toy)
                    .enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                            if(response?.isSuccessful == true) {
                                Toast.makeText(context,
                                        "Sucesso",
                                        Toast.LENGTH_SHORT).show()
                                FieldRelease()
                            }
                        }
                        override fun onFailure(call: Call<Void>?, t: Throwable?) {
                            Log.e("Toy", t?.message)
                        }
                    })
        }
    }

    private fun FieldRelease() {
        inputDescription.editText?.setText("")
        inputBrand.editText?.setText("")
        inputMinAge.editText?.setText("")

    }



}
