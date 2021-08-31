package simplilearn.lockme.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import simplilearn.lockme.model.UserCredentials;
import simplilearn.lockme.model.Users;

public class Authentication {
	
	//input data
	private static Scanner keyboard;
	private static Scanner input;
	private static Scanner lockerInput;
	
	//output data 
	private static PrintWriter output;
	private static PrintWriter lockerOutput;
	
	//model to store data.
	private static Users users;
	private static UserCredentials userCredentials;
	
	
	public static void main(String[] args) {
		initApp();
		welcomeScreen();
		signInOptions();

	}
	public static void signInOptions() {
		System.out.println("1 . Registration ");
		System.out.println("2 . Login ");
		System.out.println("3 . Exit");
		int option = keyboard.nextInt();
		switch(option) {
			case 1 : 
				registerUser();
				break;
			case 2 :
				loginUser();
				break;
			case 3:
				 System.exit(0);
				break;
			default :
				System.out.println("Please select 1, 2 or 3");
				break;
		} 
		keyboard.close();
		input.close();
	}

	private Scanner sc;
	private File f;
	
	public void Main_menu() {
	
	System.out.println(" 1. Add a File");
    System.out.println(" 2. Delete a file");
    System.out.println(" 3. Search a file");
    System.out.println(" 4. Go Back");
    System.out.println("Enter Your Choice:");
    int num = sc.nextInt(); 
    
    switch(num){    
    case 1: System.out.println("Adding a File"); 
            Add_File(); 
            break;  
    case 2: System.out.println("Deleting a File");  
            Delete_File();
            break;  
    case 3: System.out.println("Searching a File");  
            Search_File();
            break; 
    case 4: System.out.println("Go Back");  
            Main_menu();
            break; 
    
    default: System.out.println("Please select from 1 to 4 option");  
             Main_menu();
    }
  }
	 
	  
  void Add_File() {
 	 
 	 System.out.println("Please Enter File Name you want to add:");
 	 try {
 		 
 	 String ad=sc.next();
 	 String[] s=f.list();
 	 File file = new File("C:\\Users\\Mansimran Kaur\\Documents\\"+ ad);
 	 boolean result;   
 		 result = file.createNewFile(); 
 	 if(result)   
 	 {  
 	 System.out.println("file"+ ad+ " Added to : "+file.getCanonicalPath()); 
 	 }  
 	 else  
 	 {  
 	 System.out.println("File already exist at location: "+file.getCanonicalPath());  
 	 } 
 	  	 Main_menu();
 	 }
 	 catch(Exception e)
 	 {
 		 e.printStackTrace();
 	 }
 	 
  }
  void Delete_File()  {
 	
 	 try{
 		   File Mainpath= f.getCanonicalFile();
 		   String ad=sc.next().trim();
 		    File filepath = new File(Mainpath +"/"+ad);
 	        String[] list = Mainpath.list();
 	        for (String file: list) {
 	            if (ad.equals(file) && filepath.delete()) {
 	                System.out.println("File " + ad + " deleted from " + Mainpath);
 	                Main_menu();
 	            }
 	        }
 	        System.out.println("Delete Operation failed. FILE NOT FOUND");
 	        Main_menu();
      }
      catch(Exception e)
 	 {
 		 e.printStackTrace(); 
 	 }
  }
  void Search_File() {
 	 try {
 	 
 	 System.out.println("Please Enter File Name you want to Search:");
 	 String ad=sc.next().trim();
 	 File filepath = new File(Mainpath +"/"+ad);
 	 String[] list = Mainpath.list();
      for (String file: list) {
          if (ad.equals(file)) {
              System.out.println("FOUND : File " + ad + " exists at " + Mainpath);
              Main_menu();
          }
      }
      System.out.println("File NOT found ");
      Main_menu();
 	 }
 	 catch(Exception e)
 	 {
 		 e.printStackTrace(); 
 	 }
  }
  void Exit() {
 	    
     System.out.println("Thank you"); 
     Exit();       
  }
	
	
	
	
	public static void lockerOptions(String inpUsername) {
		System.out.println("1 . FETCH ALL STORED CREDENTIALS ");
		System.out.println("2 . STORED CREDENTIALS ");
		int option = keyboard.nextInt();
		switch(option) {
			case 1 : 
				fetchCredentials(inpUsername);
				break;
			case 2 :
				storeCredentials(inpUsername);
				break;
			default :
				System.out.println("Please select 1 Or 2");
				break;
		}
		lockerInput.close();
	}
	
