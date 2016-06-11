
package modelo;

public class servico {

    private int id_Servico;
    private String descricao_ser;
    private double valor;

    public int getId_Servico() {
        return id_Servico;
    }

    public String getDescricao_desc() {
        return descricao_ser;
    }

    public double getValor() {
        return valor;
    }

    public void setId_Servico(int id_Servico) {
        this.id_Servico = id_Servico;
    }

    public void setDescricao_desc(String descricao_ser) {
        this.descricao_ser = descricao_ser;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
