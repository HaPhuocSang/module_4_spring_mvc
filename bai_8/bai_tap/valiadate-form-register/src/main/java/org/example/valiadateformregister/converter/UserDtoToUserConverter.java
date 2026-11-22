package org.example.valiadateformregister.converter;

import org.example.valiadateformregister.dto.UserDto;
import org.example.valiadateformregister.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {
    @Override
    public User convert(UserDto userDto) {
        return new User(userDto.getId(), userDto.getUsername(),  userDto.getPassword(), userDto.getEmail(), userDto.getPhoneNumber());
    }
}
