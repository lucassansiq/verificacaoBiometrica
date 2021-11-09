/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Produtora;
import model.Usuario;

/**
 *
 * @author Lucas Hype
 */
public class ProdutoraDAO implements dao.Persistencia<Produtora> {
    
    private static ProdutoraDAO dao = null ;
    
    public ProdutoraDAO(){
        
    }
    
    public static ProdutoraDAO getInstance(){
        if(dao == null) dao = new ProdutoraDAO();
        
        return dao;
    }

    @Override
    public int create(Produtora obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produtora findByCodigo(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Produtora c = null;
        String sql = "SELECT * FROM Produtora where codigo = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("Nome");
                String NumEmpregados = rs.getString("NumEmpregados");
                String QtMaquinas = rs.getString("QtMaquinas");
                String Nivel = rs.getString("Nivel");
                String Endereco = rs.getString("Endereco");
                String Produtos = rs.getString("Produtos");
                String Destino = rs.getString("Destino");
                String Producao = rs.getString("Producao");                
                c = new Produtora(codigo,NumEmpregados,QtMaquinas,Nivel,nome,Endereco,Produtos,Destino,Producao);
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return c;
    }

    @Override
    public Produtora findByUsuario(String user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Produtora c = null;
        String sql = "SELECT * FROM Produtora where Nome = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,user);
            rs = pst.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("Nome");
                String NumEmpregados = rs.getString("NumEmpregados");
                String QtMaquinas = rs.getString("QtMaquinas");
                String Nivel = rs.getString("Nivel");
                String Endereco = rs.getString("Endereco");
                String Produtos = rs.getString("Produtos");
                String Destino = rs.getString("Destino");
                String Producao = rs.getString("Producao");                
                c = new Produtora(codigo,NumEmpregados,QtMaquinas,Nivel,nome,Endereco,Produtos,Destino,Producao);
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return c;
    }

    

    @Override
    public void delete(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Produtora obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produtora> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

}
