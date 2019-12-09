package sanchez.jimenez.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.elemento.view.*

class PersonaAdapter(personas:ArrayList<Persona>, contexto: Context): RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    var elementos: ArrayList<Persona>?=null
    var contexto:Context?=null

    init {
        this.elementos = personas
        this.contexto = contexto
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int):  PersonaAdapter.ViewHolder{
        val vistaPersona:View = LayoutInflater.from(contexto).inflate(R.layout.elemento,p0, false)
        val personaViewHolder = ViewHolder(vistaPersona)
        vistaPersona.tag =  personaViewHolder
        return  personaViewHolder
    }
    override fun getItemCount(): Int {
        return this.elementos!!.count()
    }

    override fun onBindViewHolder(p0: PersonaAdapter.ViewHolder, p1: Int){
        p0.nombre!!.text =  elementos!![p1].nombre
        p0.genero!!.text = elementos!![p1].genero
        Picasso.get().load(elementos!![p1].foto)

            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(p0.imagen)
    }

    class ViewHolder(vista: View): RecyclerView.ViewHolder(vista){
        var imagen:ImageView?=null
        var nombre:TextView?=null
        var genero:TextView?=null

        init {
            imagen= vista.ivPersona
            nombre = vista.tvNombre
            genero = vista.tvGenero
        }
    }
}