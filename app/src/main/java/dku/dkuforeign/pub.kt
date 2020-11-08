package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class pub : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pub)

        var imgbtn_pubback = findViewById<ImageButton>(R.id.imgbtn_pubback)
        var imgbtn_pubhome = findViewById<ImageButton>(R.id.imgbtn_pubhome)
        var btn_shinhwa = findViewById<Button>(R.id.btn_shinhwa)
        var btn_laskal = findViewById<Button>(R.id.btn_laskal)
        var btn_hitehouse = findViewById<Button>(R.id.btn_hitehouse)

        imgbtn_pubback.setOnClickListener {
            finish()
        }

        imgbtn_pubhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_shinhwa.setOnClickListener {
            var nextIntent = Intent(this, shinhwa::class.java)
            startActivity(nextIntent)
        }

        btn_laskal.setOnClickListener {
            var nextIntent = Intent(this, laskal::class.java)
            startActivity(nextIntent)
        }

        btn_hitehouse.setOnClickListener {
            var nextIntent = Intent(this, hitehouse::class.java)
            startActivity(nextIntent)
        }
    }
}
