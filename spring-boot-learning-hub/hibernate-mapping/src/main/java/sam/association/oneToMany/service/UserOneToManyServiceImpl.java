//package sam.association.OneToMany.service;
//
//import jakarta.transaction.Transactional;
//import lombok.AllArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import sam.association.OneToMany.dto.EmployeeDto;
//import sam.association.OneToMany.dto.DepartmentDto;
//import sam.association.OneToMany.entity.AddressOneToMany;
//import sam.association.OneToMany.entity.UserOneToMany;
//import sam.association.OneToMany.repository.EmployeeRepository;
//import sam.association.OneToMany.repository.DepartmentRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class UserOneToManyServiceImpl implements UserOneToManyService {
//    private DepartmentRepository departmentRepository;
//    private EmployeeRepository employeeRepository;
//    private ModelMapper modelMapper;
//
//    @Override
//    @Transactional
//    public void save(DepartmentDto departmentDto) {
//        UserOneToMany userOneToMany = UserOneToMany.builder()
//                .name(departmentDto.getName())
//                .build();
//
//        List<AddressOneToMany> addressOneToManyList = new ArrayList<>(departmentDto.getAddressDto().stream()
//                .map(employeeDto ->
//                        AddressOneToMany.builder()
//                                .description(employeeDto.getDescription())
//                                .state(employeeDto.getState())
//                                .pinCode(employeeDto.getPinCode())
//                                .city(employeeDto.getCity())
//                                .country(employeeDto.getCountry())
//                                .userOneToMany(userOneToMany)
//                                .build()
//                ).toList());
//
//        departmentRepository.saveAndFlush(userOneToMany);
//        employeeRepository.saveAllAndFlush(addressOneToManyList);
//
//    }
//
//    @Override
//    public List<DepartmentDto> getAllUsers() {
//        List<UserOneToMany> userOneToManyList = departmentRepository.findAll();
//        System.out.println(userOneToManyList.size());
//        System.out.println(userOneToManyList.get(0));
//        userOneToManyList.forEach(System.out::println);
//        return userOneToManyList.stream().map(this::convertToDto).collect(Collectors.toList());
//    }
//
//    private DepartmentDto convertToDto(UserOneToMany userOneToMany) {
//        DepartmentDto departmentDto = modelMapper.map(userOneToMany, DepartmentDto.class);
//        EmployeeDto employeeDto = modelMapper.map(userOneToMany.getAddressOneToManyList(), EmployeeDto.class);
//        departmentDto.setAddressDto((List<EmployeeDto>) employeeDto);
//        return departmentDto;
//    }
//
//}
