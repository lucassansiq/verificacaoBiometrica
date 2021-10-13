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
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Lucas Hype
 */
public class UsuarioDAO implements dao.Persistencia<Usuario> {
    
    
    private static UsuarioDAO dao = null ;
    
    public UsuarioDAO(){
        
    }
    
    public static UsuarioDAO getInstance(){
        if(dao == null) dao = new UsuarioDAO();
        
        return dao;
    }
    
    
    @Override
    public int create(Usuario c) {
        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Usuario(nome,usuario,senha,nivel) VALUES"
                + "(?,?,?,?)";
        try{
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getUsuario());
            pst.setString(3, c.getSenha());
            pst.setInt(4, c.getNivel());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if (rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException ex){
            id = 0;
        }finally{
            ConnectionFactory.closeConnection(con,pst,rs);
        }
        
        return id;
    }

    @Override
    public Usuario findByCodigo(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario c = null;
        String sql = "SELECT * FROM Usuario where id = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("id");
                String nome = rs.getString("nome");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                int nivel = rs.getInt("nivel");
                c = new Usuario(codigo,nome,usuario,senha,nivel);
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return c;
    }
    
    
    //Me'todo para fazer busca pelo usuario , passando o usuario como parametro
    @Override
    public Usuario findByUsuario(String user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario c = null;
        String sql = "SELECT * FROM Usuario where usuario = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,user);
            rs = pst.executeQuery();
            while (rs.next()){
                String nome = rs.getString("nome");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                int nivel = rs.getInt("nivel");
                c = new Usuario(nome,usuario,senha,nivel);
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return c;
    }
    
    //O mesmo para o delete, fiz passando pelo usuario
    @Override
    public void delete(String user) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "DELETE from usuario where usuario = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,user);
            pst.execute();
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Delete");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
    }

    @Override
    public void update(Usuario c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "UPDATE usuario set nome=?,senha=?,nivel=? where usuario=?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome());
            pst.setString(2, c.getSenha());
            pst.setInt(3, c.getNivel());
            pst.setString(4,c.getUsuario());
            pst.execute();
        }catch(SQLException ex){
            throw new RuntimeException("Erro no update");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
    } 

    @Override
    public List<Usuario> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario c = null;
        String sql = "SELECT * FROM usuario ORDER BY Nome";
        List<Usuario> lista = new ArrayList<Usuario>();
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                int nivel = rs.getInt("nivel");
                lista.add(new Usuario(id,nome,usuario,senha,nivel));
            }
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro no Select");
        }finally{
            ConnectionFactory.closeConnection(con, pst, rs);
        }
        return lista;
    }
    


}
