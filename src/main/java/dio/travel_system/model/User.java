package dio.travel_system.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "users_tab")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
     
    @NotBlank(message = "Name cannot be blank")
    @Column(nullable = false, length = 50)
    private String name;
    
    @NotBlank(message = "CPF cannot be blank")
    @Column(nullable = false, unique = true)
    private String cpf;
    
    @NotBlank(message = "Street cannot be blank")
    @Column (nullable = false, length = 25)
    private String street;
    
    @NotBlank(message = "Number cannot be blank")
    @Column(nullable = false, length = 20)
    private String number;

    @NotBlank(message = "City cannot be blank")
    @Column(nullable = false, length = 50)
    private String city;

    public User() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
}
