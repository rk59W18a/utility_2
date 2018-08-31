package utility.parte2;

import java.io.Serializable;

public class Menu implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String titolo;
	private String [] voci;
	
	public static final String CORNICE = "*************************************************************";
	public static final String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata: ";
	public static final int NUM_MINIMO_OPZIONE = 1;
	
	public Menu(String titolo, String [] voci)
	{
		this.titolo  = titolo;
		this.voci = voci;
	}
	
	public int scegli()
    {
		stampa();
 	   	int opzione = InputDati.leggiIntero(RICHIESTA_INSERIMENTO, NUM_MINIMO_OPZIONE , voci.length);
		   
 	   	return opzione;
	}
	
	public void stampa()
	{
		System.out.println(CORNICE);
		System.out.println(titolo);
		System.out.println(CORNICE);
		   
		for(int i = 0; i < voci.length; i++)
		{
			System.out.println( (i+1) + "-" + voci[i]);
		}
		   
		System.out.println();
	}
	   
}