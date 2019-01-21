/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author renilson
 */
public class SmartForTwo {

    ArrayList<Tripulante> aviao = new ArrayList<>();
    private String map = "\n";

    public SmartForTwo() {

    }

    public String transportar(ArrayList<Tripulante> t) {

        int index = 0;
        int index2 = 0;
        t.add(new Tripulante(new Cargo(0, "Policial"), 0, "Policial"));
        t.add(new Tripulante(new Cargo(0, "Presidiário"), 0, "Presidiário"));

        while (index < t.size()) {
            if (t.get(index).getCargo().getDescricao().equals("Piloto")) {
                index2 = 0;
                while (index2 < t.size()) {
                    if (t.get(index2).getCargo().getDescricao().equals("Oficial")) {
                        aviao.add(t.get(index2));
                        t.remove(index2);
                        index2--;
                        map = map + "Ida: Piloto e Oficial - Retorno: Piloto\n";
                    }
                    index2++;
                }
                index2 = 0;
                while (index2 < t.size()) {
                    if (t.get(index2).getCargo().getDescricao().equals("Chefe de Serviço")) {
                        aviao.add(t.get(index));
                        t.remove(index);
                        index2--;
                        map = map + "Ida: Piloto e Chefe de Serviço - Retorno: Chefe de Serviço\n";
                    }
                    index2++;
                }
            }
            if (t.get(index).getCargo().getDescricao().equals("Policial")) {
                index2 = 0;
                while (index2 < t.size()) {
                    if (t.get(index2).getCargo().getDescricao().equals("Presidiário")) {
                        aviao.add(t.get(index2));
                        aviao.add(t.get(index));
                        for (int i = 0; i < aviao.size(); i++) {
                            if (aviao.get(i).getCargo().getDescricao().equals("Piloto")) {
                                t.add(aviao.get(i));
                                aviao.remove(i);
                            }
                        }
                        t.remove(index2);
                        t.remove(index);
                        index2--;
                        map = map + "Ida: Policial e Presidiário - Retorno: Piloto\n";
                    }
                    index2++;
                }
            }
            index++;
        }
        index = 0;
        while (index < t.size()) {
            if (t.get(index).getCargo().getDescricao().equals("Chefe de Serviço")) {
                index2 = 0;
                while (index2 != t.size()) {
                    if (t.get(index2).getCargo().getDescricao().equals("Piloto")) {
                        aviao.add(t.get(index2));
                        t.remove(index2);
                        index2--;
                        map = map + "Ida: Chefe de Serviço e Piloto - Retorno: Chefe de Serviço\n";
                    }
                    index2++;
                }
                index2 = 0;
                while (index2 < t.size()) {
                    if (t.get(index2).getCargo().getDescricao().equals("Comissário(a)")) {
                        aviao.add(t.get(index2));
                        t.remove(index2);
                        index2--;
                        if (t.size() == 1 && t.get(0).getCargo().getDescricao().equals("Chefe de Serviço")) {
                            aviao.add(t.get(0));
                            t.remove(0);
                            map = map + "Ida: Chefe de Serviço e Comissário(a)\n";
                        } else {
                            map = map + "Ida: Chefe de Serviço e Comissário(a) - Retorno: Chefe de Serviço\n";
                        }
                    }
                    index2++;
                }
            }
            index++;
        }

        for (Tripulante te : aviao) {
            System.out.println(te.getCargo().getDescricao());
        }
        System.out.println("-----------------------");
        for (Tripulante te : t) {
            System.out.println(te.getCargo().getDescricao());
        }
        return map;
    }
}
