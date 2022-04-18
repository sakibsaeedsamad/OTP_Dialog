package com.scube.otp_dialog

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView


class OTP_DialogAdapter (
    private val listAll: ArrayList<NameDataM>,
    private val context: Context
) : RecyclerView.Adapter<OTP_DialogAdapter.Adapter>() {

    var listOfNames = ArrayList<NameDataM>()

    init {
        listOfNames = listAll
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onEditClick(item: NameDataM?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dialog_row_view, parent, false)
        return Adapter(view)
    }

    override fun onBindViewHolder(holder: Adapter, position: Int) {
        val list = listOfNames[position]


        holder.tv_name.text = list.USER_NAME
        holder.tv_id.text = list.USER_ID


        holder.et_otp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                list.USER_OTP = holder.et_otp.getText().toString()

            }
        })


    }

    override fun getItemCount(): Int {
        return listOfNames.size
    }

    inner class Adapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_name: TextView
        var tv_id: TextView
        var et_otp: EditText

        init {


            tv_name = itemView.findViewById(R.id.tv_name)
            tv_id = itemView.findViewById(R.id.tv_id)
            et_otp = itemView.findViewById(R.id.et_otp)


        }
    }


}