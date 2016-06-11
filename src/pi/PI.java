/*
Integrantes:
Alessadra Vital
Sibele Nepomuceno dos Santos

2º Periodo
Tads
 */

/*
Este código foi desenvolvido para que pudesse ser utilizado por uma empresa de esmaltaria, afim
de facilitar o dia-a-dia da mesma, controlando seus agendamentos e relatorios de produtividade
*/

package pi;

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
import pi.dao.relatorioDao;
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
        System.out.println("");
        System.out.println(" 1 - Fluxo de atendimentos na unidade. ");
        System.out.println(" 2 - Fluxo de atendimentos por funcionario. ");
        System.out.println(" 3 - fluxo de atendimentos por clientes. ");
        System.out.println(" 4 - Funcionario e sua unidade. ");
        System.out.println(" 5 - Funcionario e sua agenda. ");
        System.out.println(" 6 - Relatório de agendamento diário. ");
        System.out.println(" 7 - Relatório de agendamentos em espera. ");
        System.out.println(" 8 - Relatório de agendamentos cancelados. ");
        System.out.println(" 9 - Relatório de agendamentos participantes da promoção. ");
        System.out.println(" 10 - Ranking das unidades. ");
        System.out.println(" 11 - Ranking dos funcionários. ");
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
        relatorioDao relat = new relatorioDao(conn);
        // importa as classes
        cliente clie = new cliente();
        agendamento agendar = new agendamento();
        unidade unidade1 = new unidade();
        funcionario func = new funcionario();
        servico serv = new servico();
        status sta = new status();
        relatorioDao rel = new relatorioDao(conn);
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
                            agendar.setIdFuncionario(funcionario); //guarda na classe o valor (ID do funcionario)

                            //recebendo o nome do cliente
                            //informa o cliente
                            System.out.println(" Informe código do cliente");
                            System.out.println("  ");
                            System.out.println(" Código | Nome | CPF | RG | Telefone | Celular |");
                            System.out.println(" ");
                            cli.buscar(clie);
                            System.out.println(" ");

                            int idCliente = leitor.nextInt();

                            agendar.setIdCliente(idCliente);

                            System.out.println("  ");
                            System.out.println(" Digite o código do serviço que deseja ");
                            System.out.println("  ");
                            ser.buscar(serv);
                            int servico = leitor.nextInt();
                            agendar.setIdServico(servico); // inclui na classe o valor recebido na variavel
                            System.out.println("  ");

                            //insere a data
                            System.out.println(" Informe a data : ( Formato - aaaa/mm/dd )");
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

                            System.out.println(" Informe qual o código do agendamento que deseja editar ");// condição, precisa ver no banco qual chave primaria
                            System.out.println(" ");
                            System.out.println(" Código do cliente | Código da unidade | Código do serviço | Código do status | Código do agendamento | Hora Inicial | Hora Final | Fila de Espera | Promoção | Data do agendamento");
                            System.out.println(" ");
                            agend.buscar(agendar);
                            System.out.println(" ");

                            int idAgend = leitor.nextInt();
                            agendar.setCod(idAgend);
                            agendamento agendamentoEncontrado = agend.buscarEspecifica(idAgend);

                            System.out.println(" Escolha o código Status ");
                            status.buscar(sta);
                            int novoStatus = leitor.nextInt();//guardando em uma variavel
                            agendar.setIdStatus(novoStatus);
                            agend.atualizar(agendamentoEncontrado, novoStatus, idAgend);

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
                            //Relatorio que mostra quais foram os agendamentos realizados nas unidades
                            System.out.println("****Atendimentos realizados pelas unidades****");
                            System.out.println("");
                            System.out.println("Unidade | Nome | Codigo do agendamento | Codigo do status | Status");
                            System.out.println("");
                           rel.getRelatorio_Agendamento_realizado_unid();
                            
                            break;
                        
                        case 2:
                            //Relatorio que mostra quais foram os agendamentos realizados pelos profissionais
                            System.out.println("****Atendimentos realizados pelos profissionais****");
                            System.out.println("");
                            System.out.println("Código do funcionario | Nome | Agendamento | Status");
                            System.out.println("");
                            rel.getRelatorio_Agendamento_realizado_func();
                            break;
                        case 3:
                            //Relatorio que mostra os agendamentos realizados, e seus clientes
                            System.out.println("****Digite o código do cliente****");
                            int id_cliente1= leitor.nextInt();
                            System.out.println("");
                            System.out.println("Código do cliente | Nome | Frequencia | Status");
                            System.out.println("");
                            rel.setRelatorio_atendimento_cliente(id_cliente1);
                            break;
                        case 4:
                            //Neste é possivel verificar em qual unidade esta um funcionario. Em qual ele trabalha
                            System.out.println("****Digite o código de seu funcionario****");
                            int id_funcionario1=leitor.nextInt();
                            System.out.println("");
                            System.out.println("Funcionario | Nome | Unidade | Nome da Unidade");
                            System.out.println("");
                            rel.setRelatorio_funcio_suaUnid(id_funcionario1);
                            break;
                        case 5:
                            //Neste é possivel pesquisar a agenda de um funcionario, ou seja, os agendamentos que ele possui
                            System.out.println("****Digite o código de seu funcionario****");
                            int id_funcionario2=leitor.nextInt();
                            System.out.println("");
                            System.out.println("Codigo do funcionario | Funcionario | Agendamento | Data | Inicio | Final");
                            System.out.println("");
                            rel.setRelatorio_funcio_suaAgenda(id_funcionario2);
                            
                            break;
                        case 6:
                            //Apresenta a agenda para o dia atual,de uma unidade
                            System.out.println("*****Agendamentos de hoje*****");
                            System.out.println("Escolha sua unidade: ");
                            int unidade_hj=leitor.nextInt();
                            System.out.println("");
                            System.out.println("Unidade | Agendamento | Data | Codigo do cliente");
                            System.out.println("");
                            rel.setRelatorio_Agendamento_dia(unidade_hj);
                            break;
                            
                        case 7:
                            //Apresenta os agendamentos que participam da fila de espera
                            System.out.println("*****Em espera*****");
                            System.out.println("");
                            System.out.println("Espera| Codigo do agendamento ");
                            System.out.println("");
                            rel.getRelatorio_Agendamento_emEspera();
                            break;
                        case 8:
                            //Apresenta os agendamentos que foram cancelados
                            System.out.println("*****Cancelados*****");
                            System.out.println("");
                            System.out.println("Agendamento| Codigo do status | Status ");
                            System.out.println("");
                            rel.getRelatorio_Agendamento_cancelados();
                            break;
                        case 9:
                            //Apresenta a quantidade de atendimentos participantes da promoção, por unidade
                            System.out.println("**Quantidade de Participantes da promoção- por unidade**");
                            System.out.println("Digite o nome da unidade que você deseja verificar: ");   
                            String nome_unid=leitor.nextLine();
                            System.out.println("");
                            System.out.println("Quantidades de promoção | Nome da unidade | Numero ");
                            System.out.println("");
                            rel.setRelatorio_Agendamento_promocao(nome_unid);
                            break;
                        case 10:
                             //Responsavel por emitir o relatorio de ranking de atendimento das unidades
                            System.out.println("***Ranking das unidades***");
                            System.out.println("");
                            System.out.println("Codigo do Funcionario | Nome | Quantidade ");
                            System.out.println("");
                            rel.getRanking_Unidade();
                            break;
                        case 11:
                            //Responsavel por emitir o relatorio de ranking de atendimento dos funcionarios
                            System.out.println("***Ranking dos funcionarios***");
                            System.out.println("");
                            System.out.println("Numero da unidade | Nome | Quantidade | Status");
                            System.out.println("");
                            rel.getRanking_funcionario();
                            break;
                        }  
                    break;

                    

                case 3:

                    int op2 = submenu1(); //submenu para gerenciar cadastro -  escolhe qual cadastro gerenciar
                    switch (op2) {

                        case 1: //cliente
                            int opcaoCliente = submenu(); // editar, excluir ou visualizar - cliente
                            switch (opcaoCliente) {
                                case 1:
                                    System.out.println(" Informe o codigo do cliente deseja editar ");// condição, precisa ver no banco qual chave primaria
                                    System.out.println(" ");
                                    System.out.println(" Código | Nome | CPF | RG | Telefone | Celular |");
                                    System.out.println(" ");
                                    cli.buscar(clie);
                                    System.out.println(" ");

                                    int codCliente = leitor.nextInt();

                                    cliente clienteEncontrado = cli.buscarEspecifica(codCliente);

                                    System.out.println(" Qual campo você deseja editar ? ");

                                    System.out.println(" 1 - Nome ");
                                    System.out.println(" 2 - CPF ");
                                    System.out.println(" 3 - RG ");
                                    System.out.println(" 4 - Telefone ");
                                    System.out.println(" 5 - Celular ");
                                    int opEscolha = leitor.nextInt();

                                    switch (opEscolha) {
                                        case 1:
                                            System.out.println(" Digite novo nome ");
                                            String novoNome = leitor.next();//guardando em uma variavel
                                            clie.setNomeNovo(novoNome); // pasando para a classe cliente
                                            cli.atualizar(clienteEncontrado, novoNome, opEscolha);// chamando a classe Cliente DAO para atualizar o dado

                                            break;
                                        case 2:
                                            System.out.println(" Digite novo CPF ");
                                            String novoCpf = leitor.next();
                                            clie.setCpfNovo(novoCpf);
                                            cli.atualizar(clienteEncontrado, novoCpf, opEscolha);
                                            break;
                                        case 3:
                                            System.out.println(" Digite novo RG ");
                                            String novoRg = leitor.next();
                                            clie.setRgNovo(novoRg);
                                            cli.atualizar(clienteEncontrado, novoRg, opEscolha);
                                            break;
                                        case 4:
                                            System.out.println(" Digite novo telefone ");
                                            String novoTel = leitor.next();
                                            clie.setTelefoneNovo(novoTel);
                                            cli.atualizar(clienteEncontrado, novoTel, opEscolha);
                                            break;
                                        case 5:
                                            System.out.println(" Digite novo Celular ");
                                            String novoCel = leitor.next();
                                            clie.setCelularNovo(novoCel);
                                            cli.atualizar(clienteEncontrado, novoCel, opEscolha);
                                            break;
                                        default:
                                            System.out.println(" Código invalido!! ");

                                    }

                                   
                                    break;
                                case 2:
                                    System.out.println(" Informe qual codigo do cliente deseja excluir ");

                                    System.out.println(" ");
                                    System.out.println(" Código | Nome | CPF | RG | Telefone | Celular |");
                                    System.out.println(" ");
                                    cli.buscar(clie);
                                    System.out.println(" ");

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
                                    System.out.println(" ");
                                    System.out.println(" Id Funcionario | id unidade | Nome do Funcionario | CPF | RG | Cargo |");
                                    System.out.println(" ");
                                    fun.buscar(func);
                                    System.out.println(" ");

                                    int idFun = leitor.nextInt();
                                    func.setIdFuncionario(idFun);
                                    funcionario funcionarioEncontrado = fun.buscarEspecifica(idFun);

                                    System.out.println(" Qual campo você deseja editar ? ");

                                    System.out.println(" 1 - Nome ");
                                    System.out.println(" 2 - CPF ");
                                    System.out.println(" 3 - RG ");
                                    System.out.println(" 4 - Cargo ");

                                    int oEscolha = leitor.nextInt();

                                    switch (oEscolha) {
                                        case 1:
                                            System.out.println(" Digite novo nome ");
                                            String novoNome = leitor.next();//guardando em uma variavel
                                            func.setNomeNovo(novoNome); // pasando para a classe funciomario
                                            fun.atualizar(funcionarioEncontrado, novoNome, oEscolha, idFun);// chamando a classe funcionario DAO para atualizar o dado

                                            break;
                                        case 2:
                                            System.out.println(" Digite novo CPF ");
                                            String novoCpf = leitor.next();
                                            func.setCpfNovo(novoCpf);
                                            fun.atualizar(funcionarioEncontrado, novoCpf, oEscolha, idFun);
                                            break;
                                        case 3:
                                            System.out.println(" Digite novo RG ");
                                            String novoRg = leitor.next();
                                            func.setRgNovo(novoRg);
                                            fun.atualizar(funcionarioEncontrado, novoRg, oEscolha, idFun);
                                            break;
                                        case 4:
                                            System.out.println(" Digite novo cargo ");
                                            String novoTel = leitor.next();
                                            func.setTelefoneNovo(novoTel);
                                            fun.atualizar(funcionarioEncontrado, novoTel, oEscolha, idFun);
                                            break;

                                        default:
                                            System.out.println(" Código invalido!! ");
                                    }
                                    break;
                                case 2:
                                    System.out.println(" Informe qual o código do funcionário que deseja excluir ");// condição, precisa ver no banco qual chave primaria
                                    System.out.println(" ");
                                    System.out.println(" Código do Funcionário | Código da Unidade | Nome do Funcionario | CPF | RG | Cargo |");
                                    System.out.println(" ");
                                    fun.buscar(func);
                                    System.out.println(" ");

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

        } while (op != 0);

    }

}
