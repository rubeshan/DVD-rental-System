
public class Remove {

	public void Remove(){
		functions.inputs.add("remove");
		CIN="remove";
		Login.loginCheck();
		
		if(functions.adminCheck()){
			if(functions.dvdFinder()==true){
				removeCheck();
			}else{
				System.out.println("We are unable to remove anything at the moment. please try again.");
			}
		}else{
			System.out.println("ohh ohh... You are not an admin, you cannot add items.. login as Admin to remove");
		}		
			
		System.out.println(functions.inputs);
		
	}
	
	public void removeCheck(){
		
	}
}
