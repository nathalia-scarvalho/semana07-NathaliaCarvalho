import modelo.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.ProdutoService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
public class Main implements CommandLineRunner {

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

