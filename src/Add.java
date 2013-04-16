import java.io.IOException;


public class Add {
	private static String CIN;
	
	public Add(){
		functions.inputs.add("add");
		CIN="add";
		Login.loginCheck();
		
		if(functions.adminCheck()){
			boolean found = functions.dvdFinder();
				if(found==true){
					
					if(functions.inputs.get(functions.inputs.size()-1).equalsIgnoreCase("2")){
						functions.dvdStatusCheck('R');
						
						System.out.println("inputs before add chekc "+functions.inputs);
						addCheck();
						System.out.println("inputs after add chckc "+functions.inputs);	
						
					}else if(functions.inputs.get(functions.inputs.size()-1).equals("1")&&functions.status=='S'){
						System.out.println("That DVD is available for sale only. cannot add to that, ");
						functions.inputs.remove(functions.inputs.size()-1);
						functions.inputs.remove(functions.inputs.size()-1);
						functions.inputs.remove(functions.inputs.size()-1);
						
					}else if(functions.inputs.get(functions.inputs.size()-1).equals("2")&&functions.status=='R'){
						functions.dvdStatusCheck('R');
						System.out.println("inputs before add chckc "+functions.inputs);
						addCheck();
						System.out.println("inputs after add chckc "+functions.inputs);
					}else{
					System.out.println("Your "+CIN+" DVD exists in the system.");
					addCheck();
					}
					
				}else{
					System.out.println("We are unable to add anything at the moment. please try again.");
				}
		}else{
			System.out.println("ohh ohh... You are not an admin, you cannot add items.. login as Admin to add");
		}
		
		System.out.println(functions.inputs);
		
	}
	
	public void addCheck(){		
		System.out.println("How many copies would you like to add to database?");
	//	try {CIN= br.readLine();} catch (IOException e) {e.printStackTrace();}
		if(CIN.length()>3){
			System.out.println("Invalid input. You can only add maximum of 999.");
			addCheck();
		}else{			
			int copy = Integer.parseInt(CIN);			
			if(copy<=999&&copy>=1){
				if(functions.copies<=999&&functions.copies>=1){
					
				}else{
					System.out.println("There is ");
				}
				char stat='R';
					System.out.println(copy+" is added to database");
					functions.inputsUpdate(functions.copies+copy, stat, functions.price);								
			}else{
				System.out.println("Invalid value was entered");
				addCheck();
			}
		}
	}

}
