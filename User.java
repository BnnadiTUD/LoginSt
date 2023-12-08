
public class User {
String userName, password;

public User() {
	this.userName = " ";
	this.password = " ";
}

public User(String u, String p) {
	this.userName = u;
	this.password = p;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String toString() {
	String result = "\n" + userName + " || " + password;
			return result;
}
}
