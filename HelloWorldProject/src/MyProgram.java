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

			while (!name.toLowerCase().equals("end"))// start while
			{
				if (name.substring(0,3).equals("CAR") )
				{
					String product = x.nextLine();
					String origin = x.nextLine();
					String dest = x.nextLine();
					int weight = x.nextInt();
					int mile = x.nextInt();
					Train tomas = new Train(name,product, origin,dest,weight,mile);
					myQ.add(tomas);
					name= x.nextLine();
				}
				else
				{
					String dest = x.nextLine();
					Train tomas = new Train(name,dest);
					myQ.add(tomas);
					name= x.nextLine();
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		Stack <Train> TrackA= new Stack<Train>();
		Stack <Train> TrackB= new Stack<Train>();
		Stack <Train> TrackC= new Stack<Train>();
		Stack <Train> TrackD= new Stack<Train>();
		Stack <Train> Track1= new Stack<Train>();
		int weightA=0;
		int weightB=0;
		int weightC=0;

		while (!myQ.isEmpty()){// start while
			Train car= myQ.peek();
			if (car.getName().substring(0,3).equals("CAR") && car.getMiles()>700){
				Track1.add(myQ.remove());

			}// end if 



			else if(car.getDestination().equals("Trenton")){
				if (car.getName().substring(0,3).equals("CAR")){
					if(weightA + car.getWeight()<=limitTrackA){
						TrackA.push(myQ.remove());
						weightA += car.getWeight();
					}
					else{
						TrackA.push(new Train ("ENG00000 ","Trenton"));
						System.out.println(TrackA.peek().getName()+ " leaving for " + TrackA.pop().getDestination() + " with the following cars: ");
						while(TrackA.isEmpty()==false){
							System.out.println(TrackA.peek().getName()+ " containing " + TrackA.pop().getProduct());
						}
						System.out.println();
						weightA=0;	
					}
				}
				else {// start else for engine
					TrackA.push(myQ.remove());
					System.out.println(TrackA.peek().getName()+ " leaving for " + TrackA.pop().getDestination() + " with the following cars: ");
					while(TrackA.isEmpty()==false){
						System.out.println(TrackA.peek().getName()+ " containing " + TrackA.pop().getProduct());
					}
					System.out.println();
					weightA=0;
				}
			}// end else if TRENTON

			else if(car.getDestination().equals("Charlotte")){
				if (car.getName().substring(0,3).equals("CAR")){
					if(weightB + car.getWeight()<=limitTrackB){
						TrackA.push(car);
						System.out.print(car.getName()+" "+ " Charlotte below limit");
						weightB += car.getWeight();
					}
					else{
						while(TrackA.isEmpty()==false){
							Train temp = TrackA.pop();
							System.out.println(car.getName()+" "+ " Charlotte Above limit");
							System.out.println(car.getName()+" containing "+ temp.getProduct());
						}
					}
				}
				else{
					while(TrackB.isEmpty()==false){
						Train temp = TrackB.pop();
						System.out.println(car.getName()+ " leaving for " + temp.getDestination() + " with the following cars: ");
						while(TrackB.isEmpty()==false){
							System.out.println(car.getName()+" "+ " CHARLOTTE sent engiine");
							System.out.println(car.getName()+" containing "+ temp.getProduct());
						}
					}
					TrackB.push(car);
				}

			}// end else if Charlotte

			else if(car.getDestination().equals("Baltimore")){
				if (car.getName().substring(0,3).equals("CAR")){
					if(weightC + car.getWeight()<=limitTrackC){
						TrackC.push(car);
						System.out.println(car.getName()+" "+ " Baltimore below limit");
						weightB += car.getWeight();
					}
					else{
						while(TrackC.isEmpty()==false){
							Train temp = TrackA.pop();
							System.out.println(car.getName()+" containing "+ temp.getProduct());
						}
					}
				}
				else {
					while(TrackC.isEmpty()==false){
						Train temp = TrackC.pop();
						System.out.println(car.getName()+ " leaving for " + temp.getDestination() + " with the following cars: ");
						while(TrackC.isEmpty()==false){
							System.out.println(car.getName()+" containing "+ temp.getProduct());
						}
					}
					TrackC.push(car);
				}

			}// end else if Baltimore
			
			else{
				TrackD.push(car);
			
				Train temp = TrackD.pop();
						System.out.println("these are the cars with other destinations:");
						while(TrackD.isEmpty()==false){
							System.out.println(car.getName()+" containing "+ car.getProduct());
						}
					
			}









		}// end while

	}
}
