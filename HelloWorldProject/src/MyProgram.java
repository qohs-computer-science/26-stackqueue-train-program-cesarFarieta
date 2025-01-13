/*
 * TODO: Name
 * TODO: Date
 * TODO: Class Period
 * TODO: Program Description
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {

		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
	
		Scanner x = new Scanner(System.in);
		Queue <String> myQ = new LinkedList <String> ();

		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			System.out.println(name);
			myQ.add(name);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		Stack <Train> TrackA= new Stack<>();
		Stack <Train> TrackB= new Stack<>();
		Stack <Train> TrackC= new Stack<>();
		Stack <Train> TrackD= new Stack<>();
		Stack <Train> Track1= new Stack<>();
		int weightA;
		int weightB;
		int weightC;

		while (!myQ.toLowerCase.equals("end")){// start while
			Train car= myQ.peek();
			if (car.getName().substring(0,3).equals("CAR") && car.getMiles()>700){
				Track1.push(car);

			}
			










		}// end while

	}
}
