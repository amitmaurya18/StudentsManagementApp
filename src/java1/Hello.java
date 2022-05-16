package java1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hello {

	public static void main(String[] args)throws IOException {
		System.out.println("Welcome to Students Management App....");
		System.out.println("      ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 to ADD Student");
			System.out.println("PRESS 2 to Delete Student");
			System.out.println("PRESS 3 to Display Student");
			System.out.println("PRESS 4 to Update Student details");
			System.out.println("PRESS 5 to Exit App");
			int c= Integer.parseInt(br.readLine());
			
			if(c==1) {
				//add student
				System.out.println("Enter user name: ");
				String name= br.readLine();
				
				System.out.println("Enter user phone number: ");
				String phone= br.readLine();
				
				System.out.println("Enter user city: ");
				String city= br.readLine();
				
				//create student object to store student
				Students st= new Students(name, phone,city);
				boolean answer=StudentDao.insertStudenttoDB(st);
				if (answer) {
					System.out.println("Students is added successfully...");
				}
				else {
					System.out.println("Something went wrong try again...");
				}
				System.out.println(st);
				}
			else if(c==2) {
				// delete student
				System.out.println("Enter Student id to delete");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudents(userId);
				if(f) {
					System.out.println("Successfully Deleted...");
				}
				else {
					System.out.println("Something went wrong...");
				}
			}
			else if(c==3) {
				// display student
				boolean f=StudentDao.showAllStudent();
			}
			else if(c==4) {
				
				System.out.println("PRESS 1 to UPDATE name");
				System.out.println("PRESS 2 to UPDATE phone");
				System.out.println("PRESS 3 to UPDATE city");
				int val = Integer.parseInt(br.readLine());
				if(val == 1) {
					//Update Name
					System.out.println("Enter name to UPDATE...");
					String name = br.readLine();
					System.out.println("Enter ID to identify student!");
					int id = Integer.parseInt(br.readLine());
					Students st = new Students();
					st.setStudentName(name);
					boolean f = StudentDao.updateStudentRecord(val,name,id,st);
					if(f) {
						System.out.println("Student Name Updated Successfully...");
					}else {
						System.out.println("Something Went Wrong Please try Again!");
					}
				}
				else if(val == 2) {
					//Update Phone
					System.out.println("Enter phone to UPDATE...");
					String phone = br.readLine();
					System.out.println("Enter ID to identify student!");
					int id = Integer.parseInt(br.readLine());
					Students st = new Students();
					st.setStudentPhone(phone);
					boolean f = StudentDao.updateStudentRecord(val,phone,id,st);
					if(f) {
						System.out.println("Student Phone Updated Successfully...");
					}else {
						System.out.println("Something Went Wrong Please try Again!");
					}
				}
				else if(val == 3) {
					//Update city
					System.out.println("Enter city to UPDATE...");
					String city = br.readLine();
					System.out.println("Enter ID to identify student!");
					int id = Integer.parseInt(br.readLine());
					Students st = new Students();
					st.setStudentCity(city);
					boolean f = StudentDao.updateStudentRecord(val,city,id,st);
					if(f) {
						System.out.println("Student City Updated Successfully...");
					}else {
						System.out.println("Something Went Wrong Please try Again!");
					}
				}
				else {
					System.out.println("Hey You have not updated Anything... Please choose option Correctly!");
				}
				
			}
			else if(c==5) {
				//exit
				break;
			}
			else {
				
			}
		}
		System.out.println("Thankyou for using my App");
	}
}

