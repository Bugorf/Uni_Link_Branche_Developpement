package com.uni.link.pages.message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MsgAdapter(context: Context, private val data: List<String>) :
    ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            val inflater = LayoutInflater.from(context)
            itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        }

        val textView = itemView?.findViewById<TextView>(android.R.id.text1)
        textView?.text = getItem(position)

        return itemView!!
    }
}
