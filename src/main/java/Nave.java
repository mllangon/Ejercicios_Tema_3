public abstract class Nave {
    protected int vida;
    protected int daño;

    public Nave(int vida, int daño) {
        this.vida = vida;
        this.daño = daño;
    }

    public void recibirDaño(int daño) {
        vida -= daño;
    }

    public int atacar() {
        return daño;
    }

    public boolean estaViva() {
        return vida > 0;
    }
}