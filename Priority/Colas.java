import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList; 

public class Colas{
	
	public static void main(String args[])
	{
		try
		{
			String[] lista_pacientes = Readfile("pacientes.txt");
			Paciente[] pacientes_preliminar = PacienteArray(lista_pacientes);
			Vector<Paciente> temp = new Vector<Paciente>();
			
			for(int i = 0; i < pacientes_preliminar.length;i++)
			{
				temp.add(pacientes_preliminar[i]);
			}
			ColaPriority<Paciente> pacientes = new ColaPriority<Paciente>(temp);
			
			while(true)
			{	
				try
				{
					int opcion = Menu(pacientes);
					if(opcion == 3)
					{
						break;
					}
					else if(opcion == 2)
					{
						Print(pacientes.getNext());
					}
					else if(opcion == 1)
					{
						AnadirPaciente(pacientes);
					}
				}
				catch(Exception ex)
				{
					System.out.println("Error: " + ex.toString());
				}
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex.toString());
		}
	}
	
	private static void AnadirPaciente(ColaPriority<Paciente> pacientes)
	{
		Print("Ingrese el nombre, sintomas y prioridad (en mayuscula) separada por comas.");
		Scanner sc= new Scanner(System.in);
		String texto = sc.nextLine();
		Paciente pacienteTemp = new Paciente(texto.split(","));
		pacientes.add(pacienteTemp);
	}
	
	private static int Menu(ColaPriority<Paciente> pacientes) throws Exception
	{
		try
		{			
			Print("\nQue desea hacer:\n1. Anadir un paciente a la cola\n2. Indicar cual es el siguiente paciente en cola\n3. Terminar");
			Scanner sc= new Scanner(System.in);
			int texto = sc.nextInt();
			
			//int resultado = int.parseInt(texto);
			
			return texto;
		}
		catch(Exception e)
		{
			throw new Exception("Error en Menu: " + e.toString());
		}
	}
	
	private static void Print(String str)
	{
		System.out.println(str);
	}
	
	private static String[] Readfile(String path) throws Exception{
		try{
			File file =	new File(path);
			Scanner sc = new Scanner(file);
			ArrayList<String> array = new ArrayList<String>();
			
			while (sc.hasNextLine()){
				
				String line = sc.nextLine();
				array.add(line);
				
			}
			
			String[] fileInfo = array.toArray(new String[array.size()]);
			return fileInfo;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	private static Paciente[] PacienteArray(String[] a)
	{
		Paciente[] arreglo = new Paciente[a.length];
		for(int i = 0; i < a.length; i++)
		{
			String[] temp = a[i].split(",");
			
			Paciente tempPaciente = new Paciente(temp);
			
			arreglo[i] = tempPaciente;
		}
		
		
		return arreglo;
	} 
}