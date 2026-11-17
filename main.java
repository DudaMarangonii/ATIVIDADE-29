
import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Instancia o DAO utilizando a interface (DIP)
        LivroDAO dao = new LivroDAOSqlite();

        System.out.println("====================================");
        System.out.println("       SISTEMA BOOKSTORE");
        System.out.println("====================================");

        // 2. Cadastro de três livros
        System.out.println("\n--- CADASTRANDO LIVROS ---");

        Livro livro1 = new Livro(
            "Clean Code",
            "Robert C. Martin",
            89.90
        );

        Livro livro2 = new Livro(
            "Design Patterns",
            "Erich Gamma et al.",
            125.50
        );

        Livro livro3 = new Livro(
            "Refactoring",
            "Martin Fowler",
            98.00
        );

        dao.salvar(livro1);
        dao.salvar(livro2);
        dao.salvar(livro3);

        // Verifica os IDs gerados
        System.out.println("Livro cadastrado: " + livro1);
        System.out.println("Livro cadastrado: " + livro2);
        System.out.println("Livro cadastrado: " + livro3);

        // 3. Consulta pelo ID 2
        System.out.println("\n--- BUSCANDO LIVRO ID 2 ---");

        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println("Livro encontrado: " + livro),
            () -> System.out.println("Livro não encontrado!")
        );

        // 4. Consulta por ID inexistente
        System.out.println("\n--- BUSCANDO ID INEXISTENTE ---");

        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println("Livro encontrado: " + livro),
            () -> System.out.println("Nenhum livro encontrado com ID 999.")
        );

        // 5. Listagem de todos os livros
        System.out.println("\n--- CATÁLOGO COMPLETO ---");

        List<Livro> livros = dao.listarTodos();

        System.out.println("-----------------------------------------------");
        System.out.printf("%-5s %-20s %-22s %10s%n",
            "ID", "TITULO", "AUTOR", "PRECO");
        System.out.println("-----------------------------------------------");

        for (Livro livro : livros) {
            System.out.printf("%-5d %-20s %-22s R$ %8.2f%n",
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getPreco()
            );
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Total de livros: " + livros.size());
        System.out.println("====================================");
        System.out.println("       FIM DOS TESTES");
        System.out.println("====================================");
    }
}