
public class Logout {

	public Logout(){
		
		if(functions.inputs.size()>1){
			System.out.println("Logout Function Reached");
		System.exit(100);
		}else{System.out.println("You are trying to logout but you did not login into the system. please enter : login");}
	}
	
}
