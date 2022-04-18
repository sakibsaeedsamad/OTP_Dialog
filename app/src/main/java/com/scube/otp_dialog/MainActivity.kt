package com.scube.otp_dialog

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var btn_open_dialog:Button
    lateinit var dialog:Dialog
    lateinit var nameList: ArrayList<NameDataM>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_open_dialog=findViewById(R.id.btn_open_dialog)

        nameList=ArrayList<NameDataM>()
        val nameDataM1 = NameDataM(
            "Sakib", "1", "")
       val nameDataM2 = NameDataM(
            "Saeed", "2", "" )

        val nameDataM3 = NameDataM(
            "SSS", "3", "" )

        nameList.add(nameDataM1)
        nameList.add(nameDataM2)
        nameList.add(nameDataM3)

        btn_open_dialog.setOnClickListener {
            showOtpDialog()
        }
    }

    private fun showOtpDialog() {


        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.otp_dialog);

        var btn_submit:Button = dialog.findViewById(R.id.btn_submit)
        var btn_cancel:Button = dialog.findViewById(R.id.btn_cancel)
        var rcv_dialog:RecyclerView = dialog.findViewById(R.id.rcv_dialog)

        var userOtp:String=""

        lateinit var otpDialogViewAdapter: RecyclerView.Adapter<*>
        lateinit var otpDialogViewManager: RecyclerView.LayoutManager

        otpDialogViewManager = LinearLayoutManager(this)
        otpDialogViewAdapter = OTP_DialogAdapter(
            nameList,
            this)

        rcv_dialog.apply {
            setHasFixedSize(true)
            layoutManager = otpDialogViewManager
            adapter = otpDialogViewAdapter

        }


        btn_submit.setOnClickListener{


            Toast.makeText(this,"${nameList[0].USER_OTP}", Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"${nameList[1].USER_OTP}", Toast.LENGTH_SHORT).show()

            dialog.dismiss()
        }

        btn_cancel.setOnClickListener {

            dialog.dismiss()
        }

        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }






}