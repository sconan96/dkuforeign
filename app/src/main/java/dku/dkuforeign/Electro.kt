package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_electro.*

class Electro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electro)

        var btn_electrofinish = findViewById<ImageButton>(R.id.btn_electrofinish)
        var imgbtn_electrohome = findViewById<ImageButton>(R.id.imgbtn_electrohome)


        btn_electrofinish.setOnClickListener {
            finish()
        }

        imgbtn_electrohome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(fragelectro1())
        adapter.addFragment(fragelectro2())
        adapter.addFragment(fragelectro3())
        viewPager.adapter = adapter
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
