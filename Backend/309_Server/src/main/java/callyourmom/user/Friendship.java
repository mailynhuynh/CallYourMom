
package callyourmom.user;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "Friendship")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Integer id;

	@Column(name = "friendId")
    @NotFound(action = NotFoundAction.IGNORE)
    private Integer friendId;

    
    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getFriendId() {
		return friendId;
	}
	
	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}
	
	
	// Edit: Mar 10
    @Override
	public String toString() {
		return "User  =" + id + ", firstName=" + "Friend = " + friendId + 
			 "]";
	}
}
