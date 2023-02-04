package State;

import Model.Room.Room;

public class ServiceState extends State{

	public ServiceState(Room room) {
		super(room);
		// TODO Auto-generated constructor stub
		for(String facility : room.getFacility())
		{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Prepare "+facility);
		}
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
		this.room.setState(new StopState(this.room));
	}

}
