
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ConexaoBd;
import model.Passageiro;

/**
 *
 * @author renilson
 */
public class PassageiroDao{

    private ConexaoBd conexao;
    
    public PassageiroDao() {
        this.conexao = new ConexaoBd();
    }
    
    public void inserirPassageiro(Passageiro p){
        conexao.conectar();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("insert into passageiro (pas_nome,pas_cpf) values (?,?)"));
            conexao.getPreparedStatement().setString(1, p.getNome());
            conexao.getPreparedStatement().setString(2, p.getCpf());
            conexao.getPreparedStatement().execute();
            conexao.desconectar();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            Logger.getLogger(PassageiroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Passageiro> buscarPassageiroByString(String s){
        conexao.conectar();
        ArrayList<Passageiro> passageiros = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("select * from passageiro where pas_nome ilike ? order by pas_nome"));
            conexao.getPreparedStatement().setString(1, "%"+s+"%");
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                passageiros.add(new Passageiro(conexao.getResultSet().getString("pas_cpf"),
                        conexao.getResultSet().getInt("pas_id"),
                        conexao.getResultSet().getString("pas_nome")));
            }
            conexao.desconectar();
            return passageiros;
        } catch (SQLException ex) {
            Logger.getLogger(PassageiroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Passageiro buscarPassageiro(Integer id){
        conexao.conectar();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("select * from passageiro where pas_id = ?"));
            conexao.getPreparedStatement().setInt(1, id);
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            conexao.getResultSet().next();
            Passageiro p = new Passageiro(conexao.getResultSet().getString("pas_cpf"),
                    Integer.parseInt(conexao.getResultSet().getString("pas_id")),
                    conexao.getResultSet().getString("pas_nome"));
            conexao.desconectar();
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PassageiroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
