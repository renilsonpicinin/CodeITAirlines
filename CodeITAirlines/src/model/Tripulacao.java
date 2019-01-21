
package model;

import java.util.ArrayList;

/**
 *
 * @author renilson
 */
public class Tripulacao {

    private Integer id;
    private ArrayList<Tripulante> tripulantes;

    public Tripulacao() {
    }

    public Tripulacao(Integer id, ArrayList<Tripulante> tripulantes) {
        this.id = id;
        this.tripulantes = tripulantes;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(ArrayList<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

}
