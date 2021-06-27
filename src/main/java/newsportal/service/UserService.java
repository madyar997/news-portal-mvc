package newsportal.service;

import newsportal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//@Service
//@Transactional
//public class UserService implements IUserService {
//    @Autowired
//    private UserRepository repository;
//
//    @Override
//    public org.springframework.security.core.userdetails.User registerNewUserAccount(User userDto) throws UserAlreadyExistException {
//        if (emailExist(userDto.getEmail())) {
//            throw new UserAlreadyExistException("There is an account with that email address: "
//              + userDto.getEmail());
//        }
//
//        // the rest of the registration operation
//    }
//    private boolean emailExist(String email) {
//        return userRepository.findByEmail(email) != null;
//    }
//}