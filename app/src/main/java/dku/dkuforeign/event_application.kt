package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import kotlinx.android.synthetic.main.activity_event_application.*
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Toast



class event_application : AppCompatActivity() {
    var date = 0
    var app_date = "0"
    var isPageOpen = false
    var pre_date = 0
    var changedate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_application)

        var event_application_back = findViewById<ImageButton>(R.id.btn_event_application_back)
        var event_application_home = findViewById<ImageButton>(R.id.btn_event_application_home)

        var edtxt_name = findViewById<EditText>(R.id.edtxt_name)
        var edtxt_title = findViewById<EditText>(R.id.edtxt_title)
        var edtxt_event_content = findViewById<EditText>(R.id.edtxt_event_content)
        var btn_event_submit = findViewById<ImageButton>(R.id.btn_event_submit)

        var btn_event_date_calendar = findViewById<ImageButton>(R.id.btn_event_date_calendar)

        var Animshow = AnimationUtils.loadAnimation(this,R.anim.abc_slide_in_bottom)
        var Animgone = AnimationUtils.loadAnimation(this, R.anim.abc_slide_out_bottom)
        var layout_calendar = findViewById<LinearLayout>(R.id.layout_calendar)
        var application_calendar = findViewById<CalendarView>(R.id.application_calendar)

        var rdGroup = findViewById<RadioGroup>(R.id.rdGroup)
        var rdbtn_study = findViewById<RadioButton>(R.id.rdbtn_study)
        var rdbtn_party = findViewById<RadioButton>(R.id.rdbtn_party)
        var selected = "StudyTable"

        event_application_back.setOnClickListener {
            finish()
        }

        event_application_home.setOnClickListener {
            var intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        rdGroup.setOnCheckedChangeListener { rdGroup, checkedId ->
            when (checkedId) {
                R.id.rdbtn_study -> selected = "StudyTable"
                R.id.rdbtn_party -> selected = "PartyTable"
            }
        }

        btn_event_date_calendar.setOnClickListener {
            Animshow.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {

                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })

            Animgone.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {

                }

                override fun onAnimationRepeat(animation: Animation?) {

                }
            })

            layout_calendar.startAnimation(Animshow)
            layout_calendar.setVisibility(View.VISIBLE)


            application_calendar.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                layout_calendar.startAnimation(Animgone)
                layout_calendar.setVisibility(View.GONE)

                app_date = (month+1).toString() + "/" + dayOfMonth.toString()
            })
        }

        btn_event_submit.setOnClickListener {
            var helper1 = DBHelper_Study(this)
            var db1 = helper1.writableDatabase

            var helper2 = DBHelper_Party(this)
            var db2 = helper2.writableDatabase

            var sql = "insert into "+ selected + " (dateData, titleData, nameData, contentData)" +
                    " values (?,?,?,?)"

            var arg1 = arrayOf(app_date, edtxt_title.text, edtxt_name.text, edtxt_event_content.text) //int랑 float형식이더라도 무조건 다 문자형식으로 넣음

            if(selected == "StudyTable") {
                if(app_date =="0" || edtxt_title.getText().toString().equals("")  ||
                    edtxt_name.getText().toString().equals("") || edtxt_event_content.getText().toString().equals("")) {
                    Toast.makeText(applicationContext, "Insert all information", Toast.LENGTH_LONG).show()
                    db1.close()
                    db2.close()
                }
                else {
                    db1.execSQL(sql, arg1)
                    db1.close()
                    db2.close()
                    var intent = Intent(this, event_study::class.java)
                    startActivity(intent)
                }
            }
            else if(selected == "PartyTable"){
                if(app_date =="0" || edtxt_title.getText().toString().equals("")  ||
                    edtxt_name.getText().toString().equals("") || edtxt_event_content.getText().toString().equals("")) {
                    Toast.makeText(applicationContext, "Insert all information", Toast.LENGTH_LONG).show()
                    db1.close()
                    db2.close()
                }
                else {
                    db2.execSQL(sql, arg1)
                    db2.close()
                    db1.close()
                    var intent = Intent(this, event_party::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
