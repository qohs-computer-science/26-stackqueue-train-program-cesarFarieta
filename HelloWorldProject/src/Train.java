public class Train {
    private String name, product, origin, destination;
    private int weight, miles;


    Public train (string car, string con, string city, string dest, int size, int dist){
            name=car;
            product=con;
            origin=city;
            destination=dest;
            weight=size;
            miles=dist;
    } 
    Public train (string car, string dest){
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

    public String getWeight() {
        return weight;
    }

    public String getMiles() {
        return miles;
    }

    public String toString(){
        return "Name "+this.name +"\n Product "+this.product +"\n Origin "+this.origin +"\n Destination "+this.destination +"\n Weight "+this.weight +"\n Miles "+this.miles; 
    }


}
