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
		Queue <Train> myQ = new LinkedList <Train> ();

		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			System.out.println(name);
			while (!name.toLowerCase.equals("end")){// start while
			{
				if (name.substring(0,3).equals("CAR") )
				{
					String name2 = x.nextLine();
					String product = x.nextLine();
					String origin = x.nextLine();
					String dest = x.nextLine();
					int weight = x.nextInt();
					int mile = x.nextInt();

					myQ.add(new Train(name2,product, origin,dest,weight,mile));
					// read in the rest of the input for a car, create a train, add train to the q
				}
				else
				{
					String name2 = x.nextLine();
					String dest = x.nextLine();
					myQ.add(new Train(name2,dest));

					// read in the rest of the input for an enginer, create a train, add train to the q
				}
				// read the next name // loop variable changing  (Still do that)
			}
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
		int weightA=0;
		int weightB=0;
		int weightC=0;

		while (!myQ.isEmpty()){// start while
			Train car= myQ.remove();
			if (car.getName().substring(0,3).equals("CAR") && car.getMiles()>700){
				Track1.push(car);
				myQ.remove(car)
				
			}// end if 



			else if(car.getDestination().equals("Trenton")){
				if (car.getName().substring(0,3).equals("CAR")){
					if(weightA + car.getWeight()<=limitTrackA){
						TrackA.push(car);
						myQ.remove(car);
					}
					else{
	
					}
				}
				else {
					while(TrackA.isEmpty()==False){
						TrackA.peep().pop();
					}

				}
			}// end else if TRENTON





			else if(car.getDestination().equals("Charlotte")){
				if (car.getName().substring(0,3).equals("CAR")){

				}
				else 


			}// end else if Charlotte
			else if(car.getDestination().equals("Baltimore")){
				if (car.getName().substring(0,3).equals("CAR")){

				}
				else 




			}// end else if Baltimore
			
			else 
				TrackD.push(car);










		}// end while

	}
}
