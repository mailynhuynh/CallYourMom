package callyourmom.repository;

import callyourmom.user.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Integer> {
    Event findByTitle(String title);
}   