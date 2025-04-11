package sam.association.oneToMany.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sam.association.oneToMany.dto.DepartmentDto;
import sam.association.oneToMany.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/api/oneToMany/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentServiceImpl departmentService;

    @PostMapping("/save")
    public void saveDepartmentAndEmployee(@RequestBody DepartmentDto departmentDto) {
        System.out.println("Request received for saveDepartmentAndEmployee => " + departmentDto);
        departmentService.saveDepartmentAndEmployee(departmentDto);
    }

}
