/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;
import modelo.agendamento;
import pi.dao.Conexao;
import pi.dao.clienteDao;
import modelo.cliente;
import modelo.funcionario;
import modelo.servico;
import modelo.status;
import modelo.unidade;
import pi.dao.agendamentoDao;
import pi.dao.funcionarioDao;
import pi.dao.servicoDao;
import pi.dao.statusDao;
import pi.dao.unidadeDao;

/**
 *
 * @author Alessandra
 */
public class PI {

    static int menu() {
        Scanner leitor = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" >>>>>>>> Agendamento Eletrônico <<<<<<<<");
        System.out.println("");
        System.out.println(" ++++++  Esmalteria - Com que Cor? ++++++");
        System.out.println(" ");
        System.out.println(" 1 - Agendar "); // verificar agendas ou efetuar agendamentos
        System.out.println(" 2 - Relatorios"); // 
        System.out.println(" 3 - Cadastro "); // editar, excluir, visualizar
        System.out.println(" 0 - Sair ");
        System.out.println(" ");
        int op = leitor.nextInt();

        return op;
    }
// menu para editar, excluir e visualizar o cadastro

    static int submenu() {

        Scanner leitor = new Scanner(System.in);
        System.out.println(" Escolha a opção ");
        System.out.println(" 1 - Editar ");
        System.out.println(" 2 - Excluir ");
        System.out.println(" 3 - Visualizar ");

        int op3 = leitor.nextInt();

        return op3;
    }
