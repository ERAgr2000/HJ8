import java.util.*;

public class ColaHeap<E extends Comparable<E>> extends VectorHeap<E>
{
	private ColaHeap()
	{
		

	}
		
	public ColaHeap(Vector<E> v)
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}

	public Vector<E> getData()
	{
		return data;
	}
	
	public String toString()
	{
		String string = "";
		for(int i =0;i<data.size();i++)
		{
			string = string + data.get(i).toString() + "\n";
		}
		return string;
	}
	
	public String getNext()
	{
		if(data.size()==0)
		{
			return("No hay pacientes en cola");
		}
		
		E paciente = this.remove();
		
		String string = "Es el turno de " + paciente.toString();
		return string;
	}
}