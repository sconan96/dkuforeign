package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_deoksu.*
import kotlinx.android.synthetic.main.activity_gyeongbok.*

class gyeongbok : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gyeongbok)

        var btn_gyeongbokfinish = findViewById<ImageButton>(R.id.btn_gyeongbokfinish)
        var imgbtn_gyeongbokhome = findViewById<ImageButton>(R.id.imgbtn_gyeongbokhome)


        btn_gyeongbokfinish.setOnClickListener {
            finish()
        }

        imgbtn_gyeongbokhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(fraggyeongbok1())
        adapter.addFragment(fraggyeongbok2())
        viewPagergyeong.adapter = adapter
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
