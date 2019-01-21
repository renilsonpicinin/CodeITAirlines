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
import model.Cargo;
import model.ConexaoBd;

/**
 *
 * @author renilson
 */
public class CargoDao {
    private ConexaoBd conexao;

    public CargoDao() {
        conexao = new ConexaoBd();
    }
    
    public ArrayList<Cargo> listarCargos(){
        conexao.conectar();
        ArrayList<Cargo> cargos = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection()
                    .prepareStatement("select * from cargo order by carg_descricao"));
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                cargos.add(new Cargo(conexao.getResultSet().getInt("carg_id"),
                        conexao.getResultSet().getString("carg_descricao")));
            }
            conexao.desconectar();
            return cargos;
        } catch (SQLException ex) {
            Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
