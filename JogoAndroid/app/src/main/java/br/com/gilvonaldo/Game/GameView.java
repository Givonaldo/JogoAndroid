package br.com.gilvonaldo.Game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 *
 * @author Gilvonaldo
 */
public class GameView extends View implements Runnable {

    private static final int INTERVAL = 10;
    private boolean running = true;
    private int y;
    private Paint paint;
    private Inimigo[] inimigos; // Vetor com vários inimigos

    public GameView(Context c){
        super(c);

        paint = new Paint();
        Thread minhaThread = new Thread(this);
        minhaThread.setPriority(Thread.MIN_PRIORITY);
        minhaThread.start();

    }

    /**
     *
     */
    public void iniciaJogo(){

        inimigos = new Inimigo[getHeight() / 50]; // Altura da tela dividido por 50.

        for (int i = 0; i < inimigos.length; i++){

            // Posição X será randomica
            int x = (int) (Math.random() * (getWidth()-25));
            int y = i+-50;
            inimigos[i] = new Inimigo(x,y);
        }
    }

    @Override
    public void run() {

        while(running){
            try {
                Thread.sleep(INTERVAL);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            update();
        }

    }

    /**
     * Metodo que vai realizar a atualização da altura do objeto
     * e chamar o metodo postInvalidate() que por sua vez chamará
     * o metodo draw
     */
    private void update(){

        if (inimigos == null){
            return;
        }

        for (int i = 0; i < inimigos.length; i++){
            inimigos[i].mexe(getWidth(), getHeight());
        }

        postInvalidate();
    }

    /**
     * Metodo responsável por desenhar na tela.
     */
    public void draw(Canvas canvas){

        super.draw(canvas); //passando para o pai da classe o Canvas que é a classe que consegue desenhar.

        if (inimigos == null){
            iniciaJogo();
        }


        canvas.drawColor(Color.BLACK);

        // Desenho de Inimigos
        for (int i = 0; i < inimigos.length;i++){
            inimigos[i].draw(canvas, paint);
        }


    }

    /**
     * Metodo que vai seta o termino do jogo.
     */
    public void release(){
        running = false;
    }



    public boolean onTouchEvent(MotionEvent event){

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            int x = (int) event.getX();
            int y = (int) event.getY();

            for (int i = 0; i < inimigos.length; i++) {

                // Verifica se o inimigo foi tocado
                if (inimigos[i].colide(x,y)){
                    inimigos[i].setX(-50);
                }

            }
        }

        return super.onTouchEvent(event);
    }

}
