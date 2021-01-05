package com.example.android.dbsample;

public class Logins {
    public int ID;
    public String Username;
    public String Password;
    //for login details
    Logins( int ID, String userName,String password)
    {
        this.ID = ID;
        this.Username = userName;
        this.Password = password;
    }
}
