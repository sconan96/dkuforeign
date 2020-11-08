package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_shinsegae.*

class Shinsegae : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shinsegae)

        var btn_shinsegaefinish = findViewById<ImageButton>(R.id.btn_shinsegaefinish)
        var imgbtn_shinsegaehome = findViewById<ImageButton>(R.id.imgbtn_shinsegaehome)


        btn_shinsegaefinish.setOnClickListener {
            finish()
        }

        imgbtn_shinsegaehome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(fragshinsegae1())
        adapter.addFragment(fragshinsegae2())
        adapter.addFragment(fragshinsegae3())
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
