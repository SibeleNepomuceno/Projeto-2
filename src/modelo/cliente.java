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

    private String nome, cpf, rg, telefone, celular;
    private int idCliente;

    private String nomeNovo, cpfNovo, rgNovo, telefoneNovo, celularNovo;

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public int getIdCliente() {
        return idCliente;
    }

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
