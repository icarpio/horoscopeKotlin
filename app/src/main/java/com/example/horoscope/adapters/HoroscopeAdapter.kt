package com.example.horoscope.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope.R
import com.example.horoscope.data.Horoscope


// 3. Crear Adapter para que le diga al recyvler view que datos mostrar
//

class HoroscopeAdapter (private var dataSet: List<Horoscope>, private val onItemClickListener: (Int) -> Unit) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horoscope, parent, false)

        return HoroscopeViewHolder(view)
    }

    //override fun getItemCount(): Int = dataSet.size
    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val item = dataSet[position]
        holder.render(item)
        // val context = holder.logoImageView.context
        //holder.logoImageView.setImageDrawable(context.getDrawable(item.logo))
        holder.itemView.setOnClickListener {
            /*
            //Redirige a la segunda vista
            val intent = Intent(context, SecondActivity::class.java)
            //Traspasa los valores de la primera vista  ala segunda vista
            intent.putExtra("Sign", context.getString(item.name)) // Pasa datos a la segunda actividad
            intent.putExtra("Description", context.getString(item.description))
            intent.putExtra("Logo", item.logo)
            intent.putExtra("id", item.id)
            context.startActivity(intent)*/
            onItemClickListener(position)
        }

    }
    // Este método sirve para actualizar los datos
    fun updateData (newDataSet: List<Horoscope>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }



}





