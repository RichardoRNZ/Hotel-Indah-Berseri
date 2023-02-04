package State;

import Model.Room.Room;

public class StopState extends State{

	public StopState(Room room) {
		super(room);
		// TODO Auto-generated constructor stub
		System.out.println(room.getRoomType()+" Room has prepared");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeState() {
		// TODO Auto-generated method stub
	
		
	}

}
