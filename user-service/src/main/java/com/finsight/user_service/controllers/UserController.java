package com.finsight.user_service.controllers;

import com.finsight.user_service.entity.User;
import com.finsight.user_service.repositories.UserRepository;
import com.finsight.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;  // Inject the UserService to handle ML prediction


    private void logInstance(String methodName) {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            System.out.println("📦 Request handled by instance: " + hostname + " → method: " + methodName);
        } catch (UnknownHostException e) {
            System.out.println("⚠️ Could not get hostname");
        }
    }

    // Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logInstance("create-user");
        User savedUser = userRepository.save(user);
        // Trigger ML prediction and risk engine
        double creditScore = userService.predictCreditScore(user);  // Call ML model
        boolean hasDefaultRisk = userService.predictDefaultRisk(user);  // Call risk engine

        // Update user with prediction results
        savedUser.setCreditScore(creditScore);

        userRepository.save(savedUser);  // Save the updated user with predictions

        return ResponseEntity.ok(savedUser);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        logInstance("get-users");
        return userRepository.findAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        logInstance("get-userbyId");
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        logInstance("put-user");
        return userRepository.findById(id)
                .map(user -> {
                    // Update user fields
                    user.setIncome(updatedUser.getIncome());
                    user.setSavings(updatedUser.getSavings());
                    user.setDebt(updatedUser.getDebt());
                    // Set other fields as needed

                    // Trigger ML model prediction and risk check
                    double creditScore = userService.predictCreditScore(user);  // Call ML model
                    boolean hasDefaultRisk = userService.predictDefaultRisk(user);  // Call risk engine

                    // Update user with predictions
                    user.setCreditScore(creditScore);


                    User saved = userRepository.save(user);
                    return ResponseEntity.ok(saved);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        logInstance("delete-user");
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
