/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 */
public class Client {
	


	public static UserRecord Input()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Select the Operation:\n 1: New Record \n 2: Search Record");

		int operation = Integer.parseInt(sc.nextLine());
		System.out.println("Type username: ");
		String username = sc.nextLine();
		UserRecord newRec;
		
		if(operation == 1)
		{
			System.out.println("Type the notes: ");
			
			String notes = sc.nextLine();
			newRec = new UserRecord(username,notes,1);

		}
		else
		{
			newRec = new UserRecord(username,"",2);
		}
		return newRec;
	}



	public static void main(String[] args) 
	{
		try
		{	
			Socket sender = new Socket("localhost",8001);
			UserRecord newRec = Input();
			ObjectOutputStream outServer = new ObjectOutputStream(sender.getOutputStream());
			ObjectInputStream inServer = new ObjectInputStream(sender.getInputStream());
			
			outServer.writeObject(newRec);

			if(newRec.operation == 2)
			{
				while(true)
				{
					UserRecord newRec1 = (UserRecord)inServer.readObject();
					System.out.println("User Found: ");
					System.out.println("User Name: "+newRec1.Username);
					System.out.println("Notes : "+ newRec1.Notes);
				}
			}

			sender.close();   
		}
		catch(Exception e)
		{
			System.out.println("Exception");
			System.out.println(e.getMessage());
		}
	}

}
