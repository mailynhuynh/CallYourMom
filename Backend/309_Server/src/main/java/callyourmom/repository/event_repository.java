package callyourmom.repository;

import callyourmom.user.event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface event_repository extends JpaRepository<event, Long> {
    event findByTitle(String title);
}