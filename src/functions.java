import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class functions {
	
	public static String CIN;//Current Input
	static ArrayList<String> inputs = new ArrayList<String>();//arraylist to store, valid inputs.
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Buffered reader to read user inputs.
	static String title ="";//title of the DVD
	static int copies=0;//number of copies 
	static char status =' ';
	static double price =' ';
	static boolean admin = true;
	
	public functions(){
		
	}
	
	/*
	 * Method Name : dbdFinder()
	 * 
	 * This method will search the database (current Dvd file) for
	 * the dvd title inputed by the user. If the dvd is in the
	 * database, it will return true or else, it will return false
	 * it will also add the correct inputs to the arraylist so that
	 * it will be easily used in the transaction method.
	 * 
	 */
	public static boolean dvdFinder(){		
		
		boolean found = false;	
		title=null;
		System.out.println("What movie would you like to "+inputs.get(inputs.size()-1)+" today? :");
		try {CIN= br.readLine();} catch (IOException e) {e.printStackTrace();}	
		if(CIN.equalsIgnoreCase("logout")){
			System.out.println("You cannot logout while a transaction is taking place.");
			System.out.println("Complete this Transaction and then logout.");
			dvdFinder();
		}else{
			if(CIN.length()>25){
				System.out.println("DVD title is too long. You have "+CIN.length()+" characters in it. you can only enter 25 characters.");
				dvdFinder();
			}else{
				String file = "src/DVD_files/Currnet_DVD_File.txt";			  
		  		String line =" ";
		  		
		  		try{
					FileInputStream g = new FileInputStream(file);
					DataInput f = new DataInputStream (g);			
					 line = f.readLine();
					 int c=0;
					while(line !=null){
						title =line.substring(0, 25).replaceAll("[^a-zA-Z0-9]", "");
						if(title.equalsIgnoreCase(CIN.replaceAll("[^a-zA-Z0-9]", ""))){							
							copies = Integer.parseInt(line.substring(26, 30));
							status = line.charAt(31);
							price = Double.parseDouble(line.substring(33, 39));
							c++;
							inputs.add(CIN+"#"+copies+"$"+price+"?"+status);
							found=true;						
						}else{}						
						line= f.readLine(); 
					}	
					inputs.add(""+c);
				}catch(Exception e){
					e.printStackTrace();			
				}	   		
			}
		}
		if(found==false){
			System.out.println(CIN+" does not exist in the system");
			System.out.println("What do you want to do now? ie:");
			if(inputs.get(1).equalsIgnoreCase("admin")){
			int i=0;while(index.AdmCommand.length>i){System.out.print(index.AdmCommand[i]+"\t");i++;}
			System.out.println();}else {int i=0;while(index.StdCommand.length>i){System.out.print(index.StdCommand[i]+"\t");i++;}
			System.out.println();}
			
			inputs.remove(inputs.size()-1);
			return false;
		}				
		return true;
	}
	
	/*
	 * Method Name : inputsUpdate()
	 * 
	 * Thie method will update the inputs in the inputs arraylist.
	 * id the user wants to rent 3 DVD's it will update it only
	 * in the array list,during the transaction all will be removed
	 * and this changes will be applied to the current DVD file.
	 */
	public static void inputsUpdate(int newCopy, char newStatus, double newPrice){
		String q = inputs.get(inputs.size()-1);int w =0;		
		while(q.charAt(w)!='#'){w++;}		
		inputs.remove(inputs.size()-1);
		inputs.add(q.substring(0, w)+"#"+newCopy+"$"+newPrice+"?"+newStatus);
	}
	
	/*
	public void dvdUpdater(){		
		String file = "src/DVD_files/Currnet_DVD_File.txt";			  
  		String line =" ";  		
  		try{
			FileInputStream g = new FileInputStream(file);
			DataInput f = new DataInputStream (g);			
			 line = f.readLine();
			 
			while(line !=null){
				title =line.substring(0, 25).replaceAll("[^a-zA-Z0-9]", "");
				if(title.equalsIgnoreCase(CIN.replaceAll("[^a-zA-Z0-9]", ""))){
						System.out.println("Your "+CIN+" DVD exists in the system.");
					
					copies = Integer.parseInt(line.substring(26, 30));
					status = line.charAt(31);
					price = Double.parseDouble(line.substring(33, 39));
					inputs.add(CIN+"~"+copies+"~"+price+"~"+status);			
				}else{}						
				line= f.readLine(); 
			}					
		}catch(Exception e){
			e.printStackTrace();			
		}	   		
		
	}*/
	
	/*
	 * Method Name : dvdStsusCheck()
	 * 
	 * This method will check if one DVD title has
	 * different status, for example, movie1 might
	 * rent status and sale status. this methods exists to
	 * make sure, that if the user is renting a DVD, it 
	 * does not affect the DVDs for sale.
	 *
	 */
	public static void dvdStatusCheck(char s){
		String ty = inputs.get(inputs.size()-1);
		int type = Integer.parseInt(ty);
		inputs.remove(inputs.size()-1);		
		String aa = ""+s;
		if(type==2){
			String a = inputs.remove(inputs.size()-1);
			String b = inputs.remove(inputs.size()-1);
			
			System.out.println("A = "+a);
			System.out.println("B = "+b);
			String z = "";
				if(a.substring(a.length()-1, a.length()).equalsIgnoreCase(aa)){ z=a;}	  
				if(b.substring(b.length()-1, b.length()).equalsIgnoreCase(aa)){	z=b;}				
				
				int w =0, x=0, y=0;		
				while(z.charAt(w)!='#'){w++;}
				while(z.charAt(x)!='$'){x++;}
				while(z.charAt(y)!='?'){y++;}			
				copies=Integer.parseInt(z.substring(w+1, x));
				status= z.substring(y+1, z.length()).charAt(0);
				price = Double.parseDouble(z.substring(x+1, y));
				inputs.add(z.substring(0, w)+"#"+z.substring(w+1, x)+"$"+z.substring(x+1, y)+"?"+z.substring(y+1, z.length()));
				System.out.println(status +" DVD ststus check function "+inputs); 
		}
	}
	
	/*
	 * Methos Name : TTANSACTION()
	 * 
	 * This method is responsible for printing out a transaction report.
	 * it will give details of the current transaction. it will name the
	 * result file in by year-month-date-hour-minute-second.  this will
	 * take place only if the user logouts. 
	 * 
	 */
	public void TRANSACION(){
		inputs.remove(0);
		inputs.remove(0);
		
		String CC = null;
		String AA = null;
		String NN = null;
		String SS = null;
		String PP = null;
		
		  Calendar currentDate = Calendar.getInstance();
		  SimpleDateFormat formatter=   new SimpleDateFormat("yyyy-MMM-dd-HH-mm-ss");
		  String dateNow = formatter.format(currentDate.getTime());
		  try{			  
			  FileWriter fstream = new FileWriter("src/Transaction/"+dateNow+".txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write("This file is called \n\n");			  
			  out.close();
			  }catch (Exception ee){
			  System.err.println("Error: " + ee.getMessage());
			  }		
	}
	
	/*
	 * Method Name: adminCheck()
	 * 
	 * This method will check to see if the user is admin or not. 
	 * as per the requirements, standard user has limited privileges, so
	 * we need to make sure that admin can only add, remove, sell, or create
	 * DVDs so we have to place this method.
	 * 
	 */
	public static boolean adminCheck(){
		if(inputs.contains("admin")){
			return admin;
		}else{
			inputs.remove(inputs.size()-1);
			return !admin;
		}
	}
	
	

}
