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
public class RedRouteTicketTest
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
     * Check that concrete RedRoute class is a sub-class of Tram.
     */
    @Test
    public void testRedTramRouteSubClass()
    {
        assertTrue(new RedRouteTicket(under5, timeNoon,dateFri) instanceof TramTicketRoute);
        System.out.println("Concrete RedRoute class extends TramRoute");
    }

    /**
     * Check that concrete upgrades are sub-classes of Tram and TramTicketUpgrade.
     */
    @Test
    public void testUpgradeRedRouteSubClassTramRoute()
    {

        TramTicketRoute trr = new RedRouteTicket(under18, timeMid,dateFri);

        // first class upgrade red route
        trr = new FirstClassUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // wifi upgrade red route
        trr = new WifiUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Newspaper upgrade red route
        trr = new NewspaperUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Refreshment Upgrade red route
        trr = new RefreshmentUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Entertainment Upgrade  red route
        trr = new EntertainmentUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        System.out.println("Concrete class RedRoute extends TramRoute & TramUpgrade");
    }

    /**
     * Test basic costs for all passenger types on the red route
     */
    @Test
    public void testBasicCosts()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, timeNoon,dateFri);
        final double expectedCost1 = 0.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Basic RedRoute Under 5 cost Correct");

        // under 18
        tr = new RedRouteTicket(under18, timeMid,dateFri);
        final double expectedCost2 = 5.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Basic RedRoute Under 18 cost Correct");

        // adult
        tr = new RedRouteTicket(adult, timeNoon,dateFri);
        final double expectedCost3 = 10.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Basic RedRoute Adult cost Correct");

        // pensioner 
        tr = new RedRouteTicket(pensioner, timeNoon,dateFri);
        final double expectedCost4 = 5.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Basic RedRoute Pensioner cost Correct");
    }
    
    @Test 
    public void testBasicCostPeakTime()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, time830,dateFri);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("RedRoute Under 5 Cost Peak Time OK");

        // under 18
        tr = new RedRouteTicket(under18, time1130,dateFri);
        final double expectedCost2 = 7.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("RedRoute Under 18 Cost Peak Time OK");

        // adult
        tr = new RedRouteTicket(adult, time400,dateFri);
        final double expectedCost3 = 14.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("RedRoute Adult Cost Peak Time OK");

        // pensioner 
        tr = new RedRouteTicket(pensioner, time630,dateFri);
        final double expectedCost4 = 9.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("RedRoute Pensioner Cost Peak Time OK");
    }
    
    @Test 
    public void testBasicCostWeekend()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, timeNoon,dateSat);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("RedRoute Under 5 Cost Weekend Period OK");

        // under 18
        tr = new RedRouteTicket(under18, timeMid,dateSun);
        final double expectedCost2 = 7.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("RedRoute Under 18 Cost Weekend Period OK");

        // adult
        tr = new RedRouteTicket(adult, timeMid,dateSat);
        final double expectedCost3 = 12.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("RedRoute Adult Cost Weekend Period OK");

        // pensioner 
        tr = new RedRouteTicket(pensioner, timeNoon,dateSun);
        final double expectedCost4 = 7.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("RedRoute Pensioner Cost Weekend Period OK");
    }
    
    @Test 
    public void testBasicCostMixed()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, time400,dateSat);
        final double expectedCost1 = 6.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("RedRoute Under 5 Cost Peak Time & Weekend Period OK");

        // under 18
        tr = new RedRouteTicket(under18, time1130,dateSun);
        final double expectedCost2 = 9.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("RedRoute Under 18 Peak Time & Weekend Period OK");

        // adult
        tr = new RedRouteTicket(adult, timeNoon,dateSun);
        final double expectedCost3 = 12.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("RedRoute Adult Cost Off Peak & Weekend Period OK");

        // pensioner 
        tr = new RedRouteTicket(pensioner, time630,dateFri);
        final double expectedCost4 = 9.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("RedRoute Pensioner Cost Peak Time & Weekend Period OK");
    }

    /**
     * Test Wifi upgrade for all passenger types on the red route
     */
    @Test
    public void testWifiUpgrades()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost1 = 10.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Wifi Under 5 Upgrade OK");
        
        // under 5 peak time and weekend
        tr = new RedRouteTicket(under5, time830, dateSun);
        tr = new WifiUpgrade(tr);
        final double expectedCost2 = 14.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Wifi Under 5 Upgrade, Peak Time & Weekend Period OK");

        // under 18
        tr = new RedRouteTicket(under18, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost3 = 15.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Wifi Under 18 Upgrade OK");

        // adult
        tr = new RedRouteTicket(adult, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost4 = 20.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Wifi Adult Upgrade OK");
        
        // adult peak time
        tr = new RedRouteTicket(adult, time630, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost5 = 24.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Wifi Adult Upgrade, Peak Time OK");

        // pensioner
        tr = new RedRouteTicket(pensioner, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost6 = 15.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Wifi Pensioner Upgrade OK");
        
        // pensioner at weekend
        tr = new RedRouteTicket(pensioner, timeNoon, dateSat);
        tr = new WifiUpgrade(tr);
        final double expectedCost7 = 17.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Wifi Pensioner Upgrade OK");
    }

    /**
     * Test First Class upgrades on all passenger types on the red route
     */
    @Test
    public void testFirstClassUpgrades()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost1 = 217.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("First Class Under 5 Upgrade OK");
        
        // under 5 at weekend
        tr = new RedRouteTicket(under5, timeNoon, dateSat);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost2 = 219.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("First Class Under 5 Upgrade, Weekend Period OK");

        // under 5 at peak time and weekend
        tr = new RedRouteTicket(under5, time400, dateSun);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost3 = 223.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("First Class Under 5 Upgrade, Peak Time & Weekend Period OK");
        
        
        // under 18
        tr = new RedRouteTicket(under18, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost4 = 222.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("First Class Under 18 Upgrade OK");

        // adult
        tr = new RedRouteTicket(adult, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost5 = 227.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("First Class Adult Upgrade OK");
        
        // adult at weekend & peak
        tr = new RedRouteTicket(adult, time830, dateSun);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost6 = 231.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("First Class Adult Upgrade, Peak Time & Weekend Period OK");
        
        // pensioner
        tr = new RedRouteTicket(pensioner, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost7 = 222.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("First Class Pensioner Upgrade OK");
        
        // pensioner at peak
        tr = new RedRouteTicket(pensioner, time1130, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost8 = 224.0;
        assertEquals(tr.getCost(), expectedCost8, 0.0);
        System.out.println("First Class Pensioner Upgrade, Peak Time OK");
    }

    /**
     * Test Newspaper Upgrade on all passenger types on the red route
     */
    @Test
    public void testNewspaperUpgrades()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Newspaper Under 5 Upgrade OK");
        
        // under 5 at peak time
        tr = new RedRouteTicket(under5, time400, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 6.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Newspaper Under 5 Upgrade, Peak Time OK");

        // under 18
        tr = new RedRouteTicket(under18, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost3 = 7.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Newspaper Under 18 Upgrade OK");
        
        // under 18 weekend
        tr = new RedRouteTicket(under18, timeNoon, dateSat);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost4 = 9.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Newspaper Under 5 Upgrade, Weekend Period OK");
        
        // under 18 peak time
        tr = new RedRouteTicket(under18, time1130, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost5 = 9.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Newspaper Under 5 Upgrade, Peak Time OK");

        // adult
        tr = new RedRouteTicket(adult, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost6 = 12.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Newspaper Adult Upgrade OK");

        // pensioner
        tr = new RedRouteTicket(pensioner, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost7 = 7.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Newspaper Pensioner Upgrade OK");
    }

    /**
     * Test Entertainment Upgrade on all passengers on the red route
     */
    @Test
    public void testEntertainmentUpgrades()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, timeMid, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost1 = 100.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Entertainment Under 5 Upgrade OK");

        // under 18
        tr = new RedRouteTicket(under18, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost2 = 105.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Entertainment Under 18 Upgrade OK");
        
        // under 18 Weekend & Peak Time
        tr = new RedRouteTicket(under18, time1130, dateSun);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost3 = 109.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Entertainment Under 18 Upgrade, Weekend & Peak Time OK");

        // adult
        tr = new RedRouteTicket(adult, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost4 = 110.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Entertainment Adult Upgrade OK");
        
        // adult peak time
        tr = new RedRouteTicket(adult, time400, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost5 = 114.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Entertainment Adult Upgrade, Peak Time OK");

        // pensioner
        tr = new RedRouteTicket(pensioner, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost6 = 105.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Entertainment Pensioner Upgrade OK");
        
        // pensioner weekend
        tr = new RedRouteTicket(pensioner, timeNoon, dateSat);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost7 = 107.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Entertainment Pensioner Upgrade, Weekend Period OK");
    }

    /**
     * Test Refreshment Upgrade on all passengers on the red route
     */
    @Test
    public void testRefreshmentUnder5UpgradeRedRoute()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Refreshment Under 5 Upgrade OK");
        
        // under 5 weekend
        tr = new RedRouteTicket(under5, timeNoon, dateSat);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 4.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Refreshment Under 5 Upgrade, Weekend Period OK");

        // under 18
        tr = new RedRouteTicket(under18, timeNoon, dateSat);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost3 = 9.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Refreshment Under 18 Upgrade OK");
        
        // under 18 Weekend & Peak Time
        tr = new RedRouteTicket(under18, time400, dateSat);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost4 = 13.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Refreshment Under 18 Upgrade, Peak Time & Weekend Period OK");

        // adult 
        tr = new RedRouteTicket(adult, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost5 = 12.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Refreshment Adult Upgrade OK");
        
        // adult Peak Time & Weekend
        tr = new RedRouteTicket(adult, time1130, dateSun);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost6 = 16.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Refreshment Adult Upgrade, Peak Time & Weekend Period OK");

        // pensioner
        tr = new RedRouteTicket(pensioner, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost7 = 7.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Refreshment Pensioner Upgrade OK");
        
        // pensioner weekend upgrade
        tr = new RedRouteTicket(pensioner, timeNoon, dateSat);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost8 = 9.0;
        assertEquals(tr.getCost(), expectedCost8, 0.0);
        System.out.println("Refreshment Pensioner Upgrade, Peak Time OK");
    }

    /**
     * Test multiple upgrades on all passenger types on the red route
     */
    @Test
    public void testMulitpleUnder5UpgradeRedRoute()
    {
        // under 5
        TramTicketRoute tr = new RedRouteTicket(under5, timeNoon, dateSat);
        tr = new RefreshmentUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost1 = 223.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Multiple Upgrades on Red Route, Weekend Period, For Under 5's Correct");

        // under 18
        tr = new RedRouteTicket(under5, time1130, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 231.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Multiple Upgrades on Red Route, Peak Time, For Under 18's Correct");

        // adult
        tr = new RedRouteTicket(adult, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new EntertainmentUpgrade(tr);
        tr = new RefreshmentUpgrade(tr);
        final double expectedCost3 = 339.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Multiple Upgrades on Red Route For Adults Correct");

        // pensioner
        tr = new RedRouteTicket(pensioner, time400, dateSun);
        tr = new WifiUpgrade(tr);
        tr = new RefreshmentUpgrade(tr);
        final double expectedCost4 = 23.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Multiple Upgrades on Red Route, Peak Time & Weekend Period, For Pensioners Correct");
    }

    /**
     * Test of getDepartureLoaction method, of class RedRoute.
     */
    @Test
    public void testGetDepartureLoaction()
    {
        RedRouteTicket instance = new RedRouteTicket("", timeNoon,dateFri);
        String expResult = "Pallister Park";
        String result = instance.getDepartureLoaction();
        assertEquals(expResult, result);
        System.out.println("Red Route Departure Location Correct");
    }

    /**
     * Test of getArrivalLoaction method, of class RedRoute.
     */
    @Test
    public void testGetArrivalLoaction()
    {
        RedRouteTicket instance = new RedRouteTicket("", timeNoon,dateFri);
        String expResult = "Cargo Fleet Lane";
        String result = instance.getArrivalLoaction();
        assertEquals(expResult, result);
        System.out.println("Red Route Arrival Location Correct");
    }

    /**
     * Test of getPassengerType method for all passenger types
     */
    @Test
    public void testGetPassengerTypes()
    {
        // under 5
        RedRouteTicket instance = new RedRouteTicket(under5, timeNoon, dateFri);
        String expResult1 = under5;
        String result1 = instance.getPassengerType();
        assertEquals(expResult1, result1);
        System.out.println("Passenger Type Under 5 Working Correct");

        // under 18
        instance = new RedRouteTicket(under18, timeNoon, dateFri);
        String expResult2 = under18;
        String result2 = instance.getPassengerType();
        assertEquals(expResult2, result2);
        System.out.println("Passenger Type Under 18 Working Correct");

        // adult
        instance = new RedRouteTicket(adult, timeNoon, dateFri);
        String expResult3 = adult;
        String result3 = instance.getPassengerType();
        assertEquals(expResult3, result3);
        System.out.println("Passenger Type Adult Working Correct");

        // pensioner
        instance = new RedRouteTicket(pensioner, timeNoon, dateFri);
        String expResult4 = pensioner;
        String result4 = instance.getPassengerType();
        assertEquals(expResult4, result4);
        System.out.println("Passenger Type Pensioner Working Correct");
    }

    /**
     * Test Upgrade Codes
     */
    @Test
    public void testUpgradeCodes()
    {
        // newspaper
        TramTicketRoute tr = new RedRouteTicket("", timeNoon,dateFri);
        tr = new NewspaperUpgrade(tr);
        final String expResult1 = " N";
        assertEquals(tr.getUpgrade(), expResult1);
        System.out.println("Newspaper Code Correct");

        // refreshment
        tr = new RedRouteTicket("", timeNoon,dateFri);
        tr = new RefreshmentUpgrade(tr);
        final String expResult2 = " R";
        assertEquals(tr.getUpgrade(), expResult2);
        System.out.println("Refreshment Code Correct");

        // wifi
        tr = new RedRouteTicket("", timeNoon,dateFri);
        tr = new WifiUpgrade(tr);
        final String expResult3 = " W";
        assertEquals(tr.getUpgrade(), expResult3);
        System.out.println("Wifi Code Correct");

        // first class
        tr = new RedRouteTicket("", timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final String expResult4 = " FC";
        assertEquals(tr.getUpgrade(), expResult4);
        System.out.println("First Class Code Correct");

        // entertainment
        tr = new RedRouteTicket("", timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final String expResult = " E";
        assertEquals(tr.getUpgrade(), expResult);
        System.out.println("Entertainment Code Correct");

    }

    /**
     * Test Time 10:30
     */
    @Test
    public void testArrivalTimes()
    {
        TramTicketRoute tr = new RedRouteTicket("", LocalTime.of(10, 30),dateFri);
        LocalTime expResult = LocalTime.of(11, 30);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 10:30, Arrives at 11:30 correct");

        tr = new RedRouteTicket("", LocalTime.of(11, 30),dateFri);
        expResult = LocalTime.of(12, 30);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 11:30, Arrives at 12:30 correct");

        tr = new RedRouteTicket("", LocalTime.of(13, 30),dateFri);
        expResult = LocalTime.of(14, 30);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 13:30, Arrives at 14:30 correct");

        tr = new RedRouteTicket("", LocalTime.of(16, 30),dateFri);
        expResult = LocalTime.of(17, 30);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 16:30, Arrives at 17:30 correct");

        tr = new RedRouteTicket("", LocalTime.of(21, 30),dateFri);
        expResult = LocalTime.of(22, 30);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 21:30, Arrives at 22:30 correct");

        tr = new RedRouteTicket("", LocalTime.of(01, 30),dateFri);
        expResult = LocalTime.of(02, 30);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 01:30, Arrives at 02:30 correct");
    }
    
    @Test 
    public void testToString()
    {
        TramTicketRoute tr = new RedRouteTicket("", LocalTime.of(01, 30),dateFri);
        String expResult = String.format(" \n Price: £%s,    Depart From: %s,    Arrive At: %s,   Depart Time: %s,   Arrive At: %s,   Date: %s,   Type: %s,   Extra's Code: %s",
                tr.getCost(), tr.getDepartureLoaction(), tr.getArrivalLoaction(), tr.getDepartureTime(),
                tr.getArrivalTime(), tr.getDate(), tr.getPassengerType(), tr.getUpgrade());
        assertEquals(tr.toString(), expResult);
        System.out.println("To String Method Is Correct");
    }
    
    @Test
    public void testDefaultCost()
    {
        TramTicketRoute tr = new RedRouteTicket("dfsdf",timeNoon,dateFri);
        double expResult = -1;
        assertEquals(tr.getCost(),expResult, 0.0);
        System.out.println("Default Cost Working Correct");
    }
}
