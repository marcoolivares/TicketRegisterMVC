/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class TicketModel
{
    private Connection connection;
    Statement statement;
    ResultSet resultSet;
    private String url = "jdbc:mysql://localhost:3306/citation";
    private String query = "";
    
    private ArrayList<Ticket> ticketList = new ArrayList<>();
    
    public TicketModel()
    {
        //connecting to the database
        getDatabaseConnection();
        //loading the tickets from the database
        loadTickets();
        
    }
    /**
     * Receives 10 strings which are the values of the ticket, creates a new Ticket object and
     * finally add the created ticket to the ArrayList.
     * The default value for the "paid" variable is false
     * @param a is the ticket number and primary key
     * @param b is the license number
     * @param c is the state
     * @param d is the permit number
     * @param e is the model
     * @param f is the color
     * @param g is the reason
     * @param h is the date
     * @param i is the time
     * @param j is the location 
     * @param k is the name of the person who issued the ticket
     */
    public int createTicket(int a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k)
    {
        Ticket t = new Ticket();
        t.setNumber(a);
        t.setLicense(b);
        t.setState(c);
        t.setPermitnumber(d);
        t.setModel(e);
        t.setColor(f);
        t.setReason(g);
        t.setDate(h);
        t.setTime(i);
        t.setLocation(j);
        t.setIssuedby(k);
        t.setPaymentinfo("PAYMENTS\n"
                + "Payments can be made at the following office:\n"
                + "Business Office, Tandy 107\n"
                + "Monday thru Friday 8:00 am - 5:00 pm\n"
                + "$25 per citation, other fees may apply\n"
                + "$100 for boot removal\n"
                + "Payment can be mailed to the following address:\n"
                + "TSC C/O Finance Dept\n"
                + "Attn: Parking Enforcement\n"
                + "80 Fort Brown\n"
                + "Brownsville, TX 78520\n"
                + "DO NOT MAIL IN CASH!\n"
                + "For More Information on parking citations please visit:\n"
                + "www.tsc.edu/parking\n");
        t.setPaid(false);
        
        //verifying that the ticket we want to add doesn't have a duplicated primary key value
        boolean add = true;
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == a)
            {
                
                add = false;
            }
        }
        if(add)
        {
            ticketList.add(t);
            storeTicket(t);
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    /**
     * Returns the license number of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its license number
     * @return 
     */
    public String getCurrentTicketNumber(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                return ""+ticket.getNumber();
            }
            value++;
        }
        return "";
    }
    
    /**
     * Returns the license number of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its license number
     * @return 
     */
    public String getCurrentTicketLicenseNumber(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getLicense().compareTo("")!=0)
                    return ticket.getLicense();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }
    
    /**
     * Returns the state of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its state
     * @return 
     */
    public String getCurrentState(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getState().compareTo("")!=0)
                    return ticket.getState();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }   
    
    /**
     * Returns the permit number of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its permit number
     * @return 
     */
    public String getCurrentPermitNumber(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getPermitnumber().compareTo("") != 0)
                    return ticket.getPermitnumber();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }   
    
    /**
     * Returns the vehicle model of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its vehicle model
     * @return 
     */
    public String getCurrentModel(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getModel().compareTo("") != 0)
                    return ticket.getModel();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }
    
    /**
     * Returns the vehicle color of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its vehicle color
     * @return 
     */
    public String getCurrentColor(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getColor().compareTo("")!=0)
                    return ticket.getColor();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }  
    
    /**
     * Returns the reason of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its reason
     * @return 
     */
    public String getCurrentReason(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getReason().compareTo("")!=0)
                    return ticket.getReason();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }  
    
    /**
     * Returns the date of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its date
     * @return 
     */
    public String getCurrentDate(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getDate().compareTo("")!=0)
                    return ticket.getDate();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }   
    
    /**
     * Returns the time of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its time
     * @return 
     */
    public String getCurrentTime(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getTime().compareTo("")!=0)
                    return ticket.getTime();
                else
                    return "---";
            }
            value++;
        }
        return "";
    } 
    
    /**
     * Returns the location of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its location
     * @return 
     */
    public String getCurrentLocation(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getLocation().compareTo("")!=0)
                    return ticket.getLocation();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }   
    
    /**
     * Returns the name of the person who issued the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its issued name
     * @return 
     */
    public String getCurrentIssuedBy(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getIssuedby().compareTo("")!=0)
                    return ticket.getIssuedby();
                else
                    return "---";
            }
            value++;
        }
        return "";
    }   
    
    /**
     * 
     * @return a String with all the payment information
     */
    public String getPaymentInformation()
    {
        return "PAYMENTS\n"
                + "Payments can be made at the following office:\n"
                + "Business Office, Tandy 107\n"
                + "Monday thru Friday 8:00 am - 5:00 pm\n"
                + "$25 per citation, other fees may apply\n"
                + "$100 for boot removal\n"
                + "Payment can be mailed to the following address:\n"
                + "TSC C/O Finance Dept\n"
                + "Attn: Parking Enforcement\n"
                + "80 Fort Brown\n"
                + "Brownsville, TX 78520\n"
                + "DO NOT MAIL IN CASH!\n"
                + "For More Information on parking citations please visit:\n"
                + "www.tsc.edu/parking\n";
    }
    
    /**
     * Returns the paid state of the current ticket.
     * if the value of the boolean variable is false, the method will return a "paid" string, if not
     * it will return a "unpaid" string
     * @param currentTicket is the number of the ticket which system needs to get its paid state
     * @return 
     */
    public String getCurrentPaidStatus(int currentTicket)
    {
        int value = 1;
        for(Ticket ticket : ticketList)
        {
            if(value == currentTicket)
            {
                if(ticket.getPaid())
                    return "paid";
                else
                    return "unpaid";
            }
            value++;
        }
        return "";
    }
    
    /**
     * This method will change the value of the boolean variable to true is the current value is false, or viceversa
     * @param currentTicket is the name of the current ticket
     */
    public void changePaidStatus(int currentTicket)
    {
        for (int i = 0; i < ticketList.size(); i++) 
        {
            if(i+1 == currentTicket)
            {
                if(ticketList.get(i).getPaid())
                {
                    ticketList.get(i).setPaid(false);
                    updateTicket(ticketList.get(i).getNumber(), 0);
                }
                else
                {
                    ticketList.get(i).setPaid(true);
                    updateTicket(ticketList.get(i).getNumber(), 1);
                }
            }
        }
    }
    
    /**
     * 
     * @return the ArrayList with all the created tickets.
     */
    public ArrayList<Ticket> getTicketList()
    {
        return ticketList;
    }
    
    public void storeTicket(Ticket lastTicket)
    {
        query = "insert into ticket(ticketnumber, licensenumber, state, permitnumber, model, color, reason, date,";
        query += "time, location, issuedby, paid) value ('"+lastTicket.getNumber()+"','"+lastTicket.getLicense();
        query += "','"+lastTicket.getState()+"','"+lastTicket.getPermitnumber()+"','"+lastTicket.getModel()+"','";
        query += lastTicket.getColor()+"','"+lastTicket.getReason()+"','"+lastTicket.getDate()+"','"+lastTicket.getTime()+"','";
        query += lastTicket.getLocation()+"','"+lastTicket.getIssuedby()+"',"+lastTicket.getPaid()+")";
        
        try
        {
            //executing the query
            statement.executeUpdate(query);
        } catch (SQLException ex)
        {
            Logger.getLogger(TicketModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error, query couldn't be executed");
        }    
    } 
    
    public void updateTicket(int ticketNumber, int paid)
    {
        query = "update ticket set paid = "+paid+" where ticketnumber = "+ticketNumber+"";
        try
        {
            //executing the query
            statement.executeUpdate(query);
        } catch (SQLException ex)
        {
            Logger.getLogger(TicketModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error, query couldn't be executed");
        }
    }
    
    public void getDatabaseConnection()
    {
        try
        {
            connection = DriverManager.getConnection(url, "root", "root");
            statement = connection.createStatement();
        } catch (SQLException ex)
        {
            Logger.getLogger(TicketModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection()
    {
        try
        {
            connection.close();
        } catch (SQLException ex)
        {
            Logger.getLogger(TicketModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadTickets()
    {
        int ticketnumber;
        String license;
        String state;
        String permitNumber;
        String model;
        String color;
        String reason;
        String date;
        String time;
        String location;
        String issuedby;
        boolean paid;
        Ticket t;
        try
        {
            query = "select * from ticket";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                ticketnumber = Integer.parseInt(""+resultSet.getObject(1));
                license = ""+resultSet.getObject(2);
                state = ""+resultSet.getObject(3);
                permitNumber = ""+resultSet.getObject(4);
                model = ""+resultSet.getObject(5);
                color = ""+resultSet.getObject(6);
                reason = ""+resultSet.getObject(7);
                date = ""+resultSet.getObject(8);
                time = ""+resultSet.getObject(9);
                location = ""+resultSet.getObject(10);
                issuedby = ""+resultSet.getObject(11);
                
                if(Integer.parseInt(""+resultSet.getObject(12))==1)
                {
                    paid = true;
                }
                else
                {
                    paid = false;
                }
                
                //creating a new ticket
                t = new Ticket();
                t.setNumber(ticketnumber);
                t.setLicense(license);
                t.setState(state);
                t.setPermitnumber(permitNumber);
                t.setModel(model);
                t.setColor(color);
                t.setReason(reason);
                t.setDate(date);
                t.setTime(time);
                t.setLocation(location);
                t.setIssuedby(issuedby);
                t.setPaymentinfo("PAYMENTS\n"
                        + "Payments can be made at the following office:\n"
                        + "Business Office, Tandy 107\n"
                        + "Monday thru Friday 8:00 am - 5:00 pm\n"
                        + "$25 per citation, other fees may apply\n"
                        + "$100 for boot removal\n"
                        + "Payment can be mailed to the following address:\n"
                        + "TSC C/O Finance Dept\n"
                        + "Attn: Parking Enforcement\n"
                        + "80 Fort Brown\n"
                        + "Brownsville, TX 78520\n"
                        + "DO NOT MAIL IN CASH!\n"
                        + "For More Information on parking citations please visit:\n"
                        + "www.tsc.edu/parking\n");
                t.setPaid(paid);
                ticketList.add(t);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(TicketModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}