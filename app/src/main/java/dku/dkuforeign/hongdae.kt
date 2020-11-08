package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class hongdae : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hongdae)

        var imgbtn_hongdaeback = findViewById<ImageButton>(R.id.imgbtn_hongdaeback)
        var imgbtn_hongdaehome = findViewById<ImageButton>(R.id.imgbtn_hongdaehome)
        var btn_brown = findViewById<Button>(R.id.btn_brown)
        var btn_nb2 = findViewById<Button>(R.id.btn_nb2)

        imgbtn_hongdaeback.setOnClickListener {
            finish()
        }

        imgbtn_hongdaehome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        btn_brown.setOnClickListener {
            var nextIntent = Intent(this, brown::class.java)
            startActivity(nextIntent)
        }

        btn_nb2.setOnClickListener {
            var nextIntent = Intent(this, nb2::class.java)
            startActivity(nextIntent)
        }

    }
}
