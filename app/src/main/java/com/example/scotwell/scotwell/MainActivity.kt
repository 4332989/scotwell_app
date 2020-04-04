package com.example.scotwell.scotwell

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.scotwell.scotwell.R

open class MainActivity : AppCompatActivity() {
    private var btn: Button? = null
    private val CAMERA_PERMISSION_CODE = 100
    private val SPLASH_DISPLAY_LENGTH = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        checkPermission(Manifest.permission.CAMERA,
                CAMERA_PERMISSION_CODE)
        tvresult = findViewById<TextView>(R.id.tvresult)

        btn = findViewById<Button>(R.id.btn_scan)

        btn!!.setOnClickListener {

            val intent = Intent(this@MainActivity, ScanActivity::class.java)


            startActivity(intent)
        }

    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this@MainActivity, permission)
                == PackageManager.PERMISSION_DENIED) { // Requesting the permission
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission),
                    requestCode)
        } else {
            Toast.makeText(this@MainActivity,
                    "Permission already granted",
                    Toast.LENGTH_SHORT)
                    .show()
        }
    }


    companion object {

        var tvresult: TextView? = null
    }

    fun openBrowser(view: View) {

        val url = view.tag as String

        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.addCategory(Intent.CATEGORY_BROWSABLE)

        //pass the url to intent data
        //pass the url to intent data
        intent.data = Uri.parse(url)

        startActivity(intent)
    }

}
