package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class amusementpark : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amusementpark)

        var imgbtn_amuseback = findViewById<ImageButton>(R.id.imgbtn_amuseback)
        var imgbtn_amusehome = findViewById<ImageButton>(R.id.imgbtn_amusehome)
        var btn_lotteworld = findViewById<Button>(R.id.btn_lotteworld)
        var btn_everland = findViewById<Button>(R.id.btn_everland)

        imgbtn_amuseback.setOnClickListener {
            finish()
        }

        imgbtn_amusehome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_lotteworld.setOnClickListener {
            var nextIntent = Intent(this, lotteworld::class.java)
            startActivity(nextIntent)
        }

        btn_everland.setOnClickListener {
            var nextIntent = Intent(this, everland::class.java)
            startActivity(nextIntent)
        }
    }
}
