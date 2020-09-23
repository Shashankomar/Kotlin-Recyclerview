package com.example.kotlinquoteslist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var dataList = ArrayList<MainDataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_main.visibility = View.GONE
        pb.visibility = View.VISIBLE
        getData()
    }

    private fun getData() {
        val call: Call<List<MainDataModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<MainDataModel>> {
            override fun onFailure(call: Call<List<MainDataModel>>, t: Throwable) {
                rv_main.visibility = View.VISIBLE
                pb.visibility = View.GONE
                Log.e("errorMsg", t.message ?: getString(R.string.error_msg_null))
            }

            override fun onResponse(
                call: Call<List<MainDataModel>>,
                response: Response<List<MainDataModel>>
            ) {
                if (response.isSuccessful) {
                    pb.visibility = View.GONE
                    rv_main.visibility = View.VISIBLE
                    dataList.addAll(response.body()!!)
                    setRecyclerView(dataList)
                }
            }
        })
    }

    private fun setRecyclerView(data: List<MainDataModel>) {
        rv_main.adapter = MainDataAdapter(this, data)
        rv_main.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
    }
}