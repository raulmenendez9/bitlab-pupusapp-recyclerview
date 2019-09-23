package sv.edu.bitlab.pupusap

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Orden

class MainAdapter(var rellenos: ArrayList<String>, var rellenoss: ArrayList<String>): RecyclerView.Adapter<MainAdapter.viewholder>(){


  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
    val v=LayoutInflater.from(parent.context).inflate(R.layout.lisrt_row,parent,false)
    return viewholder(v)

  }

  override fun getItemCount(): Int {
    return rellenos.size + rellenoss.size
  }


  override fun onBindViewHolder(holder: viewholder, position: Int) {

      holder.bindItems(rellenos[position], rellenoss[position])

  }

  class viewholder(view: View): RecyclerView.ViewHolder(view){
    var botonesMaiz = hashMapOf<String, Button>()
    var botonesArroz = hashMapOf<String, Button>()

    fun bindItems(data: String, datas: String){
      var relleno2: Button = itemView.findViewById(R.id.masaMaiz)
      var relleno1: Button = itemView.findViewById(R.id.masaArroz)

      relleno2.text= datas
      relleno1.text=data

      botonesMaiz= hashMapOf(
        data to relleno1!!
      )
      botonesArroz= hashMapOf(
        datas to relleno2!!
      )


      /*when(itemView){
        relleno1->itemView.setOnClickListener{
          addMaiz(data)
        }
        relleno2->itemView.setOnClickListener{
          addArroz(data)
        }
      }
      displayCounters()*/

    }
    val orden = Orden()

    val pupusaStringResources = hashMapOf(
      QUESO to R.string.pupusa_queso,
      FRIJOLES to R.string.frijol_con_queso,
      REVUELTAS to R.string.revueltas,
      LOROCO to R.string.queso_con_loroco,
      AYOTE to R.string.ayote,
      CHIPILIN to R.string.chipilin

    )

    fun displayCounters() {
      for ((key,value) in orden.maiz){
        //val resource = pupusaStringResources[key]
        val text = this.pupusaStringResources[key]
        botonesMaiz[key]!!.text= text.toString()
      }


      for ((key,value) in orden.arroz){
        val resource = pupusaStringResources[key]
        val text = this.pupusaStringResources[key]
        botonesArroz[key]!!.text = text.toString()
      }

    }

    fun addMaiz(relleno: String) {
      orden.maiz[relleno] = orden.maiz[relleno]!! + 1
      val contador = orden.maiz[relleno]
      val text = pupusaStringResources[relleno + contador]
      //val text = this.getString(resource!!, contador)
      botonesMaiz[relleno]!!.text = text.toString()
    }
    fun addArroz(relleno: String) {
      orden.arroz[relleno] = orden.arroz[relleno]!! + 1
      val contador =  orden.arroz[relleno]
      val text = pupusaStringResources[relleno + contador]
      //val text = this.resources.getString(resource!!, contador)
      botonesArroz[relleno]!!.text = text.toString()
    }


  }


}