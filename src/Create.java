
public class Create {
	
	public void Create(){
		functions.inputs.add("create");
		CIN="create";
		Login.loginCheck();
		boolean isAdmin = functions.adminCheck();
		if(isAdmin){
			if(functions.dvdFinder()==false){
				createCheck();
			}else{
				System.out.println("We are unable to create anything at the moment. please try again.");
			}
		}else{
			System.out.println("ohh ohh... You are not an admin, you cannot create items.. login as Admin to create DVD");
		}
	}
	public void createCheck(){
		
	}
	

}
