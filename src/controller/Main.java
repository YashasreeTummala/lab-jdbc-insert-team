
package controller;

import java.sql.Connection;
import java.util.Scanner;

import dao.CityDAO;
import dao.TeamDAO;
import model.City;
import model.Team;
import utility.ConnectionManager;

public class Main 
{
	public static void main(String args[]) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		
		TeamDAO tdao = new TeamDAO();
		CityDAO cdao = new CityDAO(); 
		
		Connection con = null;
		con = ConnectionManager.getConnection();
		
		System.out.println("1.insert \n2.check ");
		int check = sc.nextInt();
		switch(check)
		{
		case 1: System.out.println("Enter details to store/insert into database");
		
				System.out.println("Enter Name:");
				String name = sc.next();
				System.out.println("Enter Coach:");
				String coach = sc.next();
				System.out.println("Enter Captain:");
				String captain = sc.next();
				System.out.println("Enter CityId:");
				long cityId = sc.nextLong();
				System.out.println("Enter CityName:");
				String cityName = sc.next();
				
				City city = new City (cityId, cityName);
				Team team = new Team (name, coach, captain, city);
				
				tdao.createTeam(team);
				System.out.println("Values Inserted");
				break;
		case 2: System.out.println("Enter City Name");
				String search = sc.next();
				City x = cdao.getCityByName(search);
				
				//System.out.println("City Id: " + x.getCityId());
				//System.out.println("City Name: " + x.getCityName());
		}
		
		sc.close();
		con.close();
		
	}
}
