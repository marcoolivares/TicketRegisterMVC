/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class TicketModel
{
    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private static int ticketnumber = 1;
    /**
     * Receives 10 strings which are the values of the ticket, creates a new Ticket object and
     * finally add the created ticket to the ArrayList.
     * The default value for the "paid" variable is false
     * @param a is the license number
     * @param b is the state
     * @param c is the permit number
     * @param d is the model
     * @param e is the color
     * @param f is the reason
     * @param g is the date
     * @param h is the time
     * @param i is the location 
     * @param j is the name of the person who issued the ticket
     */
    public void createTicket(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j)
    {
        Ticket t = new Ticket();
        t.setNumber(ticketnumber);
        ticketnumber++;
        t.setLicense(a);
        t.setState(b);
        t.setPermitnumber(c);
        t.setModel(d);
        t.setColor(e);
        t.setReason(f);
        t.setDate(g);
        t.setTime(h);
        t.setLocation(i);
        t.setIssuedby(j);
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
        ticketList.add(t);
    }
    
    /**
     * Returns the license number of the current ticket.
     * if the value of the string is null, the method will return a "---" string
     * @param currentTicket is the number of the ticket which system needs to get its license number
     * @return 
     */
    public String getCurrentTicketLicenseNumber(int currentTicket)
    {
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getLicense().compareTo("")!=0)
                    return ticket.getLicense();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getState().compareTo("")!=0)
                    return ticket.getState();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getPermitnumber().compareTo("") != 0)
                    return ticket.getPermitnumber();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getModel().compareTo("") != 0)
                    return ticket.getModel();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getColor().compareTo("")!=0)
                    return ticket.getColor();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getReason().compareTo("")!=0)
                    return ticket.getReason();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getDate().compareTo("")!=0)
                    return ticket.getDate();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getTime().compareTo("")!=0)
                    return ticket.getTime();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getLocation().compareTo("")!=0)
                    return ticket.getLocation();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getIssuedby().compareTo("")!=0)
                    return ticket.getIssuedby();
                else
                    return "---";
            }
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
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                if(ticket.getPaid())
                    return "paid";
                else
                    return "unpaid";
            }
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
            if(ticketList.get(i).getNumber() == currentTicket)
            {
                if(ticketList.get(i).getPaid())
                    ticketList.get(i).setPaid(false);
                else
                    ticketList.get(i).setPaid(true);
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
    
}
