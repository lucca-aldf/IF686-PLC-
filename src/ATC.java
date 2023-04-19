import java.util.List;

public class ATC {
    private List<Runway> listRunways;
    private int totalRunway;
    private int nextRunway = -1;
	
	
    public ATC(List<Runway> myRunways) {
		this.totalRunway = myRunways.size();
	    this.listRunways = myRunways;
    }
 
	public Runway runwayRequest(Plane myPlane) {
		nextRunway = (nextRunway + 1) % totalRunway;
		return listRunways.get(nextRunway);
	}
	 
}
