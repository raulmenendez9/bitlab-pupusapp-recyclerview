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
import sv.edu.bitlab.pupusap.Models.Orden
import kotlin.collections.HashMap as HashMap1

class MainActivity : AppCompatActivity() {

    val orden = Orden()

    /*val pupusaStringResources = hashMapOf(
        QUESO to R.string.pupusa_queso,
        FRIJOLES to R.string.frijol_con_queso,
        REVUELTAS to R.string.revueltas,
        LOROCO to R.string.queso_con_loroco,
        AYOTE to R.string.ayote,
        CHIPILIN to R.string.chipilin

    )*/

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
         val maiz = ArrayList<String>()
        val arroz = ArrayList<String>()

      maiz.add("QUESO")
      maiz.add("Frijoles")
      maiz.add("Revueltas")
      maiz.add("Ayote")
      maiz.add("Loroco")
      maiz.add("Chipillin")

      arroz.add("Queso")
      arroz.add("Frijoles")
      arroz.add("Revueltas")
      arroz.add("Ayote")
      arroz.add("Loroco")
      arroz.add("Chipillin")

        val adapter=MainAdapter(maiz,arroz)
        recyclerView.adapter=adapter

     // displayCounters()
//        setActionBar(null)
        Log.d("ACTIVITY", "MainActivity onCreate()")
    }

    /*fun displayCounters() {
        for ((key,value) in orden.maiz){
            val resource = pupusaStringResources[key]
            val text = this.resources.getString(resource!!, value)
            botonesMaiz[key]!!.text = text
        }


        for ((key,value) in orden.arroz){
            val resource = pupusaStringResources[key]
            val text = this.resources.getString(resource!!, value)
            botonesArroz[key]!!.text = text
        }

    }

    fun addMaiz(relleno: String) {
        orden.maiz[relleno] = orden.maiz[relleno]!! + 1
        val contador = orden.maiz[relleno]
        val resource = pupusaStringResources[relleno]
        val text = this.resources.getString(resource!!, contador)
        botonesMaiz[relleno]!!.text = text
    }
    fun addArroz(relleno: String) {
        orden.arroz[relleno] = orden.arroz[relleno]!! + 1
        val contador =  orden.arroz[relleno]
        val resource = pupusaStringResources[relleno]
        val text = this.resources.getString(resource!!, contador)
        botonesArroz[relleno]!!.text = text
    }*/

    private fun confirmarOrden() {
        val intent = Intent(this, DetalleOrdeActivity::class.java)
        intent.putExtra(ORDEN,orden)
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