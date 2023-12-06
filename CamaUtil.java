import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class CamaUtil {

  // Função para adicionar um quarto ao array
  public static void adicionarCama(ArrayList<Cama> listaCamas, String codigoCama,
      boolean ehBeliche, String posicao, String descricao) {
    int indice = encontrarIndiceVazio(listaCamas);
    if (indice != -1) {
      Cama novaCama = new Cama(indice + 1, codigoCama, ehBeliche, posicao, descricao);
      listaCamas.add(novaCama);
      System.out.println("Cama adicionada!");
    } else {
      System.out.println("A lista de Quartos está cheia. Não é possível adicionar mais Quartos.");
    }
  }

  // Função para encontrar o primeiro índice vazio
  private static int encontrarIndiceVazio(ArrayList<Cama> listaCamas) {
    return listaCamas.size();
  }

  // Funçlão para editar uma cama
  private static void editarCama(ArrayList<Cama> listaCamas, int id, String codigoCama,
      boolean ehBeliche, String posicao, String descricao) {
    // Procurando a cama no ArrayList com base no ID
    for (Cama cama : listaCamas) {
      if (cama.getId() == id) {
        // Atualizando os dados da cama
        cama.setCodigoCama(codigoCama);
        cama.setEhBeliche(ehBeliche);
        cama.setPosicao(posicao);
        cama.setDescricao(descricao);
        System.out.println("A cama" + id + " foi atualizada com sucesso!");
        break;
      }
    }
  }

  // Função para excluir uma cama
  public static void excluirCama(ArrayList<Cama> listaCamas, int id) {

    Iterator<Cama> iterator = listaCamas.iterator();
    while (iterator.hasNext()) {
      Cama cama = iterator.next();
      if (cama.getId() == id) {
        iterator.remove();
        System.out.println("A cama " + id + "foi removida com sucesso!");
        break;
      }
    }
  }

  public static void listarCamas(ArrayList<Cama> listaCamas) {
    for (Cama cama : listaCamas) {
      System.out.println(cama.toString());
    }
  }

  // Função para enviar os dados para a função inserir
  public static void inserirDadosCamaViaTeclado(ArrayList<Cama> listaCamas, Scanner scanner) {
    scanner.nextLine();
    System.out.println("Código da cama: ");
    String codigoCama = scanner.nextLine();
    System.out.println("Posição: ");
    String posicao = scanner.nextLine();
    System.out.println("É um beliche( True / False): ");
    boolean ehBeliche = scanner.nextBoolean();
    System.out.println("Descrição: ");
    String descricao = scanner.nextLine();

    adicionarCama(listaCamas, codigoCama, ehBeliche, posicao, descricao);
  }

  // Função para enviar os dados para a função editar
  public static void editarDadosCamaViaTeclado(ArrayList<Cama> listaCamas, int id, Scanner scanner) {
    scanner.nextLine();

    for (Cama cama : listaCamas) {

      if (cama != null && cama.getId() == id) {

        System.out.println("Código da cama: ");
        String codigoCama = scanner.nextLine();
        System.out.println("Posição: ");
        String posicao = scanner.nextLine();
        System.out.println("É um beliche( True / False): ");
        boolean ehBeliche = scanner.nextBoolean();
        System.out.println("Descrição: ");
        String descricao = scanner.nextLine();

        editarCama(listaCamas, id, codigoCama, ehBeliche, posicao, descricao);
      } else {
        System.out.println("Cama não encontrado com ID " + id + ". Nenhum dado foi editado.");
        return;
      }
    }

  }
}