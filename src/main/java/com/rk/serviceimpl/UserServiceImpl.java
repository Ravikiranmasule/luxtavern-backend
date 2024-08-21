package com.rk.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.rk.entity.User;
import com.rk.repository.UserRepository;
import com.rk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                             .orElseThrow(() -> new RuntimeException("User not found"));
    }

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}
	
	 @Override
	    public User updateUser(Long id, User updatedUser) {
	        User existingUser = userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        existingUser.setUsername(updatedUser.getUsername());
	        existingUser.setRole(updatedUser.getRole());

	        // Optionally update password if provided (add validation if needed)
	      
	        return userRepository.save(existingUser);
	    }
	

}
