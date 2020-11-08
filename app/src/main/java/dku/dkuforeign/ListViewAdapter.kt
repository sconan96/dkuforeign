package dku.dkuforeign

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.ArrayList

class ListViewAdapter : BaseAdapter() {

    private val listVO = ArrayList<ListVO>()
    private var remember_position = 0

    override fun getCount(): Int {
        return listVO.size
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        //postion = ListView의 위치      /   첫번째면 position = 0
        val context = parent.context

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.custom_listview, parent, false)
        }

        val index = convertView!!.findViewById<TextView>(R.id.index)
        val numb = convertView.findViewById<TextView>(R.id.numb)
        val date = convertView.findViewById<TextView>(R.id.date)
        val title = convertView.findViewById<TextView>(R.id.title)
        val name = convertView.findViewById<TextView>(R.id.name)


        val listViewItem = listVO[position]

        // 아이템 내 각 위젯에 데이터 반영
        index.text = listViewItem.index
        numb.text = listViewItem.numb
        date.text = listViewItem.date
        title.text = listViewItem.title
        name.text = listViewItem.name

        return convertView
    }


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getItem(position: Int): Any {
        return listVO[position]
    }

    fun getindex(position : Int) : String? {
        return listVO[position].index
    }

    fun gettype(position: Int) : String? {
        return listVO[position].date
    }


    // 데이터값 넣어줌
    fun addVO(index : String, numb : String, date: String, title: String, name: String) {
        val item = ListVO()

        item.index = index
        item.numb = numb
        item.date = date
        item.name = name
        item.title = title

        listVO.add(item)
    }

    fun clearVO(){
        listVO.clear()
    }
}
