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
public class InformacoesFiscais extends Produtora{
    
    private String incentivosFiscais,impostosMunicipais,impostosEstaduais,impostosFederais,taxasFederais;
    private int cdProdutora;

    public String getIncentivosFiscais() {
        return incentivosFiscais;
    }

    public void setIncentivosFiscais(String incentivosFiscais) {
        this.incentivosFiscais = incentivosFiscais;
    }

    public String getImpostosMunicipais() {
        return impostosMunicipais;
    }

    public void setImpostosMunicipais(String impostosMunicipais) {
        this.impostosMunicipais = impostosMunicipais;
    }

    public String getImpostosEstaduais() {
        return impostosEstaduais;
    }

    public void setImpostosEstaduais(String impostosEstaduais) {
        this.impostosEstaduais = impostosEstaduais;
    }

    public String getImpostosFederais() {
        return impostosFederais;
    }

    public void setImpostosFederais(String impostosFederais) {
        this.impostosFederais = impostosFederais;
    }

    public String getTaxasFederais() {
        return taxasFederais;
    }

    public void setTaxasFederais(String taxasFederais) {
        this.taxasFederais = taxasFederais;
    }

    public int getCdProdutora() {
        return new Produtora().getCodigo();
    }

    public InformacoesFiscais(String incentivosFiscais, String impostosMunicipais, String impostosEstaduais, String impostosFederais, String taxasFederais) {
        setIncentivosFiscais(incentivosFiscais);
        setImpostosMunicipais(impostosMunicipais);
        setImpostosEstaduais(impostosEstaduais);
        setImpostosFederais(impostosFederais);
        setTaxasFederais(taxasFederais);
        
    }

    public InformacoesFiscais(String incentivosFiscais, String impostosMunicipais, String impostosEstaduais, String impostosFederais, String taxasFederais,int codigo, String NumEmpregados, String QtMaquinas, String Nivel, String nome, String endereco, String produtos, String destino, String producao) {
        super(codigo, NumEmpregados, QtMaquinas, Nivel, nome, endereco, produtos, destino, producao);
        setIncentivosFiscais(incentivosFiscais);
        setImpostosMunicipais(impostosMunicipais);
        setImpostosEstaduais(impostosEstaduais);
        setImpostosFederais(impostosFederais);
        setTaxasFederais(taxasFederais);
    }
    
    public InformacoesFiscais(){}
    
    @Override
    public String toString(){
        return  "Incentivos fiscais recebidos.:" + getIncentivosFiscais() +
                "Impostos municipais pagos....:" + getImpostosMunicipais() +
                "Impostos estaduais recolhidos:" + getImpostosEstaduais() +
                "Impostos federais pagos......:" + getImpostosFederais() +
                "Taxas federais pagas.........:" + getTaxasFederais();
    }
}
