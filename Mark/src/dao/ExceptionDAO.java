package dao;
public class ExceptionDAO extends Exception {
	private static final long serialVersionUID = 1L;
	public ExceptionDAO(String message) {
        super(message);
    }
}
