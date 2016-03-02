/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class UserRecord implements java.io.Serializable
{
    public String Username;
    public String Notes;
    public int operation;
    
    public UserRecord(String U,String N, int O)
    {
        Username = U ;
        Notes = N;
        operation = O;
    }
    
    
    public String getUser()
    {
        return Username;
    }
    
    public String getNotes()
    {
        return Notes;
    }
    
}
