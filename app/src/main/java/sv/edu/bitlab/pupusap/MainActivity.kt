package sv.edu.bitlab.pupusap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.DetalleOrden.DetalleOrdeActivity
import sv.edu.bitlab.pupusap.DetalleOrden.DetalleOrdeActivity.Companion.CONTADOR_ARROZ
import sv.edu.bitlab.pupusap.DetalleOrden.DetalleOrdeActivity.Companion.CONTADOR_MAIZ
import sv.edu.bitlab.pupusap.Models.Orden

class MainActivity : AppCompatActivity(), MainViewHolder.MainItemListener {

  val orden = Orden()

    val pupusaStringResources = hashMapOf(
        QUESO to R.string.pupusa_queso,
        FRIJOLES to R.string.frijol_con_queso,
        REVUELTAS to R.string.revueltas,
        LOROCO to R.string.queso_con_loroco,
        AYOTE to R.string.ayote,
        CHIPILIN to R.string.chipilin

    )

    var botonesMaiz = hashMapOf<String, Button>()
    var botonesArroz = hashMapOf<String, Button>()
    var quesoIzquierda: Button? = null
    var frijolIzquierda: Button? = null
    var revueltaIzquierda: Button? = null

    var quesoDerecha: Button? = null
    var frijolDerecha: Button? = null
    var revueltasDerecha: Button? = null
    var loadingContainer: View? = null

    var sendButton: Button? = null

    //var recyclerView:RecyclerView? = null

    //@SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //quesoIzquierda = findViewById(R.id.quesoIzquierda)
        //frijolIzquierda = findViewById(R.id.frijolIzquierdaMaiz)
        //revueltaIzquierda = findViewById(R.id.revueltasIzquierda)

  /*      botonesMaiz= hashMapOf(
            QUESO to quesoIzquierda!!,
            FRIJOLES to frijolIzquierda!!,
            REVUELTAS to revueltaIzquierda!!
        )*/

//        quesoIzquierda!!.setOnClickListener { addMaiz(QUESO) }
  //      frijolIzquierda!!.setOnClickListener { addMaiz(FRIJOLES) }
    //    revueltaIzquierda!!.setOnClickListener { addMaiz(REVUELTAS) }


        //quesoDerecha = findViewById(R.id.quesoDerecha)
        //frijolDerecha = findViewById(R.id.frijolIDerechaArroz)
        //revueltasDerecha = findViewById(R.id.revueltasDerecha)

   /*     botonesArroz= hashMapOf(
            QUESO to quesoDerecha!!,
            FRIJOLES to frijolDerecha!!,
            REVUELTAS to revueltasDerecha!!
        )*/

     //quesoDerecha!!.setOnClickListener { addArroz(QUESO) }
   //     frijolDerecha!!.setOnClickListener { addArroz(FRIJOLES) }
     //   revueltasDerecha!!.setOnClickListener { addArroz(REVUELTAS) }

        sendButton = findViewById(R.id.sendButton)
        sendButton!!.setOnClickListener {
            confirmarOrden()
        }

        loadingContainer = findViewById(R.id.loadingContainer)
        loadingContainer!!.setOnClickListener { showLoading(false) }

        val recyclerView: RecyclerView= findViewById(R.id.containerView)
        recyclerView.layoutManager=LinearLayoutManager(this, RecyclerView.VERTICAL,false)
         var maiz = ArrayList<String>()
        var arroz = ArrayList<String>()

      maiz.add("QUESO")
      maiz.add("FRIJOLES")
      maiz.add("REVUELTAS")
      maiz.add("AYOTE")
      maiz.add("LOROCO")
      maiz.add("CHIPILIN")

      arroz.add("QUESO")
      arroz.add("FRIJOLES")
      arroz.add("REVUELTAS")
      arroz.add("AYOTE")
      arroz.add("LOROCO")
      arroz.add("CHIPILIN")

        val adapter=MainAdapter(maiz,arroz,this)
        recyclerView.adapter=adapter

     //displayCounters()
//        setActionBar(null)
        Log.d("ACTIVITY", "MainActivity onCreate()")
    }

   override fun displayCounters(relleno: kotlin.collections.HashMap<String, Button>) {
     if (relleno == botonesMaiz) {
       for ((key, value) in orden.maiz) {
         val resource = pupusaStringResources[key]
         val text = this.resources.getString(resource!!, value)
         relleno[key]!!.text = text
       }
     }else if(relleno==botonesArroz){

       for ((key, value) in orden.arroz) {
         val resource = pupusaStringResources[key]
         val text = this.resources.getString(resource!!, value)
         relleno[key]!!.text = text
       }
     }

    }
   override fun addMaiz(relleno: String, botonM: kotlin.collections.HashMap<String, Button>) {
    orden.maiz[relleno] = orden.maiz[relleno]!! + 1
    val contador = orden.maiz[relleno]
    val resource = pupusaStringResources[relleno]
    val text = this.resources.getString(resource!!, contador)
    botonM[relleno]!!.text = text
  }
  override fun addArroz(relleno: String, botonA: kotlin.collections.HashMap<String, Button>) {
    orden.arroz[relleno] = orden.arroz[relleno]!! + 1
    val contador =  orden.arroz[relleno]
    val resource = pupusaStringResources[relleno]
    val text = this.resources.getString(resource!!, contador)
    botonA[relleno]!!.text = text
  }


    private fun confirmarOrden() {
        val intent = Intent(this, DetalleOrdeActivity::class.java)
      var maiz = arrayListOf(
        orden.maiz[QUESO],
        orden.maiz[FRIJOLES],
        orden.maiz[REVUELTAS],
        orden.maiz[AYOTE],
        orden.maiz[LOROCO],
        orden.maiz[CHIPILIN]
      )
      var arroz = arrayListOf(
        orden.arroz[QUESO],
        orden.arroz[FRIJOLES],
        orden.arroz[REVUELTAS],
        orden.arroz[AYOTE],
        orden.arroz[LOROCO],
        orden.arroz[CHIPILIN]
      )
        intent.putExtra(CONTADOR_MAIZ,maiz)
      intent.putExtra(CONTADOR_ARROZ, arroz)
        this.startActivity(intent)
    }

    fun showLoading(show: Boolean) {
        val visibility = if(show) View.VISIBLE else View.GONE
        loadingContainer!!.visibility = visibility
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

    }

    companion object{
        const val MAIZ = "MAIZ"
        const val ARROZ = "ARROZ"
    }

}
