package callyourmom.repository;

import callyourmom.user.user;
import org.springframework.data.jpa.repository.JpaRepository;


public interface user_repository extends JpaRepository<user, Long> {
    user findByUserName(String username);
}