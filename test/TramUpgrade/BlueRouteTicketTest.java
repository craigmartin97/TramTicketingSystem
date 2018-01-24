/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TramUpgrade;


import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 *
 * @author Craig
 */
public class BlueRouteTicketTest
{
    /**
     * Types of passengers
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
     * Check that concrete BlueRoute class is a sub-class of Tram.
     */
    @Test
    public void testBlueTramRouteSubClass()
    {
        assertTrue(new BlueRouteTicket(under5, timeNoon,dateFri) instanceof TramTicketRoute);
        System.out.println("Concrete BlueRoute class extends TramRoute");
    }

    /**
     * Check that concrete upgrades are sub-classes of Tram and TramTicketUpgrade.
     */
    @Test
    public void testUpgradeBlueRouteSubClassTramRoute()
    {

        TramTicketRoute trr = new BlueRouteTicket(under18, timeMid,dateFri);

        // first class upgrade Blue Route
        trr = new FirstClassUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // wifi upgrade Blue Route
        trr = new WifiUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Newspaper upgrade Blue Route
        trr = new NewspaperUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Refreshment Upgrade Blue Route
        trr = new RefreshmentUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        // Entertainment Upgrade  Blue Route
        trr = new EntertainmentUpgrade(trr);
        assertTrue(trr instanceof TramTicketRoute);
        assertTrue(trr instanceof TramTicketUpgrade);

        System.out.println("Concrete class BlueRoute extends TramRoute & TramUpgrade");
    }

    /**
     * Test basic costs for all passenger types on the blue route
     */
    @Test
    public void testBasicCosts()
    {

        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, timeNoon, dateFri);
        final double expectedCost1 = 0.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Basic BlueRoute Under 5 cost Correct");

        // under 18
        tr = new BlueRouteTicket(under18, timeNoon, dateFri);
        final double expectedCost2 = 15.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Basic BlueRoute Under 18 cost Correct");

        // adult
        tr = new BlueRouteTicket(adult, timeNoon, dateFri);
        final double expectedCost3 = 30.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Basic BlueRoute Adult cost Correct");

