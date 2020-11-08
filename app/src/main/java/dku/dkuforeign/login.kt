package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.ImageButton

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var imgbtn_login = findViewById<ImageButton>(R.id.imgbtn_login)

        imgbtn_login.setOnClickListener {
            /*mainBtn 맨 위에 버튼(누르면 다이얼로그가 켜짐)*/
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)

            builder.setView(dialogView)
                .setPositiveButton("Ok") { dialogInterface, i ->
                    var nextIntent = Intent(this, home::class.java)
                    startActivity(nextIntent)
                }
                .show()
        }
    }
}