	public static void registerUser() {
		System.out.println("*********************************************************");
		System.out.println("*                                                       *");
		System.out.println("*             WELCOME TO REGISTRATION PAGE              *");
		System.out.println("*                                                       *");
		System.out.println("*********************************************************");
		
		System.out.println("Enter Username :");
		String username = keyboard.next();
		users.setUsername(username);
		
		System.out.println("Enter Password :");
		String password = keyboard.next();
		users.setPassword(password);
		
		output.println(users.getUsername());
		output.println(users.getPassword());
		
		System.out.println("User Registration Suscessful !");
		output.close();
		
	}
	public static void loginUser() {
		System.out.println();
		System.out.println("*********************************************************");
		System.out.println("*                                                       *");
		System.out.println("*              WELCOME TO LOGIN PAGE                    *");
		System.out.println("*                                                       *");
		System.out.println("*********************************************************");
		System.out.println("Enter Username :");
		String inpUsername = keyboard.next();
		boolean found = false;
		while(input.hasNext() && !found) {
			if(input.next().equals(inpUsername)) {
				System.out.println("Enter Password :");
				String inpPassword = keyboard.next();
				if(input.next().equals(inpPassword)) {
					System.out.println("Login Successful !");
					found = true;
					lockerOptions(inpUsername);
					break;
				}
			}
		}
		if(!found) {
			System.out.println("User Not Found Login Failure ");
		}
		
	}
	
	public static void welcomeScreen() {
		System.out.println();
		System.out.println("*********************************************************");
		System.out.println("*        Welcome to the Locked Me Application!          *");
		System.out.println("*                                                       *");
		System.out.println("*             Developer : Shamal Indurkar               *");
		System.out.println("*********************************************************");
		
	}
	//store credentials
	public static void storeCredentials(String loggedInUser) {
		System.out.println("*********************************************************");
		System.out.println("*                                                       *");
		System.out.println("*    WELCOME TO DIGITAL LOCKER STORE YOUR CREDS HERE    *");
		System.out.println("*                                                       *");
		System.out.println("*********************************************************");
		
		userCredentials.setLoggedInUser(loggedInUser);
		
		System.out.println("Enter Site Name :");
		String siteName = keyboard.next();
		userCredentials.setSiteName(siteName);
		
		System.out.println("Enter Username :");
		String username = keyboard.next();
		userCredentials.setUsername(username);
		
		System.out.println("Enter Password :");
		String password = keyboard.next();
		userCredentials.setPassword(password);
		
		lockerOutput.println(userCredentials.getLoggedInUser());
		lockerOutput.println(userCredentials.getSiteName());
		lockerOutput.println(userCredentials.getUsername());
		lockerOutput.println(userCredentials.getPassword());
		
		System.out.println("YOUR CREDENTIAL ARE STORED AND SECURED!");
		lockerOutput.close();		
	}
	
	//fetch credentials
	public static void fetchCredentials(String inpUsername) {
		System.out.println("*********************************************************");
		System.out.println("*                                                       *");
		System.out.println("*              WELCOME TO DIGITAL LOCKER                *");
		System.out.println("*                 YOUR CREDENTIALS ARE                      *");
		System.out.println("*                                                       *");
		System.out.println("*********************************************************");
		System.out.println(inpUsername);
		
		
		while(lockerInput.hasNext()) {
//			System.out.println(lockerInput.hasNext());
			if(lockerInput.next().equals(inpUsername)) {
				System.out.println("Site Name: "+lockerInput.next());
				System.out.println("User Name: "+lockerInput.next());
				System.out.println("User Password: "+lockerInput.next());
			}
		}
		
	}
	
	public static void initApp() {

		File  dbFile = new File("database.txt");
		File  lockerFile = new File("locker-file.txt");
		
		try {
			//read data from database file
			input = new Scanner(dbFile);
			
			//red data from locker file
			lockerInput = new Scanner(lockerFile);
			
			//read data from keyboard
			keyboard = new Scanner(System.in);
			
			//out put 
			output = new PrintWriter( new FileWriter(dbFile,true));
			lockerOutput = new PrintWriter( new FileWriter(lockerFile,true));
			
			users = new Users();
			userCredentials  = new UserCredentials();
			
			
		} catch (IOException e) {
			System.out.println(" File Not Found ");
		}
		
	}
	

}
