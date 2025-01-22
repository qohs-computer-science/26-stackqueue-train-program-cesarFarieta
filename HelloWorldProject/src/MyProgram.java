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
					x.nextLine();
					myQ.add(new Train(name, product, origin, dest , weight, mile));
				}
				else{
					String dest = x.nextLine();
					myQ.add(new Train(name, dest));
					
				}

				name= x.nextLine();
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
			Train car= myQ.remove();
	
			if (car.getName().substring(0,3).equals("CAR") && car.getMiles()>700){
				Track1.push(car);
	
			}// end if 



			else if(car.getDestination().equals("Trenton")){
				if (car.getName().substring(0,3).equals("CAR")){
					if(weightA + car.getWeight()<=limitTrackA){
						TrackA.push(car);
						//car.setMiles();
						weightA += car.getWeight();
					}
					else{
						System.out.println();
						System.out.println("Sent out to Trenton");
						System.out.println("ENG00000 leaving for Trenton with following cars");
						while(TrackA.isEmpty()==false){
							Train temp = TrackA.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
						}
						TrackA.push(car);
						weightA = car.getWeight();
					}
				}
				else {// start else for engine
					System.out.println();
					System.out.println("Sent out to Trenton");
					System.out.println(car.getName() + " leaving for "+ car.getDestination()+ " with the following cars: ");

					while(TrackA.isEmpty()==false){
						Train temp = TrackA.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}
					//System.out.println(weightA);
					weightA=0;
				}
			}// end else if TRENTON

			




			else if(car.getDestination().equals("Charlotte")){
				if(car.getName().substring(0,3).equals("CAR")){
					if(weightB + car.getWeight() <= limitTrackB){
						TrackB.push(car);
						//car.setMiles();
						weightB += car.getWeight();
					} else {
						System.out.println();
						System.out.println("Sent out to Charlotte");
						System.out.println("ENG00000 leaving for Charlotte with following cars: ");
						while(!TrackB.isEmpty()){
							Train temp = TrackB.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
						}
						TrackB.push(car);
						//car.setMiles();
						//System.out.println(weightB + " " + car.getWeight());
						weightB = car.getWeight();
						//System.out.println(weightB + " " + car.getWeight());
					}
				} else {
					System.out.println();
					System.out.println("Sent out to Charlotte");
					System.out.println(car.getName() + " leaving for " + car.getDestination() + " with the following cars: ");
					while(!TrackB.isEmpty()){
							Train temp = TrackB.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}
					//System.out.println(weightB);
					weightB = 0;
				}
			} else if(car.getDestination().equals("Baltimore")){
				if(car.getName().substring(0,3).equals("CAR")){
					if(weightC + car.getWeight() <= limitTrackC){
						TrackC.push(car);
						//car.setMiles();
						weightC += car.getWeight();
					} else {
						System.out.println();
						System.out.println("Sent out to Baltimore");
						System.out.println("ENG00000 leaving for Baltimore with following cars: ");
						while(!TrackC.isEmpty()){
							Train temp = TrackC.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
						}
						TrackC.push(car);
						//car.setMiles();
						//System.out.println(weightC + " " + car.getWeight());

						weightC = car.getWeight();
						//System.out.println(weightC + " " + car.getWeight());

					}
				} else {
					System.out.println();
					System.out.println("Sent out to Baltimore");
					System.out.println(car.getName() + " leaving for " + car.getDestination() + " with the following cars: ");
					while(!TrackC.isEmpty()){
						Train temp = TrackC.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}
					weightC = 0;
				}
			} else {
				TrackD.push(car);
			}
			
		} //



		



		System.out.println("break and start of the second part after sort");




		while (!Track1.isEmpty()){// start while
			Train car= Track1.pop();
			car.setMiles();
	
			if(car.getDestination().equals("Trenton")){
				if(weightA + car.getWeight()<=limitTrackA){
					TrackA.push(car);
					weightA += car.getWeight();
					}
				else{
					System.out.println();
					System.out.println("Sent out to Trenton");
					System.out.println("ENG00000 leaving for Trenton with following cars");
					while(TrackA.isEmpty()==false){
						Train temp = TrackA.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}
					TrackA.push(car);
					weightA = car.getWeight();
				}
			}

			

			else if(car.getDestination().equals("Charlotte")){
				if(weightB + car.getWeight()<=limitTrackB){
					TrackB.push(car);
					weightB += car.getWeight();
					}
				else{
					System.out.println();
					System.out.println("Sent out to Charlotte");
					System.out.println("ENG00000 leaving for Charlotte with following cars");
					while(TrackB.isEmpty()==false){
						Train temp = TrackB.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}
					TrackB.push(car);
					weightB = car.getWeight();
				}
			}



			else if(car.getDestination().equals("Baltimore")){
				if(weightC + car.getWeight()<=limitTrackC){
					TrackC.push(car);
					weightC += car.getWeight();
					}
				else{
					System.out.println();
					System.out.println("Sent out to Baltimore");
					System.out.println("ENG00000 leaving for Baltimore with following cars");
					while(TrackC.isEmpty()==false){
						Train temp = TrackC.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}
					TrackC.push(car);
					weightC = car.getWeight();
				}
			}

			else {
				TrackD.push(car);
			}

		}








		// loop through track __ other, changing miles - 
		System.out.println();










		System.out.println("Trains leaving for other destinations: ");
		while(!TrackD.isEmpty()){
			Train temp = TrackD.pop();
			System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
		}
	}
}