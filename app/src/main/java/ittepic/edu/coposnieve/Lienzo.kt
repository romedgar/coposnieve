package ittepic.edu.coposnieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo(este:MainActivity) : View(este){
    val este = este
   val copos = Array<Copo>(200,{ Copo(this) })

    val corrutina = GlobalScope.launch {
        while (true){
            este.runOnUiThread {
                invalidate()
            }
            delay(30L)
            //generarCopos()
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        c.drawColor(Color.rgb(52, 164, 235))
        var p = Paint()


        //Dibujamos Pasto
        p.color = Color.GREEN
        c.drawCircle(70f,1800f,300f,p)
        c.drawCircle(500f,1700f,300f,p)
        c.drawCircle(1000f,1800f,350f,p)

        //Dibujamos Casa
        p.color = Color.rgb(196, 148, 51)
        c.drawRect(350f,1450f,670f,1250f,p)
        p.color = Color.rgb(79, 53, 13)
        c.drawRect(390f,1450f,450f,1340f,p)
        p.color = Color.rgb(84, 208, 222)
        c.drawRect(500f,1380f,620f,1340f,p)
        p.color = Color.rgb(79, 53, 13)
        c.drawRect(350f,1220f,670f,1270f,p)
        c.drawRect(370f,1200f,650f,1250f,p)
        c.drawRect(390f,1180f,630f,1230f,p)
        p.color = Color.rgb(196, 148, 51)
        c.drawRect(420f,1130f,480f,1180f,p)
        p.color = Color.rgb(79, 53, 13)
        c.drawRect(420f,1110f,480f,1130f,p)

        //Dibujamos Humo
        p.color = Color.rgb(118, 129, 130)
        c.drawOval(420f,1060f,480f,1090f,p)
        c.drawOval(480f,1000f,570f,1060f,p)
        c.drawOval(560f,940f,680f,1020f,p)

        //Dibujamos Arboles
        p.color = Color.rgb(79, 53, 13)
        c.drawRect(40f,1400f,80f,1500f,p)
        p.color = Color.rgb(20, 107, 41)
        c.drawOval(0f,1340f,120f,1420f,p)
        c.drawOval(0f,1280f,120f,1360f,p)
        c.drawOval(0f,1220f,120f,1300f,p)
        p.color = Color.rgb(79, 53, 13)
        c.drawRect(900f,1600f,1100f,1900f,p)
        p.color = Color.rgb(20, 107, 41)
        c.drawOval(800f,1450f,1200f,1650f,p)
        c.drawOval(800f,1300f,1200f,1500f,p)
        c.drawOval(800f,1150f,1200f,1350f,p)

        //Nieve
        p.color = Color.WHITE
        c.drawRect(600f,1220f,670f,1230f,p)
        c.drawRect(600f,1200f,650f,1210f,p)
        c.drawRect(600f,1180f,630f,1190f,p)
        c.drawOval(1020f,1150f,1200f,1350f,p)
        c.drawOval(1020f,1450f,1200f,1650f,p)
        c.drawOval(1020f,1300f,1200f,1500f,p)




            for(cop in copos){
                cop.mover()
                cop.pintar(c)
                cop.intensidad()
            }









        /*(0..circulos.size-1).forEach {
            circulos[it].mover()
            circulos[it].pintar(c)
        }*/



    }
    /*fun generarCopos(){
        var copos = Array<Copo>(Random.nextInt(100),{ Copo(this) })
    }*/
}