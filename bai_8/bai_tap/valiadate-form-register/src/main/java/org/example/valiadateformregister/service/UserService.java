package org.example.valiadateformregister.service;

import org.example.valiadateformregister.converter.UserDtoToUserConverter;
import org.example.valiadateformregister.dto.UserDto;
import org.example.valiadateformregister.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final UserDtoToUserConverter userDtoToUserConverter;

    public UserService(IUserRepository userRepository, UserDtoToUserConverter userDtoToUserConverter) {
        this.userRepository = userRepository;
        this.userDtoToUserConverter = userDtoToUserConverter;
    }

    @Override
    public boolean save(UserDto userDto) {
        if (userDto.getId() != null) {
            return false;
        }
        userRepository.save(Objects.requireNonNull(userDtoToUserConverter.convert(userDto)));
        return true;
    }
}
