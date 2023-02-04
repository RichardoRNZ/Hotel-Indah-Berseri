package Mediator;

import Model.User;

public interface IMediator {
	public void addUser(User user);
	public void SendEmail(String message, User user);

}
