package dio.travel_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hosting_tab")
public class Hosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_id"))
    private User user;

    @Column(nullable = false, length = 25)
    private String street;
    
    @Column(nullable = false, length = 25)
    private String city;

    @Column(nullable = false, length = 25)
    private String state;
    
    @Column(nullable = false)
    private boolean available = false;
    
    public Hosting() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public boolean isAvailable() {  
        return available;
    }

    public void setAvailable(boolean available) {  
        this.available = available;
    }
}
