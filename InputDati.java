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
    
	/**
     * Metodo generatore dell'oggetto Scanner usato per l'interazione con l'utente
     * @return Scanner
     */     
	private static Scanner creaScanner ()
	{
		Scanner creato = new Scanner(System.in);
		creato.useDelimiter(System.getProperty("line.separator"));
		return creato;
	}
	
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione della stringa digitata dall'utente
     * @param messaggio: il messaggio da stampare
     * @return String
     */    
	public static String leggiStringa (String messaggio)
	{
		System.out.print(messaggio);
		return lettore.next();
	}
	
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione della stringa digitata dall'utente privata degli eventuali spazi iniziali e finali.
     * Se tale stringa e' vuota mostra a video un messaggio di errore
     * @param messaggio: il messaggio da stampare
     * @return String
     */ 
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
	
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione del primo carattere della stringa digitata dall'utente.
     * Se tale stringa e' vuota mostra a video un messaggio di errore
     * @param messaggio: il messaggio da stampare
     * @return char
     */ 
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
	
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione del primo carattere della stringa digitata dall'utente.
     * Viene poi ottenuta la lettera maiuscola corrispondente al carattere acquisito e successivamente si verifica che tale lettera compaia nell'elenco dei caratteri ammissibili selezionati dall'utente;
     * in caso contrario viene mostrato a video un messaggio di errore
     * @param messaggio: il messaggio da stampare
     * @param ammissibili: stringa con i caratteri ammissibili
     * @return char
     */ 
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
	  
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione di un intero digitato dall'utente.
     * Se il formato del numero acquisito non e' compatibile mostra a video un messaggio di errore.
     * @param messaggio: il messaggio da stampare
     * @return int
     */ 
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
	
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione di un intero digitato dall'utente il cui valore sia superiore ad un valore minimo impostato.
     * Se il formato del numero acquisito non e' compatibile mostra a video un messaggio di errore;
     * se il valore del numero acquisito e' minore del valore impostato mostra a video un messaggio di errore.
     * @param messaggio: il messaggio da stampare
     * @param minimo: il numero minimo ammissibile
     * @return int
     */ 
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
	
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione di un intero digitato dall'utente il cui valore sia superiore ad un valore minimo impostato ed inferiore ad un valore massimo impostato.
     * Se il formato del numero acquisito non e' compatibile mostra a video un messaggio di errore;
     * se il valore del numero acquisito e' minore o maggiore del valore impostato mostra a video un messaggio di errore.
     * @param messaggio: il messaggio da stampare
     * @param minimo: il numero minimo ammissibile
     * @param massimo: il numero massimo ammissibile
     * @return int
     */ 
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
	
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione di un numero digitato dall'utente.
     * Se il formato del numero acquisito non e' compatibile mostra a video un messaggio di errore.
     * @param messaggio: il messaggio da stampare
     * @return int
     */ 
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
	
	/**
     * Metodo per la stampa di un messaggio a video e la successiva acquisizione di un numero digitato dall'utente il cui valore sia superiore ad un valore minimo impostato.
     * Se il formato del numero acquisito non e' compatibile mostra a video un messaggio di errore;
     * se il valore del numero acquisito e' minore del valore impostato mostra a video un messaggio di errore.
     * @param messaggio: il messaggio da stampare
     * @param minimo: il numero minimo ammissibile
     * @return int
     */ 
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
