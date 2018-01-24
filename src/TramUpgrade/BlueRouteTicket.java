/**
 *
 * A class to create a new tram route called BlueRouteTicket.
 */
package TramUpgrade;

import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;

/**
 *
 * @author Craig, q5031372
 */
public class BlueRouteTicket extends TramTicketRoute
{

    /**
     * Default constructor
     */
    BlueRouteTicket()
    {
        passengerType = "";
        departureTime = LocalTime.of(0, 0);
        date = LocalDate.of(0, 1, 1);
    }

    /**
     * Constructor sets instance variables and calcs the cost for the passenger
     *
     * @param passengerType
     * @param departureTime
     */
    public BlueRouteTicket(String passengerType, LocalTime departureTime, LocalDate date)
    {

        departureLocation = "James Cook Hospital";
        arrivalLocation = "Nunthorpe Village Centre";
        this.passengerType = passengerType;
        this.departureTime = departureTime;
        arrivalTime = departureTime.plusHours(1).plusMinutes(30);
        this.date = date;

        // calculates the cost
        calcCharge();

    }

    /**
     * method to calculate the charge of the ticket
     */
    public final void calcCharge()
    {
        switch (passengerType)
        {
            case "Under 5":
                cost = 0.0;
                break;
            case "Under 18":
                cost = 15.0;
                break;
            case "Adult":
                cost = 30.0;
                break;
            case "Pensioner":
                cost = 15.0;
                break;
            default:
                cost = -1;
                break;
        }

        // extra weekend charge
        if (this.date.getDayOfWeek() == this.date.getDayOfWeek().SATURDAY || this.date.getDayOfWeek() == this.date.getDayOfWeek().SUNDAY)
        {
            cost = cost + 2.0;
        }

        // adjust time dependant upon time of day
        if (this.departureTime.isAfter(LocalTime.of(8, 29)) && this.departureTime.isBefore(LocalTime.of(11, 31)))
        {
            cost = cost + 2.0;
        } else if (this.departureTime.isAfter(LocalTime.of(15, 59)) && this.departureTime.isBefore(LocalTime.of(18, 31)))
        {
            cost = cost + 4.0;
        }
    }

    /**
     * method to return the cost of the blue route
     *
     * @return cost
     */
    @Override
    public double getCost()
    {
        return cost;
    }

    /**
     * method to return the departure location of the blue route
     *
     * @return departureLocation
     */
    @Override
    public String getDepartureLoaction()
    {
        return departureLocation;
    }

    /**
     * method to return the arrival location of the blue route
     *
     * @return arrivalLocation
     */
    @Override
    public String getArrivalLoaction()
    {
        return arrivalLocation;
    }

    /**
     * method to return the departure time of the blue route
     *
     * @return departureTime
     */
    @Override
    public LocalTime getDepartureTime()
    {
        return departureTime;
    }

    /**
     * method to return the arrival time of the blue route
     *
     * @return arrivalTime
     */
    @Override
    public LocalTime getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * method to return the date of the blue route
     *
     * @return date
     */
    @Override
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * method to return the passenger type of the blue route
     *
     * @return passengerType
     */
    @Override
    public String getPassengerType()
    {
        return passengerType;
    }

    /**
     * method to return the upgrade applied of the blue route
     *
     * @return upgrade
     */
    @Override
    public String getUpgrade()
    {
        return upgrade;
    }
    
        
    @Override
    public TramTicketRoute getPreviousLayer()
    {
        return this;
    }
}
