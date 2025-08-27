package RentingApp.RentEasy.Rentservice;

import RentingApp.RentEasy.entity.User;
import RentingApp.RentEasy.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Import this
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Inject the PasswordEncoder bean
    @Autowired
    private PasswordEncoder passwordEncoder;

    // --- SIGN UP LOGIC (Updated to use injected encoder) ---
    public User registerUser(User user) throws Exception {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("Username already exists");
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    // --- NEW: SIGN IN LOGIC ---
    public User authenticateUser(String username, String password) throws Exception {
        // 1. Find the user by their username (email)
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("User not found"));

        // 2. Check if the provided password matches the stored hashed password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("Invalid credentials");
        }

        // 3. If credentials are correct, return the user object
        return user;
    }
}