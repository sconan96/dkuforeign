package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout

class community : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community)

        var btn_community_back = findViewById<ImageButton>(R.id.btn_community_back)
        var btn_community_home = findViewById<ImageButton>(R.id.btn_community_home)
        var btn_communitytoplace = findViewById<Button>(R.id.btn_communitytoplace)
        var btn_img_eventstudy = findViewById<ImageButton>(R.id.btn_img_eventstudy)
        var btn_eventstudy = findViewById<Button>(R.id.btn_eventstudy)
        var btn_img_eventparty = findViewById<ImageButton>(R.id.btn_img_eventparty)
        var btn_eventparty = findViewById<Button>(R.id.btn_eventparty)
        var btn_img_eventcalendar = findViewById<ImageButton>(R.id.btn_img_eventcalendar)
        var btn_eventcalendar = findViewById<Button>(R.id.btn_eventcalendar)
        var btn_img_mentor = findViewById<ImageButton>(R.id.btn_img_mentor)
        var btn_mentoringmentor = findViewById<Button>(R.id.btn_mentoringmentor)
        var btn_img_mentee = findViewById<ImageButton>(R.id.btn_img_mentee)
        var btn_mentoringmentee = findViewById<Button>(R.id.btn_mentoringmentee)


        btn_img_eventstudy.setOnClickListener {
            var nextIntent = Intent(this, event_study::class.java)
            startActivity(nextIntent)
        }

        btn_eventstudy.setOnClickListener {
            var nextIntent = Intent(this, event_study::class.java)
            startActivity(nextIntent)
        }

        btn_img_eventparty.setOnClickListener {
            var nextIntent = Intent(this, event_party::class.java)
            startActivity(nextIntent)
        }

        btn_eventparty.setOnClickListener {
            var nextIntent = Intent(this, event_party::class.java)
            startActivity(nextIntent)
        }

        btn_img_eventcalendar.setOnClickListener {
            var nextIntent = Intent(this, calendar::class.java)
            startActivity(nextIntent)
        }

        btn_eventcalendar.setOnClickListener {
            var nextIntent = Intent(this, calendar::class.java)
            startActivity(nextIntent)
        }

        btn_img_mentor.setOnClickListener {
            var nextIntent = Intent(this, mentor_board::class.java)
            startActivity(nextIntent)
        }

        btn_mentoringmentor.setOnClickListener {
            var nextIntent = Intent(this, mentor_board::class.java)
            startActivity(nextIntent)
        }

        btn_img_mentee.setOnClickListener {
            var nextIntent = Intent(this, mentee_board::class.java)
            startActivity(nextIntent)
        }

        btn_mentoringmentee.setOnClickListener {
            var nextIntent = Intent(this, mentee_board::class.java)
            startActivity(nextIntent)
        }

        btn_communitytoplace.setOnClickListener {
            var nextIntent = Intent(this, place::class.java)
            startActivity(nextIntent)
        }

        btn_community_back.setOnClickListener {
            finish()
        }

        btn_community_home.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }
    }
}
