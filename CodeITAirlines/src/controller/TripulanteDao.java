
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
public class TripulanteDao {
    
    private ConexaoBd conexao;

    public TripulanteDao() {
        conexao = new ConexaoBd();
    }
    
    public void inserirTripulante(Tripulante t){
        conexao.conectar();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("insert into tripulante (trip_nome,carg_id) values (?,?)"));
            conexao.getPreparedStatement().setString(1, t.getNome());
            conexao.getPreparedStatement().setInt(2, t.getCargo().getId());
            conexao.getPreparedStatement().execute();
            conexao.desconectar();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
            Logger.getLogger(TripulanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Tripulante> buscarTripulanteByString(String s){
        conexao.conectar();
        ArrayList<Tripulante> tripulantes = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("select * " +
                            "from tripulante as t " +
                            "inner join cargo as c on t.carg_id = c.carg_id and trip_nome ilike ? order by trip_nome"));
            conexao.getPreparedStatement().setString(1, "%"+s+"%");
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                tripulantes.add(new Tripulante(new Cargo(conexao.getResultSet().getInt("carg_id"), 
                        conexao.getResultSet().getString("carg_descricao")),
                        Integer.parseInt(conexao.getResultSet().getString("trip_id")),
                        conexao.getResultSet().getString("trip_nome")));
            }
            conexao.getResultSet().close();
            conexao.desconectar();
            return tripulantes;
        } catch (SQLException ex) {
            Logger.getLogger(TripulanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Tripulante buscarTripulanteById(Integer i){
        conexao.conectar();
        Tripulante tripulante = new Tripulante();
        try {
            conexao.setPreparedStatement(conexao.getConnection().prepareStatement("select * " +
                            "from tripulante as t " +
                            "inner join cargo as c on t.carg_id = c.carg_id and trip_id = ? order by trip_nome"));
            conexao.getPreparedStatement().setInt(1, i);
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                tripulante = new Tripulante(new Cargo(conexao.getResultSet().getInt("carg_id"), 
                        conexao.getResultSet().getString("carg_descricao")),
                        Integer.parseInt(conexao.getResultSet().getString("trip_id")),
                        conexao.getResultSet().getString("trip_nome"));
            }
            conexao.getResultSet().close();
            conexao.desconectar();
            return tripulante;
        } catch (SQLException ex) {
            Logger.getLogger(TripulanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Tripulante> listarTripulantes(){
        conexao.conectar();
        ArrayList<Tripulante> tripulantes = new ArrayList<>();
        try {
            conexao.setPreparedStatement(conexao.getConnection()
                    .prepareStatement("select * " +
                            "from tripulante as t " +
                            "inner join cargo as c on t.carg_id = c.carg_id"));
            conexao.setResultSet(conexao.getPreparedStatement().executeQuery());
            while(conexao.getResultSet().next()){
                tripulantes.add(new Tripulante(new Cargo(conexao.getResultSet().getInt("carg_id"), 
                        conexao.getResultSet().getString("carg_descricao")),
                        Integer.parseInt(conexao.getResultSet().getString("trip_id")),
                        conexao.getResultSet().getString("trip_nome")));
            }
            conexao.desconectar();
            return tripulantes;
        } catch (SQLException ex) {
            Logger.getLogger(TripulanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
