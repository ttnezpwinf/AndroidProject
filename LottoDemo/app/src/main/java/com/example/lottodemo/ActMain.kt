package com.example.lottodemo

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ActMain : Activity() {

    var lottoNumbers:Array<String?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actmain)
        initialComponent()
    }

    val btnMath_click : View.OnClickListener=View.OnClickListener {
        var cLottoGen:CLottoGen = CLottoGen()
        val s:String = cLottoGen.getNumbers()
        lblMessage?.text = s
    }

    val btnMulMath_click : View.OnClickListener=View.OnClickListener {
        var cLottoGen:CLottoGen = CLottoGen()
        lottoNumbers = cLottoGen.getMulNumbers()

        var builder = AlertDialog.Builder(this)
        builder.setTitle("請選擇一組樂透號碼:")
        builder.setItems(lottoNumbers, listItem_click)

        var message:AlertDialog = builder.create()
        message.show()
    }

    val listItem_click : DialogInterface.OnClickListener=DialogInterface.OnClickListener {
            di:DialogInterface, index:Int ->
        lblMessage?.text = lottoNumbers?.get(index)
    }

    val btnList_click : View.OnClickListener=View.OnClickListener {
        val intent = Intent(this, ActList::class.java)
        startActivityForResult(intent, 89)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==89){
            val yourChose = data?.extras!!.getString("lottoNum")
            lblMessage?.text = "$yourChose "
        }
    }

    private fun initialComponent() {
        lblMessage = findViewById(R.id.lblMessage)
        btnMath = findViewById(R.id.btnMath)
        btnMath?.setOnClickListener(btnMath_click)
        btnMulMath = findViewById(R.id.btnMulMath)
        btnMulMath?.setOnClickListener(btnMulMath_click)
        btnList = findViewById(R.id.btnList)
        btnList?.setOnClickListener(btnList_click)
    }

    var lblMessage: TextView? = null
    var btnMath: Button? = null
    var btnMulMath: Button? = null
    var btnList: Button? = null
}
