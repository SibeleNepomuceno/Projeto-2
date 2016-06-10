/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Alessandra
 */
/**
 *
 * @author Alessandra
 */
public class agendamento {

    private int idCliente;
    private String nomeCliente;
    private int idFuncionario;
    private int idServico;
    private int idStatus;
    private int idUnidade;
    private int idAgendamento;
    private String horaFinal;
    private String horaInicial;
    private boolean filaEspera, promocao;
    private String dataAgendamento;
    private int unidade;
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public void setFilaEspera(boolean filaEspera) {
        this.filaEspera = filaEspera;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public int getUnidade() {
        return unidade;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public int getIdServico() {
        return idServico;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public String getHoraInicial() {
        return horaInicial;
    }


    public boolean isFilaEspera() {
        return filaEspera;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }
    
        public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    

}
