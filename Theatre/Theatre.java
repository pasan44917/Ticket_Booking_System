import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Theatre {

    //creating arrays
    static int[] row1= new int[12];
    static int[] row2= new int[16];
    static int[] row3=new int[20];
    static int[][] rows ={row1,row2,row3};

    //making array list
    static ArrayList<Ticket> allTickets=new ArrayList<Ticket>();

    static ArrayList<Ticket> sortedTickets=new ArrayList<Ticket>();
    static File row_save = new File("/C:/Users/C H I K U/OneDrive/Desktop/20221518_w1956428/saved.txt");


    //buy_ticket method
    public static void buy_ticket(){

        Scanner input3=new Scanner(System.in);
        System.out.println("Enter your name:");
        String name=input3.nextLine();

        Scanner input4=new Scanner(System.in);
        System.out.println("Enter your surname: ");
        String surname=input4.nextLine();

        Scanner input5=new Scanner(System.in);
        System.out.println("Enter your e-mail: ");
        String mail=input5.nextLine();

        Scanner input1=new Scanner(System.in);
        System.out.println("Enter row number:");
        int rowNumber=input1.nextInt();

        Scanner input2=new Scanner(System.in);
        System.out.println("Enter seat number:");
        int seatNumber=input2.nextInt();

        Scanner input6=new Scanner(System.in);
        System.out.println("Enter ticket price: ");
        double price=input6.nextDouble();

        Person obj=new Person(name,surname,mail);

        Ticket newTicket=new Ticket(rowNumber,seatNumber,price,obj);

        if (rowNumber<=3){
            if(rowNumber==1){
                if (seatNumber<=12){
                    if (row1[seatNumber-1]==0){
                        row1[seatNumber-1]=1;
                        System.out.println("Reserved");
                        allTickets.add(newTicket);
                        sortedTickets.add(newTicket);
                    }
                    else {
                        System.out.println("Seat is not Available.");
                    }
                }
                else {
                    System.out.println("Error: This seat number does not exist. Please select 1-12.");
                }
            } else if (rowNumber==2) {
                if (seatNumber<=16){
                    if (row2[seatNumber-1]==0){
                        row2[seatNumber-1]=1;
                        System.out.println("Reserved");
                        allTickets.add(newTicket);
                        sortedTickets.add(newTicket);
                    }
                    else {
                        System.out.println("Seat is not Available.");
                    }
                }
                else {
                    System.out.println("Error: This seat number does not exist. Please select 1-16.");
                }

            } else if (rowNumber==3) {
                if (seatNumber<=20){
                    if (row3[seatNumber-1]==0){
                        row3[seatNumber-1]=1;
                        System.out.println("Reserved");
                        allTickets.add(newTicket);
                        sortedTickets.add(newTicket);
                    }
                    else {
                        System.out.println("Seat is not Available.");
                    }
                }
                else {
                    System.out.println("Error: This seat number does not exist. Please select 1-20.");
                }

            }
        }
        else {
            System.out.println("Error: This row number does not exist. Please select 1-3.");
        }

    }

    //method of printing seat ares
    public static void print_seating_area(){
        System.out.println("       ***********");
        System.out.println("       *  STAGE  *");
        System.out.println("       ***********");
        //print row 1
        System.out.print("      ");
        for (int i=0;i<=11;i++){
            if (i == 6)
                System.out.print(" ");
            if (row1[i]==0){
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }
        System.out.println();

        //print row 2
        System.out.print("    ");
        for (int i=0;i<=15;i++){
            if(i==8)
                System.out.print(" ");
            if (row2[i]==0){
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }
        System.out.println();

        //print row 3
        System.out.print("  ");
        for (int i=0;i<=19;i++){
            if(i==10)
                System.out.print(" ");
            if (row3[i]==0){
                System.out.print("O");
            }
            else {
                System.out.print("X");
            }
        }
        System.out.println();
    }

    //method for cancelling ticket
    public static void cancel_ticket(){
        Scanner input1=new Scanner(System.in);
        System.out.println("Enter row number:");
        int rowNumber=input1.nextInt();

        Scanner input2=new Scanner(System.in);
        System.out.println("Enter seat number:");
        int seatNumber=input2.nextInt();

        if (rowNumber<=3){
            if(rowNumber==1){
                if (seatNumber<=12){
                    if (row1[seatNumber-1]==1) {
                        row1[seatNumber - 1] = 0;
                        System.out.println("Canceled");

                        for (int i = 0; i < allTickets.size(); i++) {
                            if (allTickets.get(i).row == rowNumber && allTickets.get(i).seat == seatNumber) {
                                allTickets.remove(i);
                            }
                        }
                        for (int i = 0; i < sortedTickets.size(); i++) {
                            if (sortedTickets.get(i).row == rowNumber && sortedTickets.get(i).seat == seatNumber) {
                                sortedTickets.remove(i);
                            }
                        }
                    }
                    else {
                        System.out.println("Seat is still available.");
                    }
                }
                else {
                    System.out.println("Over the amount of the seats.");
                }
            } else if (rowNumber==2) {
                if (seatNumber<=16){
                    if (row2[seatNumber-1]==1){
                        row2[seatNumber-1]=0;
                        System.out.println("Canceled");

                        for (int i=0;i<allTickets.size();i++){
                            if (allTickets.get(i).row==rowNumber && allTickets.get(i).seat==seatNumber){
                                allTickets.remove(i);
                            }
                        }
                        for (int i = 0; i < sortedTickets.size(); i++) {
                            if (sortedTickets.get(i).row == rowNumber && sortedTickets.get(i).seat == seatNumber) {
                                sortedTickets.remove(i);
                            }
                        }
                    }
                    else {
                        System.out.println("Seat is still available.");
                    }
                }
                else {
                    System.out.println("Over the amount of the seats.");
                }

            } else if (rowNumber==3) {
                if (seatNumber<=20){
                    if (row3[seatNumber-1]==1){
                        row3[seatNumber-1]=0;
                        System.out.println("Canceled");

                        for (int i=0;i<allTickets.size();i++){
                            if (allTickets.get(i).row==rowNumber && allTickets.get(i).seat==seatNumber){
                                allTickets.remove(i);
                            }
                        }
                        for (int i = 0; i < sortedTickets.size(); i++) {
                            if (sortedTickets.get(i).row == rowNumber && sortedTickets.get(i).seat == seatNumber) {
                                sortedTickets.remove(i);
                            }
                        }
                    }
                    else {
                        System.out.println("Seat is still available.");
                    }
                }
                else {
                    System.out.println("Over the amount of the seats.");
                }

            }
        }
        else {
            System.out.println("Over the rows limit.");
        }

    }

    //method of displaying still available seats
    public static void show_available(){
        //row 1
        System.out.print("Seats available in row 1: ");
        for (int i=0;i<=11;i++){
            if (row1[i]==0){
                System.out.print(i+1+", ");
            }
        }
        System.out.println();
        //row 2
        System.out.print("Seats available in row 2: ");
        for (int i=0;i<=15;i++){
            if (row2[i]==0){
                System.out.print(i+1+", ");
            }
        }
        System.out.println();
        //row 3
        System.out.print("Seats available in row 3: ");
        for (int i=0;i<=19;i++){
            if (row3[i]==0){
                System.out.print(i+1+", ");
            }
        }
        System.out.println();
    }
    //method of displaying tickets informations and shows the all buy tickets total
    public static  void show_tickets_info(){

        int i=-1;
        double totalPrice=0.0;

        for (Ticket ticket:allTickets){
            i+=1;
            ticket.print();
            totalPrice+=allTickets.get(i).price;
            System.out.println();
        }
        System.out.println("Total price is: "+totalPrice);
    }
    //saves the 3 arrays with the row’s information in a file
    static void save() {
        try {
            FileWriter data = new FileWriter("/C:/Users/C H I K U/OneDrive/Desktop/new/saved.txt");
            data.write(Arrays.deepToString(rows));
            data.close();
            System.out.println("Successful");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    //loads the file saved in Task 7 and restores the 3 arrays with the row's information
    static void load() {
        try {
            Scanner row_data = new Scanner(row_save);
            String input_data = row_data.nextLine();
            System.out.println(input_data);
            System.out.println("Loading Successful");
            row_data.close();

            input_data = input_data.replaceAll("]", "").replaceAll("\\[", "");
            String[] list_input_data= input_data.split(", ");

            for (int a=0;a<12;a++)
                row1[a]=Integer.parseInt(list_input_data[a]);
            for (int b=0;b<16;b++)
                row2[b]=Integer.parseInt(list_input_data[b+12]);
            for(int c=0; c<20;c++)
                row3[c]=Integer.parseInt(list_input_data[c+27]);

        } catch (FileNotFoundException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
    }
    //Sorting ticket information from law price to high price
    static void sort_tickets(){

        Comparator<Ticket> com = new Comparator<>() {
            public int compare(Ticket x, Ticket y) {
                if (x.price>y.price)
                    return 1;
                else
                    return -1;
            }
        };
        sortedTickets.sort(com);
        for (Ticket ti:sortedTickets)
            ti.print();
    }
    public static void main(String[] args){

                //Creating welcome message
                System.out.println("Welcome to the New Theatre");
                System.out.println();
                System.out.println("---------------------------------------------------");
                System.out.println();


                //print options
                System.out.println("Please select an option:");
                System.out.println("  1. Buy a ticket");
                System.out.println("  2. Print seating area");
                System.out.println("  3. Cancel ticket");
                System.out.println("  4. List available seats");
                System.out.println("  5. Save to file");
                System.out.println("  6. Load from file");
                System.out.println("  7. Print ticket information and total price");
                System.out.println("  8. Sort ticket by price");
                System.out.println("0. Quit");
                System.out.println();
                System.out.println("---------------------------------------------------");

                while (true) {
                    Scanner input = new Scanner(System.in);
                    try {
                    //get  user input for option
                    System.out.println("Enter option:");
                    int option = input.nextInt();

                    //check user option
                    if (option == 0) {
                        System.out.println("----------------------END-----------------------");
                        break;
                    } else if (option == 1) {
                        buy_ticket();

                    } else if (option == 2) {
                        print_seating_area();

                    } else if (option == 3) {
                        cancel_ticket();

                    } else if (option == 4) {
                        show_available();

                    } else if (option == 5) {
                        save();

                    } else if (option == 6) {
                        load();

                    } else if (option == 7) {
                        show_tickets_info();

                    } else if (option == 8) {
                        sort_tickets();

                    } else {
                        System.out.println("Invalid option");
                    }
                    } catch(InputMismatchException e) {
                        System.out.println("Please enter a valid option");
                        input.next();
                    }
                }


    }
}
