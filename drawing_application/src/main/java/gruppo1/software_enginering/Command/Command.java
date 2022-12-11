package gruppo1.software_enginering.Command;

public interface Command {
    
    public abstract void execute();
    public default void undo(){
        
    }; 
    
}
