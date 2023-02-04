package State;

import Model.Room.Room;


public class StartState extends State{

	public StartState(Room room) {
		super(room);
		// TODO Auto-generated constructor stub
		System.out.println("Please Wait...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Prepare " + room.getRoomType()+ " Room");
		this.changeState();
	}

	@Override
	public void changeState() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.room.setState(new ServiceState(this.room));
		
	}

}
