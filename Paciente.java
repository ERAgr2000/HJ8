public class Paciente implements Comparable<Paciente>{
	
	static final private char[] order = {'A','B','C','D','E'};
	private char prior;
	private String nombre;
	private String sintoma;
	
	private Paciente()
	{
		
	}
	
	public Paciente(String[] ficha)
	{
		nombre = ficha[0].trim();
		sintoma = ficha[1].trim();
		prior = ficha[2].trim().charAt(0);
	}
	
	public char getPrior()
	{
		return prior;
	}
	
	@Override
	public int compareTo(Paciente paciente){
		//Compara la prioridades segun la lista statica 
		for(int i = 0; i < order.length; i = i + 1){
			if(prior == order[i] && paciente.getPrior() == order[i])
			{
				return 0;
			}
			else if(prior == order[i] && paciente.getPrior() != order[i])
			{
				return -1;
			}
			else if(prior != order[i] && paciente.getPrior() == order[i])
			{
				return 1;
			}
		};
		return 0;
	}
	
	
	public String toString()
	{
		String prio = Character.toString(prior);
		String str = nombre + " presenta " + sintoma + " por lo que se le dio una prioridad " + prio;
		
		return str;
	}
}