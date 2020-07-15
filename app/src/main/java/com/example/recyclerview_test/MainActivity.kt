package com.example.recyclerview_test

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MainActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value = resources.getStringArray(R.array.URL).toMutableList()

        viewAdapter = RecyclerAdapter(this, this, value)
        viewManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

    }

    override fun onItemClick(view: View, position: Int) {
//        val myWebView = WebView(this)
        val url = view.itemTextView.text
//        Toast.makeText(applicationContext, "$url was tapped", Toast.LENGTH_SHORT).show()
//        setContentView(myWebView)
//        myWebView.settings.javaScriptEnabled = true
//        myWebView.webViewClient = WebViewClient()
//        myWebView.loadUrl("$url")
        val intent = Intent(this, WebviewActivity::class.java)
        intent.putExtra("url", url)
        this.startActivity(intent)
    }
}

//class MainActivity : AppCompatActivity(){
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        /// 表示するテキスト配列を作る [テキスト１, テキスト２, ....]
//        val list = Array<String>(10) {"レシピ$it"}
//        val adapter = RecyclerAdapter(list)
//        val layoutManager = LinearLayoutManager(this )
//
//        // アダプターとレイアウトマネージャーをセット
//        my_recycler_view.layoutManager = layoutManager
//        my_recycler_view.adapter = adapter
//        my_recycler_view.setHasFixedSize(true)
//
//        // インターフェースの実装
//        adapter.setOnItemClickListener(object:RecyclerAdapter.OnItemClickListener{
//            override fun onItemClickListener(view: View, position: Int, clickedText: String) {
//                Toast.makeText(applicationContext, "${clickedText}がタップされました", Toast.LENGTH_LONG).show()
//            }
//        })
//    }
//}