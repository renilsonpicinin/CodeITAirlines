
package model;

/**
 *
 * @author renilson
 */
public class Passageiro extends Pessoa {
    
    private String cpf;

    public Passageiro() {
    }

    public Passageiro(String cpf) {
        this.cpf = cpf;
    }

    public Passageiro(String cpf, Integer id, String nome) {
        super(id, nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return String.valueOf(getId())+" - "+getNome()+" - "+getCpf();
    }
}
