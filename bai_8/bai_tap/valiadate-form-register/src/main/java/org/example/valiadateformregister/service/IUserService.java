package org.example.valiadateformregister.service;

import org.example.valiadateformregister.dto.UserDto;

public interface IUserService {
    boolean save(UserDto userDto);
}
