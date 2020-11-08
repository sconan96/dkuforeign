package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class gangnam : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gangnam)


        var imgbtn_gangnamback = findViewById<ImageButton>(R.id.imgbtn_gangnamback)
        var imgbtn_gangnamhome = findViewById<ImageButton>(R.id.imgbtn_gangnamhome)
        var btn_octagon = findViewById<Button>(R.id.btn_octagon)

        imgbtn_gangnamback.setOnClickListener {
            finish()
        }

        imgbtn_gangnamhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_octagon.setOnClickListener {
            var nextIntent = Intent(this, octagon::class.java)
            startActivity(nextIntent)
        }

    }
}
