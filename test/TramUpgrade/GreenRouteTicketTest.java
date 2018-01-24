/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TramUpgrade;

import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalTime;

/**
 *
 * @author Craig
 */
public class GreenRouteTicketTest
{
    
    /**
     * Instances of passenger types
     */
    private final String under5 = "Under 5";
    private final String under18 = "Under 18";
    private final String adult = "Adult";
    private final String pensioner = "Pensioner";
    
    /**
     * 2017,11,17 is a Friday   NO ADDITIONAL FEE
     * 2017,11,18 is a Saturday  2.0 ADDITIONAL FEE
     * 2017,11,19 is a Sunday    2.0 ADDITIONAL FEE
     */
    private final LocalDate dateFri = LocalDate.of(2017, 11, 17);
    private final LocalDate dateSat = LocalDate.of(2017,11,18);
    private final LocalDate dateSun = LocalDate.of(2017, 11, 19);
    
    /**
     * Noon and Midnight have NO ADDITIONAL FEE's Applied
     */
    private final LocalTime timeNoon = LocalTime.NOON;
    private final LocalTime timeMid = LocalTime.MIDNIGHT;
    
    /**
     * Between 8:30 and 11:30 additional fee's apply   £2.0
     */
    private final LocalTime time830 = LocalTime.of(8, 30);
    private final LocalTime time1130 = LocalTime.of(11, 30);
    
    /**
     * Between 16:00 and 18:30 additional fee's apply   £4.0
     */
    private final LocalTime time400 = LocalTime.of(16, 00);
    private final LocalTime time630 = LocalTime.of(18, 30);

    /**
     * Check that concrete GreenRoute class is a sub-class of Tram.
     */
    @Test
    public void testRedTramRouteSubClass()
    {
        assertTrue(new GreenRouteTicket(adult, timeNoon, dateFri) instanceof TramTicketRoute);
        System.out.println("Concrete GreenRoute class extends TramRoute");
    }

    /**
     * Check that concrete upgrades are sub-classes of Tram and TramTicketUpgrade.
     */
    @Test
    public void testUpgradeGreenRouteSubClassTramRoute()
    {

        TramTicketRoute trr = new GreenRouteTicket(pensioner, timeNoon, dateSun);

        // first class upgrade Green Route
        trr = new FirstClassUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // wifi upgrade Green Route
        trr = new WifiUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Newspaper upgrade Green Route
        trr = new NewspaperUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Refreshment Upgrade Green Route
        trr = new RefreshmentUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Entertainment Upgrade  Green Route
        trr = new EntertainmentUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        System.out.println("Concrete class GreenRoute extends TramRoute & TramUpgrade");
    }

