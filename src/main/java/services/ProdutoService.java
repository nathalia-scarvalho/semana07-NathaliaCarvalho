package services;
import modelo.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @SpringBootApplication
    public static class Main implements CommandLineRunner {

        private final ProdutoService produtoService;

        @Autowired
        public Main(ProdutoService produtoService) {
            this.produtoService = produtoService;
        }

        public static void main(String[] args) {
            SpringApplication.run(Main.class, args);
        }

        @Override
        public void run(String... args) {
            Produto novoProduto = new Produto();
            novoProduto.setNome("Teste");
            novoProduto.setDescricao("Teste");
            novoProduto.setPreco(16);

            Produto produtoCadastrado = produtoService.cadastrarProduto(novoProduto);

            System.out.println("Novo produto cadastrado: " + produtoCadastrado);
        }
    }
}
