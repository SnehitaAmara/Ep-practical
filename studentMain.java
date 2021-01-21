package Main;

import java.util.*;
import java.sql.SQLException;

import Bean.studentBean;
import Insertions.studentInsertions;

public class studentMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		studentBean sb = new studentBean();
		
		studentInsertions si = new studentInsertions();
		
		while (true) {
			System.out.println("enter your option for the CRUD operations");
			System.out.println("1.INSERTION");
			System.out.println("2.DELETION");
			System.out.println("3.UPDATION");
			System.out.println("4.DISPLAY");
			System.out.println("enter your choice");
			int x = sc.nextInt();

			switch (x) {
			case 1:
				System.out.println("Values for insertion\n");
				System.out.println("Enter Id");
				int id = sc.nextInt();
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter Mailid");
				String email = sc.next();
				sb.setRegno(id);
				sb.setName(name);
				sb.setEmail(email);

				int a = si.studentInsert(sb);
				if (a > 0) {
					System.out.println("Insertion sucessful !!!");
				} else {
					System.out.println("Insertion failed !!!");
				}
				break;

			case 2:
				System.out.println("Enter Id for deletion");
				int regno = sc.nextInt();
				sb.setRegno(regno);
				int b = si.studentDelete(sb);
				if (b > 0) {
					System.out.println("Deletion sucessful !!!");
				} else {
					System.out.println("Deletion failed !!!");
				}

				break;
			case 3:
				System.out.println("Enter Id for updation");
				int id1 = sc.nextInt();
				sb.setRegno(id1);
				System.out.println("Enter Name for updation");
				String name_update = sc.next();
				sb.setName(name_update);
				int a1 = si.studentUpdate(sb);
				if (a1 > 0) {
					System.out.println("updation sucessful !!!");
				} else {
					System.out.println("updation failed !!!");
				}
				break;
			case 4:
				si.studentDisplay(sb);
				break;

			}
		}
	}

}
