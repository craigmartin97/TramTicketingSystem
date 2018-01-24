/**
 *
 * A class to create a new tram route called GreenRoute.
 */
package TramUpgrade;

import java.time.LocalDate;
import java.util.Date;
import java.time.LocalTime;

/**
 *
 * @author Craig, q5031372
 */
public class GreenRouteTicket extends TramTicketRoute
{

    /**
     * Default Constructor
     */
    GreenRouteTicket()
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
    public GreenRouteTicket(String passengerType, LocalTime departureTime, LocalDate date)
    {
        departureLocation = "Redcar";
        arrivalLocation = "Saltburn";
        this.passengerType = passengerType;
        this.departureTime = departureTime;
        arrivalTime = departureTime.plusHours(4).plusMinutes(25);
        this.date = date;

        calcCharge();

    }

    /**
     * Method that calculates the charge of the ticket
     */
    public final void calcCharge()
    {
        // calc cost of ticket
        switch (passengerType)
        {
            case "Under 5":
                cost = 0.0;
                break;
            case "Under 18":
                cost = 3.0;
                break;
            case "Adult":
                cost = 6.0;
                break;
            case "Pensioner":
                cost = 4.0;
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
     * method to return the cost of the green route
     *
     * @return cost
     */
    @Override
    public double getCost()
    {
        return cost;
    }

    /**
     * method to return the departure location of the green route
     *
     * @return departureLocation
     */
    @Override
    public String getDepartureLoaction()
    {
        return departureLocation;
    }

    /**
     * method to return the arrival location of the green route
     *
     * @return arrivalLocation
     */
    @Override
    public String getArrivalLoaction()
    {
        return arrivalLocation;
    }

    /**
     * method to return the departure time of the green route
     *
     * @return departureTime
     */
    @Override
    public LocalTime getDepartureTime()
    {
        return departureTime;
    }

    /**
     * method to return the arrival time of the green route
     *
     * @return arrivalTime
     */
    @Override
    public LocalTime getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * method to return date of the green route
     *
     * @return date
     */
    @Override
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * method to return the passenger type of the green route
     *
     * @return passengerType
     */
    @Override
    public String getPassengerType()
    {
        return passengerType;
    }

    /**
     * method to return upgrade that has been applied on the green route
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
