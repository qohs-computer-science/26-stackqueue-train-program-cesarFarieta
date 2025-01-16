public class Train {
    private String name, product, origin, destination;
    private int weight, miles;


    public Train (String car, String con, String city, String dest, int size, int dist){
            name=car;
            product=con;
            origin=city;
            destination=dest;
            weight=size;
            miles=dist;
    } 
    public Train (String car, String dest){
            name=car;
            destination=dest;
    }

    public String getName() {
        return name;
      }
    
    public String getProduct() {
        return product;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public int getMiles() {
        return miles;
    }

    public int setMiles() {
        miles =  100;
        return miles;
    }

    public String toString(){
        return "Name "+this.name +"\n Product "+this.product +"\n Origin "+this.origin +"\n Destination "+this.destination +"\n Weight "+this.weight +"\n Miles "+this.miles; 
    }


}
