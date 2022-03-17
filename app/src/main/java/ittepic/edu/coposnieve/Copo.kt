package ittepic.edu.coposnieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Copo(lienzo : Lienzo) {
    val lienzo = lienzo
    var x = 0f
    var y = 0f
    var movX = 0f
    var movY = 0f
    var color = Color.WHITE
   var tamano = 0f
    var conta = 0

    init {
        x = rand(1000)
        y = rand(1800)
        movX = rand(1)
        movY = rand(2)+0.2f
        tamano = rand(30)
    }

    private fun rand(hasta:Int) : Float {
        return Random.nextInt(hasta).toFloat()
    }

    fun mover(){
        x+=movX
        y+=movY

        if(y>1900){
            y=0f
        }
        if(x>1200){
            x=0f
        }
    }

    fun intensidad(){
        if (movY<=0) movY=1f
        if (movX<=0) movX=1f
        var nivel = Random.nextInt(100)
        if(nivel>50){
            movY +=0.2f
            movX +=0.2f
        }else{
            movY -=0.15f
            movX -=0.15f
        }
        conta++
        if(conta>3000){
            movX = rand(100)/100+0.2f
            movY = rand(100)/100+0.4f
            conta = 0
        }
    }

    fun pintar(canvas : Canvas){
        var p = Paint()
        p.color= color
        p.alpha = Random.nextInt(300)
        canvas.drawCircle(x,y,tamano,p)
    }
}