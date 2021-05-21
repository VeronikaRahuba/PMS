package com.example.girafferest.ui.book


import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.girafferest.R
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class MyBookRecyclerViewAdapter(
    private val context: Context,
    private var values: List<Book>,
    private val listener: (Book) -> Unit
) : RecyclerView.Adapter<MyBookRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewprice: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_books, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title + "\n"
        holder.subtitle.text = item.subtitle + "\n"
        holder.price.text = item.price + "\n"
        Glide.with(context).load(item.image).into(holder.image)
        holder.itemView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title)
        val subtitle: TextView = view.findViewById(R.id.subtitle)
        val price: TextView = view.findViewById(R.id.price)
        val image: ImageView = view.findViewById(R.id.image)
    }
    fun removeItem(position: Int) {
        values.toMutableList().removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(item: Book, position: Int) {
        values.toMutableList().add(position, item)
        notifyItemInserted(position)
    }

    fun getData(): List<Book> {
        return values
    }

    fun updateList(list: List<Book>) {
        values = list
        notifyDataSetChanged()
    }
}
