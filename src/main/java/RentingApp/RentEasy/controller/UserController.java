package RentingApp.RentEasy.controller;

import RentingApp.RentEasy.entity.User;
import RentingApp.RentEasy.Rentservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // --- DTOs for requests ---
    public static class SignUpRequest {
        public String username;
        public String password;
        public String confirmPassword;
        public String mobileNumber;
        public String name;
    }

    // NEW: DTO for the sign-in request
    public static class SignInRequest {
        public String username;
        public String password;
    }

    // --- SIGN UP ENDPOINT (Updated to include name) ---
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if (!signUpRequest.password.equals(signUpRequest.confirmPassword)) {
            return new ResponseEntity<>("Passwords do not match!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(signUpRequest.username);
        user.setPassword(signUpRequest.password);
        user.setMobileNumber(signUpRequest.mobileNumber);
        // Note: You need to add a 'name' field to your User entity to save this

        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // --- NEW: SIGN IN ENDPOINT ---
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody SignInRequest signInRequest) {
        try {
            User user = userService.authenticateUser(signInRequest.username, signInRequest.password);
            // On successful login, you would typically return a JWT token.
            // For now, we'll return a success message.
            return ResponseEntity.ok("Sign in successful! Welcome back, " + user.getUsername());
        } catch (Exception e) {
            // Return a more specific status code for unauthorized access
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}