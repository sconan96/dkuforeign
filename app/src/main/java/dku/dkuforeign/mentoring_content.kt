package dku.dkuforeign

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.quicksettings.Tile
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_mentoring_content.*

class mentoring_content : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentoring_content)

        var intent = getIntent()

        var btn_mentoring_content_finish = findViewById<ImageButton>(R.id.btn_mentoring_content_finish)
        var btn_mentoring_content_home = findViewById<ImageButton>(R.id.btn_mentoring_content_home)
        var txt_mentoring_content_title = findViewById<TextView>(R.id.txt_mentoring_content_title)
        var txt_mentoring_content_name = findViewById<TextView>(R.id.txt_mentoring_content_name)
        var txt_mentoring_content = findViewById<TextView>(R.id.txt_mentoring_content)

        btn_mentoring_content_finish.setOnClickListener {
            finish()
        }

        btn_mentoring_content_home.setOnClickListener{
            var intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        var helper1 = DBHelper_Mentor(this)
        var db1 = helper1.writableDatabase

        var helper2 = DBHelper_Mentee(this)
        var db2 = helper2.writableDatabase

        var type = intent.getStringExtra("type")
        var sql = "select * from " + type

        Log.d("yang", "type = " + type )

        if(type == "MentorTable") {
            Log.d("yang", "Mentortable "  )
            var c: Cursor = db1.rawQuery(sql, null)
            while(c.moveToNext()) {
                var idx_pos = c.getColumnIndex("idx")
                var titleData_pos = c.getColumnIndex("titleData")
                var nameData_pos = c.getColumnIndex("nameData")
                var contentdata_pos = c.getColumnIndex("contentData")
                var nationdata_pos = c.getColumnIndex("nationData")
                var subjectdata_pos = c.getColumnIndex("subjectData")

                var numb = c.getString(idx_pos)
                var Title = c.getString(titleData_pos)
                var Name = c.getString(nameData_pos)
                var Content = c.getString(contentdata_pos)
                var nation = c.getString(nationdata_pos)
                var subject = c.getString(subjectdata_pos)

                if(numb == intent.getStringExtra("value")) {
                    txt_mentoring_content_title.text = Title
                    txt_mentoring_content_name.text = Name
                    txt_mentoring_content.text = Content
                    txt_mentoring_content_type.text = "Mentor"
                    txt_mentoring_content_subject.text = subject
                    txt_mentoring_content_nation.text = nation
                    break
                }
            }
            db1.close()
            db2.close()
        }

        else if(type == "MenteeTable"){
            Log.d("yang", "MenteeTable "  )
            var c: Cursor = db2.rawQuery(sql, null)
            while(c.moveToNext()) {
                var idx_pos = c.getColumnIndex("idx")
                var titleData_pos = c.getColumnIndex("titleData")
                var nameData_pos = c.getColumnIndex("nameData")
                var contentdata_pos = c.getColumnIndex("contentData")
                var nationdata_pos = c.getColumnIndex("nationData")
                var subjectdata_pos = c.getColumnIndex("subjectData")

                var numb = c.getString(idx_pos)
                var Title = c.getString(titleData_pos)
                var Name = c.getString(nameData_pos)
                var Content = c.getString(contentdata_pos)
                var nation = c.getString(nationdata_pos)
                var subject = c.getString(subjectdata_pos)

                if(numb == intent.getStringExtra("value")) {
                    txt_mentoring_content_title.text = Title
                    txt_mentoring_content_name.text = Name
                    txt_mentoring_content.text = Content
                    txt_mentoring_content_type.text = "Mentee"
                    txt_mentoring_content_subject.text = subject
                    txt_mentoring_content_nation.text = nation
                    break
                }
            }
            db2.close()
            db1.close()
        }





/*
        btn_event_content_home.setOnClickListener {
            var home = Intent(this, home::class.java)
            startActivity(home)
        }
        */
    }
}
