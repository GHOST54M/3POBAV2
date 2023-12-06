import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class QuartoUtil {
  // Função para adicionar um quarto ao array
  public static void adicionarQuarto(ArrayList<Quarto> quartos, String nomeQuarto, int qtdeCamas, boolean temBanheiro,
      String descricao) {

    int indice = encontrarIndiceVazio(quartos);

    if (indice != -1) {
      Quarto novoQuarto = new Quarto(indice + 1, nomeQuarto, qtdeCamas, temBanheiro, descricao);
      quartos.add(novoQuarto);
      System.out.println("Quarto adicionado!");
    } else {
      System.out.println("A lista de Quartos está cheia. Não é possível adicionar mais Quartos.");
    }

  }

  // Função para encontrar o primeiro índice vazio
  private static int encontrarIndiceVazio(ArrayList<Quarto> quartos) {
    return quartos.size();
  }

  // Função para editar Quarto
  private static void editarQuarto(ArrayList<Quarto> quartos, int id, String nomeQuarto, int qtdeCamas,
      boolean temBanheiro,
      String descricao) {

    for (Quarto quarto : quartos) {
      if (quarto != null && quarto.getId() == id) {
        quarto.setNomeQuarto(nomeQuarto);
        quarto.setQtdeCamas(qtdeCamas);
        quarto.setTemBanheiro(temBanheiro);
        quarto.setDescricao(descricao);

        System.out.println("Dados do Quarto " + id + " foram editados com sucesso.");
        return;
      }
    }
  }

  // Função para excluir um Quarto com base no ID
  public static void excluirQuarto(ArrayList<Quarto> quartos, int id) {
    Iterator<Quarto> iterator = quartos.iterator();
    while (iterator.hasNext()) {
      Quarto quarto = iterator.next();
      if (quarto.getId() == id) {
        iterator.remove();
        System.out.println("Quarto " + id + " foi excluído com sucesso.");
        break;
      }
    }
  }

  // Função para listar todos os Quartos
  public static void exibirTodosQuartos(ArrayList<Quarto> quartos) {
    System.out.println("Lista de Quartos:");
    for (Quarto quarto : quartos) {
      if (quartos != null) {
        System.out.println(quartos.toString());
      }
    }
  }

  // Função para enviar os dados para a função inserir
  public static void inserirDadosQuartoViaTeclado(ArrayList<Quarto> quartos, Scanner scanner) {
    scanner.nextLine();
    System.out.println("Nome: ");
    String nome = scanner.nextLine();
    System.out.println("Quantidade de Camas:: ");
    int camas = scanner.nextInt();
    System.out.println("Tem Banheiro? (true/false): ");
    boolean banheiro = scanner.nextBoolean();
    System.out.println("Descrição: ");
    String descricao = scanner.nextLine();

    adicionarQuarto(quartos, nome, camas, banheiro, descricao);
  }

  // Função para enviar os dados para a função editar
  public static void editarDadosQuartoViaTeclado(ArrayList<Quarto> quartos, int id, Scanner scanner) {
    scanner.nextLine();

    for (Quarto quarto : quartos) {

      if (quarto != null && quarto.getId() == id) {

        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Quantidade de Camas:: ");
        int camas = scanner.nextInt();
        System.out.println("Tem Banheiro? (true/false): ");
        boolean banheiro = scanner.nextBoolean();
        System.out.println("Descrição: ");
        String descricao = scanner.nextLine();

        editarQuarto(quartos, id, nome, camas, banheiro, descricao);
      } else {
        System.out.println("Quarto não encontrado com ID " + id + ". Nenhum dado foi editado.");
        return;
      }
    }

  }
}
