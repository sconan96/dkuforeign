package dku.dkuforeign

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_event_study.*

class event_study : AppCompatActivity() {

    private var listview: ListView? = null
    private var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_study)

        var btn_event_study_back = findViewById<ImageButton>(R.id.btn_event_study_back)
        var btn_event_study_home = findViewById<ImageButton>(R.id.btn_event_study_home)
        var btn_event_study_write = findViewById<ImageButton>(R.id.btn_event_study_write)

        btn_event_study_back.setOnClickListener {
            finish()
        }

        btn_event_study_home.setOnClickListener {
            var intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        btn_event_study_write.setOnClickListener {
            var applicationpage = Intent(this, event_application::class.java)
            startActivity(applicationpage)
        }

        var helper = DBHelper_Study(this)
        var db = helper.writableDatabase

        var sql = "select * from StudyTable"

        var c: Cursor = db.rawQuery(sql, null)
        //Cursor 없어도 됨. 한 줄 한 줄 실행하기 위한 모듈
        //선택 아니고 다가져오니까 null쓰면 됨
        //변수 초기화
        adapter = ListViewAdapter()

        listview = findViewById<ListView>(R.id.Study_List_view)

        //어뎁터 할당
        listview!!.adapter = adapter

        listview!!.setOnItemClickListener { parent, view, position, id ->
            var helper2 = DBHelper_Study(this)
            var db2 = helper2.writableDatabase

            var sql2 = "select * from StudyTable"
            var c2: Cursor = db2.rawQuery(sql2, null)

            c2.moveToPosition(position)

            var idx_pos = c2.getColumnIndex("idx")

            var numb = c2.getString(idx_pos)

            var intent = Intent(this, event_content::class.java)
            intent.putExtra("value", numb)
            intent.putExtra("type", "StudyTable")
            startActivity(intent)

            db2.close()
        }

        while(c.moveToNext()) {
            var idx_pos = c.getColumnIndex("idx")
            var dateData_pos = c.getColumnIndex("dateData")
            var titleData_pos = c.getColumnIndex("titleData")
            var nameData_pos = c.getColumnIndex("nameData")
            var contentdata_pos = c.getColumnIndex("contentData")

            var numb = c.getString(idx_pos)
            var date = c.getString(dateData_pos)
            var Title = c.getString(titleData_pos)
            var Name = c.getString(nameData_pos)
            var Content = c.getString(contentdata_pos)

            Log.d("yang", "Data = " + numb )
            Log.d("yang", "Data = " + date )
            Log.d("yang", "Data = " + Title )
            Log.d("yang", "Data = " + Name)

            //adapter를 통한 값 전달
            adapter!!.addVO(numb, numb, date, Title, Name)
        }
        db.close()
    }
}