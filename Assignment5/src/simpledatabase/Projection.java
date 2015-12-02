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
		Tuple nextTuple = child.next();
		if (nextTuple==null)	// if null then return null
		{
			return nextTuple;
		}
			
			
		
		for (int i = 0;i < nextTuple.getAttributeList().size();i++)
		{
			if (nextTuple.getAttributeName(i).equalsIgnoreCase(attributePredicate)){
				temp = nextTuple.attributeList.get(i);
				break;
		}
		}
			
		nextTuple.attributeList.clear();	// clear all of the attributelist
		nextTuple.attributeList.add(temp);	// add the matched result
		return nextTuple;		
	}
		
	
		

	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return child.getAttributeList();
	}

}