// menu que vai diferenciar em qual cadastro a pessoa vai gerenciar, se é cliente ou funcionario

    static int submenu1() {
        Scanner leitor = new Scanner(System.in);

        System.out.println(" Escolha a opção que deseja gerenciar ");
        System.out.println(" 1 - Cliente ");
        System.out.println(" 2 - Funcionário ");
        int op2 = leitor.nextInt();

        return op2;
    }

    static int relatorios() {
        Scanner leitor = new Scanner(System.in);

        System.out.println(" Informe qual relatório deseja consultar ");
        System.out.println(" 1 - fluxo de atendimentos na unidade. ");
        System.out.println(" 2 - fluxo de atendimentos por funcionário");
        System.out.println(" 3 - fluxo de serviço prestado ");
        System.out.println(" 4 - total de clientes que participaram da promoção ");
        System.out.println(" 5 - total de frequencia de cada cliente ");

        int opRelatorio = leitor.nextInt();

        return opRelatorio;
    }

    static int cadastro() {
        Scanner leitor = new Scanner(System.in);
        System.out.println(" 1 - Realizar Agendamento ");
        System.out.println(" 2 - Alterar Agendamento ");
        System.out.println(" 3 - Visualizar Agendamento ");
        int opCadastro = leitor.nextInt();

        return opCadastro;
    }

    public static void main(String[] args) throws SQLException {
        Scanner leitor = new Scanner(System.in);
        //leitor.nextLine();

        // conectar com o banco de dados
        Connection conn = Conexao.conectar();

        // importar as classes de conexão com banco de dados
        clienteDao cli = new clienteDao(conn);
        agendamentoDao agend = new agendamentoDao(conn);
        unidadeDao uni = new unidadeDao(conn);
        funcionarioDao fun = new funcionarioDao(conn);
        servicoDao ser = new servicoDao(conn);
        statusDao status = new statusDao(conn);

        // importa as classes
        cliente clie = new cliente();
        agendamento agendar = new agendamento();
        unidade unidade1 = new unidade();
        funcionario func = new funcionario();
        servico serv = new servico();
        status sta = new status();

        int op; //menu principal
        do {
            op = menu();
            switch (op) {

                case 1:
                    int opCadastro = cadastro();
                    switch (opCadastro) {

                        case 1: // efetuar o agendamento
                            //encontrar as unidades no banco de dados
                            System.out.println(" Informe qual unidade deseja realizar o serviço ");
                            System.out.println(" ");
                            uni.buscar(unidade1);
                            int unidade = leitor.nextInt();
                            agendar.setIdUnidade(unidade);
                            // agend.insere(agendar); //insere no banco - agendamento

                            // escolher funcionario
                            System.out.println(" Digite o código da Funcionário(a):");
                            System.out.println("  ");
                            fun.pesquisarPorID(unidade); //irá chamar a profissional da unidade digitada anteriormente
                            int funcionario = leitor.nextInt();
                            agendar.getIdFuncionario(); //guarda na classe o valor (ID do funcionario)

                            //recebendo o nome do cliente
                            //informa o cliente
                            System.out.println(" Informe o cliente");
                            System.out.println("  ");
                            System.out.println(" 1 - Por nome - caso não possua cadastro "); //por nome caso o cliente não esteja cadastrado
                            System.out.println(" 2 - Por código "); //codigo do cadastro

                            int escolha = leitor.nextInt();

                            if (escolha == 1) { //se a opcao for 1, nome será guardado na variavel de nome da classe agendamento
                                System.out.println(" Digite o nome: ");
                                String nomeCliente = leitor.next();
                                agendar.setNomeCliente(nomeCliente);

                            } else if (escolha == 2) {
                                System.out.println(" Digite o código: ");
                                int idCliente = leitor.nextInt();
                                agendar.setIdCliente(idCliente);
                            }
                            System.out.println("  ");
                            System.out.println(" Digite o código do serviço que deseja ");
                            System.out.println("  ");
                            ser.buscar(serv);
                            int servico = leitor.nextInt();
                            agendar.setIdServico(servico); // inclui na classe o valor recebido na variavel
                            System.out.println("  ");

                            //insere a data
                            System.out.println(" Informe a data ");
                            System.out.println("  ");
                            String data = leitor.next();
                            agendar.setDataAgendamento(data);//insere a data na classe agendamento

                            System.out.println("  ");
                            System.out.println(" Informe o horário inicial - cada serviço terá 30 minutos para realização ");
                            System.out.println("  ");
                            String horaInicial = leitor.next();
                            agendar.setHoraInicial(horaInicial);

                            System.out.println("  ");
                            System.out.println(" Informe o horário final - cada serviço terá 30 minutos para realização ");
                            System.out.println("  ");
                            String horaFinal = leitor.next();
                            agendar.setHoraFinal(horaFinal);

                            //verificação se a cliente esta participando da promoção
                            System.out.println(" ");
                            System.out.println(" Digite a opção : ");
                            System.out.println(" Participa da Promoção ? ");
                            System.out.println("  ");
                            System.out.println(" 1 - Sim ");
                            System.out.println(" 2 - Não ");
                            int opPromocao = leitor.nextInt();

                            //compara se participa da promocao ou não
                            if (opPromocao == 1) {
                                boolean promocao = true;

                                //guarda na classe a resposta
                                agendar.setPromocao(promocao);
                            } else {
                                boolean promocao = false;

                                //guarda na classe a resposta
                                agendar.setPromocao(promocao);
                            }

                            System.out.println(" Valor ");
                            System.out.println("  ");
                            Double val = leitor.nextDouble();
                            agendar.setValor(val);

                            //informa o status do agendamento
                            System.out.println(" ");
                            System.out.println(" Digite o código do Status ");
                            System.out.println("  ");
                            status.buscar(sta);
                            int idStatus = leitor.nextInt();
                            agendar.setIdStatus(idStatus);

                            //fila de espera
                            System.out.println(" Participa da Fila de Espera?");
                            System.out.println("  ");
                            System.out.println(" 1 - Sim ");
                            System.out.println(" 2 - Não ");
                            int opFila = leitor.nextInt();

                            //compara se participa da promocao ou não
                            if (opFila == 1) {
                                boolean fila = true;

                                //guarda na classe a resposta
                                agendar.setFilaEspera(fila);
                            } else {
                                boolean fila = false;

                                //guarda na classe a resposta
                                agendar.setFilaEspera(fila);
                            }

                            System.out.println(" Agendamento Realizado !!! ");

                            agend.insere(agendar); //insere as informações na tabela agendamento do banco de dados

                            break;
                        case 2:
                            break;

                        case 3:

                            System.out.println(" ");
                            System.out.println(" Código do cliente | Código da unidade | Código do serviço | Código do status | Código do agendamento | Hora Inicial | Hora Final | Fila de Espera | Promoção | Data do agendamento");
                            System.out.println(" ");
                            agend.buscar(agendar);
                            System.out.println(" ");

                            break;
                    }
                    break;
                case 2:
                    int opRelatorio = relatorios();

                    switch (opRelatorio) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                    }
                    break;

                case 3:

                    int op2 = submenu1(); //submenu para gerenciar cadastro -  escolhe qual cadastro gerenciar
                    switch (op2) {

                        case 1: //cliente
                            int opcaoCliente = submenu(); // editar, excluir ou visualizar - cliente
                            switch (opcaoCliente) {
                                case 1:
                                    System.out.println(" Informe qual cliente deseja editar ");// condição, precisa ver no banco qual chave primaria

                                    cli.atualizar(clie);
                                    break;
                                case 2:
                                    System.out.println(" Informe qual codigo do cliente deseja excluir ");
                                    //comparar se possui nome para excluir ******
                                    int idApagar = leitor.nextInt();
                                    cli.apagar(idApagar);
                                    System.out.println(" Cadastro apagado com sucesso !! ");
                                    break;
                                case 3:
                                    System.out.println(" ");
                                    System.out.println(" Código | Nome | CPF | RG | Telefone | Celular |");
                                    System.out.println(" ");
                                    cli.buscar(clie);
                                    System.out.println(" ");

                                    break;

                            }
                            break;

                        case 2: //funcionario
                            int opcaoFuncionario = submenu();// editar, excluir ou visualizar - Funcionario

                            switch (opcaoFuncionario) {
                                case 1:
                                    System.out.println(" Informe qual o código do funcionário que deseja editar ");// condição, precisa ver no banco qual chave primaria

                                    break;
                                case 2:
                                    System.out.println(" Informe qual o código do funcionário que deseja excluir ");// condição, precisa ver no banco qual chave primaria
                                    int idApagar = leitor.nextInt();
                                    fun.apagar(idApagar); //passa o id para a funcao apagar da classe funcionario que faz conexão com DB
                                    System.out.println(" Cadastro apagado com sucesso !! ");
                                    break;
                                case 3:
                                    System.out.println(" ");
                                    System.out.println(" Código do Funcionário | Código da Unidade | Nome do Funcionario | CPF | RG | Cargo |");
                                    System.out.println(" ");
                                    fun.buscar(func);
                                    System.out.println(" ");
                                    break;
                            }
                    }
                    break;

                default:
                    System.out.println(
                            " Opção invalida !!! ");
            }

            /*System.out.println(" Nome: ");
        String nome = leitor.nextLine();
        System.out.println(" CPF: ");
        String cpf = leitor.nextLine();
        System.out.println(" RG: ");
        String rg = leitor.nextLine();
        System.out.println(" Telefone: ");
        String tel = leitor.nextLine();
        System.out.println(" Celular: ");
        String cel = leitor.nextLine();

        clie.setNome(nome);
        clie.setRg(rg);
        clie.setCpf(cpf);
        clie.setCelular(cel);
        clie.setTelefone(tel);

        cli.insere(clie);*/
        } while (op != 0);

    }
}
