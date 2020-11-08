package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class othernext : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_othernext)

        var opinion_wrong = ""

        var imgbtn_bothernext = findViewById<ImageButton>(R.id.imgbtn_bothernext)
        var imgbtn_homeothernext = findViewById<ImageButton>(R.id.imgbtn_homeothernext)

        var txt_othersubmitted = findViewById<TextView>(R.id.txt_othersubmitted)

        var intent = getIntent()

        var opinion_value = intent.getStringExtra("opinion1")

        if (opinion_value == opinion_wrong) {
            txt_othersubmitted.text = "Enter something and submit again"
        }
        else {
            txt_othersubmitted.text = "Your complain is submitted!"
        }

        imgbtn_bothernext.setOnClickListener {
            var nextIntent = Intent(this, Other::class.java)
            startActivity(nextIntent)
        }

        imgbtn_homeothernext.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

    }
}
