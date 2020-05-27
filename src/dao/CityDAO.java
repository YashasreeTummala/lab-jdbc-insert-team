package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.City;
import utility.ConnectionManager;

public class CityDAO
{
	public City getCityByName(String name) throws Exception
	{
		 City city = null;
		 Connection con = ConnectionManager.getConnection();
		 
		 Statement stmt = con.createStatement();
		 
		 ResultSet rs = stmt.executeQuery("SELECT * FROM KABADDI");
		 System.out.println("Result SET values" + rs);
		 
		 while(rs.next())
		 {
			 if(name.equals(rs.getString(5)))
			 {
				 System.out.println("Name: " + rs.getString("NAME"));
				 System.out.println("Coach: " + rs.getString("COACH"));
				 System.out.println("Captain: " + rs.getString("CAPTAIN"));
				 System.out.println("City Id: " + rs.getLong("CITYID"));
				 System.out.println("City Name: " + rs.getString("CITYNAME"));
				 long cityId = rs.getLong("CITYID");
				 String cityName = rs.getString("CITYNAME");
				 city = new City(cityId, cityName);
			 }
		 }
		 
		 return city;
	}
}

