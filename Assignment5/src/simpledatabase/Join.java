package simpledatabase;
import java.util.ArrayList;

public class Join extends Operator{

	private ArrayList<Attribute> newAttributeList;
	private String joinPredicate;
	ArrayList<Tuple> tuples1;
	ArrayList<Tuple> tuples2;
	int g = 0;
	
	//Join Constructor, join fill
	public Join(Operator leftChild, Operator rightChild, String joinPredicate){
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.joinPredicate = joinPredicate;
		
		newAttributeList = new ArrayList<Attribute>();
		tuples1 = new ArrayList<Tuple>();
		tuples2 = new ArrayList<Tuple>();
		
		Tuple b = rightChild.next();
		
		
		while(b!=null)
		{
			tuples2.add(b);
			g++;
			b = rightChild.next();
		}
		System.out.println(tuples2.size());
	}

	
	/**
     * It is used to return a new tuple which is already joined by the common attribute
     * @return the new joined tuple
     */
	//The record after join with two tables
	@Override
	public Tuple next(){
		Attribute temp = null;
		
		Tuple c = new Tuple("1","2","3");
			
		

		Tuple a = leftChild.next();
		if(a==null)
		{
			return null;
		}
		Tuple b = rightChild.next();
		if(b==null)
		{
			return null;
		}
		mainloop:
		
			
			for(int tuple1_x = 0;tuple1_x <= a.getAttributeList().size()-1;tuple1_x++)
			{
				for (int tuple2_y = 0;tuple2_y <= tuples2.size()-1;tuple2_y++)
				{
					b = tuples2.get(tuple2_y);
					for(int tuple2_x = 0;tuple2_x <= b.getAttributeList().size()-1;tuple2_x++)
					{
				
				
				if(a.getAttributeValue(tuple1_x)== b.getAttributeValue(tuple2_x))
			{
				c.attributeList.clear();
				for(int z = 0;z <= a.getAttributeList().size()-1;z++)
				{
					
				temp = a.attributeList.get(z);
				c.attributeList.add(temp);
				}
				for(int y = 0;y <= b.getAttributeList().size()-1;y++)
				{
					
				temp = b.attributeList.get(y);
				c.attributeList.add(temp);	// add the matched result
				}
				
				
				break mainloop;
			}
			
			
			}
			
			
	
		}}
		
		
		return c;	
	}
	
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		if(joinPredicate.isEmpty())
			return child.getAttributeList();
		else
			return(newAttributeList);
	}

}