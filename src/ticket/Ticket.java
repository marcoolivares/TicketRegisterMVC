package ticket;
/**
 *
 * @author Marco
 */
public class Ticket 
{
    private int number;
    private String license;
    private String state;
    private String permitnumber;
    private String model;
    private String color;
    private String reason;
    private String date;
    private String time;
    private String location;
    private String issuedby;
    private String paymentinfo;
    private Boolean paid;
    public Ticket()
    {
        
    }
    
    public Ticket(String license, String state, String permitnumber, String model, String color, String reason, String date, String time, String location, String issuedby, Boolean paid) {
        this.license = license;
        this.state = state;
        this.permitnumber = permitnumber;
        this.model = model;
        this.color = color;
        this.reason = reason;
        this.date = date;
        this.time = time;
        this.location = location;
        this.issuedby = issuedby;
        this.paid = paid;
    }
    
    
    /**
     * @return the number
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number)
    {
        this.number = number;
    }

    /**
     * @return the license
     */
    public String getLicense() 
    {
        return license;
    }

    /**
     * @param license the license to set
     */
    public void setLicense(String license) 
    {
        this.license = license;
    }

    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return the permitnumber
     */
    public String getPermitnumber()
    {
        return permitnumber;
    }

    /**
     * @param permitnumber the permitnumber to set
     */
    public void setPermitnumber(String permitnumber) 
    {
        this.permitnumber = permitnumber;
    }

    /**
     * @return the model
     */
    public String getModel()
    {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) 
    {
        this.model = model;
    }

    /**
     * @return the color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * @return the reason
     */
    public String getReason()
    {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    /**
     * @return the date
     */
    public String getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date)
    {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() 
    {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time)
    {
        this.time = time;
    }

    /**
     * @return the location
     */
    public String getLocation() 
    {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location)
    {
        this.location = location;
    }

    /**
     * @return the issuedby
     */
    public String getIssuedby()
    {
        return issuedby;
    }

    /**
     * @param issuedby the issuedby to set
     */
    public void setIssuedby(String issuedby) 
    {
        this.issuedby = issuedby;
    }

    /**
     * @return the paymentinfo
     */
    public String getPaymentinfo() 
    {
        return paymentinfo;
    }

    /**
     * @param paymentinfo the paymentinfo to set
     */
    public void setPaymentinfo(String paymentinfo)
    {
        this.paymentinfo = paymentinfo;
    }
    
    public void setPaid(Boolean paid)
    {
        this.paid = paid;
    }
    
    public Boolean getPaid()
    {
        return paid;
    }
}
