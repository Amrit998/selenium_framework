package utils;

public class FrameworkException extends Exception {
	private static final long serialVersionUID = 1L;
	
	String exceptionMessage;
	
	public FrameworkException(String message){
		exceptionMessage = message;
	}
	
	public String toString(){ 
	      return ("Framework Exception:  "+exceptionMessage) ;
	   }
}
