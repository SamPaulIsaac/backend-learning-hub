package sam.association.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sam.association.oneToMany.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
