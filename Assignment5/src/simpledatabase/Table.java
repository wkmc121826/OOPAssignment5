package simpledatabase;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Table extends Operator{
	private BufferedReader br = null;
	private boolean getAttribute=false;
	private Tuple tuple;
	private String Attr;
	private String Type;
	private String Cont;
	public String from ="";
	
	public Table(String from){
		this.from = from;
		
		//Create buffer reader
		try{
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/datafile/"+from+".csv")));
			Attr = br.readLine();
			Type = br.readLine();
		
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
		
		try {
			Cont = br.readLine();	//Read new value
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (Cont!=null){		//return tuple if not empty
			tuple = new Tuple (Attr,Type,Cont);	
			tuple.setAttributeName();
			tuple.setAttributeType();
			tuple.setAttributeValue();
			
			return tuple;
		}
		else return null;
	}
	

	/**
     * The function is used to get the attribute list of the tuple
     * @return the attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return tuple.getAttributeList();
	}
	
}