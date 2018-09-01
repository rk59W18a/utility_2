package utility.parte2;

import java.util.*;

public class InputDati 
{
	private static Scanner lettore = creaScanner();
	  
	private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non e' nel formato corretto";
	private final static String ERRORE_MINIMO= "Attenzione: e' richiesto un valore maggiore o uguale a ";
	private final static String ERRORE_STRINGA_VUOTA= "Attenzione: non hai inserito alcun carattere";
	private final static String ERRORE_MASSIMO= "Attenzione: e' richiesto un valore minore o uguale a ";
	private final static String ERRORE_UGUALE= "Attenzione: e' richiesto un valore uguale a ";
	private final static String MESSAGGIO_AMMISSIBILI= "Attenzione: i caratteri ammissibili sono: ";

	private static Scanner creaScanner ()
	{
		Scanner creato = new Scanner(System.in);
		creato.useDelimiter(System.getProperty("line.separator"));
		return creato;
	}
	
	public static String leggiStringa (String messaggio)
	{
		System.out.print(messaggio);
		return lettore.next();
	}
	
	public static String leggiStringaNonVuota(String messaggio)
	{
		boolean finito=false;
	    String lettura = null;
	    
	    do
	    {
	    	lettura = leggiStringa(messaggio);
	    	lettura = lettura.trim();
	    	
	    	if (lettura.length() > 0)
	    		finito=true;
	    	else
	    		System.out.println(ERRORE_STRINGA_VUOTA);
	    	
	    } while (!finito);
	   
	   return lettura;
	}
	
	public static char leggiChar (String messaggio)
	{
		boolean finito = false;
		char valoreLetto = '\0';
		  
		do
		{
			System.out.print(messaggio);
			String lettura = lettore.next();
			  
			if (lettura.length() > 0)
			{
				valoreLetto = lettura.charAt(0);
				finito = true;
			}
			else
			{
				System.out.println(ERRORE_STRINGA_VUOTA);
			}
			  
		} while (!finito);
		  
		return valoreLetto;
	}
	
	public static char leggiUpperChar (String messaggio, String ammissibili)
	{
		boolean finito = false;
	    char valoreLetto = ' ';
	  
	    do
	    {
	    	valoreLetto = leggiChar(messaggio);
	    	valoreLetto = Character.toUpperCase(valoreLetto);
	    	
	    	if (ammissibili.indexOf(valoreLetto) != -1)
	    		finito  = true;
	    	else
	    		System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
	    	
	    } while (!finito);
	    
	    return valoreLetto;
	}
	  
	public static int leggiIntero (String messaggio)
	{
		boolean finito = false;
	    int valoreLetto = 0;
	    do
	    {
	    	System.out.print(messaggio);
	    	
	    	if (lettore.hasNextInt())
	    	{
	    		valoreLetto = lettore.nextInt();
	    		finito = true;
	    	}
	    	else
	    	{
	    		System.out.println(ERRORE_FORMATO);
	    		lettore.next();
	    	}
	    	
	    } while (!finito);
	    
	    return valoreLetto;
	}
	
	public static int leggiInteroConMinimo(String messaggio, int minimo)
	{
		boolean finito = false;
		int valoreLetto = 0;
		
	    do
	    {
	    	valoreLetto = leggiIntero(messaggio);
	    	
	    	if (valoreLetto >= minimo)
	    		finito = true;
	    	else
	    		System.out.println(ERRORE_MINIMO + minimo);
	    	
	    } while (!finito);
	     
	    return valoreLetto;
	}
	
	public static int leggiIntero(String messaggio, int minimo, int massimo)
	{
		boolean finito = false;
	    int valoreLetto = 0;
	    
	    do
	    {
	    	valoreLetto = leggiIntero(messaggio);
	    	
	    	if (valoreLetto >= minimo && valoreLetto<= massimo)
	    		finito = true;
	    	else if (valoreLetto < minimo && minimo != massimo)
	    			System.out.println(ERRORE_MINIMO + minimo);
	    	else if (valoreLetto > massimo && minimo != massimo)
	    		System.out.println(ERRORE_MASSIMO + massimo);
	    	else
	    		System.out.println(ERRORE_UGUALE + massimo);
	    	
	    } while (!finito);
	     
	    return valoreLetto;
	}
	
	public static double leggiDouble (String messaggio)
	{
		boolean finito = false;
	    double valoreLetto = 0;
	    
	    do
	    {
	    	System.out.print(messaggio);
	    	
	    	if (lettore.hasNextDouble())
	    	{
	    		valoreLetto = lettore.nextDouble();
	    		finito = true;
	    	}
	    	else
	    	{
	    		System.out.println(ERRORE_FORMATO);
	    		lettore.next();
	    	}
	    } while (!finito);
	    
	    return valoreLetto;
	}
	
	public static double leggiDoubleConMinimo (String messaggio, double minimo)
	{
		boolean finito = false;
		double valoreLetto = 0;
		
		do
	    {
			valoreLetto = leggiDouble(messaggio);
			
			if (valoreLetto >= minimo)
				finito = true;
			else
				System.out.println(ERRORE_MINIMO + minimo);
	    } while (!finito);
	     
		return valoreLetto;
	}
	
}
