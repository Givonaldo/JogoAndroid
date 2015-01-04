package br.com.gilvonaldo.Game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by gilvonaldo on 03/01/15.
 */
public class Inimigo extends Retangulo {

    public Inimigo(int x, int y){
        super(x,y,25,25);
    }

    /** Metodo que vai "criar" os retangulos que
     * vão decendo da tela, em uma posição Randomica.
     *
     * @param height
     *      Altura da tela.
     * @param width
     *      Largura da Tela.
     */
    public void mexe(int height, int width){

        if (getY() < height){
            setY(getY()+5);
        }else {
            int x = (int) (Math.random() * (width - 25));
            setX(x);
            setY(-25);
        }
    }

    /**
     * Metodo que vai desenhar um retangulo na tela.
     *
     * @param canvas
     *
     * @param paint
     */
    public void draw(Canvas canvas, Paint paint){

        paint.setColor(Color.RED); // Cor do retangulo que será criado.
        canvas.drawRect(getX(), getY(), getX()+getWidth(), getY() + getHeight(), paint); // Desenho do retangulo inimigo

    }
}
