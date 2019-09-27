package sv.edu.bitlab.pupusap.DetalleOrden

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.ORDEN
import sv.edu.bitlab.pupusap.R

class  DetalleOrdeActivity : AppCompatActivity(){
  var orden = Orden()



  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.detalle_orden_activity)
    Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show()
    val params = this.intent.extras
    orden = params!!.getParcelable<Orden>(ORDEN)!!
    Log.d("ACTIVITY", "onCreate()")
    //addFragment()
  }

  /*fun addFragment() {
    val fragment = OrdenDetalleFragment.newInstance(this.orden)
    val builder = supportFragmentManager
      .beginTransaction()
      .add(
        R.id.pruebaFragmentContainer, fragment,
        FRAGMENT_TAG
      )
    builder.commit()
  }*/

  companion object{
    const val FRAGMENT_TAG = "FRAGMENT_TAG"
  }
}
