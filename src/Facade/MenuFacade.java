package Facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factory.RoomFactory;

import Mediator.Mediator;
import Model.User;
import Model.Room.Room;

public class MenuFacade {
	private Scanner input = new Scanner(System.in);
	private Mediator mediator = new Mediator();
	private RoomFactory factory = new RoomFactory();
	private ArrayList<Room> roomlist = new ArrayList<>();
	private Room Room = new Room();
	private User user;
	public void DisplayMenu()
	{
		System.out.println("Hotel Indah Berseri");
		System.out.println("===========================");
		System.out.println("1. Insert new Reservation");
		System.out.println("2. Prepare Reservation");
		System.out.println("3. Manage Reservation");
		System.out.println("4. Exit");
		System.out.print(">>");
	}
	public void MainMenu()
	{
		boolean isRun = true;
		int menu = -1;
		do {
			do {
				DisplayMenu();
			
				try {
					menu = input.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
					menu =-1;
				}
				input.nextLine();
				
			} while (menu<1 || menu>4);
			switch (menu) {
			case 1:
				insertNewReservation();
				break;
			case 2:
				PrepareRoom();
				break;
			case 3:
				manageReservation();
				break;
			case 4:
				isRun = false;
				break;

			}
		} while (isRun);
	}
	public void insertNewReservation()
	{
		String name = "";
		do {
			System.out.print("Input Name : ");
			name = input.nextLine();
			user = new User(name);
			mediator.addUser(user);
			String room="";
			boolean cek = false;
			while(cek==false)
			{
				System.out.print("Input Room [Regular | Family | Royal] :");
				room = input.nextLine();
				System.out.print("Input Price : ");
				Integer price =input.nextInt();
				input.nextLine();
				if(checkPrice(price, room)==true)
				{
					cek=true;
					roomlist.add(factory.makeRoom(price, room, name));
					System.out.println("Insert Reservation Success");
				}
			}
			
		} while (name.isBlank() || name.equals(""));
	}
	private boolean checkPrice(Integer price, String room)
	{
		if(room.equalsIgnoreCase("Regular"))
		{
			if(price>=1000000)
			{
				return true;
			}
			return false;
		}
		else if(room.equalsIgnoreCase("Family"))
		{
			if(price>=2000000)
			{
				return true;
			}
			return false;
			
		}
		else if(room.equalsIgnoreCase("Royal"))
		{
			if(price>=4000000)
			{
				return true;
			}
			return false;
		}
		return false;
	}
	private boolean checkUpgrade(Integer price, String room, int reservationidx)
	{
		if(!room.equals("Regular") && !room.equals(roomlist.get(reservationidx).getRoomType()))
		{
			if(room.equalsIgnoreCase("Family"))
			{
				if(price>=2000000)
				{
					return true;
				}
				return false;
				
			}
			else if(room.equalsIgnoreCase("Royal"))
			{
				if(price>=4000000)
				{
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	public void ShowReservation()
	{
		int no = 1;
		if(roomlist.isEmpty())
		{
			System.out.println("No Reservation");
		}
		else {
			for (Room room : roomlist) {
				System.out.println("Reservation Detail");
				System.out.println("========================");
				System.out.println("Reservation ID : " + no++);
				System.out.println("Customer Name : " + room.getName());
				System.out.println("Room Type : " +room.getRoomType());
				System.out.println("Room Price:" + room.getRoomPrice());
				System.out.println("Facility : ");
				int number=1;
				for(String facility :room.getFacility())
				{
					System.out.println(number++ +". "+facility);
				}
				System.out.println("Free Breakfast for " +room.getNumberOfBreakfast()+" person");
				if(room.isCanRequestMenu())
				{
					System.out.println("Eligible to request menu (" +room.getMenuRequest()+")");
				}
				
			}
		}
	}
	public void PrepareRoom()
	{
		ShowReservation();
		if(!roomlist.isEmpty())
		{
			int choose = -1;
			do {
				
				System.out.print("Input ID : ");
				choose = input.nextInt();
				input.nextLine();
				
			} while (choose<1 || choose>roomlist.size());
			roomlist.get(choose-1).prepareRoom();
		}
	}
	public void upgradeRoom()
	{
		ShowReservation();
		if(!roomlist.isEmpty())
		{
			int choose = -1;
			boolean cek = false;
			
			do {
				
				System.out.print("Input ID : ");
				choose = input.nextInt();
				input.nextLine();
				
				
			} while (choose<1 || choose>roomlist.size());
			while(cek==false)
			{
				System.out.print("Input Room [Family | Royal] :");
				String room = input.nextLine();
				System.out.print("Input Price : ");
				Integer price =input.nextInt();
				input.nextLine();
				if(checkUpgrade(price, room, choose-1)==true)
				{
					cek=true;
					roomlist.set(choose-1,factory.makeRoom(price, room, roomlist.get(choose-1).getName()));
					System.out.println("Upgrade Reservation Success");
					mediator.SendEmail("Upgrade to "+ roomlist.get(choose-1).getRoomType()+" room success", user);
				}
			}
		}
		
	}
	public void DeleteReservation()
	{
		ShowReservation();
		if(!roomlist.isEmpty())
		{
			int choose = -1;
			boolean cek = false;
			
			do {
				
				System.out.print("Input ID : ");
				choose = input.nextInt();
				input.nextLine();
				
				
			} while (choose<1 || choose>roomlist.size());
			roomlist.remove(choose-1);
			mediator.SendEmail("Remove Reservation Success", user);
		}
	}
	public void manageReservation()
	{
	
		int choose = -1;
		do {
			System.out.println("1. Upgrade Reservation");
			System.out.println("2. Delete Reservation");
			System.out.print(">>");
			try {
				choose = input.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				choose =-1;
			}
			input.nextLine();
			
		} while (choose<1 || choose>2);
		switch (choose) {
		case 1:
			upgradeRoom();
			break;
		case 2:
			DeleteReservation();
		}
		
	}
	

}
