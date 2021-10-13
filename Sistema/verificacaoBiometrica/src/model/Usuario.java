/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.UsuarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Hype
 */
public class Usuario {
    
    private String nome, usuario,senha = null;
    private int nivel,id = 0;
    
    public int setId(int id){
        return this.id;
    }
    
    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Usuario(String nome, String usuario, String senha, int nivel) {
        setNome(nome);
        setUsuario(usuario);
        setSenha(senha);
        setNivel(nivel);
        gravar();
    }
    
    public Usuario(int id,String nome, String usuario, String senha, int nivel) {
        setId(id);
        setNome(nome);
        setUsuario(usuario);
        setSenha(senha);
        setNivel(nivel);
        gravar();
    }
    
    public Usuario(){}

    @Override
    public String toString() {
        return ("Nome.....:" + getNome() + "\n" +
                "Usuario..:" + getUsuario() + "\n" +
                "Senha....:" + getSenha() + "\n" + 
                "Nivel....:" + getNivel());
    }
    
    
    private void gravar(){
        UsuarioDAO dao = new UsuarioDAO();
        int id = dao.create(this);
        if(id > 0) setId(id);
    }
    
    public static DefaultTableModel getTableModel(){
        List<Usuario> lista = UsuarioDAO.getInstance().read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nome");
        modelo.addColumn("usuario");
        modelo.addColumn("senha");
        modelo.addColumn("nivel");
        for (Usuario c: lista){
            String[] reg = {String.valueOf(c.getId()),c.getNome(),c.getUsuario(),c.getSenha(),String.valueOf(c.getNivel())};
            modelo.addRow(reg);
        }
        return modelo;
    }
    
    
    
    
    

}
