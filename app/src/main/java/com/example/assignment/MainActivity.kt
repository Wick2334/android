package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
        val but:Button=findViewById(R.id.bt)
        val en:EditText=findViewById(R.id.enum1)
        val res:TextView=findViewById(R.id.res)
        var flag:String="sum"
        val spinn:Spinner=findViewById(R.id.spinner)
        var options=arrayOf("cm","km")
        spinn.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        but.setOnClickListener { view->
            val x:Double=en.text.toString().toDouble()
            if(flag=="cm"){
                res.text=convertcm(x).toString();
            }
            else{
                res.text= convertkm(x).toString();
            }
        }
        spinn.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }}

        }


    }
    public fun convertcm(a:Double):Double{
      return a*100;
    }
    public fun convertkm(a:Double):Double{
        return a*0.001;
    }
