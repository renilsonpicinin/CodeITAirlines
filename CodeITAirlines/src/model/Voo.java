
package model;

import java.util.ArrayList;

/**
 *
 * @author renilson
 */
public class Voo {
    
    private Integer id;
    private String data;
    private String hora;
    private Aeroporto origem;
    private Aeroporto destino;
    private Aviao aviao;
    private Tripulacao tripulacao;
    private ArrayList<Passageiro> passageiros;

    public Voo() {
    }

    public Voo(Integer id, String data, String hora, Aeroporto origem, Aeroporto destino, Aviao aviao, Tripulacao tripulacao, ArrayList<Passageiro> passageiros) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
        this.tripulacao = tripulacao;
        this.passageiros = passageiros;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tripulacao getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(Tripulacao tripulacao) {
        this.tripulacao = tripulacao;
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(ArrayList<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }  

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }
    
    @Override
    public String toString(){
        return getId() +" - "+ getData() +" - "+ getHora() +" - "+ getOrigem() 
                +" - "+ getDestino() +" - "+ getAviao().getEmpresa().getNome();
    }
}
