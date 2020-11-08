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

class event_content : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_content)

        var intent = getIntent()

        var btn_event_content_finish = findViewById<ImageButton>(R.id.btn_event_content_finish)
        var btn_event_content_home = findViewById<ImageButton>(R.id.btn_event_content_home)
        var txt_event_content_title = findViewById<TextView>(R.id.txt_event_content_title)
        var txt_event_content_name = findViewById<TextView>(R.id.txt_event_content_name)
        var txt_event_content = findViewById<TextView>(R.id.txt_event_content)
        var txt_study_or_party = findViewById<TextView>(R.id.txt_study_or_party)

        btn_event_content_finish.setOnClickListener {
            finish()
        }

        btn_event_content_home.setOnClickListener {
            var home = Intent(this, home::class.java)
            startActivity(home)
        }

        var helper1 = DBHelper_Study(this)
        var db1 = helper1.writableDatabase

        var helper2 = DBHelper_Party(this)
        var db2 = helper2.writableDatabase

        var type = intent.getStringExtra("type")
        var sql = "select * from " + type

        Log.d("yang", "type = " + type )

        if(type == "StudyTable") {
            txt_study_or_party.text = "study"
            Log.d("yang", "studytable "  )
            var c: Cursor = db1.rawQuery(sql, null)
            while(c.moveToNext()) {
                var idx_pos = c.getColumnIndex("idx")
                var titleData_pos = c.getColumnIndex("titleData")
                var nameData_pos = c.getColumnIndex("nameData")
                var contentdata_pos = c.getColumnIndex("contentData")

                var numb = c.getString(idx_pos)
                var Title = c.getString(titleData_pos)
                var Name = c.getString(nameData_pos)
                var Content = c.getString(contentdata_pos)

                if(numb == intent.getStringExtra("value")) {
                    txt_event_content_title.text = Title
                    txt_event_content_name.text = Name
                    txt_event_content.text = Content
                    break
                }
            }
            db1.close()
            db2.close()
        }

        else if(type == "PartyTable"){
            txt_study_or_party.text = "party"
            Log.d("yang", "partytable "  )
            var c: Cursor = db2.rawQuery(sql, null)
            while(c.moveToNext()) {
                var idx_pos = c.getColumnIndex("idx")
                var titleData_pos = c.getColumnIndex("titleData")
                var nameData_pos = c.getColumnIndex("nameData")
                var contentdata_pos = c.getColumnIndex("contentData")

                var numb = c.getString(idx_pos)
                var Title = c.getString(titleData_pos)
                var Name = c.getString(nameData_pos)
                var Content = c.getString(contentdata_pos)

                if(numb == intent.getStringExtra("value")) {
                    txt_event_content_title.text = Title
                    txt_event_content_name.text = Name
                    txt_event_content.text = Content
                    break
                }
            }
            db2.close()
            db1.close()
        }
    }
}
