package Model.Room;

import java.util.ArrayList;

import Model.User;

public class RegularRoom extends Room{

	public RegularRoom(Integer roomPrice, String user) {
		// TODO Auto-generated constructor stub
		super(roomPrice, user);
		this.facility = new ArrayList<>();
		this.facility.add("Mini Fridge Inside Bedroom");
		this.canRequestMenu = false;
		this.menuRequest = null;
		this.setRoomType("Regular");
		this.numberOfBreakfast=2;
		
	}
	
	

}
