
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

@Entity
@Table(name = "Events")
public class Event {

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
    
    @Column(name = "description")
    @NotFound(action = NotFoundAction.IGNORE)
    private String description;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFriends_invited() {
		return friends_invited;
	}

	public void setFriends_invited(String friends_invited) {
		this.friends_invited = friends_invited;
	}

	public String getFriends_going() {
		return friends_going;
	}

	public void setFriends_going(String friends_going) {
		this.friends_going = friends_going;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", time=" + time + ", title=" + title + ", location=" + location
				+ ", friends_invited=" + friends_invited + ", friends_going=" + friends_going + ", tags=" + tags
				+ ", description=" + description + "]";
	}
}
