package br.com.mrsti.toyapplication.ui.toylist


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.mrsti.toyapplication.R
import br.com.mrsti.toyapplication.api.RetrofitClient
import br.com.mrsti.toyapplication.api.ToyAPI
import br.com.mrsti.toyapplication.model.Toy
import kotlinx.android.synthetic.main.fragment_toy_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ToyListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toy_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadToys()
    }

    fun loadToys() {
        val api = RetrofitClient
                .getInstance()
                .create(ToyAPI::class.java)

        api.findAll()
                .enqueue(object : Callback<List<Toy>> {
                    override fun onResponse(call: Call<List<Toy>>?, response: Response<List<Toy>>?) {
                        if(response?.isSuccessful == true) {
                            listAdapter(response.body())
                        }
                    }

                    override fun onFailure(call: Call<List<Toy>>?, t: Throwable?) {

                    }
                })
    }

    fun listAdapter(toys: List<Toy>?) {
        toys.let {
            rvToys.adapter = ToyListAdapter(toys!!, context!!)
            val layoutManager = LinearLayoutManager(context)
            rvToys.layoutManager = layoutManager

        }
    }
}
