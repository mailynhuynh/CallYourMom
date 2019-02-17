
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
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Integer id;

	@Column(name = "firstName")
    @NotFound(action = NotFoundAction.IGNORE)
    private String firstName;

    @Column(name = "lastName")
    @NotFound(action = NotFoundAction.IGNORE)
    private String lastName;
    
    @Column(name = "userName")
    @NotFound(action = NotFoundAction.IGNORE)
    private String userName;
    
    @Column(name = "password")
    @NotFound(action = NotFoundAction.IGNORE)
    private int password;

    @Column(name = "address")
    @NotFound(action = NotFoundAction.IGNORE)
    private String address;

    @Column(name = "telephone")
    @NotFound(action = NotFoundAction.IGNORE)
    private String telephone;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

    @Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", address=" + address + ", telephone=" + telephone + "]";
	}
}
