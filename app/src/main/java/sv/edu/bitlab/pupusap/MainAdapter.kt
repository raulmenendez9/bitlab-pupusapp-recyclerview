package sv.edu.bitlab.pupusap

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Orden

class MainAdapter(var rellenos: ArrayList<String>, var rellenoss: ArrayList<String>, val listener: MainViewHolder.MainItemListener): RecyclerView.Adapter<MainViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.lisrt_row, parent, false)
    return MainViewHolder(v,listener)

  }

  override fun getItemCount(): Int {
    return rellenos.size
  }


  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

    holder.bindItems(rellenos[position], rellenoss[position])


  }
}

