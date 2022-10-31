package mx.edu.ittepic.ladm_u2_tarea2_paralelo

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class animacion (p:MainActivity): View(p) {

    //pantalla 1080x2400
    var tierra= BitmapFactory.decodeResource(resources,R.drawable.globoterraqueo)
    var luna= BitmapFactory.decodeResource(resources, R.drawable.luna)
    var cohete1= BitmapFactory.decodeResource(resources,R.drawable.cohete)
    var cohete2= BitmapFactory.decodeResource(resources,R.drawable.cohete)
    var meta= BitmapFactory.decodeResource(resources, R.drawable.meta)
    var satelite = BitmapFactory.decodeResource(resources, R.drawable.satelite1)
    var estrella= BitmapFactory.decodeResource(resources, R.drawable.estrellas)

    var c1x= 250f
    var c1y= 1200f

    var c2x= 480f
    var c2y= 1200f

    init {
        avancecohete2()

    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p= Paint()

        c.drawColor(Color.BLUE)//pintartodo el fondo

        //estaticos
        c.drawBitmap(tierra,200f, 1540f,p)
        c.drawBitmap(luna,200f,-280f,p)
        c.drawBitmap(meta,380f,2f,p)
        c.drawBitmap(satelite,860f, 1550f,p)
        c.drawBitmap(estrella,5f,20f,p)
        c.drawBitmap(estrella,900f,20f,p)

        //dinamicos
        c.drawBitmap(cohete1,c1x,c1y,p)
        c.drawBitmap(cohete2,c2x,c2y,p)
    }

    fun avancecohete2()= GlobalScope.launch {
        var direccionY=5
        while(true){
            delay(20)
            c2y-=direccionY
            if(c2y<200 || c2y>1200){
                direccionY*=+1
            }
            invalidate()
        }
    }


}