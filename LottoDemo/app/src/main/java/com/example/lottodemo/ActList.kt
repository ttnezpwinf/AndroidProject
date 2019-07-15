package com.example.lottodemo

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class ActList :ListActivity(){
    var lottoNumbers:Array<String?>? = null

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var itemSelect:String = this.listAdapter.getItem(position).toString()
        Log.i("LIST_DEMO", itemSelect)
        myItemSelect(itemSelect)
    }

    private fun myItemSelect(itemSelect: String) {
        var intent:Intent = Intent()
        var bund:Bundle = Bundle()
        bund.putString("lottoNum", itemSelect)
        intent.putExtras(bund)
        setResult(0,intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var cLottoGen:CLottoGen = CLottoGen()
        lottoNumbers = cLottoGen.getMulNumbers()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lottoNumbers!!)
        this.listAdapter = adapter
    }
}