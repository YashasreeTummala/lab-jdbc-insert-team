package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.City;
import model.Team;
import utility.ConnectionManager;

public class TeamDAO
{
	 public void createTeam(Team team) throws Exception
	 {
		 Connection con = ConnectionManager.getConnection();
		 
		 String sql = "INSERT INTO KABADDI (NAME, COACH, CAPTAIN, CITYID, CITYNAME) VALUES(?,?,?,?,?)";
		 PreparedStatement stmt = con.prepareStatement(sql);
		
		 String name = team.getName();
		 String coach = team.getCoach();
		 String captain = team.getCaptain();
		 
		 City city = team.getCity(); //COPYING getCity() values to City Object
		 
		 long cityId = city.getCityId();
		 String cityName = city.getCityName();
		 
		 stmt.setString(1, name);
		 stmt.setString(2, coach);
		 stmt.setString(3, captain);
		 stmt.setLong(4, cityId);
		 stmt.setString(5, cityName);
		 
		 stmt.executeUpdate();
		 con.close();
	 }
}