    /**
     * Test basic GreenRoute costs for all passenger types
     */
    @Test
    public void testBasicCosts()
    {
        // under 5
        TramTicketRoute tr = new GreenRouteTicket(under5, timeNoon, dateFri);
        final double expectedCost1 = 0.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Basic GreenRoute Under 5 cost Correct");
        
        // under 5 peak time
        tr = new GreenRouteTicket(under5, time830, dateFri);
        final double expectedCost2 = 2.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Basic GreenRoute Under 5, Peak Time Morning cost Correct");

        // under 5 peak time night
        tr = new GreenRouteTicket(under5, time400, dateFri);
        final double expectedCost3 = 4.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Basic GreenRoute Under 5, Peak Time Night cost Correct");
        
        // under 5 peak time weekend
        tr = new GreenRouteTicket(under5, timeNoon, dateSat);
        final double expectedCost4 = 2.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Basic GreenRoute Under 5, Weekend Period cost Correct");
        
        // under 5 peak time and weekend
        tr = new GreenRouteTicket(under5, time1130, dateSat);
        final double expectedCost5 = 4.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Basic GreenRoute Under 5, Peak Time & Weekend Period cost Correct");
        
        // under 18
        tr = new GreenRouteTicket(under18, timeNoon, dateFri);
        final double expectedCost6 = 3.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Basic GreenRoute Under 18 cost Correct");
        
        // under 18 peak time morning
        tr = new GreenRouteTicket(under18, time1130, dateFri);
        final double expectedCost7 = 5.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Basic GreenRoute Under 18, Peak Time Morning cost Correct");

        // under 18 peak time Night
        tr = new GreenRouteTicket(under18, time630, dateFri);
        final double expectedCost8 = 7.0;
        assertEquals(tr.getCost(), expectedCost8, 0.0);
        System.out.println("Basic GreenRoute Under 18, Peak Time Night cost Correct");
        
        // under 18 weekend
        tr = new GreenRouteTicket(under18, timeNoon, dateSat);
        final double expectedCost9 = 5.0;
        assertEquals(tr.getCost(), expectedCost9, 0.0);
        System.out.println("Basic GreenRoute Under 18, Weekend Period cost Correct");
        
        // under 18 peak time and weekend
        tr = new GreenRouteTicket(under18, time400, dateSat);
        final double expectedCost10 = 9.0;
        assertEquals(tr.getCost(), expectedCost10, 0.0);
        System.out.println("Basic GreenRoute Under 18, Peak Time & Weekend Period cost Correct");
        
        // adult
        tr = new GreenRouteTicket(adult, timeNoon, dateFri);
        final double expectedCost11 = 6.0;
        assertEquals(tr.getCost(), expectedCost11, 0.0);
        System.out.println("Basic GreenRoute Adult, Peak Time Morning cost Correct");
        
        // adult peak time morning
        tr = new GreenRouteTicket(adult, time830, dateFri);
        final double expectedCost12 = 8.0;
        assertEquals(tr.getCost(), expectedCost12, 0.0);
        System.out.println("Basic GreenRoute Adult, Peak Time Morning cost Correct");

        // adult peak time Night
        tr = new GreenRouteTicket(adult, time400, dateFri);
        final double expectedCost13 = 10.0;
        assertEquals(tr.getCost(), expectedCost13, 0.0);
        System.out.println("Basic GreenRoute Adult, Peak Time Night cost Correct");
        
        // adult weekend
        tr = new GreenRouteTicket(adult, timeNoon, dateSat);
        final double expectedCost14 = 8.0;
        assertEquals(tr.getCost(), expectedCost14, 0.0);
        System.out.println("Basic GreenRoute Adult, Weekend Period cost Correct");
        
        // adult peak time and weekend
        tr = new GreenRouteTicket(adult, time400, dateSun);
        final double expectedCost15 = 12.0;
        assertEquals(tr.getCost(), expectedCost15, 0.0);
        System.out.println("Basic GreenRoute Adult, Peak Time & Weekend Period cost Correct");

        // pensioner
        tr = new GreenRouteTicket(pensioner, timeMid, dateFri);
        final double expectedCost16 = 4.0;
        assertEquals(tr.getCost(), expectedCost16, 0.0);
        System.out.println("Basic GreenRoute Pensioner cost Correct");
        
                // adult peak time morning
        tr = new GreenRouteTicket(pensioner, time830, dateFri);
        final double expectedCost17 = 6.0;
        assertEquals(tr.getCost(), expectedCost17, 0.0);
        System.out.println("Basic GreenRoute Pensioner, Peak Time Morning cost Correct");

        // adult peak time Night
        tr = new GreenRouteTicket(pensioner, time400, dateFri);
        final double expectedCost18 = 8.0;
        assertEquals(tr.getCost(), expectedCost18, 0.0);
        System.out.println("Basic GreenRoute Pensioner, Peak Time Night cost Correct");
        
        // adult weekend
        tr = new GreenRouteTicket(pensioner, timeNoon, dateSat);
        final double expectedCost19 = 6.0;
        assertEquals(tr.getCost(), expectedCost19, 0.0);
        System.out.println("Basic GreenRoute Pensioner, Weekend Period cost Correct");
        
        // adult peak time and weekend
        tr = new GreenRouteTicket(pensioner, time400, dateSun);
        final double expectedCost20 = 10.0;
        assertEquals(tr.getCost(), expectedCost20, 0.0);
        System.out.println("Basic GreenRoute Pensioner, Peak Time & Weekend Period cost Correct");
    }

