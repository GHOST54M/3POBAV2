import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Quarto> quartos = new ArrayList<>();
    ArrayList<Cama> listaCamas = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    boolean continuar = true;
    System.out.println("\nEscolha uma operação:\n");
    System.out.println("X. \n-------  OPERAÇÕES CLIENTE  -------\n");
    System.out.println("1. Inserir Cliente");
    System.out.println("2. Exibir todos os Clientes");
    System.out.println("3. Editar Cliente");
    System.out.println("4. Excluir Cliente");
    System.out.println("X. \n-------  OPERAÇÕES QUARTO   -------\n");
    System.out.println("5. Inserir Quarto");
    System.out.println("6. Exibir todos os Quartos");
    System.out.println("7. Editar Quarto");
    System.out.println("8. Excluir Quarto");
    System.out.println("X. \n-------  OPERAÇÕES CAMA   -------\n");
    System.out.println("9. Inserir Cama");
    System.out.println("10. Exibir todas as Camas");
    System.out.println("11. Editar Cama");
    System.out.println("12. Excluir Cama");
    System.out.println("X. \n-------  OPERAÇÕES RESERVA   ----\n");
    System.out.println("13. Inserir Reserva");
    System.out.println("14. Exibir todas as Reservas");
    System.out.println("15. Editar Reserva");
    System.out.println("16. Excluir Reserva");
    System.out.println("17. Sair");

    while (continuar) {

      int escolha = scanner.nextInt();

      switch (escolha) {
        case 1:
          ClienteUtil.inserirDadosClienteViaTeclado(clientes, scanner);
          break;

        case 2:
          ClienteUtil.exibirTodosClientes(clientes);
          break;

        case 3:
          System.out.println("Editar dados de qual Cliente? Digite o ID:");
          int idEditar = scanner.nextInt();
          scanner.nextLine();
          ClienteUtil.editarDadosClienteViaTeclado(clientes, idEditar, scanner);
          break;

        case 4:
          System.out.println("Excluir dados de qual Cliente? Digite o ID:");
          int idExcluir = scanner.nextInt();
          ClienteUtil.excluirCliente(clientes, idExcluir);
          break;

        case 5:
          QuartoUtil.inserirDadosQuartoViaTeclado(quartos, scanner);
          break;

        case 6:
          QuartoUtil.exibirTodosQuartos(quartos);
          break;

        case 7:
          System.out.println("Editar dados de qual Quarto? Digite o ID:");
          int idEditar1 = scanner.nextInt();
          scanner.nextLine();
          QuartoUtil.editarDadosQuartoViaTeclado(quartos, idEditar1, scanner);
          break;

        case 8:
          System.out.println("Excluir dados de qual Quarto? Digite o ID:");
          int idExcluir1 = scanner.nextInt();
          QuartoUtil.excluirQuarto(quartos, idExcluir1);
          break;

        case 9:
          CamaUtil.inserirDadosCamaViaTeclado(listaCamas, scanner);
          break;

        case 10:
          CamaUtil.listarCamas(listaCamas);
          break;

        case 11:
          System.out.println("Editar dados de qual Cama? Digite o ID:");
          int idEditar2 = scanner.nextInt();
          scanner.nextLine();
          CamaUtil.editarDadosCamaViaTeclado(listaCamas, idEditar2, scanner);
          break;

        case 12:
          System.out.println("Excluir dados de qual Cama? Digite o ID:");
          int idExcluir2 = scanner.nextInt();
          CamaUtil.excluirCama(listaCamas, idExcluir2);
          break;

        case 13:
          ReservaUtil.inserirDadosReservaViaTeclado(reservas, scanner);
          break;

        case 14:
          ReservaUtil.listarReserva(reservas);
          break;

        case 15:
          System.out.println("Editar dados de qual Reserva? Digite o ID:");
          int idEditar3 = scanner.nextInt();
          scanner.nextLine();

          ReservaUtil.editarDadosReservaViaTeclado(reservas, idEditar3, scanner);
          break;

        case 16:
          System.out.println("Excluir dados de qual Reserva? Digite o ID:");
          int idExcluir3 = scanner.nextInt();

          ReservaUtil.excluirReserva(reservas, idExcluir3);
          break;

        case 17:
          continuar = false;
          break;
      }
    }
  }
}
