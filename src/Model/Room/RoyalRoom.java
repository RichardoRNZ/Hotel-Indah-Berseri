package Model.Room;

import java.util.ArrayList;

import Model.User;

public class RoyalRoom extends Room{
	public RoyalRoom(Integer roomPrice, String user) {
		// TODO Auto-generated constructor stub
		super(roomPrice, user);
		this.facility = new ArrayList<String>();
		this.facility.add("Private Jaccuzy");
		this.facility.add("Private Pool");
		this.canRequestMenu = true;
		this.setRoomType("Royal");
		this.menuRequest = "All Day Service";
		this.numberOfBreakfast=4;
	}

	
	

}
