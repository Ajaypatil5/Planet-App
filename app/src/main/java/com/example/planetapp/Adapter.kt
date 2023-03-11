package com.example.planetapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var planet: List<planetData>): RecyclerView.Adapter<Adapter.myViewHolder>() {
    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.title
        var planet_img = view.planet_img
        var galaxy = view.galaxy
        var distance = view.distance
        var gravity = view.gravity
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
    var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent,false)
    return myViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return planet.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var imageSetter:Int? = null
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,planetDetail::class.java)
            intent.putExtra("data", planet[position])
            intent.putExtra("planetImage", imageSetter)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.gravity.text = planet[position].gravity+ " m/ss"
        holder.distance.text = planet[position].distance + " m km"

        when(planet[position].title!!.toLowerCase()){
            "mars"->
                imageSetter = R.drawable.mars
            "earth"->
                imageSetter = R.drawable.earth
            "moon"->
                imageSetter = R.drawable.moon
            "sun"->
                imageSetter = R.drawable.sun
            "mercury"->
                imageSetter = R.drawable.mercury
            "venus"->
                imageSetter = R.drawable.venus
            "jupiter"->
                imageSetter = R.drawable.jupiter
            "neptune"->
                imageSetter = R.drawable.neptune
            "uranus"->
                imageSetter = R.drawable.uranus
            "saturn"->
                imageSetter = R.drawable.saturn

        }
            holder.planet_img.setImageResource(imageSetter!!)

    }


}

