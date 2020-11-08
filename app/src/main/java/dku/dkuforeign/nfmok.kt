package dku.dkuforeign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_nfmok.*

class nfmok : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nfmok)

        var btn_nfmokfinish = findViewById<ImageButton>(R.id.btn_nfmokfinish)
        var imgbtn_nfmokhome = findViewById<ImageButton>(R.id.imgbtn_nfmokhome)


        btn_nfmokfinish.setOnClickListener {
            finish()
        }

        imgbtn_nfmokhome.setOnClickListener {
            var nextIntent = Intent(this, home::class.java)
            startActivity(nextIntent)
        }

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(fragnfmok1())
        adapter.addFragment(fragnfmok2())
        viewPagernfmok.adapter = adapter
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
