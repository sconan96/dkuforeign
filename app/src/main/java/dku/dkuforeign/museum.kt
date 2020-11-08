package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class museum : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        var imgbtn_museumback = findViewById<ImageButton>(R.id.imgbtn_museumback)
        var imgbtn_museumhome = findViewById<ImageButton>(R.id.imgbtn_museumhome)
        var btn_nmok = findViewById<Button>(R.id.btn_nmok)
        var btn_nfmok = findViewById<Button>(R.id.btn_nfmok)
        var btn_smoa = findViewById<Button>(R.id.btn_smoa)
        var btn_smoh = findViewById<Button>(R.id.btn_smoh)
        var btn_wmok = findViewById<Button>(R.id.btn_wmok)

        imgbtn_museumback.setOnClickListener {
            finish()
        }

        imgbtn_museumhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_nmok.setOnClickListener {
            var nextIntent = Intent(this, nmok::class.java)
            startActivity(nextIntent)
        }

        btn_nfmok.setOnClickListener {
            var nextIntent = Intent(this, nfmok::class.java)
            startActivity(nextIntent)
        }

        btn_smoa.setOnClickListener {
            var nextIntent = Intent(this, smoa::class.java)
            startActivity(nextIntent)
        }

        btn_smoh.setOnClickListener {
            var nextIntent = Intent(this, smoh::class.java)
            startActivity(nextIntent)
        }

        btn_wmok.setOnClickListener {
            var nextIntent = Intent(this, wmok::class.java)
            startActivity(nextIntent)
        }
    }
}
