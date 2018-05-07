package br.com.mrsti.toyapplication.ui.toylist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.mrsti.toyapplication.R
import br.com.mrsti.toyapplication.model.Toy
import kotlinx.android.synthetic.main.toy_item.view.*

class ToyListAdapter(private val toys: List<Toy>,
                         private val context: Context)
    : RecyclerView.Adapter<ToyListAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val toy = toys[position]
        holder?.let {
            it.bindView(toy)
        }
    }

    override fun getItemCount(): Int {
        return toys.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.toy_item, parent, false)
        return MyViewHolder(view)
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(toy: Toy) {
            itemView.tvDescription.text = toy.description
            itemView.tvBrand.text = toy.brand
            itemView.tvMinAge.text = toy.minAge.toString()
        }
    }

}