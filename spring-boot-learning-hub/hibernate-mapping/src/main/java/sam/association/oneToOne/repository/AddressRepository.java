package sam.association.oneToOne.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sam.association.oneToOne.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
