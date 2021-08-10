import java.util.*;

public class Cofre {

    private final Stack<Item> itens= new Stack<>();

    private final Stack<Moeda> moedas= new Stack<>();

    private int volume=0;

    private final int volMaximo;

    private int volRestante;

    private boolean quebrado=false;

    public Cofre(int volumeMaximo) {
        volMaximo=volumeMaximo;
        volRestante=volumeMaximo;
    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMaximo() {
        return volMaximo;
    }

    public int getVolumeRestante() {
        return volRestante;
    }

    public boolean add(Item item) {
        if(volRestante-item.getVolume()>=0&&!quebrado){
            volRestante-=item.getVolume();
            volume+=item.getVolume();
            itens.push(item);
            return true;
        }
        else
            return false;
    }

    public boolean add(Moeda moeda) {
        if(volRestante-moeda.getVolume()>=0&&!quebrado){
            volRestante-=moeda.getVolume();
            volume+=moeda.getVolume();
            moedas.push(moeda);
            return true;
        }
        else
            return false;
    }

    public String obterItens() {
        if(quebrado){
            return getItens();
        }
        else
            return null;
    }

    private String getItens() {
        StringBuilder s= new StringBuilder();
        if(itens.empty())
            s.append("vazio");
        while(!itens.empty()) {
            s.insert(0, itens.peek().getDescricao());
            itens.pop();
            if(!itens.empty())
                s.insert(0, ", ");
        }
        return s.toString();
    }

    public double obterMoedas() {
        if(quebrado){
            double valor=0;
            while(!moedas.empty()) {
                valor+=moedas.peek().getValor();
                moedas.pop();
            }
            return valor;
        }
        else
            return -1;
    }
    
    public boolean taInteiro() {
        return !quebrado;
    }

    public boolean quebrar() {
        if(!quebrado){
            quebrado=true;
            return true;
        }
        else
            return false;
    }
}
