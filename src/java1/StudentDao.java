package java1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudenttoDB(Students st){
		
		boolean f=false;
		//jdbc code...
		try {
			Connection con=Connectionprovider.createC();
			String q="insert into students(sname,sphone,scity) values(?,?,?)";
			//PreaparedStatement
			PreparedStatement pstmt=con.prepareStatement(q);
			//set the value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute the query
			pstmt.executeUpdate();
			f=true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudents(int userId) {
		// TODO Auto-generated method stub
		boolean f=false;
		//jdbc code...
		try {
			Connection con=Connectionprovider.createC();
			String q="delete from students where sid=?";
			//PreaparedStatement
			PreparedStatement pstmt=con.prepareStatement(q);
			//set the value of parameter
			pstmt.setInt(1, userId);
			
			//execute the query
			pstmt.executeUpdate();
			f=true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean showAllStudent() {
		// TODO Auto-generated method stub
		boolean f=false;
		//jdbc code...
		try {
			Connection con=Connectionprovider.createC();
			String q="select * from students";
			Statement stmt= con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString(4);
				
				System.out.println("ID: "+id);
				System.out.println("Name: "+name);
				System.out.println("Phone: "+phone);
				System.out.println("City: "+city);
				System.out.println("                       ");
			}
			f=true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean updateStudentRecord(int val,String toUpdate,int id,Students st) {
		// TODO Auto-generated method stub
		boolean f = false;
		
		try {
			  Connection con = Connectionprovider.createC();
			 if(val == 1) {
					//Update Name
					
						String query = "update students set sname=? where sid=?";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, toUpdate);
						pstmt.setInt(2, id);
						
						//execute..
						pstmt.executeUpdate();
						f = true;
				}
				else if(val == 2) {
					//Update Phone
					String query = "update students set sphone=? where sid=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, toUpdate);
					pstmt.setInt(2, id);
					
					//execute..
					pstmt.executeUpdate();
					f = true;
				}
				else if(val == 3) {
					//Update City
					String query = "update students set scity=? where sid=?";
					PreparedStatement pstmt = con.prepareStatement(query);
					pstmt.setString(1, toUpdate);
					pstmt.setInt(2, id);
					
					pstmt.executeUpdate();
					f = true;
				}
				else {
					
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return f;
	}

}
