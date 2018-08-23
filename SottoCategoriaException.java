package utility_2;

public class SottoCategoriaException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public SottoCategoriaException()
	{
		super("Operazione non consentita su SottoCategoria");
	}
}

