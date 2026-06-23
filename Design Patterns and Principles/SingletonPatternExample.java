 final class Logger{
    private static final Logger INSTANCE = new Logger();
    private Logger(){

    }
    public static Logger getInstance(){
        return INSTANCE;
    }
    public void log( String message){
        System.out.println("LOG "+message);

    }
}

public class SingletonPatternExample{
     public static void main(String[] args){
        Logger logger1= Logger.getInstance();
        Logger logger2= Logger.getInstance();
        logger1.log("App started");
        logger2.log("user logged in ");
         System.out.println(logger1==logger2);

        
     }
}
class Test{
     public static void main(String[] args){
        Logger logger1= Logger.getInstance();
        Logger logger2= Logger.getInstance();
       if (logger1 == logger2) {
            System.out.println(" PASS: Same instance confirmed.");
        } else {
            System.out.println(" FAIL: Different instances found!");
        }
        
     }
}