import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;




public class Q1 {
    
    

    public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //Scanner scanner = new Scanner(System.in);

        //System.out.println("Insira a quantidade de aviões que irão decolar:");
        //int N = scanner.nextInt();
        int N = Integer.parseInt(bufferedReader.readLine());
        
        //System.out.println("Insira os tempos de decolagem de cada avião:");

		int[] departure_times = new int[N];
        for (int i = 0; i < N; i++) {
            // int departure_time = scanner.nextInt();
            int departure_time = Integer.parseInt(bufferedReader.readLine());
            departure_times[i] = departure_time;
        }
        
        //System.out.println("Insira a quantidade de aviões que irão pousar:");
        //int M = scanner.nextInt();
        int M = Integer.parseInt(bufferedReader.readLine());

        //System.out.println("Insira os tempos de pouso de cada avião:");
        int[] arrival_times = new int[M];
        for (int i = 0; i < M; i++) {
            //int arrival_time = scanner.nextInt();
            int arrival_time = Integer.parseInt(bufferedReader.readLine());
            arrival_times[i] = arrival_time;
        }

        //final int numberRunways = scanner.nextInt();
        final int numberRunways = Integer.parseInt(bufferedReader.readLine());
        ATC controller = new ATC(numberRunways);
        
        long startTime = System.currentTimeMillis() + 25;
        Plane.setTime(startTime);
        
        Plane[] departures = new Plane[N];
        for (int i = 0; i < N; i++) {
            departures[i] = new Plane(departure_times[i], true, controller);
            departures[i].start();
        }

        Plane[] arrivals = new Plane[M];
        for (int i = 0; i < M; i++) {
            arrivals[i] = new Plane(arrival_times[i], false, controller);
            arrivals[i].start();
        }
        
        
        Thread.sleep(Math.max((int)(startTime - System.currentTimeMillis()), 0));
        controller.start();

        for (int i = 0; i < N; i++) {
            departures[i].join();
        }
        for (int i = 0; i < M; i++) {
            arrivals[i].join();
        }
        
        System.out.print("Fim");

    }
}