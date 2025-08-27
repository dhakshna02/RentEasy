package RentingApp.RentEasy.Repository;

import RentingApp.RentEasy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query to find a user by their username (email)
    Optional<User> findByUsername(String username);
}