package dku.dkuforeign

import android.content.Intent
import android.database.Cursor
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_mentor_board.*
import kotlinx.android.synthetic.main.activity_mentee_board.*

class mentee_board : AppCompatActivity() {

    private var listview: ListView? = null
    private var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentee_board)

        var btn_mentee_home = findViewById<ImageButton>(R.id.btn_mentee_home)
        var btn_mentee_back = findViewById<ImageButton>(R.id.btn_mentee_back)
        var btn_mentee_write = findViewById<ImageButton>(R.id.btn_mentee_write)


        btn_mentee_back.setOnClickListener {
            finish()
        }

        btn_mentee_home.setOnClickListener{
            var intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        btn_mentee_write.setOnClickListener {
            var applicationpage = Intent(this, mentoring_application::class.java)
            startActivity(applicationpage)
        }

        var helper = DBHelper_Mentee(this)
        var db = helper.writableDatabase

        var sql = "select * from MenteeTable"

        var c: Cursor = db.rawQuery(sql, null)

        adapter = ListViewAdapter()

        listview = findViewById<ListView>(R.id.mentee_List_view)

        //어뎁터 할당
        listview!!.adapter = adapter

        listview!!.setOnItemClickListener { parent, view, position, id ->
            var helper2 = DBHelper_Mentee(this)
            var db2 = helper2.writableDatabase

            var sql2 = "select * from MenteeTable"
            var c2: Cursor = db2.rawQuery(sql2, null)

            c2.moveToPosition(position)

            var idx_pos = c2.getColumnIndex("idx")

            var numb = c2.getString(idx_pos)

            var intent = Intent(this, mentoring_content::class.java)
            intent.putExtra("value", numb)
            intent.putExtra("type", "MenteeTable")
            startActivity(intent)

            db2.close()
        }

        while(c.moveToNext()) {
            var idx_pos = c.getColumnIndex("idx")
            var subjectData_pos = c.getColumnIndex("subjectData")
            var titleData_pos = c.getColumnIndex("titleData")
            var nameData_pos = c.getColumnIndex("nameData")

            var numb = c.getString(idx_pos)
            var subject = c.getString(subjectData_pos)
            var Title = c.getString(titleData_pos)
            var Name = c.getString(nameData_pos)

            Log.d("yang", "Data = " + numb )
            Log.d("yang", "Data = " + Title )
            Log.d("yang", "Data = " + Name)

            adapter!!.addVO(numb,numb, subject, Title, Name)
        }
        db.close()
    }
}
