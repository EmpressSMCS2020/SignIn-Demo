//IMPORTS-----------------------------------------------------------------------------------------------------------------------------
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.io.File;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("serial")
public class GUIScreen extends JFrame implements ActionListener{
	
//FIELDS------------------------------------------------------------------------------------------------------------------------------
	public String filepath;
	public Color logocolor;
	//public File teacherNamesAndEmails;
	//public File studentIDsNamesTeachers
	//public String reasonsList
	//public File data
	
	public final static JPanel s1 = new JPanel(new GridBagLayout());
	public static JLabel logolabel;
	
	public final static JPanel s2 = new JPanel(new GridBagLayout());
	public final static JLabel askID = new JLabel("PLEASE ENTER YOUR STUDENT ID:");
	public final static JLabel confirm  = new JLabel("PLEASE CONFIRM THE FOLLOWING INFORMATION:");
	
	public final static JPanel s3 = new JPanel(new GridBagLayout());
	public JTextField inputID  = new JTextField(10);
	
	public final static JPanel s4 = new JPanel(new GridBagLayout());
	public final static JLabel askReason = new JLabel("PLEASE SELECT YOUR REASON FOR VISITING:");
	
	public final static JPanel s5 = new JPanel(new GridBagLayout());
	public JComboBox<String> inputReason  = new JComboBox<String>(); 																		
	
	public final static JPanel s6 = new JPanel(new GridBagLayout());
	public final JButton cont  = new JButton("CONTINUE");
	public final JButton finish  = new JButton("FINISH");
	
	public final static JPanel p2 = new JPanel(new GridBagLayout());
	public final static JLabel askTeacher  = new JLabel("TEACHER THIS PERIOD:");
	
	public final static JPanel p3 = new JPanel(new GridBagLayout());
	public JComboBox<String> enterTeacher  = new JComboBox<String>(); 																		
	
	public final static JPanel p4 = new JPanel(new GridBagLayout());
	public final static JLabel askCounselor  = new JLabel("YOUR COUNSELOR:");
	
	public final static JPanel p5 = new JPanel(new GridBagLayout());
	public JComboBox<String> enterCounselor  = new JComboBox<String>(); 																
	
	public final static JPanel p6 = new JPanel(new GridBagLayout());
	public static JLabel fullName = new JLabel("");
	
	public final static JPanel p7 = new JPanel(new GridBagLayout());
	public final JButton cancel  = new JButton("");
	
	public static GridBagConstraints c;
	
//(SCREEN ONE) CONSTRUCTOR--------------------------------------------------------------------------------------------------------------------------
	
	public GUIScreen(String f, Color co) {
		filepath = f;
		logocolor = co;
		initializeFrame();
		initializePanels();
		initializeScreenOneComponents();
		initializeScreenTwoComponents();
	}

//METHODS-----------------------------------------------------------------------------------------------------------------------------------------
	
