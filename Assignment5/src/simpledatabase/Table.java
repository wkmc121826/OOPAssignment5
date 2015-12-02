package simpledatabase;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Table extends Operator{
	private BufferedReader br = null;
	private boolean getAttribute=false;
	private Tuple tuple;
	private String At = "";
	private String Ty = "";
	private String Co = "";
	public Table(String from){
		this.from = from;
		
		//Create buffer reader
		try{
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/datafile/"+from+".csv")));	
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	
	/**
     * Create a new tuple and return the tuple to its parent.
     * Set the attribute list if you have not prepare the attribute list
     * @return the tuple
     */
	@Override
	public Tuple next(){
		System.out.println(getAttribute);
		
		
		try{
					
		if(getAttribute==false)
		{
			At = br.readLine();
			System.out.println(At);
			Ty = br.readLine();
			System.out.println(Ty);
			System.out.println(getAttribute);
			Co=  br.readLine();
			if(Co != "")
				{
					tuple = new Tuple (At,Ty,Co);	
					tuple.setAttributeName();
					tuple.setAttributeType();
					tuple.setAttributeValue();
					getAttribute=true;
					return tuple;
				}}
		else{

            Co=  br.readLine();

		if(Co != "")
			{
				
			System.out.println(getAttribute);
			tuple = new Tuple (At,Ty,Co);	
			tuple.setAttributeName();
			tuple.setAttributeType();
			tuple.setAttributeValue();
			return tuple;
		}

		}}
		catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	

	/**
     * The function is used to get the attribute list of the tuple
     * @return the attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return tuple.getAttributeList();
	}
	
}