package br.com.gilvonaldo.Game;

/**
 * Classe que servirá como uma Sprite:
 *
 * -> Um Sprite é um objeto gráfico que pode se mover na tela.
 * -> Normalmente, em uma tela temos vários sprites ao mesmo tempo.
 * -> Um sprite pode possuir atributos para sua posição(x,y),
 * tamanho(width, height) além de som e até mesmo animação própria.
 *
 *
 */
public class Retangulo {

    private int x;
    private int y;
    private int height;
    private int width;

    public Retangulo(int x, int y, int height, int width){

        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * Metodo que verifica se esse retangulo está colidindo
     * como outro retãngulo que foi passado no parametro.
     * @param r
     * @return boolean
     */
    public boolean colide(Retangulo r){
        // Verifica se está a direita
        if (r.getX()>x+width) return false;
        // Verifica se está abaixo
        if (r.getY()>y+height) return false;
        // Verifica se está a esquerda
        if (r.getX() + r.width < x) return false;
        // Verifica se está acima
        if (r.getY()+r.getHeight() < y) return false;

        // Caso ele não esteja nem a esquerda nem a direita, é sinal
        // que o retangulo está colidindo(Retorna verdadeiro).
        return true;
    }

    /**
     * Metodo que verifica se o objeto foi tocado(se ouve colisão).
     *
     * @param x2
     * @param y2
     * @return
     */
    public boolean colide(int x2, int y2){
        if (x2 > x + width) return false;
        if (y2 > y + height) return false;
        if (x2 < x) return false;
        if (y2 < y) return false;

        return true; // Está colidindo
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
