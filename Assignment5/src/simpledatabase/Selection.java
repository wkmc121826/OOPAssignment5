package simpledatabase;
import java.util.ArrayList;

public class Selection extends Operator{
	
	ArrayList<Attribute> attributeList;
	String whereTablePredicate;
	String whereAttributePredicate;
	String whereValuePredicate;

	
	public Selection(Operator child, String whereTablePredicate, String whereAttributePredicate, String whereValuePredicate) {
		this.child = child;
		this.whereTablePredicate = whereTablePredicate;
		this.whereAttributePredicate = whereAttributePredicate;
		this.whereValuePredicate = whereValuePredicate;
		attributeList = new ArrayList<Attribute>();

	}
	
	
	/**
     * Get the tuple which match to the where condition
     * @return the tuple
     */
	@Override
	public Tuple next(){
		Attribute temp = null;
		boolean select = false;
		Tuple a = child.next();
		if(a==null)
		{
			return null;
		}
		Tuple b = new Tuple("1","2","3");
		select = false;
		for (int i = 0;i <= a.getAttributeList().size()-1;i++)
		{
		if (a.getAttributeName(i).equalsIgnoreCase(whereAttributePredicate))
		{
			select = true;
		}
		}
		
		if(select == true)
		{
			mainloop:
		for (int i = 0;i <= a.getAttributeList().size()-1;i++)
		{
			
			
			
				if(a.getAttributeValue(i).toString().equals(whereValuePredicate))
			{
				b.attributeList.clear();
				for (int j = 0;j <= a.getAttributeList().size()-1;j++)
			{
				
				temp = a.attributeList.get(j);
				b.attributeList.add(temp);
				
				
			}
			
			break mainloop;
			}else if(i==a.getAttributeList().size()-1)
			{
				i=0;
				a = child.next();
			}				
			
			
		}
			
			// clear all of the attributelist
			// add the matched result
			return b;
		}
		return a;	
			
	}
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return the attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		
		return(child.getAttributeList());
	}

	
}