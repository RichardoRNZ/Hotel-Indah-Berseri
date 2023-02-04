package State;

import Model.Room.Room;

public abstract class State {
	protected Room room;
	
	public State(Room room) {
		// TODO Auto-generated constructor stub
		this.room = room;
	}
	public abstract void changeState();

}
