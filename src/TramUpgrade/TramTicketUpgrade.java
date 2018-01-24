/**
 *
 * Class to apply upgrades to Tram Tickets on any route
 * Class defines what child classes can do and there specific actions
 */
package TramUpgrade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Craig, q5031372
 */
public abstract class TramTicketUpgrade extends TramTicketRoute
{

    /**
     * an instance of a TramTicketRoute, creating a new TramTicketRoute
     */
    protected TramTicketRoute t;

    /**
     * The TramTicketRoute == the one passed in
     *
     * @param t
     */
    public TramTicketUpgrade(TramTicketRoute t)
    {
        this.t = t;
    }

    /**
     *
     * @return TramTicketRoute's (t) cost + cost of ticket
     */
    @Override
    public double getCost()
    {
        return t.getCost() + cost;
    }

    /**
     *
     * @return TramTicketRoute's (t) departureLocation
     */
    @Override
    public String getDepartureLoaction()
    {
        return t.getDepartureLoaction();
    }

    /**
     *
     * @return TramTicketRoute's (t) arrivalLocation
     */
    @Override
    public String getArrivalLoaction()
    {
        return t.getArrivalLoaction();
    }

    /**
     *
     * @return TramTicketRoute's (t) departureTime
     */
    @Override
    public LocalTime getDepartureTime()
    {
        return t.getDepartureTime();
    }

    /**
     *
     * @return TramTicketRoute's (t) departureTime
     */
    @Override
    public LocalTime getArrivalTime()
    {
        return t.getArrivalTime();
    }

    /**
     *
     * @return TramTicketRoute's (t) date
     */
    @Override
    public LocalDate getDate()
    {
        return t.getDate();
    }

    /**
     *
     * @return TramTicketRoute's (t) passengerType
     */
    @Override
    public String getPassengerType()
    {
        return t.getPassengerType();
    }

    /**
     *
     * @return TramTicketRoute's (t) upgrade
     */
    @Override
    public String getUpgrade()
    {
        return t.getUpgrade() + " " + upgrade;
    }
    
    // method returns base layer. 
    public TramTicketRoute getPreviousLayer()
    {
        return t;
    }
    

    @Override
    public String toString()
    {
        return String.format(" \n Price: £%s,    Depart From: %s,    Arrive At: %s,   Depart Time: %s,   Arrive At: %s,   Date: %s,   Type: %s,   Extra's Code: %s",
                getCost(), getDepartureLoaction(), getArrivalLoaction(), getDepartureTime(),
                getArrivalTime(), getDate(), getPassengerType(), getUpgrade());
    }
}
