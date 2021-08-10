public enum Moeda {

    M10(.10, 1),
    M25(.25, 2),
    M50(.50, 3),
    M100(1.00, 4);

    private double valor;

    private int volume;

    Moeda(double valor, int volume) {
        this.valor=valor;
        this.volume=volume;
    }

    public double getValor() {
        return valor;
    }

    public int getVolume() {
        return volume;
    }
}
