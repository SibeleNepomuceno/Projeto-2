/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;
import java.util.ArrayList;
/**
 *
 * @author Alessandra
 */
public interface DaoGenerica <ObjetoGenerico>{
  //essa interface obriga todas as classes a ter as funções de inserir, alterar, excluir e consultar
    public void inserir(ObjetoGenerico objt);
    public void alterar(ObjetoGenerico objt);
    public void excluir ();
    public ArrayList <ObjetoGenerico> consultar();
}
