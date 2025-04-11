package sam.association.oneToOne.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "end_user_address")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String city;

    private String state;

    private Integer pinCode;

    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", country='" + country + '\'' +
                ", user=" + (user != null ? user.getId() : "null") +
                '}';
    }

}
