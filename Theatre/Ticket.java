public class Ticket {
    private final Person obj;
    int row;
    int seat;
    double price;

    public Ticket(int row, int seat, double price, Person obj) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.obj=obj;
    }

    public void print(){
        System.out.println("Person name: "+obj.name);
        System.out.println("Person surname: "+obj.surname);
        System.out.println("Person e-mail: "+obj.email);
        System.out.println("Row: "+row);
        System.out.println("Seat: "+seat);
        System.out.println("Price: "+price);
    }
}
