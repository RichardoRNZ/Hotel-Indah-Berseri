package Model.Room;

import java.util.ArrayList;

import Model.User;
import State.StartState;
import State.State;

public class Room {
	
	private String name;
	private Integer RoomPrice;
	private String RoomType;
	protected ArrayList<String>facility;
	protected Integer numberOfBreakfast;
	protected boolean canRequestMenu;
	protected String menuRequest;
	private State state;
	public Room(Integer roomPrice,String name) {
		super();
		RoomPrice = roomPrice;
		this.name = name; 
	}
	public Room() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> getFacility() {
		return facility;
	}
	public Integer getRoomPrice() {
		return RoomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		RoomPrice = roomPrice;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	public void setFacility(ArrayList<String> facility) {
		this.facility = facility;
	}
	public boolean isCanRequestMenu() {
		return canRequestMenu;
	}
	public void setCanRequestMenu(boolean canRequestMenu) {
		this.canRequestMenu = canRequestMenu;
	}
	public String getMenuRequest() {
		return menuRequest;
	}
	public void setMenuRequest(String menuRequest) {
		this.menuRequest = menuRequest;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	} 
	public void prepareRoom()
	{
		this.state = new StartState(this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfBreakfast() {
		return numberOfBreakfast;
	}
	public void setNumberOfBreakfast(Integer numberOfBreakfast) {
		this.numberOfBreakfast = numberOfBreakfast;
	}
	
}
