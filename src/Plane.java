public class Plane {
	private boolean willTakeoff;
	private int id;
	private int nextId = 0;
	
	public Plane(boolean direction) {
		this.willTakeoff = direction;
		this.id = nextId;
		nextId ++;
	}
	
	public boolean getWillTakeoff() {
		return willTakeoff;
	}
	
	public int getId() {
		return id;
	}
	
	public void go() {
		System.out.println("Avião Pista nº " + getId() + " inicializada");
	}
	
}