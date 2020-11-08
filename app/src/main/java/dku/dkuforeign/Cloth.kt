package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ToggleButton
import dku.dkuforeign.R.styleable.StateListDrawable

class Cloth : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cloth)

        var imgbtn_bcloth = findViewById<ImageButton>(R.id.imgbtn_bcloth)
        var btn_shinsegae = findViewById<Button>(R.id.btn_shinsegae)
        var btn_outlet = findViewById<Button>(R.id.btn_outlet)
        var btn_bojeong = findViewById<Button>(R.id.btn_bojeong)
        var imgbtn_homecloth = findViewById<ImageButton>(R.id.imgbtn_homecloth)

        btn_shinsegae.setOnClickListener {
            var nextIntent = Intent(this, Shinsegae::class.java)
            startActivity(nextIntent)
        }

        btn_outlet.setOnClickListener {
            var nextIntent = Intent(this, Outlet::class.java)
            startActivity(nextIntent)
        }

        btn_bojeong.setOnClickListener {
            var nextIntent = Intent(this, Bojeong::class.java)
            startActivity(nextIntent)
        }

        imgbtn_bcloth.setOnClickListener {
            finish()
        }

        imgbtn_homecloth.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }
    }
}
