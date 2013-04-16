import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Login.java
 */
public class Login {
	private static String CIN;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public Login(){
		
		functions.inputs.add("login");
		CIN="login";
		 boolean success = loginCheck();
		if(success){
			System.out.println("Login command Successful");
			ChooseSession();
		}else{
			System.out.println("login FAILED");
		}	
		
	}
	/*
	 * Method name : loginCheck();
	 * 
	 * This method will check if the user is logged into the system or not
	 * if the user tries to enter valid commands without logging in such as rent or add,
	 * method will will return messages. this will also ensure that user does not login
	 * twice. 
	 */
	public static boolean loginCheck(){
		System.out.println("The vlaue of CIN is :"+CIN);
		int c = functions.inputs.size();
		if(c==1){
			if(functions.inputs.contains("login")){
				return true;
			}else{
				System.out.print("I See that you are trying to "+CIN+" something but, ");
				System.out.println("You can only enter the command : login");
				functions.inputs.remove(0);
				return false;				
			}
		}else{
				if(functions.inputs.contains("login") && CIN=="login"){
					System.out.println("You are already logged in: Enter another Command");
					functions.inputs.remove(functions.inputs.size()-1);					
					return false;
				}else{
					return true;
				}
		}
	
	}//*********** End logincheck functions********************8
	
	/*
	 * Method Name: ChooseSession()
	 * 
	 * This method will allow user to choose the session. user can choose if they
	 * want to enter an admin session or standard session. it will populate the
	 * available for each user. 
	 */
	public void ChooseSession(){		
		System.out.println("Please Choose a session Type: ADMIN ? STANDARD ?");
		try {CIN = br.readLine();} catch (IOException e) {e.printStackTrace();}	
		
		if(CIN.equalsIgnoreCase("standard")){
			functions.inputs.add("standard");
			System.out.println("As a STANDARD user, you can use the following commands:");
			int i=0;while(index.StdCommand.length>i){System.out.print(index.StdCommand[i]+"\t");i++;}
			System.out.println();
		}else if(CIN.equalsIgnoreCase("admin")){
			System.out.println("As an ADMIN, you can use the following commands:");
			int i=0;while(index.AdmCommand.length>i){System.out.print(index.AdmCommand[i]+"\t");i++;}
			System.out.println();
			functions.inputs.add("admin");
		}else{
			System.out.println(CIN.toUpperCase()+" username does not exist. Choose a Session:");
			ChooseSession();
		}		
	}//******** End choose session function ****************

}
