import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class ReservaUtil {
  private static final String FORMATO_DATA = "\\d{2}/\\d{2}/\\d{4}";

  // Função para adicionar reserva ao ArrayList
  private static void adicionarReserva(ArrayList<Reserva> reservas, int idQuarto, int idCama,
      int idCliente, Date dataEntrada, Date dataSaida) {

      int indice = encontrarIndiceVazio(reservas);

      Reserva reserva = new Reserva(indice + 1, idQuarto, idCama, idCliente, dataEntrada, dataSaida);
      reservas.add(reserva);
      System.out.println("Reserva cadastrada!");
    }

  // Função para editar os dados de um cliente com base no ID
  private static void editarReserva(ArrayList<Reserva> reservas, int id, int novoIdCama, int novoIdQuarto,
      int novoIdCliente,
      Date novaDataEntrada, Date novaDataSaida) {
    
      for (Reserva reserva : reservas) {
        if (reserva != null && reserva.getId() == id) {
          reserva.setIdQuarto(novoIdQuarto);
          reserva.setIdCama(novoIdCama);
          reserva.setIdCliente(novoIdCliente);
          reserva.setDataEntrada(novaDataEntrada);
          reserva.setDataSaida(novaDataSaida);
          System.out.println("Reserva com ID " + id + " editada com sucesso.");
          return;
        } }}

  // Função para encontrar o primeiro índice vazio
  private static int encontrarIndiceVazio(ArrayList<Reserva> reservas) {
    return reservas.size();
  }

  // Função para remover reserva com base no ID
  public static void excluirReserva(ArrayList<Reserva> reservas, int id) {

    for (int i = 0; i < reservas.size(); i++) {
      if (reservas.get(i).getId() == id) {
        reservas.remove(i);
        System.out.println("Reserva com ID " + id + " removida com sucesso.");
        return;
      }
    }
  }

  // Função para listar todas as reservas
  public static void listarReserva(ArrayList<Reserva> reservas) {
    System.out.println("Lista de Reservas:");
    for (Reserva reserva : reservas) {
      if (reserva != null) {
        System.out.println(reserva.toString());
      }
    }
  }

  // Função para enviar os dados para a função inserir
  public static void inserirDadosReservaViaTeclado(ArrayList<Reserva> reservas, Scanner scanner) {
    scanner.nextLine();

    System.out.println("Digite o ID do quarto: ");
    int quartoID = scanner.nextInt();

    System.out.println("Digite o ID da cama: ");
    int camID = scanner.nextInt();

    System.out.println("Digite o ID do cliente: ");
    int clienteID = scanner.nextInt();

    System.out.println("Data de entrada (dd/MM/yyyy): ");
    String dataEntradaStr = scanner.next();
    Date dataEntrada = parseDate(dataEntradaStr);

    System.out.println("Data de saída (dd/MM/yyyy): ");
    String dataSaidaStr = scanner.next();
      Date dataSaida = parseDate(dataSaidaStr);

    adicionarReserva(reservas, quartoID, camID, clienteID, dataEntrada, dataSaida);
  }

  // Função para enviar os dados para a função editar
  public static void editarDadosReservaViaTeclado(ArrayList<Reserva> reservas, int id, Scanner scanner) {
    scanner.nextLine();

    for (Reserva reserva : reservas) {

      if (reserva != null && reserva.getId() == id) {

        System.out.println("Digite o novo ID Cama: ");
        int novoIdCama = scanner.nextInt();

        System.out.println("Digite o novo ID Quarto: ");
        int novoIdQuarto = scanner.nextInt();

        System.out.println("Digite o novo ID Cliente: ");
        int novoIdCliente = scanner.nextInt();

        System.out.print("Digite a nova data de entrada (no formato dd/MM/yyyy): ");
        String novaDataEntradaStr = scanner.next();
        Date novaDataEntrada = parseDate(novaDataEntradaStr);

        System.out.print("Digite a nova data de saída (no formato dd/MM/yyyy): ");
        String novaDataSaidaStr = scanner.next();
        Date novaDataSaida = parseDate(novaDataSaidaStr);

        editarReserva(reservas, id, novoIdCama, novoIdQuarto, novoIdCliente, novaDataEntrada, novaDataSaida);

      } else {
        System.out.println("Reserva não encontrada com ID " + id + ". Ou a lista está vazia.");
        return;
      }
    }
  } 

  private static Date parseDate(String dateStr) {
      try {
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          return sdf.parse(dateStr);
      } catch (ParseException e) {
          System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
          return null;
      }
  }
}