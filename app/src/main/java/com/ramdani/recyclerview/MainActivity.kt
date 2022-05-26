package com.ramdani.recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
class MainActivity : AppCompatActivity() {
    private lateinit var rvProduct: RecyclerView
    private var title = "Mode List"
    private val list = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)
        rvProduct = findViewById(R.id.rv_product)
        rvProduct.setHasFixedSize(true)
        list.addAll(ProductData.listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvProduct.layoutManager = LinearLayoutManager(this)
        val listProductAdapter = ListProductAdapter(list)
        rvProduct.adapter = listProductAdapter
        listProductAdapter.setOnItemClickCallback(object :
            ListProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })
    }
    private fun showRecyclerGrid() {
        rvProduct.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridProductAdapter(list)
        rvProduct.adapter = gridHeroAdapter
        gridHeroAdapter.setOnItemClickCallback(object :
            GridProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })
    }
    private fun showRecyclerCardView() {
        rvProduct.layoutManager = LinearLayoutManager(this)
        val cardViewProductAdapter =
            CardViewProductAdapter(list)
        rvProduct.adapter = cardViewProductAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }
        setActionBarTitle(title)
    }
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
    private fun showSelectedProduct(product: Product) {
        Toast.makeText(this, "Kamu memilih " + product.name,
            Toast.LENGTH_SHORT).show()
    }
}