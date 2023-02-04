package Mediator;

import java.util.ArrayList;

import Model.User;

public class Mediator implements IMediator{

	private ArrayList<User> userlist;
	public Mediator() {
		// TODO Auto-generated constructor stub
		this.userlist = new ArrayList<>();
	}
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userlist.add(user);
		
	}

	@Override
	public void SendEmail(String message, User user) {
		// TODO Auto-generated method stub
		for(User customer : userlist)
		{
			if(customer.getName().equals(user.getName()))
			{
				user.ReceiveEmail(message);
			}
		}
	}


}
