package Main;

import java.util.*;
import java.sql.SQLException;

import Bean.grocery_bean;
import Connections.DBUtil;
import Insertions.DAO;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		grocery_bean gb = new grocery_bean();
		DAO da = new DAO();
		
		Scanner sc = new Scanner(System.in);
	
		while(true) {
			
			System.out.println("Enter your respective operation ");
			System.out.println("1. insertion");
			System.out.println("2.Display the list");
			System.out.println("3.Total cost of items");
			
			int x = sc.nextInt();
			
			switch(x){
			case 1: 
				System.out.println("Enter your item id-- ");
				int id = sc.nextInt();
				gb.setItem_id(id);
				System.out.println("Enter your item name-- ");
				String name = sc.next();
				gb.setName(name);
				System.out.println("Enter your item cost-- ");
				int cost = sc.nextInt();
				gb.setCost(cost);
				int a = da.itemInsert(gb);
				if (a > 0) {
					System.out.println("Insertion sucessfull !!!");
				} else {
					System.out.println("Insertion failed !!!");
				}
				break;
			case 2:
				da.itemDisplay(gb);
				System.out.println("-------------------");
				break;
				
			case 3: 
				da.totalCost(gb);
				break;
			}
			
		}
	}

}
