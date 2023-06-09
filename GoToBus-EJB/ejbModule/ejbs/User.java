package ejbs;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Stateless
@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	private String username;
	private String password;
	private String full_name;
	private String role;		//client/admin
	private Boolean is_loggedin;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<Notification> notificatios = new HashSet<Notification>();
	
	@ManyToMany(mappedBy="users", fetch = FetchType.EAGER)
	private Set<Trip> trips = new HashSet<Trip>();

	public User() {
		super();
		this.is_loggedin=false;
	}
	
	public User(String username, String password, String full_name, String role, Boolean is_loggedin) {
		super();
		this.username = username;
		this.password = password;
		this.full_name = full_name;
		this.role = role;
		this.is_loggedin = false;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Boolean getIs_loggedin() {
		return is_loggedin;
	}
	public void setIs_loggedin(Boolean is_loggedin) {
		this.is_loggedin = is_loggedin;
	}
	public void login() {
		this.is_loggedin=true;
	}
	public Set<Notification> getNotificatios() {
		return notificatios;
	}
	public void setNotificatios(Set<Notification> notificatios) {
		this.notificatios = notificatios;
	}
	public void addNotification(Notification notification) {
		this.notificatios.add(notification);
		System.out.println("New notification added");
		System.out.println(notification.getMessage());
	}
	
	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	public Set<Trip> getTrips() {
		return trips;
	}

	public String sayHello() {
		return "Hello User!";
	}
	public void registerToTrip(Trip newTrip) {
		this.trips.add(newTrip);
	}
}
