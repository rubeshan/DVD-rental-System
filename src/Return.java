import java.io.IOException;


public class Return {

	
	public Return(){
		inputs.add("return");
		CIN="return";
		loginCheck();
		
		if(dvdFinder()==true&&status=='R'){
			dvdStatusCheck('R');
			returnCheck();
		}else{
			System.out.println("We are unable to return anything at the moment. please try again.");
		}			
		System.out.println(inputs);
		
	}
	
	public void returnCheck(){
		System.out.println("How many copies would you like to return?");
		try {CIN= br.readLine();} catch (IOException e) {e.printStackTrace();}
		if(CIN.length()>1){
			System.out.println("Invalid input. You can only return maximum of 3 copies.");
			rentCheck();
		}else{			
			int copy = Character.getNumericValue(CIN.charAt(0));
			if(copy<=3&&copy>=1){
				char stat=status;
					System.out.println(copy+" is added to database");
					//inputsUpdate(copies+copy, stat, copy);								
			}else{
				System.out.println("Invalid value was entered");
				rentCheck();
			}
		}
		
	}

}
