import java.io.IOException;

public class Rent(){
	

	public Rent(){
		functions.inputs.add("rent");
		CIN="rent";
		Login.loginCheck();

		System.out.println("The New array of inputs is "+functions.inputs);		
		
		if(functions.dvdFinder()==true){				
			if(functions.inputs.get(functions.inputs.size()-1).equalsIgnoreCase("2")){
				functions.dvdStatusCheck('R');
				
				System.out.println("inputs beforerent chckc "+functions.inputs);
				rentCheck();
				System.out.println("inputs after rent chckc "+functions.inputs);	
				
			}else if(functions.inputs.get(functions.inputs.size()-1).equals("1")&&functions.status=='S'){
				System.out.println("That DVD is available for sale only. please try again..rent.");
				inputs.remove(inputs.size()-1);
				inputs.remove(inputs.size()-1);
				inputs.remove(inputs.size()-1);
				
			}else if(inputs.get(inputs.size()-1).equals("2")&&status=='R'){
				dvdStatusCheck('R');
				System.out.println("inputs beforerent chckc "+functions.inputs);
				rentCheck();
				System.out.println("inputs after rent chckc "+functions.inputs);
			}else{
			System.out.println("Your "+CIN+" DVD exists in the system.");
			rentCheck();
			}			
			
		}else{
			System.out.println("That DVD is available for sale only. please try again.");
			functions.inputs.remove(functions.inputs.size()-1);
			functions.inputs.remove(functions.inputs.size()-1);
			functions.inputs.remove(functions.inputs.size()-1);
		}
	}
	
	
	public void rentCheck(){		
		System.out.println("How many copies would you like to take out?");
		try {CIN= br.readLine();} catch (IOException e) {e.printStackTrace();}
		if(CIN.length()>1){
			System.out.println("Invalid input. You can only take out maximum of 3 copies.");
			rentCheck();
		}else{			
			int copy = Character.getNumericValue(CIN.charAt(0));
			if(copy<=3&&copy>=1){
				char Newstat='R';
				System.out.println("The stat value os "+Newstat);
				if(copies<=3&&copies>=1){
					System.out.println("There is only limited ("+copies+") copies available. ");
					System.out.println(copies+" is added to the Cart.");					
					inputsUpdate(copies, Newstat, price);					
				}else if(copies>=3){
					System.out.println(copy+" is added to the Cart.");
					inputsUpdate(copies-copy, Newstat, price);
				}else if(copies==0){
					System.out.println("There is no copies available in stock. What do u want to do now?");
				}else{					
				}				
			}else{
				System.out.println("Invalid value was entered");
				rentCheck();
			}
		}
		
	}
	}