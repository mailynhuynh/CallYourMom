
package callyourmom.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.core.style.ToStringCreator;

/**
 * Practice how to use Springboot
 */
@Entity
@Table(name = "Events")
public class event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Integer id;

    @Column(name = "time")
    @NotFound(action = NotFoundAction.IGNORE)
    private String time;

    @Column(name = "title")
    @NotFound(action = NotFoundAction.IGNORE)
    private String title;
    
    @Column(name = "location")
    @NotFound(action = NotFoundAction.IGNORE)
    private String location;
    
    @Column(name = "friends_invited")
    @NotFound(action = NotFoundAction.IGNORE)
    private String friends_invited;
    
    @Column(name = "friends_going")
    @NotFound(action = NotFoundAction.IGNORE)
    private String friends_going;

    @Column(name = "tags")
    @NotFound(action = NotFoundAction.IGNORE)
    private String tags;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }

    public String getTime() {
        return this.time;
    }

    public void setFirstName(String time) {
        this.time = time;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFriends_Invited() {
        return this.friends_invited;
    }

    public void setFriends_Intived(String friends_invited) {
        this.friends_invited = friends_invited;
    }
    
    public String getFriends_Going() {
        return this.friends_going;
    }
    
    public void setFriends_Going(String friends_going) {
        this.friends_going = friends_going;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId())
                .append("new", this.isNew())
                .append("time", this.getTime())
                .append("title", this.getTitle())
                .append("location", this.location)
                .append("friends_invited", this.friends_invited).toString();
    }
    
}
