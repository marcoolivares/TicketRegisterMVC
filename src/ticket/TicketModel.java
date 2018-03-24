/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class TicketModel
{
    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private static int ticketnumber = 1;
    DataOutputStream out;
    
    public TicketModel() throws IOException
    {
        //number, license, state, permitnumber, model, color, reason, date, time, location, issuedby, paid
        try(
            FileReader reader = new FileReader("tickets.dat")
        ){
            int charRead = -1;
            int counter = 0;
            String info = "";
            Ticket tick = new Ticket();
            while ((charRead = reader.read()) != -1) 
            {
                if(charRead == 10)
                {
                    counter++;
                    if(counter == 1)
                        info = "";
                    else
                    {
                        if(counter == 2)
                        {
                            tick.setLicense(info);
                            info = "";
                        }
                        else
                        {
                            if(counter == 3)
                            {
                                tick.setState(info);
                                info = "";
                            }
                            else
                            {
                                if(counter == 4)
                                {
                                    tick.setPermitnumber(info);
                                    info = "";
                                }
                                else
                                {
                                    if(counter == 5)
                                    {
                                        tick.setModel(info);
                                        info = "";
                                    }
                                    else
                                    {
                                        if(counter == 6)
                                        {
                                            tick.setColor(info);
                                            info = "";
                                        }
                                        else
                                        {
                                            if(counter == 7)
                                            {
                                                tick.setReason(info.substring(1, info.length()-1));
                                                info = "";
                                            }
                                            else
                                            {
                                                if(counter == 8)
                                                {
                                                    tick.setDate(info);
                                                    info = "";
                                                }
                                                else
                                                {
                                                    if(counter == 9)
                                                    {
                                                        tick.setTime(info);
                                                        info = "";
                                                    }
                                                    else
                                                    {
                                                        if(counter == 10)
                                                        {
                                                            tick.setLocation(info);
                                                            info = "";
                                                        }
                                                        else
                                                        {
                                                            if(counter == 11)
                                                            {
                                                                tick.setIssuedby(info);
                                                                info = "";
                                                            }
                                                            else
                                                            {    
                                                                if(counter == 12)
                                                                {
                                                                    counter = 0;
                                                                    if(info.equals("true"))
                                                                        tick.setPaid(true);
                                                                    else
                                                                        tick.setPaid(false);
                                                                    info = "";
                                                                    tick.setNumber(ticketnumber);
                                                                    ticketnumber++;
                                                                    ticketList.add(tick);
                                                                    tick = new Ticket();
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                info += (char) charRead;
            }
        } catch (FileNotFoundException ex) 
        {
            System.err.println("File not found error: " + ex);
        } catch (IOException ex) 
        {
            System.err.println("I/O error: " + ex);
        }
    }
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
        storeTicket(t);
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
    
    public void storeTicket(Ticket lastTicket)
    {
        BufferedWriter bw = null;
	FileWriter fw = null;
	try {
            File file = new File("tickets.dat");
            // if file doesnt exists, then create it
            if (!file.exists()) 
            {
                    file.createNewFile();
            }
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(lastTicket.getNumber()+"");
            bw.newLine();
            bw.write(lastTicket.getLicense()+"");
            bw.newLine();
            bw.write(lastTicket.getState()+"");
            bw.newLine();
            bw.write(lastTicket.getPermitnumber()+"");
            bw.newLine();
            bw.write(lastTicket.getModel()+"");
            bw.newLine();
            bw.write(lastTicket.getColor()+"");
            bw.newLine();
            bw.write(lastTicket.getReason()+"");
            bw.newLine();
            bw.write(lastTicket.getDate()+"");
            bw.newLine();
            bw.write(lastTicket.getTime()+"");
            bw.newLine();
            bw.write(lastTicket.getLocation()+"");
            bw.newLine();
            bw.write(lastTicket.getIssuedby());
            bw.newLine();
            bw.write(lastTicket.getPaid()+"");
            bw.newLine();
            System.out.println("Done");
        } catch (IOException e) 
        {
            e.printStackTrace();
        } finally 
        {
            try 
            {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }     
    }   
}
