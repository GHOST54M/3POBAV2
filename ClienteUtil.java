import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class ClienteUtil {
  // CRIAÇÃO DAS FUNÇÕES

  private static final String FORMATO_CPF = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
  private static final String FORMATO_DATA_NASCIMENTO = "\\d{2}/\\d{2}/\\d{4}";

  // Função para inserir dados Cliente
  public static void inserirDadosCliente(ArrayList<Cliente> clientes, String nome, String endereco, String cep,
      String pais,
      String cpf, String passaporte, String email, String dataNascimento) {

    if (!validarCPF(cpf) || !validarDataNascimento(dataNascimento)) {
      System.out.println("Formato inválido para CPF ou data de nascimento. Tente novamente.");
      return;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try {

      Date dataNasc = sdf.parse(dataNascimento);
      int indice = encontrarIndiceVazio(clientes);

      if (indice != -1) {
        Cliente novoCliente = new Cliente(indice + 1, nome, endereco, cep, pais, cpf, passaporte, email, dataNasc);
        clientes.add(novoCliente);
        System.out.println("Cliente adicionado!");
      } else {
        System.out.println("A lista de Clientes está cheia. Não é possível adicionar mais clientes.");
      }
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  // Função para encontrar o primeiro índice vazio1
  private static int encontrarIndiceVazio(ArrayList<Cliente> clientes) {
    return clientes.size();
  }

  // Função para editar os dados de um cliente com base no ID
  private static void editarDadosCliente(ArrayList<Cliente> clientes, int id, String novoNome, String novoEndereco,
      String novoCep, String novoPais, String novoCpf, String novoPassaporte, String novoEmail,
      String novaDataNascimento) {

    if (!validarCPF(novoCpf) || !validarDataNascimento(novaDataNascimento)) {
      System.out.println("Formato inválido para CPF ou data de nascimento. Tente novamente.");
      return;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {

      Date novaDataNasc = sdf.parse(novaDataNascimento);

      for (Cliente cliente : clientes) {
        if (cliente != null && cliente.getId() == id) {
          cliente.setNome(novoNome);
          cliente.setEndereco(novoEndereco);
          cliente.setCep(novoCep);
          cliente.setPais(novoPais);
          cliente.setCpf(novoCpf);
          cliente.setPassaporte(novoPassaporte);
          cliente.setEmail(novoEmail);
          cliente.setDataNascimento(novaDataNasc);
          System.out.println("Dados do Cliente " + id + " foram editados com sucesso.");
          return;
        }
      }

    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  // Função para excluir um cliente com base no ID
  public static void excluirCliente(ArrayList<Cliente> clientes, int id) {

    Iterator<Cliente> iterator = clientes.iterator();
    while (iterator.hasNext()) {
      Cliente cliente = iterator.next();
      if (cliente.getId() == id) {
        iterator.remove();
        System.out.println("Cliente " + id + " foi excluído com sucesso.");
        break;
      }
    }

  }

  // Função para listar todos os clientes
  public static void exibirTodosClientes(ArrayList<Cliente> clientes) {
    System.out.println("Lista de Clientes:");
    for (Cliente cliente : clientes) {
      if (cliente != null) {
        System.out.println(cliente.toString());
      }
    }
  }

  // Função para enviar os dados para a função inserir
  public static void inserirDadosClienteViaTeclado(ArrayList<Cliente> clientes, Scanner scanner) {
    scanner.nextLine();

    System.out.println("Nome: ");
    String nome = scanner.nextLine();

    System.out.println("Endereço: ");
    String endereco = scanner.nextLine();

    System.out.println("CEP: ");
    String cep = scanner.nextLine();

    System.out.println("País: ");
    String pais = scanner.nextLine();

    System.out.println("CPF (XXX.XXX.XXX-XX): ");
    String cpf = scanner.nextLine();

    System.out.println("Passaporte: ");
    String passaporte = scanner.nextLine();

    System.out.println("E-mail: ");
    String email = scanner.nextLine();

    System.out.println("Data de Nascimento (DD/MM/YYYY): ");
    String dataNascimento = scanner.nextLine();

    inserirDadosCliente(clientes, nome, endereco, cep, pais, cpf, passaporte, email, dataNascimento);
  }

  // Função para enviar os dados para a função editar
  public static void editarDadosClienteViaTeclado(ArrayList<Cliente> clientes, int id, Scanner scanner) {
    scanner.nextLine();
    for (Cliente cliente : clientes) {

      if (cliente != null && cliente.getId() == id) {
        System.out.println("Nome: ");

        String novoNome = scanner.nextLine();
        System.out.println("Endereço: ");

        String novoEndereco = scanner.nextLine();
        System.out.println("CEP: ");

        String novoCep = scanner.nextLine();
        System.out.println("País: ");

        String novoPais = scanner.nextLine();
        System.out.println("CPF: ");

        String novoCpf = scanner.nextLine();
        System.out.println("Passaporte: ");

        String novoPassaporte = scanner.nextLine();

        System.out.println("E-mail: ");
        String novoEmail = scanner.nextLine();

        System.out.println("Data de Nascimento (dd/MM/yyyy): ");
        String novaDataNascimento = scanner.nextLine();

        editarDadosCliente(clientes, id, novoNome, novoEndereco, novoCep, novoPais, novoCpf, novoPassaporte, novoEmail,
            novaDataNascimento);
      } else {
        System.out.println("Cliente não encontrado com ID " + id + ". Nenhum dado foi editado.");
      }
    }
  }

  // Função para validar o formato do CPF
  private static boolean validarCPF(String cpf) {
    return cpf.matches(FORMATO_CPF);
  }

  // Função para validar o formato da data de nascimento
  private static boolean validarDataNascimento(String dataNascimento) {
    return dataNascimento.matches(FORMATO_DATA_NASCIMENTO);
  }
}