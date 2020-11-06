package kr.co.kookmin.permission

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    val permission_list = arrayOf(
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_CONTACTS,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView : TextView = findViewById(R.id.textView)
        textView.text = ""

        for(permission in permission_list){
            val chk = checkCallingOrSelfPermission(permission)

            if(chk == PackageManager.PERMISSION_GRANTED){
                textView.append("$permission : 허용\n")
            }else if(chk == PackageManager.PERMISSION_DENIED){
                textView.append("$permission : 거부\n")
            }
        }

    }


}
