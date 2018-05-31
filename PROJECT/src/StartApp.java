//IMPORTS------------------------------------------------------------------------------------------------------------

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;


public class StartApp {
//FIELDS------------------------------------------------------------------------------------------------------------

//customizable variables																		//find a way to get these inputs without changing code
	public static String filepath = "H:/SOFTWAREENGINEERINGPROJECT/phslogo.png";
	public static Color logocolor = Color.getHSBColor((float)0.12, (float)0.74, (float)1.0);
	//import existing excel file
	//teacher names + emails list
	public static String studentInfoFilePath = "O:/Estep/studentsSchedule2018.mer";
	//list of reasons - guiscreen class

//other
	public static GUIScreen g;
	
//data logging info
	public static String ID = "";
	public static String FIRST = "";															//find a way to get name (not here)
	public static String LAST = "";
	public static String REASON = "";
	public static String TEACHER = "";
	public static String COUNSELOR = "";
	

//MAIN----------------------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) { 
		g = new GUIScreen(filepath, logocolor);	
		File studentInfo = new File("O:/Estep/studentsSchedule2018.mer");
		
		//add other textfile parameters
		listenForActions(g);
		g.setVisible(true);
	}
	
//METHODS--------------------------------------------------------------------------------------------------------------------

	public static void listenForActions(GUIScreen g) {
		g.cont.addActionListener((ActionListener) g);
		g.inputID.addActionListener((ActionListener) g);
		g.inputReason.addActionListener((ActionListener) g);
		
		g.cancel.addActionListener((ActionListener) g);
		
		g.finish.addActionListener((ActionListener) g);
		g.enterTeacher.addActionListener((ActionListener) g);
		g.enterCounselor.addActionListener((ActionListener) g);
	}
	
	public static void addExcelEntry() {
		System.out.println("excel entry completed! " + ID + REASON);
		//String insert = "INSERT INTO sheet1(First, Last, ID, Teacher, Councelor, Reason, House, Grade) VALUES(";
		//String data = "'" + FIRST + "'" + "," +"'" + LAST+ "'" +  "," + "'" + ID + "'"+ ","+ "'" + TEACHER + "'"+ ","+ "'" + COUNSELOR + "'"+ ","+ "'" + REASON + "'"+ "," + "'" + HOUSE + "'"+ "," + "'" + GRADE + "'";
		//String strQuery = insert + data + ")";
		//connection.executeUpdate(strQuery);
		//connection.close();
	}

	public static void sendEmail() {
		System.out.println("email sent! " + ID + REASON);
	}

}

