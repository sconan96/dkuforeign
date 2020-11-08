package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class logout_check : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout_check)

        var imgbtn_mainlogoutback = findViewById<ImageButton>(R.id.imgbtn_mainlogoutback)
        var btn_afterlogoutok = findViewById<ImageButton>(R.id.btn_afterlogoutok)

        imgbtn_mainlogoutback.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_afterlogoutok.setOnClickListener {
            var nextIntent = Intent(this, login::class.java)
            startActivity(nextIntent)
        }
    }
}
