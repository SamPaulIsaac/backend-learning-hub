package sam.association.oneToMany.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sam.association.oneToMany.dto.DepartmentDto;
import sam.association.oneToMany.entity.Department;
import sam.association.oneToMany.entity.Employee;
import sam.association.oneToMany.repository.DepartmentRepository;
import sam.association.oneToMany.repository.EmployeeRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void saveDepartmentAndEmployee(DepartmentDto departmentDto) {
        Department department = Department.builder()
                .name(departmentDto.getName())
                .build();

        Set<Employee> employees;
        employees = departmentDto.getEmployeeDto().stream().map(employee ->
                Employee.builder()
                        .name(employee.getName())
                        .age(employee.getAge())
                        .designation(employee.getDesignation())
                        .yearOfJoining(employee.getYearOfJoining())
                        .department(department)
                        .build()
        ).collect(Collectors.toSet());

        departmentRepository.saveAndFlush(department);
        employeeRepository.saveAllAndFlush(employees);

    }
}
