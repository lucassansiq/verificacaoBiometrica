/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Lucas Hype
 */
public class Agrotoxicos extends InformacoesFiscais{
    
    private String agrotoxicos;
    private int cdProdutora;
    
    public void setAgrotoxicos(String agrotoxicos){
        this.agrotoxicos = agrotoxicos;
    }
    
    public String getAgrotoxicos(){
        return agrotoxicos;
    }
    
    public int getCdProdutora(){
        return new Produtora().getCodigo();
    }

    public Agrotoxicos(String agrotoxicos, String incentivosFiscais, String impostosMunicipais, String impostosEstaduais, String impostosFederais, String taxasFederais, int codigo, String NumEmpregados, String QtMaquinas, String Nivel, String nome, String endereco, String produtos, String destino, String producao) {
        super(incentivosFiscais, impostosMunicipais, impostosEstaduais, impostosFederais, taxasFederais, codigo, NumEmpregados, QtMaquinas, Nivel, nome, endereco, produtos, destino, producao);
        setAgrotoxicos(agrotoxicos);
    }

    public Agrotoxicos(String agrotoxicos) {
        setAgrotoxicos(agrotoxicos);
    }
    
    

}
