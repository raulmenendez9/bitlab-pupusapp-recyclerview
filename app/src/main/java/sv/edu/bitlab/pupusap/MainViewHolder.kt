package sv.edu.bitlab.pupusap

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Orden

class MainViewHolder (itemView: View, val listener: MainItemListener): RecyclerView.ViewHolder(itemView){
  val orden = Orden()
  var botonesMaiz = hashMapOf<String, Button>()
  var botonesArroz = hashMapOf<String, Button>()


  fun bindItems(data: String, datas: String){

    var relleno1: Button = itemView.findViewById(R.id.masaMaiz)
    var relleno2: Button = itemView.findViewById(R.id.masaArroz)

    relleno1.text=data
    relleno2.text=datas

    botonesMaiz= hashMapOf(
      data to relleno1!!
    )
    botonesArroz= hashMapOf(
      datas to relleno2!!
    )

    when(itemView){
      relleno1->itemView.setOnClickListener{
       // addMaiz(data)
      }
      relleno2->itemView.setOnClickListener{
        //addArroz(data)
      }
    }
    //displayCounters()

  }

  val pupusaStringResources = hashMapOf(
    QUESO to R.string.pupusa_queso,
    FRIJOLES to R.string.frijol_con_queso,
    REVUELTAS to R.string.revueltas,
    LOROCO to R.string.queso_con_loroco,
    AYOTE to R.string.ayote,
    CHIPILIN to R.string.chipilin

  )

  interface MainItemListener {
    fun addMaiz(relleno: String)
    fun addArroz(relleno: String)
  }


}

