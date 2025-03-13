package dio.travel_system.model;

import jakarta.persistence.*;


@Table(name = "hosting_tab")
@Entity
public class Hosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private boolean disponibilidade;
    
    public Hosting() {}


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}