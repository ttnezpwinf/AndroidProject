package com.example.lottodemo

class CLottoGen {

    fun getMulNumbers():Array<String?>{
        var list:Array<String?> = arrayOfNulls<String?>(15)
        for(i:Int in 0 until list.size){
            list.set(i,getNumbers())
        }
        return list
    }

    fun getNumbers(): String {
        var count:Int = 0
        var numbers:IntArray = IntArray(6)
        while(count<6){
            var d:Double = Math.random()*42 +1
            val temp:Int = d.toInt()
            if(numberNotExist(temp, numbers)){
                numbers[count] = temp
                count++
            }
        }
        numbers.sort()
        var s:String = ""
        for(i:Int in numbers){
            s += i.toString() + ", "
        }
        return s
    }

    private fun numberNotExist(temp: Int, numbers: IntArray): Boolean {
        for(i:Int in numbers){
            if(temp==i){
                return false
            }
        }
        return true
    }

}