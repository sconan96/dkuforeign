package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton

class Other : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        var imgbtn_bother = findViewById<ImageButton>(R.id.imgbtn_bother)
        var imgbtn_other_submit = findViewById<ImageButton>(R.id.imgbtn_other_submit)
        var imgbtn_homeother = findViewById<ImageButton>(R.id.imgbtn_homeother)

        var edt_otherid = findViewById<EditText>(R.id.edt_otherid)

        imgbtn_other_submit.setOnClickListener {
            var intent = Intent(this, othernext::class.java)

            var opinionother_msg = edt_otherid.text.toString()

            intent.putExtra("opinion1", opinionother_msg)

            startActivity(intent)
        }

        imgbtn_bother.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        imgbtn_homeother.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }
    }
}
