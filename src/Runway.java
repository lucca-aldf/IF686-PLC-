public class Runway extends Thread{
	private boolean active;
	private boolean occupied;
    private Plane occupant;
    private int id;
    private int nextId = 0;


    public Runway() {
    	this.occupied = false;
    	this.id = nextId;
    	nextId ++;
    }

    public long getId() {
    	return id;
    }
    
    public void run() {

        System.out.println("Pista nº " + getId() + " inicializada");
        
        while (this.active) {
	        try {
	            if (this.occupied) {
	            	Thread.sleep(500); // Tempo de decolagem / pouso
	            	this.occupant.go();
	            	this.occupied = false;
	            }
	            Thread.sleep(2000); // Sleep for 2 seconds (2000 milliseconds)
	            System.out.println("Thread woke up after 2 seconds.");
	        } catch (InterruptedException e) {
	        	// Erro
	            e.printStackTrace();
	        }
	        System.out.println("Thread finished: " + getName());
        }
    }
    
    public void queuePlane(Plane plane) {
    	this.occupant = plane;
    }
    // Setter method to set a new value for the number
    public void close() {
        this.active = false;
    }

    // Method to perform some operation on the number
    public void performOperation() {
        // ... your logic here ...
        System.out.println("Performing operation on number: " + number);
    }
}