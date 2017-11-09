
import java.time.LocalTime;
import java.util.Scanner;
import java.sql.*;
import java.util.Date;

import java.util.Calendar;

public class myEcafe {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String customer_name = "";
        int counter = 0;
        int temp = 0;
        Calendar cal = Calendar.getInstance(); //Create Calendar-Object
        cal.setTime(new Date());               //Set the Calendar to now
        int hour = cal.get(Calendar.HOUR_OF_DAY); //Get the hour from the calendar

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3303/e-cafe", "root", "");

        Statement stmt = con.createStatement();
        if (hour <= 22 && hour >= 11) {
            try {

                //print the menu 
                System.out.println("Serial No. \t\t Menu \t\t\t\t\t\t Price");
                ResultSet rs = stmt.executeQuery("select * from menu");
                while (rs.next()) {

                    System.out.print(rs.getInt(1) + " \t\t" + rs.getString(2));
                    System.out.println("  \t\t\t\t\t" + rs.getInt(3));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Enter Your Name");
            Scanner name = new Scanner(System.in);
            customer_name = name.next();

            System.out.println("DO YOU WANT TO PALCE AN ORDER ?? Press 1 for yes and 0 for No");
            Scanner option = new Scanner(System.in);
            int opt = option.nextInt();

            if (opt == 1) {
                int bill = 0;
                int x = 1;
                int z=1;
                do {

                    PreparedStatement check = con.prepareStatement("select status from chef");
                    ResultSet get_status = check.executeQuery();
                    while (get_status.next()) {
                        System.out.println("Status of chef "+z +": "+get_status.getInt("status")+" seconds remaining");
                        z++;
                    }
                    System.out.println("\n\n Choose any of the above dish from the menu. Use index number for selecting thaat item :");
                    Scanner order = new Scanner(System.in);
                    int ord = order.nextInt();
                    PreparedStatement get_chef = con.prepareStatement("SELECT chef_id FROM chef WHERE status=(select min(status) from chef)");

                    ResultSet getchef = get_chef.executeQuery();
                    while (getchef.next()) {
                        temp = getchef.getInt(1);
                    }

                    // System.out.println("cheff is : "+temp);
                    String query = "INSERT INTO placeorder(c_name,orderID,chef_Id)" + "values(?,?,?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, customer_name);
                    pst.setInt(2, ord);
                    pst.setInt(3, temp);
                    pst.execute();
                    
                   
                    
                    
                    String statusupdate = "UPDATE chef SET Status = ? WHERE chef_Id= ?";
                    PreparedStatement su = con.prepareStatement(statusupdate);
                    su.setInt(1, 900);
                    su.setInt(2, temp);
                    su.execute();

                    CallableStatement cstmt = null;
                    switch (ord) {

                        case 1:
                             
                                cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs=cstmt.getResultSet();
                                while(qs.next()){
                                    System.out.println("Your selected item is : "+qs.getString("name"));
                                }
                                cstmt.close();
                            
                            bill += 350;
                            break;
                        case 2:
                                
                                cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs2=cstmt.getResultSet();
                                while(qs2.next()){
                                    System.out.println("Your selected item is : "+qs2.getString("name"));
                                }
                                cstmt.close();
                            bill += 250;
                            break;
                        case 3:
                             cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs3=cstmt.getResultSet();
                                while(qs3.next()){
                                    System.out.println("Your selected item is : "+qs3.getString("name"));
                                }
                                cstmt.close();
                            bill += 300;
                            break;
                        case 4:
                             cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs4=cstmt.getResultSet();
                                while(qs4.next()){
                                    System.out.println("Your selected item is : "+qs4.getString("name"));
                                }
                                cstmt.close();
                            bill += 550;
                            break;
                        case 5:
                           cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs5=cstmt.getResultSet();
                                while(qs5.next()){
                                    System.out.println("Your selected item is : "+qs5.getString("name"));
                                }
                                cstmt.close();
                            bill += 380;
                            break;
                        case 6:
                             cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs6=cstmt.getResultSet();
                                while(qs6.next()){
                                    System.out.println("Your selected item is : "+qs6.getString("name"));
                                }
                                cstmt.close();
                            bill += 320;
                            break;
                        case 7:
                            cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs7=cstmt.getResultSet();
                                while(qs7.next()){
                                    System.out.println("Your selected item is : "+qs7.getString("name"));
                                }
                                cstmt.close();
                            bill += 550;
                            break;
                        case 8:
                            cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs8=cstmt.getResultSet();
                                while(qs8.next()){
                                    System.out.println("Your selected item is : "+qs8.getString("name"));
                                }
                                cstmt.close();
                            bill += 450;
                            break;
                        case 9:
                             cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs9=cstmt.getResultSet();
                                while(qs9.next()){
                                    System.out.println("Your selected item is : "+qs9.getString("name"));
                                }
                                cstmt.close();
                            bill += 380;
                            break;
                        case 10:
                             cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs10=cstmt.getResultSet();
                                while(qs10.next()){
                                    System.out.println("Your selected item is : "+qs10.getString("name"));
                                }
                                cstmt.close();
                            bill += 390;
                            break;
                        case 11:
                             cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs11=cstmt.getResultSet();
                                while(qs11.next()){
                                    System.out.println("Your selected item is : "+qs11.getString("name"));
                                }
                                cstmt.close();
                            bill += 470;
                            break;
                        case 12:
                            cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs12=cstmt.getResultSet();
                                while(qs12.next()){
                                    System.out.println("Your selected item is : "+qs12.getString("name"));
                                }
                                cstmt.close();
                            bill += 500;
                            break;
                        case 13:
                             cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs13=cstmt.getResultSet();
                                while(qs13.next()){
                                    System.out.println("Your selected item is : "+qs13.getString("name"));
                                }
                                cstmt.close();
                            bill += 530;
                            break;
                        case 14:
                           cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs14=cstmt.getResultSet();
                                while(qs14.next()){
                                    System.out.println("Your selected item is : "+qs14.getString("name"));
                                }
                                cstmt.close();
                            bill += 690;
                            break;
                        case 15:
                             cstmt = con.prepareCall("{call proc (?)}");
                                cstmt.setInt(1, ord);
                                cstmt.execute();
                                ResultSet qs15=cstmt.getResultSet();
                                while(qs15.next()){
                                    System.out.println("Your selected item is : "+qs15.getString("name"));
                                }
                                cstmt.close();
                            bill += 420;
                            break;
                        default:
                            System.out.println(" !!!...invalid menu item,please select again");
                            break;

                    }
                    counter++;

                    System.out.println("your bill is : " + bill);

                    System.out.println("if you want to add more item to menu ,Press '1' to continue or press '0' to exit");
                    Scanner continue_this = new Scanner(System.in);
                    int cont = continue_this.nextInt();
                    if (cont == 0) {
                        x = 0;
                        System.out.println("\nNow you are going to exit the menu \n");
                    } else {
                        x = 1;
                    }
                } while (x == 1);
            } else {

            }
            System.out.println("You have order  " + counter + " dishes");
            System.out.println("You have 2 options : ");
            System.out.println(" 1)for deliver");
            System.out.println(" 2)for pickup");
            System.out.println("Enter any of the option options");
            Scanner del = new Scanner(System.in);
            int delivery = del.nextInt();
            if (delivery == 1) {

                LocalTime time = LocalTime.now();
                Calendar date = Calendar.getInstance();
                long t = date.getTimeInMillis();
                Time afterAddingMins = new Time(t + (15 * counter * 60000));

                System.out.println("enter you home adress : ");
                Scanner adr = new Scanner(System.in);
                String adress = adr.next();

                String adress_query = "INSERT INTO delivery(custom_name,address)" + "values(?,?)";
                PreparedStatement aq = con.prepareStatement(adress_query);
                aq.setString(1, customer_name);
                aq.setString(2, adress);
                aq.execute();
                System.out.println("Order was taken at time : " + time);
                System.out.println("\nThis order will be delivered to (" + customer_name + ")at time : " + afterAddingMins);

            } else {
                LocalTime time = LocalTime.now();
                Calendar date = Calendar.getInstance();
                long t = date.getTimeInMillis();
                Time afterAddingMins = new Time(t + (15 * counter * 60000));

                String pickup_query = "INSERT INTO pickup(c_name,pickup_time)" + "values(?,?)";
                PreparedStatement pq = con.prepareStatement(pickup_query);
                pq.setString(1, customer_name);
                pq.setTime(2, afterAddingMins);
                pq.execute();
                System.out.println("\nOrder was taken at time : " + time);
                System.out.println("\n" + customer_name + " you can pick up your order at time : " + afterAddingMins);

            }

        } else {
            System.out.println("Cafe is closed.Come between 11am to 10pm");

        }
    }
}
