package Model;

public class User {
	private String name;

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void ReceiveEmail(String message)
	{
		System.out.println(name + " has receive email : " +message);
	}

}
