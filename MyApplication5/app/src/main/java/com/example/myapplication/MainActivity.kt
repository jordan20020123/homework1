package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val gender = findViewById<EditText>(R.id.gender)
        val showname = findViewById<TextView>(R.id.showname)
        val shoegender = findViewById<TextView>(R.id.showgender)

        val buttom = findViewById<Button>(R.id.buttontest)

        buttom.setOnClickListener{
            val name1 = name.text.toString()
            val gender1=gender.text.toString()
            val bundle =Bundle()
            bundle.putString("key1",name1)
            bundle.putString("key2",gender1)

            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivityForResult(intent,1)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        data?.extras?.let {

            if(requestCode==1 && resultCode==Activity.RESULT_OK){
                findViewById<TextView>(R.id.showname).text= "名字:${it.getString("key3")}\n\n"
                findViewById<TextView>(R.id.showgender).text= "性別:${it.getString("key4")}\n\n"
                findViewById<TextView>(R.id.showsize).text= "尺寸:${it.getString("key1")}\n\n"
                findViewById<TextView>(R.id.showcolor).text= "顏色:${it.getString("key2")}\n\n"
            }
        }
    }
}