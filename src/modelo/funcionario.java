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
public class funcionario {
    private int idFuncionario;
    private int idUnidade;
    private String nomeFuncionario;
    private String cpf;
    private String rg;
    private String cargo;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getCargo() {
        return cargo;
    }
    
}
