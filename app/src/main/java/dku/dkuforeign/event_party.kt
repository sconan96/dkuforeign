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
import kotlinx.android.synthetic.main.activity_event_party.*
import kotlinx.android.synthetic.main.activity_event_study.*

class event_party : AppCompatActivity() {

    private var listview: ListView? = null
    private var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_party)

        var btn_event_party_back = findViewById<ImageButton>(R.id.btn_event_party_back)
        var btn_event_party_home = findViewById<ImageButton>(R.id.btn_event_party_home)
        var btn_event_party_write = findViewById<ImageButton>(R.id.btn_event_party_write)

        btn_event_party_back.setOnClickListener {
            finish()
        }

        btn_event_party_home.setOnClickListener {
            var intent = Intent(this, home::class.java)
            startActivity(intent)
        }

        btn_event_party_write.setOnClickListener {
            var applicationpage = Intent(this, event_application::class.java)
            startActivity(applicationpage)
        }

        var helper = DBHelper_Party(this)
        var db = helper.writableDatabase

        var sql = "select * from PartyTable"

        var c: Cursor = db.rawQuery(sql, null)

        adapter = ListViewAdapter()

        listview = findViewById<ListView>(R.id.List_view)

        //어뎁터 할당
        listview!!.adapter = adapter

        listview!!.setOnItemClickListener { parent, view, position, id ->
            var helper2 = DBHelper_Party(this)
            var db2 = helper2.writableDatabase

            var sql2 = "select * from PartyTable"
            var c2: Cursor = db2.rawQuery(sql2, null)

            c2.moveToPosition(position)

            var idx_pos = c2.getColumnIndex("idx")

            var numb = c2.getString(idx_pos)

            var intent = Intent(this, event_content::class.java)
            intent.putExtra("value", numb)
            intent.putExtra("type", "PartyTable")
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

            adapter!!.addVO(numb,numb, date, Title, Name)
        }
        db.close()
    }
}
