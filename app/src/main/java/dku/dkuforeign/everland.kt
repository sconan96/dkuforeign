package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_everland.*

class everland : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_everland)

        var btn_everlandfinish = findViewById<ImageButton>(R.id.btn_everlandfinish)
        var imgbtn_everlandhome = findViewById<ImageButton>(R.id.imgbtn_everlandhome)


        btn_everlandfinish.setOnClickListener {
            finish()
        }

        imgbtn_everlandhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(frageverland1())
        adapter.addFragment(frageverland2())
        viewPagereverland.adapter = adapter
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
