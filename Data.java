package utility.parte2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {

	public static boolean confrontaDate(LocalDate d1, LocalDate d2) {
		return d1.isEqual(d2);
	}
	
	public static boolean verificaDataSuccessiva(LocalDate d) {
		return LocalDate.now().isAfter(d);
	}
	
	public static boolean verificaDataPrecedente(LocalDate d) {
		return LocalDate.now().isBefore(d);
	}
	
	public static boolean verificaDataCoincidente(LocalDate d) {
		return LocalDate.now().equals(d);
	}
	
	public static LocalDate aumentaNumeroAnni(LocalDate d, int numeroAnni) {
		return d.plusYears(numeroAnni);
	}
	
	public static LocalDate aumentaNumeroGiorni(LocalDate d, int numeroGiorni) {
		return d.plusDays(numeroGiorni);
	}
	
	public static LocalDate diminuisciNumeroGiorni(LocalDate d, int numeroGiorni) {
		return d.minusDays(numeroGiorni);
	}
	
	public static LocalDate getDataAttuale() {
		return LocalDate.now();
	}
	
	public static LocalDate getDataImpostata(int giorno, int mese, int anno) {
		return LocalDate.of(anno, mese, giorno);
	}
	
	public static int getNumeroAnniDataAttuale() {
		return LocalDate.now().getYear();
	}
	
	public static String getDataFormattata(LocalDate d) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Costanti.FORMATO_DATA);
	    return d.format(formatter);
	}

}