    /**
     * Test Wifi upgrade for all passenger types on the green route
     */
    @Test
    public void testWifiUpgrades()
    {
        // under 5
        TramTicketRoute tr = new GreenRouteTicket(under5, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost1 = 10.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Wifi Under 5 Upgrade OK");

        // under 18
        tr = new GreenRouteTicket(under18, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost2 = 13.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Wifi Under 18 Upgrade OK");

        // adult
        tr = new GreenRouteTicket(adult, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost3 = 16.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Wifi Adult Upgrade OK");

        // pensioner
        tr = new GreenRouteTicket(pensioner, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost4 = 14.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Wifi Pensioner Upgrade OK");

    }

    /**
     * Test First Class upgrade for all passenger types on the green route
     */
    @Test
    public void testFirstClassUpgrades()
    {
        // under 5
        TramTicketRoute tr = new GreenRouteTicket(under5, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost1 = 217.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("First Class Under 5 Upgrade OK");

        // under 18
        tr = new GreenRouteTicket(under18, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost2 = 217.0 + 3.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("First Class Under 18 Upgrade OK");

        // adult
        tr = new GreenRouteTicket(adult, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost3 = 217.0 + 6.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("First Class Adult Upgrade OK");

        // pensioer
        tr = new GreenRouteTicket(pensioner, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost4 = 217.0 + 4.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("First Class Pensioner Upgrade OK");
    }

    /**
     * Test Newspaper Upgrade for all passenger types on the green route
     */
    @Test
    public void testNewspaperUpgrades()
    {
        // under 5
        TramTicketRoute tr = new GreenRouteTicket(under5, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Newspaper Under 5 Upgrade OK");

        // under 18
        tr = new GreenRouteTicket(under18, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 5.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Newspaper Under 18 Upgrade OK");

        // adult
        tr = new GreenRouteTicket(adult, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost3 = 8.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Newspaper Adult Upgrade OK");

        // pensioer
        tr = new GreenRouteTicket(pensioner, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost4 = 6.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Newspaper Pensioner Upgrade OK");
    }

    /**
     * Test Entertainment Upgrade for all passenger types on the green route
     */
    @Test
    public void testEntertainmentUpgrades()
    {
        // under 5
        TramTicketRoute tr = new GreenRouteTicket(under5, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost1 = 100.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Entertainment Under 5 Upgrade OK");

        // under 18
        tr = new GreenRouteTicket(under18, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost2 = 103.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Entertainment Under 18 Upgrade OK");

        // adult
        tr = new GreenRouteTicket(adult, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost3 = 106.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Entertainment Adult Upgrade OK");

        // pensioner
        tr = new GreenRouteTicket(pensioner, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost4 = 104.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Entertainment Pensioner Upgrade OK");
    }

    /**
     * Test Refreshment Upgrade for all passenger types on the green route
     */
    @Test
    public void testRefreshmentUpgrades()
    {
        // under 5
        TramTicketRoute tr = new GreenRouteTicket(under5, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Refreshment Under 5 Upgrade OK");

        // under 18
        tr = new GreenRouteTicket(under18, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 5.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Refreshment Under 18 Upgrade OK");

        // adult
        tr = new GreenRouteTicket(adult, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost3 = 8.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Refreshment Adult Upgrade OK");

        // pensioner
        tr = new GreenRouteTicket(pensioner, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost4 = 6.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Refreshment Pensioner Upgrade OK");
    }

    /**
     * Test multiple upgrades for all passenger types on the green route
     */
    @Test
    public void testMulitpleUpgrades()
    {
        // under 5
        TramTicketRoute tr = new GreenRouteTicket(under5, timeNoon, dateFri);
        tr = new RefreshmentUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new NewspaperUpgrade(tr);
        tr = new WifiUpgrade(tr);
        final double expectedCost1 = 2.0 + 217.0 + 2.0 + 10.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Multiple Upgrades on Green Route For Under 5's Correct");

        // under 18
        tr = new GreenRouteTicket(under18, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 10.0 + 217.0 + 2.0 + 3.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Multiple Upgrades on Green Route For Under 18's Correct");

        // adult
        tr = new GreenRouteTicket(adult, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new EntertainmentUpgrade(tr);
        tr = new RefreshmentUpgrade(tr);
        final double expectedCost3 = 10.0 + 217.0 + 100.0 + 2.0 + 6.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Multiple Upgrades on Green Route For Adults Correct");

        // pensioner
        tr = new GreenRouteTicket(pensioner, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new RefreshmentUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost4 = 10.0 + 2.0 + 4.0 + 217.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Multiple Upgrades on Green Route For Pensioners Correct");
    }

    /**
     * Test of getDepartureLoaction method, of class GreenRoute.
     */
    @Test
    public void testGetDepartureLoaction()
    {
        GreenRouteTicket instance = new GreenRouteTicket(adult, timeNoon, dateFri);
        String expResult = "Redcar";
        String result = instance.getDepartureLoaction();
        assertEquals(expResult, result);
        System.out.println("Green Route Departure Location Correct");
    }

    /**
     * Test of getArrivalLoaction method, of class GreenRoute.
     */
    @Test
    public void testGetArrivalLoaction()
    {
        GreenRouteTicket instance = new GreenRouteTicket(pensioner, timeMid, dateFri);
        String expResult = "Saltburn";
        String result = instance.getArrivalLoaction();
        assertEquals(expResult, result);
        System.out.println("Green Route Arrival Location Correct");
    }

    /**
     * Test of getPassengerType method for all passenger types on the green
     * route
     */
    @Test
    public void testGetPassengerTypeUnder5()
    {
        // under 5
        GreenRouteTicket instance = new GreenRouteTicket(under5, timeNoon, dateFri);
        String expResult1 = under5;
        String result1 = instance.getPassengerType();
        assertEquals(expResult1, result1);
        System.out.println("Passenger Type Under 5 Working Correct");

        // under 18
        instance = new GreenRouteTicket(under18, timeNoon, dateFri);
        String expResult2 = under18;
        String result2 = instance.getPassengerType();
        assertEquals(expResult2, result2);
        System.out.println("Passenger Type Under 18 Working Correct");

        // adult
        instance = new GreenRouteTicket(adult, timeNoon, dateFri);
        String expResult3 = adult;
        String result3 = instance.getPassengerType();
        assertEquals(expResult3, result3);
        System.out.println("Passenger Type Adult Working Correct");

        // pensioner
        instance = new GreenRouteTicket(pensioner, timeNoon, dateFri);
        String expResult4 = pensioner;
        String result4 = instance.getPassengerType();
        assertEquals(expResult4, result4);
        System.out.println("Passenger Type Pensioner Working Correct");
    }

    /**
     * Test Upgrade Codes for all upgrades on the green route
     */
    @Test
    public void testUpgradeCodes()
    {
        // newspaper
        TramTicketRoute tr = new GreenRouteTicket(under5, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final String expResult1 = " N";
        assertEquals(tr.getUpgrade(), expResult1);
        System.out.println("Newspaper Code Correct");

        // refreshment
        tr = new GreenRouteTicket(under18, timeNoon, dateFri);
        tr = new RefreshmentUpgrade(tr);
        final String expResult2 = " R";
        assertEquals(tr.getUpgrade(), expResult2);
        System.out.println("Refreshment Code Correct");

        // wifi
        tr = new GreenRouteTicket(adult, timeMid, dateFri);
        tr = new WifiUpgrade(tr);
        final String expResult3 = " W";
        assertEquals(tr.getUpgrade(), expResult3);
        System.out.println("Wifi Code Correct");

        // first class
        tr = new GreenRouteTicket(adult, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final String expResult4 = " FC";
        assertEquals(tr.getUpgrade(), expResult4);
        System.out.println("First Class Code Correct");

        // entertainment
        tr = new GreenRouteTicket(pensioner, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final String expResult5 = " E";
        assertEquals(tr.getUpgrade(), expResult5);
        System.out.println("Entertainment Code Correct");

    }

    /**
     * Test Times
     */
    @Test
    public void testArrivalTimes()
    {
        TramTicketRoute tr = new GreenRouteTicket(adult, LocalTime.of(10, 30), dateFri);
        LocalTime expResult = LocalTime.of(14, 55);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 10:30, Arrives at 14:55 correct");

        tr = new GreenRouteTicket(adult, LocalTime.of(11, 30), dateFri);
        expResult = LocalTime.of(15, 55);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 11:30, Arrives at 15:55 correct");

        tr = new GreenRouteTicket(adult, LocalTime.of(13, 30), dateFri);
        expResult = LocalTime.of(17, 55);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 13:30, Arrives at 17:55 correct");

        tr = new GreenRouteTicket(adult, LocalTime.of(16, 30), dateFri);
        expResult = LocalTime.of(20, 55);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 16:30, Arrives at 20:55 correct");

        tr = new GreenRouteTicket(adult, LocalTime.of(21, 30), dateFri);
        expResult = LocalTime.of(01, 55);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 21:30, Arrives at 01:55 correct");

        tr = new GreenRouteTicket(adult, LocalTime.of(01, 30), dateFri);
        expResult = LocalTime.of(05, 55);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 01:30, Arrives at 05:55 correct");
    }

    @Test 
    public void testToString()
    {
        TramTicketRoute tr = new GreenRouteTicket("", LocalTime.of(01, 30),dateFri);
        String expResult = String.format(" \n Price: £%s,    Depart From: %s,    Arrive At: %s,   Depart Time: %s,   Arrive At: %s,   Date: %s,   Type: %s,   Extra's Code: %s",
                tr.getCost(), tr.getDepartureLoaction(), tr.getArrivalLoaction(), tr.getDepartureTime(),
                tr.getArrivalTime(), tr.getDate(), tr.getPassengerType(), tr.getUpgrade());
        assertEquals(tr.toString(), expResult);
        System.out.println("To String Method Is Correct");
    }
    
    @Test
    public void testDefaultCost()
    {
        TramTicketRoute tr = new GreenRouteTicket("dfsdf",timeNoon,dateFri);
        double expResult = -1;
        assertEquals(tr.getCost(),expResult, 0.0);
        System.out.println("Default Cost Working Correct");
    }
}
