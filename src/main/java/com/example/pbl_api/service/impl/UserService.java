package com.example.pbl_api.service.impl;

import com.example.pbl_api.entity.User;
import com.example.pbl_api.entity.UserAccount;
import com.example.pbl_api.model.UserAccountModel;
import com.example.pbl_api.model.UserModel;
import com.example.pbl_api.repository.UserAccountRepository;
import com.example.pbl_api.repository.UserRepository;
import com.example.pbl_api.service.IUserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService implements IUserSerivce {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findUserAccountByUsername(username);
        if(userAccount==null) throw new UsernameNotFoundException(username);

        return UserAccountModel.build(userAccount);
    }

    @Override
    public UserModel loadUserDetailByAccoutName(String name) {

        User result = userRepository.findUserByAccountName(name);
        if (result==null) return null;
        return new UserModel(result);
    }

    @Override
    public UserModel saveNewUser(UserModel user,UserAccountModel newAccount) {
        System.out.println(user.getDateOfBirth());
        user.setUserAccount(newAccount);
        User newUser = new User(user);
        userRepository.save(newUser);
        return null;
    }

    @Override
    public UserModel editUser(long id,UserModel user) {
        User userEdit= userRepository.findUserById(id);
        userEdit.editUser(user);
        userRepository.save(userEdit);
        return null;
    }

    @Override
    public UserModel findUserById(long id) {
        User result = userRepository.findUserById(id);
        return new UserModel(result);
    }
}
