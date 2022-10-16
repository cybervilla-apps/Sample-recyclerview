package com.cybervilla.testrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AdapterMain.OnItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapterMain: AdapterMain
    lateinit var listMain:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareList()
        recyclerView = findViewById(R.id.recycler_main)
        adapterMain = AdapterMain(listMain,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterMain
    }

    fun prepareList(){
        listMain = ArrayList()
        for (i in 1..50){
            listMain.add("Test Items = $i")
        }
    }
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item = $position", Toast.LENGTH_SHORT).show()
    }

}