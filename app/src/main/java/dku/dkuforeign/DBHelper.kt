package dku.dkuforeign

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper_Party(context : Context) : SQLiteOpenHelper(context, "Party.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("yang", "oncreate Party")
        var sql = "create table PartyTable ( " +
                "idx integer primary key autoincrement, " +
                "dateData text not null, " +
                "titleData text not null, " +
                "nameData text not null, " +
                "contentData text not null " +
                ")"
        db?.execSQL(sql)
    }
    //idx : 순번, autoincrement : 자동적으로 순번 매김
    //null은 절대 허용해서 안됨
    //helper가 하는역할 : 앱을 다시 열 때 마다 다시 만들어지는 것을 방지하기 위해. 처음 한번만 실행될 수 있게 도와줌 => table 바꾸거나 하기위해서는 꼭 이전의 것(앱)을 아예 지우고 새로 만들어야 함
    //=> 귀찮음 => 마지막에 들어가야함

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    //상사의 번호 : oldVersion, 내 번호 : newVersion, 회사가면 onCreate를 내가 쓸일은 없음. 무조건 onUpgrade에서 쓰게 될 것임
}
// name : table 이름아니고 파일이름, version : 다른사람이 갖다 쓸 때 버젼 관리 해야함 우리는 지금 그냥 1만 쓰면 될 듯


class DBHelper_Study(context : Context) : SQLiteOpenHelper(context, "Study.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("yang", "oncreate Study")
        var sql = "create table StudyTable ( " +
                "idx integer primary key autoincrement, " +
                "dateData text not null, " +
                "titleData text not null, " +
                "nameData text not null, " +
                "contentData text not null " +
                ")"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}

