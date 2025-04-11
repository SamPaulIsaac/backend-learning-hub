//package sam.association.OneToMany.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//@Entity
//@Table(name = "end_user_address2")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class AddressOneToMany {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String description;
//
//    private String city;
//
//    private String state;
//
//    private Integer pinCode;
//
//    private String country;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private UserOneToMany userOneToMany;
//
//
////    @Override
////    public String toString() {
////        return "Address{" +
////                "id=" + id +
////                ", description='" + description + '\'' +
////                ", city='" + city + '\'' +
////                ", state='" + state + '\'' +
////                ", pinCode=" + pinCode +
////                ", country='" + country + '\'' +
////                ", user=" + (userOneToMany != null ? userOneToMany.getId() : "null") +
////                '}';
////    }
//
//}
