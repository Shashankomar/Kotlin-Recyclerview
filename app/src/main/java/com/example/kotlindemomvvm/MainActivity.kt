package com.example.kotlindemomvvm

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val txtBefore by lazy { TextView(this) }
    private val txtAfter by lazy { TextView(this) }
    val txtOn by lazy { TextView(this) }
    var dataList = ArrayList<MainDataModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()

        et_search.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }
        })

        val editText = EditText(this)
        editText.apply {
            setText("Androidly EditText")
            hint = "Keep entering"
            val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            lp.setMargins(8, 8, 8, 8)
            layoutParams = lp
            imeOptions = EditorInfo.IME_ACTION_NEXT
            setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_purple))
            smartTextWatcher(
                on = { txtOn.apply { text = "onTextChanged: $it" } },
                after = { txtAfter.apply { text = "smartTextWatcher: $it" } },
                before = { txtBefore.apply { text = "beforeTextChanged: $it" } }
            )
    
    }

    private fun getData() {
        val call: Call<List<MainDataModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<MainDataModel>> {
            override fun onFailure(call: Call<List<MainDataModel>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<MainDataModel>>,
                response: Response<List<MainDataModel>>
            ) {
                if (response.isSuccessful) {
                    dataList.addAll(response.body()!!)
                    setRecyclerView(dataList)
                }
            }
        })
    }

    private fun setRecyclerView(data: List<MainDataModel>?) {
        rv_main.adapter = MainDataAdapter(this, data)
        rv_main.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )
    }

}

    private fun smartTextWatcher(
        on: () -> TextView,
        after: () -> TextView,
        before: () -> TextView
    ) {
        TODO("Not yet implemented")
    }

