package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class palace : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palace)

        var imgbtn_palaceback = findViewById<ImageButton>(R.id.imgbtn_palaceback)
        var imgbtn_palacehome = findViewById<ImageButton>(R.id.imgbtn_palacehome)
        var btn_changdeok = findViewById<Button>(R.id.btn_changdeok)
        var btn_changgyeong = findViewById<Button>(R.id.btn_changgyeong)
        var btn_gyeongbok = findViewById<Button>(R.id.btn_gyeongbok)
        var btn_deoksu = findViewById<Button>(R.id.btn_deoksu)

        imgbtn_palaceback.setOnClickListener {
            finish()
        }

        imgbtn_palacehome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_changdeok.setOnClickListener {
            var nextIntent = Intent(this, changdeok::class.java)
            startActivity(nextIntent)
        }

        btn_changgyeong.setOnClickListener {
            var nextIntent = Intent(this, changgyeong::class.java)
            startActivity(nextIntent)
        }

        btn_gyeongbok.setOnClickListener {
            var nextIntent = Intent(this, gyeongbok::class.java)
            startActivity(nextIntent)
        }

        btn_deoksu.setOnClickListener {
            var nextIntent = Intent(this, deoksu::class.java)
            startActivity(nextIntent)
        }
    }
}
