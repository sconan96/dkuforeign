package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class club : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club)

        var imgbtn_clubback = findViewById<ImageButton>(R.id.imgbtn_clubback)
        var imgbtn_clubhome = findViewById<ImageButton>(R.id.imgbtn_clubhome)
        var btn_hongdae = findViewById<Button>(R.id.btn_hongdae)
        var btn_itaewon = findViewById<Button>(R.id.btn_itaewon)
        var btn_gangnam = findViewById<Button>(R.id.btn_gangnam)

        imgbtn_clubback.setOnClickListener {
            finish()
        }

        imgbtn_clubhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_hongdae.setOnClickListener {
            var nextIntent = Intent(this, hongdae::class.java)
            startActivity(nextIntent)
        }

        btn_itaewon.setOnClickListener {
            var nextIntent = Intent(this, itaewon::class.java)
            startActivity(nextIntent)
        }

        btn_gangnam.setOnClickListener {
            var nextIntent = Intent(this, gangnam::class.java)
            startActivity(nextIntent)
        }
    }
}
