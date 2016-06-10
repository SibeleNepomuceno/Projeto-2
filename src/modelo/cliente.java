/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alessandra
 */
public class cliente {
    
    private String nome,cpf,rg,telefone, celular;
  private int idCliente;
    
        public cliente() {
    }
    
    public cliente(String nome, String cpf, String rg, String telefone, String celular) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.celular = celular;
      
    }
    
        public cliente(int Idcliente,String nome, String cpf, String rg, String telefone, String celular) {
        this.idCliente = Idcliente;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.celular = celular;
      
    }
    
   

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }
    
   public int getIdcliente() {
        return idCliente;
    }
    
    public void setIdcliente(int idcliente) {
        this.idCliente = idcliente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
