package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Grocery : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grocery)

        var imgbtn_bgrocery = findViewById<ImageButton>(R.id.imgbtn_bgrocery)
        var btn_emart = findViewById<Button>(R.id.btn_emart)
        var btn_lotte = findViewById<Button>(R.id.btn_lotte)
        var btn_homeplus = findViewById<Button>(R.id.btn_homeplus)
        var imgbtn_homegrocery = findViewById<ImageButton>(R.id.imgbtn_homegrocery)

        btn_emart.setOnClickListener {
            var nextIntent = Intent(this, Emart::class.java)
            startActivity(nextIntent)
        }

        btn_lotte.setOnClickListener {
            var nextIntent = Intent(this, Lottemart::class.java)
            startActivity(nextIntent)
        }

        btn_homeplus.setOnClickListener {
            var nextIntent = Intent(this, Homeplus::class.java)
            startActivity(nextIntent)
        }

        imgbtn_bgrocery.setOnClickListener {
            finish()
        }

        imgbtn_homegrocery.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }
    }
}
