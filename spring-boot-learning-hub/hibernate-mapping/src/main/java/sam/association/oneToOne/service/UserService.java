package sam.association.oneToOne.service;

import org.springframework.stereotype.Service;
import sam.association.oneToOne.dto.UserDto;

import java.util.List;

@Service
public interface UserService {
    void save(UserDto userDto);

    List<UserDto> getAllUsers();
}
