package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Utility : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utility)

        var imgbtn_buty = findViewById<ImageButton>(R.id.imgbtn_buty)
        var btn_daiso = findViewById<Button>(R.id.btn_daiso)
        var btn_electro = findViewById<Button>(R.id.btn_electro)
        var imgbtn_homeuty= findViewById<ImageButton>(R.id.imgbtn_homeuty)

        btn_daiso.setOnClickListener {
            var nextIntent = Intent(this, Daiso::class.java)
            startActivity(nextIntent)
        }

        btn_electro.setOnClickListener {
            var nextIntent = Intent(this, Electro::class.java)
            startActivity(nextIntent)
        }

        imgbtn_buty.setOnClickListener {
            finish()
        }

        imgbtn_homeuty.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }
    }
}
