package com.example.intropager_rv.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.intropager_rv.R
import com.example.intropager_rv.adapter.Adapter
import com.example.intropager_rv.model.CirclePagerIndicatorDecoration
import com.example.intropager_rv.model.Intro

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    private fun initViews(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val skipTV = findViewById<TextView>(R.id.tv_skip)
        val getStarted = findViewById<Button>(R.id.btn_get_started)

        skipTV.setOnClickListener {

        }

        //setting indicator to recyclerView
        recyclerView.addItemDecoration(CirclePagerIndicatorDecoration())

        // using recyclerView as a ViewPager
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        // setting adapter to recyclerView
        val adapter = Adapter(prepareUserList())
        recyclerView.adapter = adapter

    }

    private fun prepareUserList() : ArrayList<Intro>{
        val introes = ArrayList<Intro>()

        introes.add(Intro(assets.open("3.json"),"Say Hello to", "Global Top-Up", "Send mobile top-up more than 500 networks", "in over 140 countries"))
        introes.add(Intro(assets.open("1.json"),"Safe, Trusted$", "Fully Secure", "Send mobile top-up more than 500 networks", "in over 140 countries"))
        introes.add(Intro(assets.open("2.json"),"Easy to Use", "", "Send mobile top-up more than 500 networks", "in over 140 countries"))

        return introes
    }
}