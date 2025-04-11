//package sam.association.OneToMany.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "end_user2")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserOneToMany {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//
//    @OneToMany(mappedBy = "userOneToMany", cascade = CascadeType.ALL)
//    private List<AddressOneToMany> addressOneToManyList = new ArrayList<>();
//
////    @Override
////    public String toString() {
////        return "User{" +
////                "id=" + id +
////                ", name='" + name + '\'' +
////                ", address=" + (address != null ? address.toString() : "null") +
////                '}';
////    }
//
//}
