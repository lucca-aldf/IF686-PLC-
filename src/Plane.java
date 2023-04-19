public class Plane extends Thread{
	private static long START_TIME;

	private ATC controlTower;
	private boolean willTakeoff;
	private long id;
	private int scheduledTime;
	private static long nextId = 0;
	
	public Plane(int time, boolean direction, ATC myController) {
		this.controlTower = myController;
		this.willTakeoff = direction;
		this.scheduledTime = time;
		this.id = nextId;
		nextId ++;
		
	}
	
	public boolean getWillTakeoff() {
		return willTakeoff;
	}
	
	public long getId() {
		return id;
	}
	
	
	public void run(){
		try {
			
		Thread.sleep(scheduledTime + (START_TIME - System.currentTimeMillis()));
			controlTower.requestRunway();
		
		if (willTakeoff) {
			System.out.print("Avião de ID " + id + " decolou em " + (System.currentTimeMillis() - START_TIME) + "ms ao invés de " + scheduledTime + "ms,");
		}
		else {
			System.out.print("Avião de ID " + id + " pousou em " + (System.currentTimeMillis() - START_TIME) + "ms ao invés de " + scheduledTime + "ms,");
		}
		
		System.out.println("com atraso de " + (System.currentTimeMillis() - START_TIME - scheduledTime) + "ms");
		Thread.sleep(500);
		
		controlTower.freeRunway();;
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void setTime(long time) {
		START_TIME = time;
	}
}