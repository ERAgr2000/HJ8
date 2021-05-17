import java.util.*;
import java.util.Objects;

public class ColaPriority<E extends Comparable<E>> extends PriorityQueue<E>
{
	private ColaPriority()
	{
		

	}
		
	public ColaPriority(Vector<E> v)
	{
		int i;
		//data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}

	
	public String getNext()
	{
		E paciente = this.poll();
		
		if(Objects.isNull(paciente) )
		{
			return("No hay pacientes en cola");
		}
		
		String string = "Es el turno de " + paciente.toString();
		return string;
	}
}