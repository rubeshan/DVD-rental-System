
public class Buy {
	public void Buy(){
		functions.inputs.add("buy");
		CIN="buy";
		Login.loginCheck();
		
		if(functions.dvdFinder()==true){
			buyCheck();
		}else{
			System.out.println("We are unable to buy anything at the moment. please try again.");
		}
			
		System.out.println(functions.inputs);
		
	}
	
	public void buyCheck(){
		
		
	}

}
