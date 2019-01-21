
package model;

/**
 *
 * @author renilson
 */
public class Tripulante extends Pessoa {

    private Cargo cargo;

    public Tripulante() {
    }

    public Tripulante(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tripulante(Cargo cargo, Integer id, String nome) {
        super(id, nome);
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString(){
        return getId() +" - "+ getNome() +" - "+ getCargo().getDescricao();
    }
}
