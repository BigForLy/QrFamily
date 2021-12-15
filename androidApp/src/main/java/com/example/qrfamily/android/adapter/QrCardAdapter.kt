package com.example.qrfamily.android.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.qrfamily.android.R
import com.example.qrfamily.file.FileSystem
import comexampleqrfamilydb.TCard

class QrCardAdapter(context: Context, private val dataSource: List<TCard>) : BaseAdapter() {

    private val inflater: LayoutInflater = (context as Activity).layoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.card_qr, parent, false)
        val titleText = rowView.findViewById<TextView>(R.id.title_card)
        val imageCard = rowView.findViewById<ImageView>(R.id.image_card)
        val card = getItem(position) as TCard

        titleText.text = card.name
        imageCard.setImageBitmap(FileSystem.toImage(card.qr) as Bitmap?)

        return rowView
    }
}