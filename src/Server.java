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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 *
 */
public class Server {


	public static void main(String[] args)
	{
		ServerSocket listener = null;
		try{
			ArrayList<UserRecord> list = new ArrayList<UserRecord>();
			listener = new ServerSocket(8001);
			while(true)
			{
				Socket socket = listener.accept();
				ObjectOutputStream  OutClient = new ObjectOutputStream (socket.getOutputStream());
				ObjectInputStream inClient = new ObjectInputStream(socket.getInputStream());
				UserRecord newRec;
				newRec = (UserRecord)inClient.readObject();

				if(newRec.operation == 1){
					list.add(newRec);
					System.out.println("Server Got: ");
					System.out.println("User: " + newRec.Username);
					System.out.println("Notes: " + newRec.Notes);
				}
				else
				{
					for(int i = 0; i < list.size();i++)
					{
						if(list.get(i).Username.equals(newRec.Username))
						{
							OutClient.writeObject(list.get(i));
						}
						else {
							System.out.println("User Not Found!");
						}
					}


				}




			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}


	}

}
