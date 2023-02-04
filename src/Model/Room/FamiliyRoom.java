package Model.Room;

import java.util.ArrayList;

import Model.User;

public class FamiliyRoom extends Room{
	
	public FamiliyRoom(Integer roomPrice,String user) {
		// TODO Auto-generated constructor stub
		super(roomPrice, user);
		this.facility = new ArrayList<>();
		this.facility.add("Private Jaccuzy");
		this.canRequestMenu = true;
		this.menuRequest = "Dinner Only";
		this.setRoomType("Family");
		this.numberOfBreakfast = 3;
	}

	

}
