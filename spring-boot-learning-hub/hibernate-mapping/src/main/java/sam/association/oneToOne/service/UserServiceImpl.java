package sam.association.oneToOne.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sam.association.oneToOne.dto.AddressDto;
import sam.association.oneToOne.dto.UserDto;
import sam.association.oneToOne.entity.Address;
import sam.association.oneToOne.entity.User;
import sam.association.oneToOne.repository.AddressRepository;
import sam.association.oneToOne.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void save(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .build();

        Address address = Address.builder()
                .description(userDto.getAddressDto().getDescription())
                .state(userDto.getAddressDto().getState())
                .pinCode(userDto.getAddressDto().getPinCode())
                .city(userDto.getAddressDto().getCity())
                .user(user)
                .build();

        userRepository.saveAndFlush(user);
        addressRepository.saveAndFlush(address);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList.size());
        System.out.println(userList.get(0));
        userList.forEach(System.out::println);
        return userList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        AddressDto addressDto = modelMapper.map(user.getAddress(), AddressDto.class);
        userDto.setAddressDto(addressDto);
        return userDto;
    }

}
