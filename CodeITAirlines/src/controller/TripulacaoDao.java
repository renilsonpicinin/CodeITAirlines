/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cargo;
import model.ConexaoBd;
import model.Tripulante;

/**
 *
 * @author renilson
 */
public class TripulacaoDao {
    
    private ConexaoBd conexao;

    public TripulacaoDao() {
        conexao = new ConexaoBd();
    }
    
    public void inserirTripulacao(ArrayList<Tripulante> trip, Integer vooId){
        conexao.conectar();
        try {
            for(Tripulante t : trip){
                conexao.setPreparedStatement(conexao.getConnection().prepareStatement("insert into tripulacao (voo_id,trip_id) values (?,?)"));
                conexao.getPreparedStatement().setInt(1, vooId);
                conexao.getPreparedStatement().setInt(2, t.getId());
                conexao.getPreparedStatement().execute();
            }
            conexao.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar tripulação");
            Logger.getLogger(TripulacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
