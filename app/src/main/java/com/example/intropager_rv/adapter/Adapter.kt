package com.example.intropager_rv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.intropager_rv.R
import com.example.intropager_rv.model.Intro

class Adapter(val introes : ArrayList<Intro>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_intro, parent, false)
        return IntroViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val intro = introes[position]

        if(holder is IntroViewHolder){
            holder.apply {
                anim.setAnimation(intro.anim, position.toString())
                text1.text = intro.text1
                text2.text = intro.text2
                text3.text = intro.text3
                text4.text = intro.text4
            }
        }
    }

    override fun getItemCount(): Int = introes.size

    class IntroViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var anim = view.findViewById<LottieAnimationView>(R.id.la_view)
        var text1 = view.findViewById<TextView>(R.id.tv_1)
        var text2 = view.findViewById<TextView>(R.id.tv_2)
        var text3 = view.findViewById<TextView>(R.id.tv_3)
        var text4 = view.findViewById<TextView>(R.id.tv_4)
    }
}