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
import model.Aeroporto;
import model.ConexaoBd;

/**
 *
 * @author renilson
 */
public class AeroportoDao {
     private ConexaoBd conexao;

    public AeroportoDao() {
        conexao = new ConexaoBd();
    }
     
    public ArrayList<Aeroporto> listarAeroporto(){
        conexao.conectar();
        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection()
                    .prepareStatement("select * from aeroporto order by aer_nome"));
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                aeroportos.add(new Aeroporto(conexao.getResultSet().getInt("aer_id"),
                        conexao.getResultSet().getString("aer_nome"),
                        conexao.getResultSet().getString("aer_sigla")));
            }
            conexao.desconectar();
            return aeroportos;
        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Aeroporto buscarAeroportoById(Integer id) {
        conexao.conectar();
        Aeroporto aeroporto;
        try {
            conexao.setPreparedStatement(conexao.getConnection()
                    .prepareStatement("select * from aeroporto where aer_id = ?"));
            conexao.getPreparedStatement().setInt(1, id);
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            conexao.getResultSet().next();
            aeroporto = new Aeroporto(conexao.getResultSet().getInt("aer_id"),
                                    conexao.getResultSet().getString("aer_nome"),
                                    conexao.getResultSet().getString("aer_sigla"));
            conexao.desconectar();
            return aeroporto;
        } catch (SQLException ex) {
            Logger.getLogger(AeroportoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Aeroporto> buscarAeroportos(String s) {
        conexao.conectar();
        ArrayList<Aeroporto> aeroportos = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("select * from aeroporto where aer_nome ilike ? order by aer_sigla"));
            conexao.getPreparedStatement().setString(1, "%"+s+"%");
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                aeroportos.add(new Aeroporto(conexao.getResultSet().getInt("aer_id"),
                        conexao.getResultSet().getString("aer_nome"),
                        conexao.getResultSet().getString("aer_sigla")));
            }
            conexao.desconectar();
            return aeroportos;
        } catch (SQLException ex) {
            Logger.getLogger(PassageiroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
