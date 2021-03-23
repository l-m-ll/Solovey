package com.example.solovey


import android.view.View
import android.view.ViewGroup
import android.annotation.SuppressLint
import android.app.Activity
import android.widget.*

class PlayListAdapter(private val context: Activity, private val title: Array<String>,
                    private val description: Array<String>, private val imgId: Array<Int>)
    : ArrayAdapter<String>(context, R.layout.music_list_view_cell, title) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.music_list_view_cell, null, true)

        val songName = rowView.findViewById(R.id.groupName) as TextView
        val iconPlaceholder = rowView.findViewById(R.id.icon) as ImageView
        val groupNameText = rowView.findViewById(R.id.songName) as TextView

        songName.text = title[position]
        iconPlaceholder.setImageResource(imgId[position])
        groupNameText.text = description[position]

        return rowView
    }
}