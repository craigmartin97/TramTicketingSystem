/**
 *
 * Class is a type of Tram Ticket Upgrade
 * adds an additional fee onto a ticket
 */
package TramUpgrade;

/**
 *
 * @author Craig, q5031372
 */
public class EntertainmentUpgrade extends TramTicketUpgrade
{

    /**
     *
     *
     * @param t
     */
    public EntertainmentUpgrade(TramTicketRoute t)
    {
        super(t);
        cost = 100;
        upgrade = "E";
    }
}
