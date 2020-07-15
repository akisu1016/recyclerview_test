package com.example.recyclerview_test

import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val context: Context, private val itemClickListener: RecyclerViewHolder.ItemClickListener, private val itemList:List<String>)
    : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var mRecyclerView : RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder?.let {
            it.itemTextView.text = itemList.get(position)
            it.itemImageView.setImageResource(R.mipmap.ic_launcher)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.list_item, parent, false)

        mView.setOnClickListener { view ->
            mRecyclerView?.let {
                itemClickListener.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return RecyclerViewHolder(mView)
    }

}

//class RecyclerAdapter(private val customList: Array<String>) : RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder>(){
//
//    // リスナー格納変数
//    lateinit var listener: OnItemClickListener
//
//    // ViewHolderクラス(別ファイルに書いてもOK)
//    class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
//        val sampleImg = view.itemImageView
//        val sampleTxt = view.itemTextView
//    }
//
//    // getItemCount onCreateViewHolder onBindViewHolderを実装
//    // 上記のViewHolderクラスを使ってViewHolderを作成
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val item = layoutInflater.inflate(R.layout.list_item, parent, false)
//        return CustomViewHolder(item)
//    }
//
//    // recyclerViewのコンテンツのサイズ
//    override fun getItemCount(): Int {
//        return customList.size
//    }
//
//    // ViewHolderに表示する画像とテキストを挿入
//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        holder.view.itemImageView.setImageResource(R.mipmap.ic_launcher_round)
//        holder.view.itemTextView.text = customList[position]
//        // タップしたとき
//        holder.view.setOnClickListener {
//            listener.onItemClickListener(it, position, customList[position])
//        }
//    }
//
//    //インターフェースの作成
//    interface OnItemClickListener{
//        fun onItemClickListener(view: View, position: Int, clickedText: String)
//    }
//
//    // リスナー
//    fun setOnItemClickListener(listener: OnItemClickListener){
//        this.listener = listener
//    }
//}