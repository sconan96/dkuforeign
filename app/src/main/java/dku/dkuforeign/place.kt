package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout

class place : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)

        var imgbtn_placesback = findViewById<ImageButton>(R.id.imgbtn_placesback)
        var imgbtn_placeshome = findViewById<ImageButton>(R.id.imgbtn_placeshome)
        var btn_placetocommunity = findViewById<Button>(R.id.btn_placetocommunity)
        var btn_img_pub = findViewById<ImageButton>(R.id.btn_img_pub)
        var btn_placespub = findViewById<Button>(R.id.btn_placespub)
        var btn_img_club = findViewById<ImageButton>(R.id.btn_img_club)
        var btn_placesclub = findViewById<Button>(R.id.btn_placesclub)
        var btn_img_clothes = findViewById<ImageButton>(R.id.btn_img_clothes)
        var btn_placesclothes = findViewById<Button>(R.id.btn_placesclothes)
        var btn_img_grocery = findViewById<ImageButton>(R.id.btn_img_grocery)
        var btn_placesgrocery = findViewById<Button>(R.id.btn_placesgrocery)
        var btn_img_utility = findViewById<ImageButton>(R.id.btn_img_utility)
        var btn_placesutility = findViewById<Button>(R.id.btn_placesutility)
        var btn_img_amuse = findViewById<ImageButton>(R.id.btn_img_amuse)
        var btn_placesamusemnet = findViewById<Button>(R.id.btn_placesamusement)
        var btn_img_palace = findViewById<ImageButton>(R.id.btn_img_palace)
        var btn_placespalace = findViewById<Button>(R.id.btn_placespalace)
        var btn_img_museum = findViewById<ImageButton>(R.id.btn_img_museum)
        var btn_placesmuseum = findViewById<Button>(R.id.btn_placesmuseum)

        btn_img_pub.setOnClickListener {
            var nextIntent = Intent(this, pub::class.java)
            startActivity(nextIntent)
        }

        btn_placespub.setOnClickListener {
            var nextIntent = Intent(this, pub::class.java)
            startActivity(nextIntent)
        }

        btn_img_club.setOnClickListener {
            var nextIntent = Intent(this, club::class.java)
            startActivity(nextIntent)
        }

        btn_placesclub.setOnClickListener {
            var nextIntent = Intent(this, club::class.java)
            startActivity(nextIntent)
        }

        btn_img_clothes.setOnClickListener {
            var nextIntent = Intent(this, Cloth::class.java)
            startActivity(nextIntent)
        }

        btn_placesclothes.setOnClickListener {
            var nextIntent = Intent(this, Cloth::class.java)
            startActivity(nextIntent)
        }

        btn_img_grocery.setOnClickListener {
            var nextIntent = Intent(this, Grocery::class.java)
            startActivity(nextIntent)
        }

        btn_placesgrocery.setOnClickListener {
            var nextIntent = Intent(this, Grocery::class.java)
            startActivity(nextIntent)
        }

        btn_img_utility.setOnClickListener {
            var nextIntent = Intent(this, Utility::class.java)
            startActivity(nextIntent)
        }

        btn_placesutility.setOnClickListener {
            var nextIntent = Intent(this, Utility::class.java)
            startActivity(nextIntent)
        }

        btn_img_amuse.setOnClickListener {
            var nextIntent = Intent(this, amusementpark::class.java)
            startActivity(nextIntent)
        }

        btn_placesamusemnet.setOnClickListener {
            var nextIntent = Intent(this, amusementpark::class.java)
            startActivity(nextIntent)
        }

        btn_img_palace.setOnClickListener {
            var nextIntent = Intent(this, palace::class.java)
            startActivity(nextIntent)
        }

        btn_placespalace.setOnClickListener {
            var nextIntent = Intent(this, palace::class.java)
            startActivity(nextIntent)
        }

        btn_img_museum.setOnClickListener {
            var nextIntent = Intent(this, museum::class.java)
            startActivity(nextIntent)
        }

        btn_placesmuseum.setOnClickListener {
            var nextIntent = Intent(this, museum::class.java)
            startActivity(nextIntent)
        }

        btn_placetocommunity.setOnClickListener {
            var nextIntent = Intent(this, community::class.java)
            startActivity(nextIntent)
        }

        imgbtn_placesback.setOnClickListener {
            finish()
        }

        imgbtn_placeshome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

    }
}
