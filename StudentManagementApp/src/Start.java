import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.Studentdao;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("welcome to student management system");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to ADD student");
			System.out.println("Press 2 to DELETE student");
			System.out.println("Press 3 to Display student");
			System.out.println("Press 4 to EXIT");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				// add student
				System.out.println("Enter user name :");
				String name = br.readLine();
				
				System.out.println("Enter user number :");
				String phone = br.readLine();
				
				System.out.println("Enter user city :");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name,phone,city);
				 boolean answer = Studentdao.insertStudentToDB(st);
				 if(answer) {
					 System.out.println("Student is added successfully...");
				 } else {
					 System.out.println("Something went wrong try again...");
				 }
				System.out.println(st);
			} else if(c==2) {
				//delete student
				System.out.println("Enter the student id..");
				int userId = Integer.parseInt(br.readLine());
				boolean f = Studentdao.deleteStudent(userId);
				if(f) {
					System.out.println("deleted successfully..");
				} else {
					System.out.println("something went wrong...2");
				}
			} else if(c==3) {
				//display student
				Studentdao.showAllStudent();
			} else if(c==4) {
				//exit
				break;
			} else {
				
			}
		}
		System.out.println("Thank u for using this application");
		System.out.println("see u soon ...");
				
	}

}
