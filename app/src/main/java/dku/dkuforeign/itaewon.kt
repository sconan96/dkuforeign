package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class itaewon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itaewon)

        var imgbtn_itaewonback = findViewById<ImageButton>(R.id.imgbtn_itaewonback)
        var imgbtn_itaewonhome = findViewById<ImageButton>(R.id.imgbtn_itaewonhome)
        var btn_cakeshop = findViewById<Button>(R.id.btn_cakeshop)
        var btn_soap = findViewById<Button>(R.id.btn_soap)

        imgbtn_itaewonback.setOnClickListener {
            finish()
        }

        imgbtn_itaewonhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_cakeshop.setOnClickListener {
            var nextIntent = Intent(this, cakeshop::class.java)
            startActivity(nextIntent)
        }

        btn_soap.setOnClickListener {
            var nextIntent = Intent(this, soap::class.java)
            startActivity(nextIntent)
        }
    }
}
