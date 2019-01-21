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
import model.ConexaoBd;
import model.Passageiro;
import model.Tripulante;

/**
 *
 * @author renilson
 */
public class PassageiroVooDao {
    private ConexaoBd conexao;

    public PassageiroVooDao() {
        conexao = new ConexaoBd();
    }
    
    public void inserirPassageiro(ArrayList<Passageiro> passageiros, Integer vooId){
        conexao.conectar();
        try {
            for(Passageiro p : passageiros){
                conexao.setPreparedStatement(conexao.getConnection().prepareStatement("insert into voo_pas (voo_id,pas_id) values (?,?)"));
                conexao.getPreparedStatement().setInt(1, vooId);
                conexao.getPreparedStatement().setInt(2, p.getId());
                conexao.getPreparedStatement().execute();
            }
            conexao.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar passageiros");
            Logger.getLogger(PassageiroVooDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
