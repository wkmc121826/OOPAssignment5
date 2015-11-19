package simpledatabase;
import java.util.ArrayList;

public class Projection extends Operator{
	
	ArrayList<Attribute> newAttributeList;
	private String attributePredicate;


	public Projection(Operator child, String attributePredicate){
		
		this.attributePredicate = attributePredicate;
		this.child = child;
		newAttributeList = new ArrayList<Attribute>();
		
	}
	
	
	/**
     * Return the data of the selected attribute as tuple format
     * @return tuple
     */
	@Override
	public Tuple next(){
		Attribute temp = null;
		Tuple a = child.next();
		
		if (a==null)	// if null then return null
			return null;
			
		
		for (int i = 0;i < a.getAttributeList().size();i++)
		{
			
			if (a.getAttributeName(i).equalsIgnoreCase(attributePredicate)){
				temp = a.attributeList.get(i);
				break;
		}
		}
			
		a.attributeList.clear();	// clear all of the attributelist
		a.attributeList.add(temp);	// add the matched result
		return a;		
	}
		

	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return child.getAttributeList();
	}

}