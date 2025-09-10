package com.web.rungroup.service;

import com.web.rungroup.dto.RegistrationDto;
import com.web.rungroup.model.Role;
import com.web.rungroup.model.UserEntity;
import com.web.rungroup.repository.RoleRepository;
import com.web.rungroup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;


@Service
public class UserServiceImp implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUserName(registrationDto.getUserName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("User");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
