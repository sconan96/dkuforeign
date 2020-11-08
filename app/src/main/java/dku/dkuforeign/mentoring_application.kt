package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import kotlinx.android.synthetic.main.activity_mentoring_application.*
import java.text.SimpleDateFormat
import java.util.*

class mentoring_application : AppCompatActivity() {
    var date = 0
    var app_date = "0"
    var isPageOpen = false
    var pre_date = 0
    var changedate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentoring_application)

        var btn_mentoring_application_back = findViewById<ImageButton>(R.id.btn_mentoring_application_back)
        var btn_mentoring_application_home = findViewById<ImageButton>(R.id.btn_mentoring_application_home)

        var edtxt_mentoring_name = findViewById<EditText>(R.id.edtxt_mentoring_name)
        var edtxt_mentoring_title = findViewById<EditText>(R.id.edtxt_mentoring_title)
        var edtxt_mentoring_content = findViewById<EditText>(R.id.edtxt_mentoring_content)
        var btn_mentoring_submit = findViewById<ImageButton>(R.id.btn_mentoring_submit)

        var Animshow = AnimationUtils.loadAnimation(this,R.anim.abc_slide_in_bottom)
        var Animgone = AnimationUtils.loadAnimation(this, R.anim.abc_slide_out_bottom)
        var layout_calendar = findViewById<LinearLayout>(R.id.layout_calendar)
        var application_calendar = findViewById<CalendarView>(R.id.application_calendar)

        var rdGroup = findViewById<RadioGroup>(R.id.rdGroup_mentoring)
        var rdbtn_mentor = findViewById<RadioButton>(R.id.rdbtn_mentor)
        var rdbtn_mentee = findViewById<RadioButton>(R.id.rdbtn_mentee)
        var selected = "MentorTable"

        btn_mentoring_application_home.setOnClickListener {
            var intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        btn_mentoring_application_back.setOnClickListener {
            finish()
        }

        rdGroup.setOnCheckedChangeListener { rdGroup, checkedId ->
            when (checkedId) {
                R.id.rdbtn_mentor -> selected = "MentorTable"
                R.id.rdbtn_mentee -> selected = "MenteeTable"
            }
        }

        btn_mentoring_submit.setOnClickListener {
            var helper1 = DBHelper_Mentor(this)
            var db1 = helper1.writableDatabase

            var helper2 = DBHelper_Mentee(this)
            var db2 = helper2.writableDatabase

            var sql = "insert into "+ selected + " (titleData, nameData, contentData, nationData, subjectData)" +
                    " values (?,?,?,?,?)"

            var arg1 = arrayOf(edtxt_mentoring_title.text, edtxt_mentoring_name.text, edtxt_mentoring_content.text, edtxt_mentoring_nation.text, edtxt_mentoring_subject.text) //int랑 float형식이더라도 무조건 다 문자형식으로 넣음

            if(selected == "MentorTable") {
                if(edtxt_mentoring_title.getText().toString().equals("")  ||
                    edtxt_mentoring_name.getText().toString().equals("") || edtxt_mentoring_content.getText().toString().equals("") ||
                    edtxt_mentoring_nation.getText().toString().equals("")|| edtxt_mentoring_subject.getText().toString().equals("")) {
                    Toast.makeText(applicationContext, "Insert all information", Toast.LENGTH_LONG).show()
                    db1.close()
                    db2.close()
                }
                else {
                    db1.execSQL(sql, arg1)
                    db1.close()
                    db2.close()
                    var intent = Intent(this, mentor_board::class.java)
                    startActivity(intent)
                }
            }
            else if(selected == "MenteeTable"){
                if(edtxt_mentoring_title.getText().toString().equals("")  ||
                    edtxt_mentoring_name.getText().toString().equals("") || edtxt_mentoring_content.getText().toString().equals("") ||
                    edtxt_mentoring_nation.getText().toString().equals("")|| edtxt_mentoring_subject.getText().toString().equals("")) {
                    Toast.makeText(applicationContext, "Insert all information", Toast.LENGTH_LONG).show()
                    db1.close()
                    db2.close()
                }
                else {
                    db2.execSQL(sql, arg1)
                    db2.close()
                    db1.close()
                    var intent = Intent(this, mentee_board::class.java)
                    startActivity(intent)
                }
            }
        }

    }
}
