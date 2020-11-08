package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_changdeok.*

class changdeok : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changdeok)

        var btn_changdeokfinish = findViewById<ImageButton>(R.id.btn_changdeokfinish)
        var imgbtn_changdeokhome = findViewById<ImageButton>(R.id.imgbtn_changdeokhome)


        btn_changdeokfinish.setOnClickListener {
            finish()
        }

        imgbtn_changdeokhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(fragchangdeok1())
        adapter.addFragment(fragchangdeok2())
        viewPagerchangdeok.adapter = adapter
    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){
        private val fragmentList : MutableList<Fragment> = ArrayList()
        override fun getItem(p0: Int): Fragment {
            return fragmentList[p0]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment){
            fragmentList.add(fragment)
        }
    }
}