/*
 * Cesar Farieta
 * 01/27/25
 * 3pd
 * This programs runs through a file and sorts the trains and engines with stacks and queues depedning on how many miles and the destination. Also if they have to much weight it just sends them to the destination.
 * the program outputs the train, what engine it is going with and what carts it has attached, including what the carts have inside too.
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {// Start class
	public static int val = 0;
	public static void main(String[] args) {// start main
		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
		Scanner x = new Scanner(System.in);
		Queue <Train> myQ = new LinkedList <Train> ();
		try{// start try
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			while (!name.toLowerCase().equals("end"))// start while
			{// start while
				if (name.substring(0,3).equals("CAR") )
				{// start if 
					String product = x.nextLine();
					String origin = x.nextLine();
					String dest = x.nextLine();
					int weight = x.nextInt();
					int mile = x.nextInt();
					x.nextLine();
					myQ.add(new Train(name, product, origin, dest , weight, mile));
				}// end if 
				else{// start else
					String dest = x.nextLine();
					myQ.add(new Train(name, dest));
				}// end else
				name= x.nextLine();
			}// end while
		}// end try
		catch(Exception e)
		{// start catch
			System.out.println(e.getMessage());
		}// end catch
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
			else if(car.getDestination().equals("Trenton")){// start else if 
				if (car.getName().substring(0,3).equals("CAR")){// start if 1
					if(weightA + car.getWeight()<=limitTrackA){// start if 2 
						TrackA.push(car);
						weightA += car.getWeight();
					}// end if 2
					else{// start else
						System.out.println();
						System.out.println("Sent out to Trenton");
						System.out.println("ENG00000 leaving for Trenton with following cars");
						while(TrackA.isEmpty()==false){// start while
							Train temp = TrackA.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
						}// end while
						TrackA.push(car);
						weightA = car.getWeight();
					}// end else 
				}// end if 1 
				else {// start else for engine
					System.out.println();
					System.out.println("Sent out to Trenton");
					System.out.println(car.getName() + " leaving for "+ car.getDestination()+ " with the following cars: ");
					while(TrackA.isEmpty()==false){// start while
						Train temp = TrackA.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}// end while
					weightA=0;
				}// end else
			}// end else if TRENTON
			else if(car.getDestination().equals("Charlotte")){// start else if 
				if(car.getName().substring(0,3).equals("CAR")){// start if 1
					if(weightB + car.getWeight() <= limitTrackB){// start if 2
						TrackB.push(car);
						//car.setMiles();
						weightB += car.getWeight();
					}// end if 2
					else {// start else
						System.out.println();
						System.out.println("Sent out to Charlotte");
						System.out.println("ENG00000 leaving for Charlotte with following cars: ");
						while(!TrackB.isEmpty()){// start while
							Train temp = TrackB.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
						}// end while
						TrackB.push(car);
						weightB = car.getWeight();
					}// end else
				} else {// start else
					System.out.println();
					System.out.println("Sent out to Charlotte");
					System.out.println(car.getName() + " leaving for " + car.getDestination() + " with the following cars: ");
					while(!TrackB.isEmpty()){// start while
							Train temp = TrackB.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}// end while 
					weightB = 0;
				}// end if 1
			} else if(car.getDestination().equals("Baltimore")){// start else if
				if(car.getName().substring(0,3).equals("CAR")){// start if 
					if(weightC + car.getWeight() <= limitTrackC){// start if 2
						TrackC.push(car);
						//car.setMiles();
						weightC += car.getWeight();
					} else {// start else
						System.out.println();
						System.out.println("Sent out to Baltimore");
						System.out.println("ENG00000 leaving for Baltimore with following cars: ");
						while(!TrackC.isEmpty()){// start while
							Train temp = TrackC.pop();
							System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
						}// end while
						TrackC.push(car);
						weightC = car.getWeight();
					}// end else
				} else {// start else 
					System.out.println();
					System.out.println("Sent out to Baltimore");
					System.out.println(car.getName() + " leaving for " + car.getDestination() + " with the following cars: ");
					while(!TrackC.isEmpty()){// start while
						Train temp = TrackC.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}// end while
					weightC = 0;
				}// end else
			} else {// start else
				TrackD.push(car);
			}// end else
			
		}// end while
		System.out.println();
		System.out.println();
		while (!Track1.isEmpty()){// start while
			Train car= Track1.pop();
			car.setMiles();
			if(car.getDestination().equals("Trenton")){// start if 
				if(weightA + car.getWeight()<=limitTrackA){// start if 2
					TrackA.push(car);
					weightA += car.getWeight();
					}// end if 2 
				else{// start else
					System.out.println();
					System.out.println("Sent out to Trenton");
					System.out.println("ENG00000 leaving for Trenton with following cars");
					while(TrackA.isEmpty()==false){// start while
						Train temp = TrackA.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}// end while
					TrackA.push(car);
					weightA = car.getWeight();
				}// end else 
			}// end if 1 
			else if(car.getDestination().equals("Charlotte")){// start if else 
				if(weightB + car.getWeight()<=limitTrackB){// start if 
					TrackB.push(car);
					weightB += car.getWeight();
					}// end if 
				else{// start ekse 
					System.out.println();
					System.out.println("Sent out to Charlotte");
					System.out.println("ENG00000 leaving for Charlotte with following cars");
					while(TrackB.isEmpty()==false){// start while
						Train temp = TrackB.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}// end while
					TrackB.push(car);
					weightB = car.getWeight();
				}// start ele
			}// end esle if 
			else if(car.getDestination().equals("Baltimore")){// start else if 
				if(weightC + car.getWeight()<=limitTrackC){// start if
					TrackC.push(car);
					weightC += car.getWeight();
					}// end if 
				else{// start ekse 
					System.out.println();
					System.out.println("Sent out to Baltimore");
					System.out.println("ENG00000 leaving for Baltimore with following cars");
					while(TrackC.isEmpty()==false){// stat while
						Train temp = TrackC.pop();
						System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
					}// end while
					TrackC.push(car);
					weightC = car.getWeight();
				}// start else 
			}// end esle if 
			else {// start else
				TrackD.push(car);
			}// end esle 
		}// end while
		System.out.println();
		System.out.println("Sent out to Trenton");
		System.out.println("ENG00000 sent to Trenton with following cars");		
		while(TrackA.isEmpty()==false){// start while 
			Train temp = TrackA.pop();
			System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
		}// end while
		weightA = 0;
		System.out.println();
		System.out.println("Sent out to Charlotte");
		System.out.println("ENG00000 sent to Charlotte with following cars");		
		while(TrackB.isEmpty()==false){// start while 
			Train temp = TrackB.pop();
			System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
		}// end while
		weightB = 0;
		System.out.println();
		System.out.println("Sent out to Baltimore");
		System.out.println("ENG00000 sent to Baltimore with following cars");		
		while(TrackC.isEmpty()==false){// start while 
			Train temp = TrackC.pop();
			System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
		}// end while
		weightC = 0;
		System.out.println();
		System.out.println("Trains leaving for other destinations: ");
		while(!TrackD.isEmpty()){// start while 
			Train temp = TrackD.pop();
			System.out.println(temp.getName() + " containing " + temp.getProduct()+" weighing "+temp.getWeight()+"lbs with "+temp.getMiles()+" miles");
		}// end while
	}// end main
}// end class