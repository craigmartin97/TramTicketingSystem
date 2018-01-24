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
public class WifiUpgrade extends TramTicketUpgrade
{

    /**
     *
     * @param t
     */
    public WifiUpgrade(TramTicketRoute t)
    {
        super(t);
        cost = 10;
        upgrade = "W";
    }
}
