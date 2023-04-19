import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Q1 {
    private static List<Integer> departures = new ArrayList<>();
    private static List<Integer> arrivals   = new ArrayList<>();
    
    private static final int numberRunways;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira a quantidade de aviões que irão decolar:");
        int N = scanner.nextInt();

        System.out.println("Insira os tempos de decolagem de cada avião:");
        for (int i = 0; i < N; i++) {
            int departure_time = scanner.nextInt();
            departures.add(departure_time);
        }
        
        System.out.print("Insira a quantidade de aviões que irão pousar:");
        int M = scanner.nextInt();

        System.out.println("Insira os tempos de pouso de cada avião:");
        for (int i = 0; i < M; i++) {
            int arrival_time = scanner.nextInt();
            departures.add(arrival_time);
        }

        numberRunways = scanner.nextInt();

        
        for (int i = 0; i < numberRunways; i++) {
            Runway newRunway = new Runway();
            newRunway.start();
        }
        
        long startTime = System.currentTimeMillis() + 25;
        Plane.setTime(startTime);
        
        Thread.sleep(startTime - System.currentTimeMillis());


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
