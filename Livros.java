
package br.com.bookstore.model;

public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private double preco;

    // Construtor completo
    public Livro(Long id, String titulo, String autor, double preco) {
        validarDados(titulo, autor, preco);

        this.id = id;
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.preco = preco;
    }

    // Construtor de negócio
    public Livro(String titulo, String autor, double preco) {
        this(null, titulo, autor, preco);
    }

    // Validação dos dados
    private void validarDados(String titulo, String autor, double preco) {

        if (titulo == null || titulo.trim().length() < 2) {
            throw new IllegalArgumentException(
                "O título deve possuir pelo menos 2 caracteres!"
            );
        }

        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "O autor não pode ser nulo ou vazio!"
            );
        }

        if (preco <= 0.0 || Double.isNaN(preco) || Double.isInfinite(preco)) {
            throw new IllegalArgumentException(
                "O preço de venda deve ser estritamente positivo!"
            );
        }
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    // Setter do ID
    public void setId(Long id) {
        this.id = id;
    }

    // Representação textual
    @Override
    public String toString() {
        return String.format(
            "Livro{id=%d, titulo='%s', autor='%s', preco=R$ %.2f}",
            id, titulo, autor, preco
        );
    }
}
