class Logger{
    private static Logger instance = new Logger();
    private Logger(){

    }
    public static Logger getInstance(){
        return instance;
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
