import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Vector;

import org.junit.jupiter.api.Test;

class PruebasUnitariasColaQueue {

	@SuppressWarnings("deprecation")
	@Test
	public void testRetirar() throws Exception 
	{
		Paciente[] esperadoTemp = new Paciente[]{new Paciente(new String[]{"Maria Ramirez","apendicitis","A"}),new Paciente(new String[]{"Carmen Sarmientos","dolores de parto","B"}), new Paciente(new String[]{"Juan Perez","fractura de pierna","C"})};
		String[] resultado = new String[esperadoTemp.length];
		String[] esperado = new String[esperadoTemp.length];
		
		String[] lista_pacientes = Main.Readfile("C:\\Users\\Eldero\\Desktop\\Universidad\\5 semestre\\Algoritmos\\HJ8\\pacientes.txt");
		Paciente[] pacientes_preliminar = Main.PacienteArray(lista_pacientes);	
		Vector<Paciente> temp = new Vector<Paciente>();
		
		for(int i = 0; i < pacientes_preliminar.length;i++)
		{
			temp.add(pacientes_preliminar[i]);
		}
		
		ColaPriority<Paciente> cola = new ColaPriority<Paciente>(temp);
		
		for(int i = 0; i < esperadoTemp.length; i++) 
		{
			String temporal = "Es el turno de " +  esperadoTemp[i].toString();
			esperado[i] = temporal;
			String resultado_parcial = cola.getNext();
			resultado[i] = resultado_parcial;
		}
		
		assertEquals(esperado, resultado);
		
	}

	
	@SuppressWarnings("deprecation")
	@Test
	public void testInsertar() throws Exception 
	{
		Vector<Paciente> esperadoTemp = new Vector<Paciente>();
		Vector<Paciente> resultadoTemp = new Vector<Paciente>();
		
		String[] lista_pacientes = Main.Readfile("C:\\Users\\Eldero\\Desktop\\Universidad\\5 semestre\\Algoritmos\\HJ8\\pacientes.txt");
		
		for(int i = 0; i<lista_pacientes.length;i++) 
		{
			Paciente pacienteTemp = new Paciente(lista_pacientes[i].split(","));
			esperadoTemp.add(pacienteTemp);
		}
		
		ColaPriority<Paciente> esperadoCola = new ColaPriority<Paciente>(esperadoTemp);
		ColaPriority<Paciente> resultadoCola = new ColaPriority<Paciente>(resultadoTemp);
		
		for(int i = 0; i<lista_pacientes.length;i++) 
		{
			Paciente pacienteTemp = new Paciente(lista_pacientes[i].split(","));
			resultadoCola.add(pacienteTemp);
		}
		
		String esperado = esperadoCola.toString();
		String resultado = resultadoCola.toString();
		assertEquals(esperado, resultado);
		
	}
}
