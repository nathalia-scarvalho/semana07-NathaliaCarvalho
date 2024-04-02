package modelo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "fabricantes")
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    // Getters e setters
}
