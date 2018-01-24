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
public class NewspaperUpgrade extends TramTicketUpgrade
{

    /**
     *
     *
     * @param t
     */
    public NewspaperUpgrade(TramTicketRoute t)
    {
        super(t);
        cost = 2;
        upgrade = "N";
    }
}
