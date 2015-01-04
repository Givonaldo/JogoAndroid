package com.example.gilvonaldo.jogoandroid;

import android.app.Activity;
import android.os.Bundle;
import br.com.gilvonaldo.Game.GameView;

/**
 * Tela principal da aplicação.
 */
public class MainActivity extends Activity {

    private GameView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new GameView(this);
        setContentView(game); // Comando que vai mostrar na tela a GameView instanciada.

    }

    /**
     * Metodo que fechará a aplicação
     */
    protected void onDestroy(){
        super.onDestroy();
        game.release();
    }

}
