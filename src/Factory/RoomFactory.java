package Factory;

import Model.User;
import Model.Room.FamiliyRoom;
import Model.Room.RegularRoom;
import Model.Room.Room;
import Model.Room.RoyalRoom;

public class RoomFactory {
	
	public Room makeRoom(Integer price, String type, String user) {
		if(type.equalsIgnoreCase("Regular"))
		{
			return new RegularRoom(price, user);
		}
		else if(type.equalsIgnoreCase("Family"))
		{
			return new FamiliyRoom(price, user);
		}
		else if(type.equals("Royal"))
		{
			return new RoyalRoom(price, user);
		}
		return null;
	}

}
