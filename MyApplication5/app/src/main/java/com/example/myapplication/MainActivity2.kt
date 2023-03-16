package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        intent?.extras?.let {


            val value1=it.getString("key1")
            val textView1=findViewById<TextView>(R.id.showname2)
            textView1.text=value1

            val button2=findViewById<Button>(R.id.button2)

            val value2 =it.getString("key2")
            val textView2=findViewById<TextView>(R.id.showgender2)
            textView2.text=value2

            button2.setOnClickListener{
                val size=findViewById<EditText>(R.id.size)
                val color=findViewById<EditText>(R.id.color)
                val size1 = size.text.toString()
                val color1=color.text.toString()
                val bundle=Bundle()
                bundle.putString("key1",size1)
                bundle.putString("key2",color1)
                bundle.putString("key3",value1)
                bundle.putString("key4",value2)
                val intent=Intent().putExtras(bundle)
                setResult(RESULT_OK,intent.putExtras(bundle))
                finish()
            }





        }
    }
}