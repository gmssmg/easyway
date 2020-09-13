package hackathon.banco.safra.easyway.application.exception;

public class InvalidCpfException extends RuntimeException{

    public InvalidCpfException(String message){
        super(message);
    }
}
