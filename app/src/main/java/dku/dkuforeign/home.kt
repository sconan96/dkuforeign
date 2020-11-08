package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var imgbtn_logout = findViewById<ImageButton>(R.id.imgbtn_logout)
        var btn_event = findViewById<ImageButton>(R.id.btn_event)
        var btn_calendar = findViewById<ImageButton>(R.id.btn_calendar)
        var btn_mentoring = findViewById<ImageButton>(R.id.btn_mentoring)
        var btn_nightlife = findViewById<ImageButton>(R.id.btn_nightlife)
        var btn_shoppping = findViewById<ImageButton>(R.id.btn_shopping)
        var btn_placestovisit = findViewById<ImageButton>(R.id.btn_placestovisit)
        var btn_others = findViewById<ImageButton>(R.id.btn_others)

        imgbtn_logout.setOnClickListener {
            var nextIntent = Intent(this, logout_check::class.java)
            startActivity(nextIntent)
        }

        btn_event.setOnClickListener {
            var community_event = Intent(this, community::class.java)
            startActivity(community_event)
        }

        btn_calendar.setOnClickListener {
            var community_calendar = Intent(this, calendar::class.java)
            startActivity(community_calendar)
        }

        btn_mentoring.setOnClickListener {
            var community_mentoring = Intent(this, community::class.java)
            startActivity(community_mentoring)
        }

        btn_nightlife.setOnClickListener {
            var place_nightlife = Intent(this, place::class.java)
            startActivity(place_nightlife)
        }

        btn_shoppping.setOnClickListener {
            var place_shopping = Intent(this, place::class.java)
            startActivity(place_shopping)
        }

        btn_placestovisit.setOnClickListener {
            var place_placestovisit = Intent(this, place::class.java)
            startActivity(place_placestovisit)
        }

        btn_others.setOnClickListener {
            var place_others = Intent(this, Other::class.java)
            startActivity(place_others)
        }
    }
}
