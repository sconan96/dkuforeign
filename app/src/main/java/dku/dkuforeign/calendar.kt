package dku.dkuforeign

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import kotlinx.android.synthetic.main.custom_listview.view.*

class calendar : AppCompatActivity() {
    var isPageOpen = false
    var pre_date = 0
    var changedate = false

    private var cal_listview: ListView? = null
    private var adapter: ListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        var Animshow = AnimationUtils.loadAnimation(this,R.anim.abc_slide_in_bottom)
        var Animgone = AnimationUtils.loadAnimation(this, R.anim.abc_slide_out_bottom)
        var slidingPanel = findViewById<LinearLayout>(R.id.slidingPanel)
        var calendar = findViewById<CalendarView>(R.id.calendar)
        var btn_calendar_finish = findViewById<ImageButton>(R.id.btn_calendar_finish)


        btn_calendar_finish.setOnClickListener {
            finish()
        }

        adapter = ListViewAdapter()
        cal_listview = findViewById<ListView>(R.id.cal_ListView)

        cal_listview!!.adapter = adapter

        cal_listview!!.setOnItemClickListener { parent, view, position, id ->
            var helper = DBHelper_Study(this)
            var db1 = helper.writableDatabase

            var helper2 = DBHelper_Party(this)
            var db2 = helper2.writableDatabase

            Log.d("yang", "값= " + adapter!!.getindex(position))
            Log.d("yang", "값= " + adapter!!.gettype(position))

            var index = adapter!!.getindex(position)
            var type = adapter!!.gettype(position)

            if(type == "Study") {
                Log.d("yang", "studytable "  )
                var sql1 = "select * from StudyTable"
                var c: Cursor = db1.rawQuery(sql1, null)

                c.moveToPosition(position)

                var numb = index

                var intent = Intent(this, event_content::class.java)
                intent.putExtra("value", numb)
                intent.putExtra("type", "StudyTable")
                startActivity(intent)

                db1.close()
                db2.close()
            }

            else if(type == "Party"){
                Log.d("yang", "partytable")
                var sql1 = "select * from PartyTable"
                var c: Cursor = db2.rawQuery(sql1, null)

                c.moveToPosition(position)

                var numb = index

                var intent = Intent(this, event_content::class.java)
                intent.putExtra("value", numb)
                intent.putExtra("type", "PartyTable")
                startActivity(intent)

                db1.close()
                db2.close()

            }

        }



        Animshow.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                if(isPageOpen){
                    if(changedate == false) {
                        slidingPanel.setVisibility(View.INVISIBLE)
                        isPageOpen = false
                    }
                    else {
                        changedate = false
                    }
                }else{
                    isPageOpen = true
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        Animgone.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                if(isPageOpen){
                    slidingPanel.setVisibility(View.INVISIBLE)
                    isPageOpen = false
                }else{
                    isPageOpen = true
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })


        calendar.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->

            if(pre_date == dayOfMonth){
                if(isPageOpen == true){
                    slidingPanel.startAnimation(Animgone)
                    slidingPanel.setVisibility(View.GONE)
                }
                else{
                    slidingPanel.startAnimation(Animshow)
                    slidingPanel.setVisibility(View.VISIBLE)
                }
            }else{
                changedate = true
                slidingPanel.startAnimation(Animshow)
                slidingPanel.setVisibility(View.VISIBLE)
            }
            pre_date = dayOfMonth

            var calendar_index = 1
            var helper = DBHelper_Party(this)
            var db = helper.writableDatabase
            var sql = "select * from PartyTable"
            var c1: Cursor = db.rawQuery(sql, null)

            adapter!!.clearVO()
            adapter!!.notifyDataSetChanged()

            while(c1.moveToNext()) {
                var idx_pos = c1.getColumnIndex("idx")
                var dateData_pos = c1.getColumnIndex("dateData")
                var titleData_pos = c1.getColumnIndex("titleData")
                var nameData_pos = c1.getColumnIndex("nameData")

                var index = c1.getString(idx_pos)
                var numb = calendar_index.toString()
                var date = c1.getString(dateData_pos)
                var type = "Party"
                var Title = c1.getString(titleData_pos)
                var Name = c1.getString(nameData_pos)

                Log.d("yang", "Date1 = " + date )
                Log.d("yang", "(month+1).toString() + dayOfMonth.toString() = " + (month+1).toString() + "/" + dayOfMonth.toString() )

                if(date == (month+1).toString() + "/" + dayOfMonth.toString()){
                    Log.d("yang", "Date1 = " + date )
                    calendar_index++
                    adapter!!.addVO(index, numb, type, Title, Name)
                }
            }
            db.close()

            var helper2 = DBHelper_Study(this)
            var db2 = helper2.writableDatabase
            var sql2 = "select * from StudyTable"
            var c2: Cursor = db2.rawQuery(sql2, null)


            while(c2.moveToNext()) {
                var idx_pos = c2.getColumnIndex("idx")
                var dateData_pos = c2.getColumnIndex("dateData")
                var titleData_pos = c2.getColumnIndex("titleData")
                var nameData_pos = c2.getColumnIndex("nameData")

                var index = c2.getString(idx_pos)
                var numb = calendar_index.toString()
                var date = c2.getString(dateData_pos)
                var type = "Study"
                var Title = c2.getString(titleData_pos)
                var Name = c2.getString(nameData_pos)

                Log.d("yang", "Date2 = " + date )
                Log.d("yang", "(month+1).toString() + dayOfMonth.toString() = " + (month+1).toString() + "/" + dayOfMonth.toString() )

                if (date == (month + 1).toString() + "/" + dayOfMonth.toString()) {
                    Log.d("yang", "Date1 = " + date )
                    calendar_index++
                    adapter!!.addVO(index, numb, type, Title, Name)
                }
            }

        })

    }
}
