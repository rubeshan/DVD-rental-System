/*
 * index.java
 * 
 * This file is the main file; it contains the main menu
 * of the program. 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class index {
	
	public static String UniCommand[] = {"login", "rent", "return", "create", "add", "remove", "sell", "buy", "logout"};
	public static String AdmCommand[] = {"rent", "return", "create", "add", "remove", "sell", "buy", "logout"};
	public static String StdCommand[] = {"rent", "return", "buy", "logout"};
	public static String Sessions[]   = {"admin", "standard"};
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String pInput;
	
	
	public index(){		
	}
	/*
	 * Method Name : main()
	 * 
	 * This is the main method. when the program starts, it will start with
	 * this method. there is a while loop which takes the inputs. it is connected 
	 * with the pInput method.
	 * 
	 */
	
	public static void main(String args[]){
	 	System.out.println("Welcome to DVD rental System 2");
		System.out.println("PLease enter a command");
		pInput ="";		
		
			while(pInput != "logout"){				
				pInput(pInput);							
			}					
	}
	/*
	 * Method  Name: pInput()
	 * 
	 * This function takes the primary inputs such as rent, login, logout...
	 * This function will then return the string value. that value then 
	 * will be put into the input checker function.
	 * 
	 */
	
	public static String pInput(String pInput){		
		try {								
			pInput = br.readLine();				
			pInputChecker(pInput);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		return pInput;
	}	
	
	/*
	 * Method Name : pInputChecker()
	 * 
	 * This function will check the user inputs and then
	 * direct the user to the correct place as required.
	 * User will be able to enter the inputs in loop until
	 * they enter the correct input. this loop is placed
	 * in the main method above. 
	 * 
	 */
	
	public static void pInputChecker(String pInput){
		
			  if(pInput.equalsIgnoreCase("LOGIN")){
		    	Login login = new Login();
		}else if(pInput.equalsIgnoreCase("RENT")){
				
		}else if(pInput.equalsIgnoreCase("return")){
				
		}else if(pInput.equalsIgnoreCase("create")){
				
		}else if(pInput.equalsIgnoreCase("add")){
				
		}else if(pInput.equalsIgnoreCase("remove")){
				
		}else if(pInput.equalsIgnoreCase("sell")){
				
		}else if(pInput.equalsIgnoreCase("buy")){
				
		}else if(pInput.equalsIgnoreCase("logout")){
						
		}else{
			System.out.println("Command Entered was :"+pInput+" And its invalid.");
		}	
}	
}
