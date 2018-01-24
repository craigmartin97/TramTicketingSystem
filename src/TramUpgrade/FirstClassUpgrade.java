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
public class FirstClassUpgrade extends TramTicketUpgrade
{
    /**
     *
     * @param t
     */
    public FirstClassUpgrade(TramTicketRoute t)
    {
        super(t);
        cost = 217;
        upgrade = "FC";
        t.getUpgrade();
        System.out.println(t.upgrade);
    }
}
