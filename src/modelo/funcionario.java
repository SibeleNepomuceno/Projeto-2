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
    
    private String nomeNovo, cpfNovo, rgNovo, telefoneNovo, celularNovo;

    public String getNomeNovo() {
        return nomeNovo;
    }

    public String getCpfNovo() {
        return cpfNovo;
    }

    public String getRgNovo() {
        return rgNovo;
    }

    public String getTelefoneNovo() {
        return telefoneNovo;
    }

    public String getCelularNovo() {
        return celularNovo;
    }

    public void setNomeNovo(String nomeNovo) {
        this.nomeNovo = nomeNovo;
    }

    public void setCpfNovo(String cpfNovo) {
        this.cpfNovo = cpfNovo;
    }

    public void setRgNovo(String rgNovo) {
        this.rgNovo = rgNovo;
    }

    public void setTelefoneNovo(String telefoneNovo) {
        this.telefoneNovo = telefoneNovo;
    }

    public void setCelularNovo(String celularNovo) {
        this.celularNovo = celularNovo;
    }

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
