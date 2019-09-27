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

      relleno1.setOnClickListener{
        listener.displayCounters(botonesMaiz)
       listener.addMaiz(data, botonesMaiz)
      }
      relleno2.setOnClickListener{
        listener.displayCounters(botonesArroz)
        listener.addArroz(datas, botonesArroz)
      }



  }
  interface MainItemListener {
    fun displayCounters(relleno: HashMap<String, Button>)
    fun addMaiz(relleno: String, botonM : HashMap<String, Button>)
    fun addArroz(relleno: String, botonA : HashMap<String, Button>)
  }


}

