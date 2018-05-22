package com.target.sendhil.deals.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.target.sendhil.R
import com.target.sendhil.deals.adapter.ProductListAdapter
import com.target.sendhil.deals.model.Data
import com.target.sendhil.deals.viewmodel.ProductListViewModel
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var productListViewModel:ProductListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)

        swipeToRefresh.setOnRefreshListener {
            swipeToRefresh.isRefreshing =true
            productListViewModel.fetchDeals();
        }
        productListViewModel = ViewModelProviders.of(this).get(ProductListViewModel::class.java)
        productListViewModel.productList.observe(this, Observer { t ->
            updateViewsWithData(t)
        })
        productListViewModel.fetchDeals();
    }

    fun updateViewsWithData(data:List<Data>?){
        recyclerView.adapter = ProductListAdapter(this,data)
        swipeToRefresh.isRefreshing =false
    }
}
