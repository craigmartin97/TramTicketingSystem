/**
 *
 * Class to define what all children can do, defines what a TramRoute is
 */
package TramUpgrade;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Craig, q5031372
 */
public abstract class TramTicketRoute
{

    /**
     * cost of the ticket
     */
    protected double cost;

    /**
     * departure location for the route
     */
    protected String departureLocation;

    /**
     * arrival location for the route
     */
    protected String arrivalLocation;

    /**
     * departure time for the route
     */
    protected LocalTime departureTime;

    /**
     * arrival time for the route
     */
    protected LocalTime arrivalTime;

    /**
     * date of leave for the route
     */
    protected LocalDate date;

    /**
     * passenger type for the route
     */
    protected String passengerType;

    /**
     * upgrades that are to be applied to the ticket
     */
    protected String upgrade = "";

    /**
     * child classes override
     *
     * @return cost
     */
    public abstract double getCost();

    /**
     * child classes override
     *
     * @return departureLocation
     */
    public abstract String getDepartureLoaction();

    /**
     * child classes override
     *
     * @return arrivalLocation
     */
    public abstract String getArrivalLoaction();

    /**
     * child classes override
     *
     * @return departureTime
     */
    public abstract LocalTime getDepartureTime();

    /**
     * child classes override
     *
     * @return arrivalTime
     */
    public abstract LocalTime getArrivalTime();

    /**
     * child classes override
     *
     * @return date
     */
    public abstract LocalDate getDate();

    /**
     * child classes override
     *
     * @return passengerType
     */
    public abstract String getPassengerType();

    /**
     * child classes override
     *
     * @return upgrade
     */
    public abstract String getUpgrade();

    /**
     * TramTicketRoute Without Upgrades Applied
     *
     * @return toString
     */
    
    public abstract TramTicketRoute getPreviousLayer();
    
    
    @Override
    public String toString()
    {
        return String.format(" \n Price: £%s,    Depart From: %s,    Arrive At: %s,   Depart Time: %s,   Arrive At: %s,   Date: %s,   Type: %s,   Extra's Code: %s",
                cost, departureLocation, arrivalLocation, departureTime, arrivalTime, date, passengerType, upgrade);
    }
}
