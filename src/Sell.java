
public class Sell {
	
	public void Sell(){
		inputs.add("sell");
		CIN="sell";
		loginCheck();
		
		if(adminCheck()){
			if(dvdFinder()==true){
				sellCheck();
			}else{
				System.out.println("We are unable to sell anything at the moment. please try again.");
			}
		}else{
			System.out.println("ohh ohh... You are not an admin, you cannot sell items.. login as Admin to sell");
		}
			
		System.out.println(inputs);
	}
	
	public void sellCheck(){
	
		
	}

}
