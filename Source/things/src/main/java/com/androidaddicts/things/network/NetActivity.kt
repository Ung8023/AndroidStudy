package com.androidaddicts.things.network

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.androidaddicts.things.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection

class NetActivity : AppCompatActivity() {

    val URL_BD = "https://www.baidu.com"

    lateinit var urlET: EditText
    lateinit var sourceTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net)

        urlET = findViewById(R.id.et_url)
        sourceTv = findViewById(R.id.tv_source)

        urlET.setText(URL_BD)

    }

    fun getSource(view: View) {
        val text = urlET.text.toString()

        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this, "您还没有输入网址", Toast.LENGTH_SHORT).show()
        }

        getSourceInBg(text)
    }

    fun getSourceInBg(url : String) {
        Thread{
            Runnable {
                val source = getSource(url)
                runOnUiThread {
                sourceTv.text = source
                }
            }
        }.start()
    }

    fun getSource(text: String): String {
        var url: URL
        try {
            url =URL(text)
        }catch (e: Exception) {
            Toast.makeText(this, "网址输入错误", Toast.LENGTH_SHORT).show()
            return ""
        }

        val openConnection: URLConnection = url.openConnection()
        val rd = BufferedReader(InputStreamReader(openConnection.getInputStream()))

        var line: String?
        val sb = StringBuffer()
        while (true) {
            line = rd.readLine()
            if (line == null) {
                break
            }
            sb.append(line)
        }

        return sb.toString()
    }
}
