package com.example.qrfamily.android

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class QrCardAdapter(context: Context, private val dataSource: Array<String>) :
    BaseAdapter() {

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
        val recipe = getItem(position) as String

        titleText.text = recipe

        return rowView
    }
}