	private void initializeFrame() {
		setTitle("Poolesville High School - Counseling Office Sign In (1/2)");
		setSize(1000,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
	}

	private void initializeScreenTwoComponents() {
		confirm.setFont(new Font("Arial",Font.PLAIN, 15));
		s2.add(confirm);
		confirm.setVisible(false);
		
		askTeacher.setFont(new Font("Arial",Font.PLAIN,15));
		p2.add(askTeacher);
		askTeacher.setVisible(false);
		
		//for (teacher t : teacherlist){
		//	enterTeacher.addItem(t);
		//}
		
		enterTeacher.setFont(new Font("Arial",Font.PLAIN,15));
		enterTeacher.addItem("Teacher 1");									//change for text file with teachers
		enterTeacher.addItem("Teacher 2");
		enterTeacher.addItem("Teacher 3");
		
		ArrayList<String> teachersList = new ArrayList<>();
		for(String r : teachersList){
			enterTeacher.addItem(r);
		}
		
		p3.add(enterTeacher);
		enterTeacher.setVisible(false);
		
		askCounselor.setFont(new Font("Arial",Font.PLAIN,15));
		p4.add(askCounselor);
		askCounselor.setVisible(false);
		
		//for (teacher t : teacherlist){
		//	enterTeacher.addItem(t);
		//}
		
		enterCounselor.setFont(new Font("Arial",Font.PLAIN,15));
		enterCounselor.addItem("Counselor 1");								//change for text file with counselors
		enterCounselor.addItem("Counselor 2");
		enterCounselor.addItem("Counselor 3");
		p5.add(enterCounselor);
		
		enterCounselor.setVisible(false);
		p6.add(fullName);
	}

	private void initializeScreenOneComponents() {
		try {               
			BufferedImage LOGO = ImageIO.read(new File(filepath));
			JLabel logolabel = new JLabel(new ImageIcon(LOGO));
							
			s1.add(logolabel);
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		askID.setFont(new Font("Arial", Font.PLAIN, 15));
		s2.add(askID);
		inputID.setFont(new Font("Arial", Font.PLAIN, 20));
		s3.add(inputID);
		askReason.setFont(new Font("Arial", Font.PLAIN, 15));
		s4.add(askReason);
		
		ArrayList<String> reasonsList = new ArrayList<>(Arrays.asList("Scheduling", "Academic Planning", "Personal/Social/Emotional",
				"College and Career Information", "Pass Received"));
		for(String r : reasonsList){
			inputReason.addItem(r);
		}
		inputReason.setFont(new Font("Arial",Font.PLAIN,15));
		s5.add(inputReason);
		
		cont.setFont(new Font("Arial", Font.PLAIN, 20));
		cont.setBackground(Color.getHSBColor((float)0.4, (float)0.9, (float)0.8));
		s6.add(cont);
		
		cancel.setFont(new Font("Arial", Font.PLAIN, 20));
		cancel.setText("CLEAR");
		cancel.setBackground(Color.getHSBColor((float)0.05, (float)0.9, (float)0.8));
		p7.add(cancel);
		
		finish.setFont(new Font("Arial", Font.PLAIN, 20));
		finish.setVisible(false);
	}

	private void initializePanels() {
		c = new GridBagConstraints(0, 0, 10, 16, 0.5, 0.5, GridBagConstraints.NORTHWEST,
				GridBagConstraints.BOTH, new Insets(0,0,0,0), 0, 0);
		
		s1.setBackground(logocolor);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 10;
		c.gridheight = 2;
		add(s1, c);
		
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 4;
		c.gridheight = 1;
		add(s2, c);
		
		c.gridx = 3;
		c.gridy = 5;
		c.gridwidth = 4;
		c.gridheight = 1;
		add(s3, c);
		
		c.gridx = 3;
		c.gridy = 9;
		c.gridwidth = 4;
		c.gridheight = 1;
		add(s4, c);

		c.gridx = 3;
		c.gridy = 10;
		c.gridwidth = 4;
		c.gridheight = 1;
		add(s5, c);
		
		c.gridx = 7;
		c.gridy = 12;
		c.gridwidth = 2;
		c.gridheight = 2;
		add(s6, c);
		
		c.gridx = 2;
		c.gridy = 7;
		c.gridwidth = 3;
		c.gridheight = 1;
		add(p2, c);
		
		c.gridx = 2;
		c.gridy = 8;
		c.gridwidth = 3;
		c.gridheight = 1;
		add(p3, c);
		
		c.gridx = 6;
		c.gridy = 7;
		c.gridwidth = 3;
		c.gridheight = 1;
		add(p4, c);
		
		c.gridx = 6;
		c.gridy = 8;
		c.gridwidth = 3;
		c.gridheight = 1;
		add(p5, c);
		
		c.gridx = 4;
		c.gridy = 14;
		c.gridwidth = 2;
		c.gridheight = 2;
		add(p6, c);
		
		c.gridx = 1;
		c.gridy = 12;
		c.gridwidth = 2;
		c.gridheight = 2;
		add(p7, c);
	
	}

	
	public void switchScreens(String getname) {
		setTitle("Poolesville High School - Counseling Office Sign In (2/2)");
		
		askID.setVisible(false);
		confirm.setVisible(true);
		inputID.setVisible(false);
		askReason.setVisible(false);
		inputReason.setVisible(false);
		cont.setVisible(false);
		
		cancel.setText("CANCEL");
		
		finish.setBackground(Color.getHSBColor((float)0.4, (float)0.9, (float)0.8));
		s6.add(finish);
		finish.setVisible(true);
		
		askTeacher.setVisible(true);
		enterTeacher.setVisible(true);
		askCounselor.setVisible(true);
		enterCounselor.setVisible(true);
		fullName.setText(getname);
		fullName.setFont(new Font("Arial", Font.ITALIC, 15));
		fullName.setVisible(true);
	}

	public void switchBack() {
		
		setTitle("Poolesville High School - Counseling Office Sign In (1/2)");
		StartApp.ID = "";
    	StartApp.REASON = "";
    	StartApp.TEACHER = "";
    	StartApp.COUNSELOR = "";
    	inputID.setText("");
		inputReason.setSelectedIndex(0);												//use this to set automatic teacher and counselor *
		enterTeacher.setSelectedIndex(0);
		enterCounselor.setSelectedIndex(0);
    	
    	confirm.setVisible(false);
    	askTeacher.setVisible(false);	
		enterTeacher.setVisible(false);
		askCounselor.setVisible(false);		
		enterCounselor.setVisible(false);
		fullName.setText("");
		fullName.setVisible(false);
		
    	askID.setVisible(true);
		inputID.setText("");
		inputID.setVisible(true);
				
		askReason.setVisible(true);
		inputReason.setVisible(true);
		
		cont.setBackground(Color.getHSBColor((float)0.4, (float)0.9, (float)0.8));
		cont.setVisible(true);
		finish.setVisible(false);
		cancel.setText("CLEAR");
	}




	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==cont) {
			StartApp.ID = inputID.getText();
			StartApp.REASON = String.valueOf(inputReason.getSelectedItem());
			String getname = "fullnameversionof:" + (StartApp.ID); 									//change this to get actual name from file
	    	switchScreens(getname);
		}
		
		else if(e.getSource()==cancel) {
			if(cancel.getText()=="CANCEL") {
				switchBack();
			}
			else if(cancel.getText()=="CLEAR") {
				inputID.setText("");
				inputReason.setSelectedIndex(0);												//use this to set automatic teacher and counselor *
			}
		}
		
		else if(e.getSource()==finish) {
			StartApp.TEACHER = String.valueOf(enterTeacher.getSelectedItem());
			StartApp.COUNSELOR = String.valueOf(enterCounselor.getSelectedItem());
			StartApp.addExcelEntry();
	    	StartApp.sendEmail();
	    	switchBack();
		}
		
	}
	
}


















