package callyourmom.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "Settings")
public class Settings {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Integer id;
	
	/**
	 * If 1, the theme is light, if 0, it should be dark
	 */
	@Column(name = "theme")
    @NotFound(action = NotFoundAction.IGNORE)
    private boolean theme;
	
	/**
	 * If 1, notifications is on, if 0, it is not.
	 */
    @Column(name = "notifications")
    @NotFound(action = NotFoundAction.IGNORE)
    private boolean notifications;
    
    /**
     * The sharing string represents who the user wants to share their schedule with.
     * There is a choice between Everyone, friends, and nobody.
     */
    @Column(name = "sharing")
    @NotFound(action = NotFoundAction.IGNORE)
    private String sharing;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isTheme() {
		return theme;
	}

	public void setTheme(boolean theme) {
		this.theme = theme;
	}

	public boolean isNotifications() {
		return notifications;
	}

	public void setNotifications(boolean notifications) {
		this.notifications = notifications;
	}

	public String getSharing() {
		return sharing;
	}

	public void setSharing(String sharing) {
		this.sharing = sharing;
	}
}


