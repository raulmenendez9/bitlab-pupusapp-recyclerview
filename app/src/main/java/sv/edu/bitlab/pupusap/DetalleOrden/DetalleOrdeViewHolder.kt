package sv.edu.bitlab.pupusap.DetalleOrden

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.R

class DetalleOrdeViewHolder(itemView: View, val listener: DetalleListener):RecyclerView.ViewHolder(itemView){


  fun detalleItems(contador: Int, index: Int){

    var detalle: TextView = itemView.findViewById(R.id.lineItemDetail1)
    var precio: TextView = itemView.findViewById(R.id.lineItemPrice1)

    listener.displayDetalle(detalle, precio, contador, index)


  }
  interface DetalleListener{

    fun displayDetalle( detalle: TextView, precio: TextView, contador: Int, index: Int)

  }

  }

