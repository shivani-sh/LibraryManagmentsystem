package com.dz.Model.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * In this we done all operation
 */
public class LibraryOperation
{
    private DBconfig dBconfig;
    private Connection connection;
    private PreparedStatement statement=null;

    public void Addbook()
    {
        dBconfig=new DBconfig();
           connection=dBconfig. getconnection();


    }



}
