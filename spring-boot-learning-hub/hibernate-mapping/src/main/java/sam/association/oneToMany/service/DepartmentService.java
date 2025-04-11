package sam.association.oneToMany.service;

import sam.association.oneToMany.dto.DepartmentDto;

public interface DepartmentService {

    void saveDepartmentAndEmployee(DepartmentDto departmentDto);
}