        // pensioner
        tr = new BlueRouteTicket(pensioner, timeNoon, dateFri);
        final double expectedCost4 = 15.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Basic BlueRoute Pensioner cost Correct");
    }
    
    @Test 
    public void testBasicCostPeakTime()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, time830,dateFri);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("BlueRoute Under 5 Cost Peak Time OK");

        // under 18
        tr = new BlueRouteTicket(under18, time1130,dateFri);
        final double expectedCost2 = 17.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("BlueRoute Under 18 Cost Peak Time OK");

        // adult
        tr = new BlueRouteTicket(adult, time400,dateFri);
        final double expectedCost3 = 34.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("BlueRoute Adult Cost Peak Time OK");

        // pensioner 
        tr = new BlueRouteTicket(pensioner, time630,dateFri);
        final double expectedCost4 = 19.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("BlueRoute Pensioner Cost Peak Time OK");
    }
    
    @Test 
    public void testBasicCostWeekend()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, timeNoon,dateSat);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("BlueRoute Under 5 Cost Weekend Period OK");

        // under 18
        tr = new BlueRouteTicket(under18, timeMid,dateSun);
        final double expectedCost2 = 17.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("BlueRoute Under 18 Cost Weekend Period OK");

        // adult
        tr = new BlueRouteTicket(adult, timeMid,dateSat);
        final double expectedCost3 = 32.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("BlueRoute Adult Cost Weekend Period OK");

        // pensioner 
        tr = new BlueRouteTicket(pensioner, timeNoon,dateSun);
        final double expectedCost4 = 17.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("BlueRoute Pensioner Cost Weekend Period OK");
    }
    
    @Test 
    public void testBasicCostMixed()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, time400,dateSat);
        final double expectedCost1 = 6.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("BlueRoute Under 5 Cost Peak Time & Weekend Period OK");

        // under 18
        tr = new BlueRouteTicket(under18, time1130,dateSun);
        final double expectedCost2 = 19.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("BlueRoute Under 18 Peak Time & Weekend Period OK");

        // adult
        tr = new BlueRouteTicket(adult, timeNoon,dateSun);
        final double expectedCost3 = 32.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("BlueRoute Adult Cost Off Peak & Weekend Period OK");

        // pensioner 
        tr = new BlueRouteTicket(pensioner, time630,dateSun);
        final double expectedCost4 = 21.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("BlueRoute Pensioner Cost Peak Time & Weekend Period OK");
    }

    /**
     * Test Wifi upgrade for all passenger types on the blue route
     */
    @Test
    public void testWifiUpgrade()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost1 = 10.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Wifi Under 5 Upgrade OK");
        
        // under 5 weekend
        tr = new BlueRouteTicket(under5, timeNoon, dateSun);
        tr = new WifiUpgrade(tr);
        final double expectedCost2 = 12.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Wifi Under 5 Upgrade, Weekend Period OK");

        // under 18
        tr = new BlueRouteTicket(under18, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost3 = 25.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Wifi Under 18 Upgrade OK");
        
        // under 18 weekend and peak time
        tr = new BlueRouteTicket(under18, time830, dateSat);
        tr = new WifiUpgrade(tr);
        final double expectedCost4 = 29.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Wifi Under 18 Upgrade, Peak Time & Weekend Period OK");
        
        // under 18 peak time
        tr = new BlueRouteTicket(under18, time400, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost5 = 29.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Wifi Under 18 Upgrade, Peak Time OK");
        
        // adult
        tr = new BlueRouteTicket(adult, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost6 = 40.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Wifi Adult Upgrade OK");

        // pensioner
        tr = new BlueRouteTicket(pensioner, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final double expectedCost7 = 25.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Wifi Pensioner Upgrade OK");
        
        // pensioner weekend
        tr = new BlueRouteTicket(pensioner, timeNoon, dateSat);
        tr = new WifiUpgrade(tr);
        final double expectedCost8 = 27.0;
        assertEquals(tr.getCost(), expectedCost8, 0.0);
        System.out.println("Wifi Pensioner Upgrade, Weekend Period OK");
    }

    /**
     * Test First Class upgrade for all passenger types on the blue route
     */
    @Test
    public void testFirstClassUpgrade()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost1 = 217.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("First Class Under 5 Upgrade OK");
        
        // under 5 weekend
        tr = new BlueRouteTicket(under5, timeNoon, dateSat);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost2 = 219.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("First Class Under 5 Upgrade, Weekend Period OK");

        // under 18
        tr = new BlueRouteTicket(under18, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost3 = 217.0 + 15.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("First Class Under 18 Upgrade OK");
        
        // under 18 peak time
        tr = new BlueRouteTicket(under18, time630, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost4 = 217.0 + 15.0 + 4.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("First Class Under 18 Upgrade, Peak Time OK");

        // adult
        tr = new BlueRouteTicket(adult, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost5 = 247.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("First Class Adult Upgrade OK");

        // pensioner
        tr = new BlueRouteTicket(pensioner, timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost6 = 217.0 + 15.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("First Class Pensioner Upgrade OK");
        
        // pensioner weekend and peak time
        tr = new BlueRouteTicket(pensioner, time400, dateSun);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost7 = 217.0 + 15.0 + 4.0 + 2.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("First Class Pensioner Upgrade, Peak Time & Weekend Period OK");
    }

    /**
     * Test Newspaper Upgrade for all passenger types on the blue route
     */
    @Test
    public void testNewspaperUpgrade()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Newspaper Under 5 Upgrade OK");

        //under 18
        tr = new BlueRouteTicket(under18, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 17.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Newspaper Under 18 Upgrade OK");
        
        // under 18 peak time
        tr = new BlueRouteTicket(under18, time1130, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost3 = 19.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Newspaper Under 18 Upgrade, Peak Time OK");
        
        // under 18 weekend
        tr = new BlueRouteTicket(under18, timeNoon, dateSat);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost4 = 17.0 + 2.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Newspaper Under 18 Upgrade, Weekend Period OK");

        // adult
        tr = new BlueRouteTicket(adult, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost5 = 32.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Newspaper Adult Upgrade OK");
        
        // adult peak time and weekend
        tr = new BlueRouteTicket(adult, time630, dateSun);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost6 = 32.0 + 4.0 + 2.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Newspaper Adult Upgrade, Peak Time & Weekend Period OK");

        // pensioner
        tr = new BlueRouteTicket(pensioner, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost7 = 17.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Newspaper Pensioner Upgrade OK");
    }

    /**
     * Test Entertainment Upgrade for all passenger types on the blue route
     */
    @Test
    public void testEntertainmentUpgrade()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost1 = 100.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Entertainment Under 5 Upgrade OK");
        
        // under 5 weekend and peak time
        tr = new BlueRouteTicket(under5, time830, dateSat);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost2 = 104.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Entertainment Under 5 Upgrade, Peak Time & Weekend Period OK");

        // under 18
        tr = new BlueRouteTicket(under18, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost3 = 115.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Entertainment Under 18 Upgrade OK");
        
        // under 18 peak time
        tr = new BlueRouteTicket(under18, time400, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost4 = 119.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Entertainment Under 18 Upgrade, Peak Time OK");

        // adult
        tr = new BlueRouteTicket(adult, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost5 = 130.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Entertainment Adult Upgrade OK");
        
        // adult and weekend
        tr = new BlueRouteTicket(adult, timeNoon, dateSat);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost6 = 132.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Entertainment Adult Upgrade, Weekend Period OK");

        // pensioner
        tr = new BlueRouteTicket(pensioner, timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost7 = 115.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Entertainment Pensioner Upgrade OK");
        
        // pensioner peak time and weekend
        tr = new BlueRouteTicket(pensioner, time400, dateSat);
        tr = new EntertainmentUpgrade(tr);
        final double expectedCost8 = 121.0;
        assertEquals(tr.getCost(), expectedCost8, 0.0);
        System.out.println("Entertainment Pensioner Upgrade, Peak Time & Weekend Period OK");
    }

    /**
     * Test Refreshment Upgrade for all passengers on the blue route
     */
    @Test
    public void testRefreshmentUpgrade()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost1 = 2.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Refreshment Under 5 Upgrade OK");

        // under 18
        tr = new BlueRouteTicket(under18, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 17.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Refreshment Under 18 Upgrade OK");

        // adult
        tr = new BlueRouteTicket(adult, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost3 = 32.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Refreshment Adult Upgrade OK");
        
        // adult weekend
        tr = new BlueRouteTicket(adult, timeNoon, dateSat);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost4 = 34.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Refreshment Adult Upgrade, Weekend Period OK");

        // pensioner
        tr = new BlueRouteTicket(pensioner, timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost5 = 17.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Refreshment Pensioner Upgrade OK");
        
        // pensioner peak and weekend
        tr = new BlueRouteTicket(pensioner, time1130, dateSat);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost6 = 21.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Refreshment Pensioner Upgrade, Peak Time & Weekend Period OK");

    }

    /**
     * Test multiple upgrades for all passengers on the blue route
     */
    @Test
    public void testMulitpleUpgrades()
    {
        // under 5
        TramTicketRoute tr = new BlueRouteTicket(under5, timeNoon, dateFri);
        tr = new RefreshmentUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost1 = 221.0;
        assertEquals(tr.getCost(), expectedCost1, 0.0);
        System.out.println("Multiple Upgrades on Blue Route For Under 5's Correct");
        
        // under 5 peak and weekend
        tr = new BlueRouteTicket(under5, time830, dateSat);
        tr = new RefreshmentUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost2 = 225.0;
        assertEquals(tr.getCost(), expectedCost2, 0.0);
        System.out.println("Multiple Upgrades on Blue Route For Under 5's, Peak Time & Weekend Period Correct");

        // under 18
        tr = new BlueRouteTicket(under18, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new NewspaperUpgrade(tr);
        final double expectedCost3 = 10.0 + 217.0 + 2.0 + 15.0;
        assertEquals(tr.getCost(), expectedCost3, 0.0);
        System.out.println("Multiple Upgrades on Blue Route For Under 18's Correct");

        // adult
        tr = new BlueRouteTicket(adult, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new EntertainmentUpgrade(tr);
        tr = new RefreshmentUpgrade(tr);
        final double expectedCost4 = 10.0 + 217.0 + 100.0 + 2.0 + 30.0;
        assertEquals(tr.getCost(), expectedCost4, 0.0);
        System.out.println("Multiple Upgrades on Blue Route For Adults Correct");
        
        // adult peak time
        tr = new BlueRouteTicket(adult, time1130, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        tr = new EntertainmentUpgrade(tr);
        tr = new RefreshmentUpgrade(tr);
        final double expectedCost5 = 10.0 + 217.0 + 100.0 + 2.0 + 30.0 + 2.0;
        assertEquals(tr.getCost(), expectedCost5, 0.0);
        System.out.println("Multiple Upgrades on Blue Route For Adults, Peak Time Correct");

        // pensioner
        tr = new BlueRouteTicket(pensioner, timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        tr = new RefreshmentUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost6 = 10.0 + 2.0 + 15.0 + 217.0;
        assertEquals(tr.getCost(), expectedCost6, 0.0);
        System.out.println("Multiple Upgrades on Blue Route For Pensioners Correct");
        
        // pensioner peak time and weekend
        tr = new BlueRouteTicket(pensioner, time400, dateSun);
        tr = new WifiUpgrade(tr);
        tr = new RefreshmentUpgrade(tr);
        tr = new FirstClassUpgrade(tr);
        final double expectedCost7 = 10.0 + 2.0 + 15.0 + 217.0 + 4.0 + 2.0;
        assertEquals(tr.getCost(), expectedCost7, 0.0);
        System.out.println("Multiple Upgrades on Blue Route For Pensioners, Peak Time & Weekend Period Correct");
    }

    /**
     * Test of getDepartureLoaction method, of class BlueRoute.
     */
    @Test
    public void testGetDepartureLoaction()
    {
        BlueRouteTicket instance = new BlueRouteTicket("", timeNoon, dateFri);
        String expResult = "James Cook Hospital";
        String result = instance.getDepartureLoaction();
        assertEquals(expResult, result);
        System.out.println("Blue Route Departure Location Correct");
    }

    /**
     * Test of getArrivalLoaction method, of class BlueRoute.
     */
    @Test
    public void testGetArrivalLoaction()
    {
        BlueRouteTicket instance = new BlueRouteTicket("", timeNoon, dateFri);
        String expResult = "Nunthorpe Village Centre";
        String result = instance.getArrivalLoaction();
        assertEquals(expResult, result);
        System.out.println("Blue Route Arrival Location Correct");
    }

    /**
     * Test of getPassengerType method, of class BlueRoute for all passengers
     */
    @Test
    public void testGetPassengerType()
    {
        // under 5
        BlueRouteTicket instance = new BlueRouteTicket(under5, timeNoon, dateFri);
        String expResult1 = under5;
        String result1 = instance.getPassengerType();
        assertEquals(expResult1, result1);
        System.out.println("Passenger Type Under 5 Working Correct");

        // under 18
        instance = new BlueRouteTicket(under18, timeNoon, dateFri);
        String expResult2 = under18;
        String result2 = instance.getPassengerType();
        assertEquals(expResult2, result2);
        System.out.println("Passenger Type Under 18 Working Correct");

        // adult
        instance = new BlueRouteTicket(adult, timeNoon, dateFri);
        String expResult3 = adult;
        String result3 = instance.getPassengerType();
        assertEquals(expResult3, result3);
        System.out.println("Passenger Type Adult Working Correct");

        // pensioner
        instance = new BlueRouteTicket(pensioner, timeNoon, dateFri);
        String expResult4 = pensioner;
        String result4 = instance.getPassengerType();
        assertEquals(expResult4, result4);
        System.out.println("Passenger Type Pensioner Working Correct");
    }

    /**
     * Test Upgrade Code for all upgrade code types
     */
    @Test
    public void testUpgradeCodes()
    {
        // newspaper
        TramTicketRoute tr = new BlueRouteTicket("", timeNoon, dateFri);
        tr = new NewspaperUpgrade(tr);
        final String expResult1 = " N";
        assertEquals(tr.getUpgrade(), expResult1);
        System.out.println("Newspaper Code Correct");

        // refreshement
        tr = new BlueRouteTicket("", timeNoon, dateFri);
        tr = new RefreshmentUpgrade(tr);
        final String expResult2 = " R";
        assertEquals(tr.getUpgrade(), expResult2);
        System.out.println("Refreshment Code Correct");

        // wifi
        tr = new BlueRouteTicket("", timeNoon, dateFri);
        tr = new WifiUpgrade(tr);
        final String expResult3 = " W";
        assertEquals(tr.getUpgrade(), expResult3);
        System.out.println("Wifi Code Correct");

        // first class
        tr = new BlueRouteTicket("", timeNoon, dateFri);
        tr = new FirstClassUpgrade(tr);
        final String expResult4 = " FC";
        assertEquals(tr.getUpgrade(), expResult4);
        System.out.println("First Class Code Correct");

        // entertainment
        tr = new BlueRouteTicket("", timeNoon, dateFri);
        tr = new EntertainmentUpgrade(tr);
        final String expResult5 = " E";
        assertEquals(tr.getUpgrade(), expResult5);
        System.out.println("Entertainment Code Correct");

    }

    /**
     * Test Arrival Times
     */
    @Test
    public void testArrivalTimes()
    {
        TramTicketRoute tr = new BlueRouteTicket("", LocalTime.of(10, 30), dateFri);
        LocalTime expResult = LocalTime.of(12, 00);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 10:30, Arrives at 11:30 correct");

        tr = new BlueRouteTicket("", LocalTime.of(11, 30), dateFri);
        expResult = LocalTime.of(13, 00);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 11:30, Arrives at 12:30 correct");

        tr = new BlueRouteTicket("", LocalTime.of(13, 30), dateFri);
        expResult = LocalTime.of(15, 00);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 13:30, Arrives at 14:30 correct");

        tr = new BlueRouteTicket("", LocalTime.of(16, 30), dateFri);
        expResult = LocalTime.of(18, 00);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 16:30, Arrives at 17:30 correct");

        tr = new BlueRouteTicket("", LocalTime.of(21, 30), dateFri);
        expResult = LocalTime.of(23, 00);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 21:30, Arrives at 22:30 correct");

        tr = new BlueRouteTicket("", LocalTime.of(01, 30), dateFri);
        expResult = LocalTime.of(03, 00);
        assertEquals(tr.getArrivalTime(), expResult);
        System.out.println("Departs at 01:30, Arrives at 02:30 correct");
    }
    
    @Test 
    public void testToString()
    {
        TramTicketRoute tr = new BlueRouteTicket("", LocalTime.of(01, 30),dateFri);
        String expResult = String.format(" \n Price: £%s,    Depart From: %s,    Arrive At: %s,   Depart Time: %s,   Arrive At: %s,   Date: %s,   Type: %s,   Extra's Code: %s",
                tr.getCost(), tr.getDepartureLoaction(), tr.getArrivalLoaction(), tr.getDepartureTime(),
                tr.getArrivalTime(), tr.getDate(), tr.getPassengerType(), tr.getUpgrade());
        assertEquals(tr.toString(), expResult);
        System.out.println("To String Method Is Correct");
    }
    
    @Test
    public void testDefaultCost()
    {
        TramTicketRoute tr = new BlueRouteTicket("dfsdf",timeNoon,dateFri);
        double expResult = -1;
        assertEquals(tr.getCost(),expResult, 0.0);
        System.out.println("Default Cost Working Correct");
    }
}
