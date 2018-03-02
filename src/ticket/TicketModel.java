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
    public void createTicket(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j)
    {
        Ticket t = new Ticket();
        t.setNumber(ticketnumber);
        ticketnumber++;
        //license number
        t.setLicense(a);
        //state
        t.setState(b);
        //permit number
        t.setPermitnumber(c);
        //vehicle model
        t.setModel(d);
        //color
        t.setColor(e);
        //reason
        t.setReason(f);
        //date
        t.setDate(g);
        //time
        t.setTime(h);
        //location
        t.setLocation(i);
        //issued by
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
        //adding the created object to the arraylist
        ticketList.add(t);
    }
    
    public int getCurrentTicketNumber(int currentTicket)
    {
        for(Ticket ticket : ticketList)
        {
            if(ticket.getNumber() == currentTicket)
            {
                return ticket.getNumber();
            }
        }
        return 0;
    }
    
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
    public ArrayList<Ticket> getTicketList()
    {
        return ticketList;
    }
    
}
