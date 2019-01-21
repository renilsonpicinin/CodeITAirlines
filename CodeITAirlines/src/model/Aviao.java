
package model;

/**
 *
 * @author renilson
 */
public class Aviao{
    
    private Integer id;
    private String modelo;
    private Empresa empresa;
    private Integer capacidade;

    public Aviao() {
    }

    public Aviao(Integer id, String modelo, Empresa empresa, Integer capacidade) {
        this.id = id;
        this.modelo = modelo;
        this.empresa = empresa;
        this.capacidade = capacidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
    
    @Override
    public String toString(){
        return getId() +" - "+ getModelo() +" - "+ getEmpresa().getNome() 
                +" - "+ getCapacidade();
    }
}
