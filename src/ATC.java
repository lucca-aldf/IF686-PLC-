import java.util.List;

public class ATC extends Thread{
    private int totalRunway;
    private int avaliableRunway;
	
	
    public ATC(int myRunways){
		this.totalRunway = myRunways;
	    this.avaliableRunway = myRunways;
    }
    
    public synchronized void requestRunway() throws InterruptedException {
        while (this.avaliableRunway == 0) {
            wait();
        }
        this.avaliableRunway--;
        notifyAll();
    }

    public synchronized void freeRunway() throws InterruptedException {
        while (this.totalRunway == this.avaliableRunway) {
            wait();
        }
        this.avaliableRunway++;
        notifyAll();
    }

}
