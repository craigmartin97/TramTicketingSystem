/**
 *
 * Main GUI, user interface class that creates the application for the user
 * to use.
 */
package Main;

import TramUpgrade.BlueRouteTicket;
import TramUpgrade.EntertainmentUpgrade;
import TramUpgrade.FirstClassUpgrade;
import TramUpgrade.GreenRouteTicket;
import TramUpgrade.NewspaperUpgrade;
import TramUpgrade.RedRouteTicket;
import TramUpgrade.RefreshmentUpgrade;
import TramUpgrade.TramTicketRoute;
import TramUpgrade.WifiUpgrade;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Craig Q5031372
 */
public class TicketGUI extends JPanel implements MouseListener
{

    /**
     * Instance variables for buttons
     */
    private JButton btnClear;
    private JButton btnTotalCost;
    private JButton btnRedRoute;
    private JButton btnBlueRoute;
    private JButton btnGreenRoute;

    /**
     * Instance variables for panels
     */
    private JPanel panelButtons;
    private JPanel panelDisplay;

    /**
     * Instance variables for text fields arrays to display the text.
     */
    private final JTextField[] displayLabelRedRoute = new JTextField[1];
    private final JTextField[] displayLabelBlueRoute = new JTextField[1];
    private final JTextField[] displayLabelGreenRoute = new JTextField[1];

    /**
     * arrays of each type of tram route
     */
    private TramTicketRoute redRouteList;
    private TramTicketRoute blueRouteList;
    private TramTicketRoute greenRouteList;

    /**
     * Instance of red route tram upgrades
     */
    private TramTicketRoute redRouteFirstClass;
    private TramTicketRoute redRouteEntertainment;
    private TramTicketRoute redRouteWifi;
    private TramTicketRoute redRouteRefreshment;
    private TramTicketRoute redRouteRefreshment2;
    private TramTicketRoute redRouteNewspaper;
    private TramTicketRoute redRouteNewspaper2;

    /**
     * Instances of a blue route tram upgrades
     */
    private TramTicketRoute blueRouteFirstClass;
    private TramTicketRoute blueRouteEntertainment;
    private TramTicketRoute blueRouteWifi;
    private TramTicketRoute blueRouteRefreshment;
    private TramTicketRoute blueRouteRefreshment2;
    private TramTicketRoute blueRouteNewspaper;
    private TramTicketRoute blueRouteNewspaper2;

    /**
     * Instances of a green route tram upgrades
     */
    private TramTicketRoute greenRouteFirstClass;
    private TramTicketRoute greenRouteEntertainment;
    private TramTicketRoute greenRouteWifi;
    private TramTicketRoute greenRouteRefreshment;
    private TramTicketRoute greenRouteRefreshment2;
    private TramTicketRoute greenRouteNewspaper;
    private TramTicketRoute greenRouteNewspaper2;

    /**
     * total cost instance variable
     */
    private static double totalCost;

    TicketGUI()
    {
        // Create Panels
        createPanels();

        // Create Labels
        createLabels();

        // Create Buttons
        createButtons();

        // Add Panels, Buttons, Labels
        addPanels();
        addButtons();
    }

    /**
     * method to create all panels
     */
    public final void createPanels()
    {
        this.setLayout(new BorderLayout());

        // Create JPanel for All Buttons
        Dimension buttonPanelSize = new Dimension(250, 170);
        panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1, 4));
        panelButtons.setPreferredSize(buttonPanelSize);

        // Create panel to hold text fields
        panelDisplay = new JPanel();
        panelDisplay.setLayout(new GridLayout(3, 1));
        panelDisplay.setPreferredSize(new Dimension(1400, 450));

    }

    /**
     * method to create all labels
     */
    public final void createLabels()
    {
        Font font = new Font("Arial", Font.PLAIN, 18);
        // red route text fields
        for (int i = 0; i < displayLabelRedRoute.length; i++)
        {
            // create jtectfields and stylings
            displayLabelRedRoute[i] = new JTextField();
            displayLabelRedRoute[i].setBackground(new Color(255, 77, 77));
            displayLabelRedRoute[i].setFont(font);
            displayLabelRedRoute[i].setHorizontalAlignment(JLabel.CENTER);
            displayLabelRedRoute[i].setForeground(new Color(255, 255, 255, 255));
            displayLabelRedRoute[i].setEditable(false);
            displayLabelRedRoute[i].setOpaque(true);
            displayLabelRedRoute[i].addMouseListener(this);
            panelDisplay.add(displayLabelRedRoute[i]);
        }

        // blue route text fields
        for (int i = 0; i < displayLabelBlueRoute.length; i++)
        {
            // create jlabel and stylings
            displayLabelBlueRoute[i] = new JTextField();
            displayLabelBlueRoute[i].setBackground(new Color(0, 153, 255));
            displayLabelBlueRoute[i].setFont(font);
            displayLabelBlueRoute[i].setHorizontalAlignment(JLabel.CENTER);
            displayLabelBlueRoute[i].setForeground(new Color(255, 255, 255, 255));
            displayLabelBlueRoute[i].setEditable(false);
            displayLabelBlueRoute[i].setOpaque(true);
            displayLabelBlueRoute[i].addMouseListener(this);
            panelDisplay.add(displayLabelBlueRoute[i]);
        }

        // green route text fields
        for (int i = 0; i < displayLabelGreenRoute.length; i++)
        {
            // create jlabel and stylings
            displayLabelGreenRoute[i] = new JTextField();
            displayLabelGreenRoute[i].setBackground(new Color(111, 220, 111));
            displayLabelGreenRoute[i].setFont(font);
            displayLabelGreenRoute[i].setHorizontalAlignment(JLabel.CENTER);
            displayLabelGreenRoute[i].setForeground(new Color(255, 255, 255, 255));
            displayLabelGreenRoute[i].setEditable(false);
            displayLabelGreenRoute[i].setOpaque(true);
            displayLabelGreenRoute[i].addMouseListener(this);
            panelDisplay.add(displayLabelGreenRoute[i]);
        }
    }

    /**
     * method to create all buttons
     */
    public final void createButtons()
    {

        // Setting colors, fonts and borders of all of the buttons
        Color btn = new Color(64, 64, 64);
        Color text = new Color(255, 255, 255, 255);
        Font font = new Font("Arial", Font.PLAIN, 30);
        Border whiteLine = BorderFactory.createLineBorder(Color.white);

        // Setting Red Route Button
        btnRedRoute = new JButton("Red Route Ticket");
        btnRedRoute.setBackground(btn);
        btnRedRoute.setForeground(text);
        btnRedRoute.setFont(font);
        btnRedRoute.setFocusPainted(false);
        btnRedRoute.setBorder(whiteLine);
        // action listener for red button
        btnRedRoute.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for (int i = 0; i < displayLabelRedRoute.length; i++)
                {
                    if (displayLabelRedRoute[i].getText().isEmpty())
                    {

                        // get time that user enters
                        LocalTime time = getTimeEntered();

                        // get date that user enters
                        LocalDate date = getDateEntered();

                        // prompt user to enter a ticket type 
                        int option = optDialogOptionPassengerType("Choose A Ticket Type", "Please Select An Option");
                        // validate they have selected an option and not x 
                        option = validateOptionPressedPassengerType(option);

                        if (option >= 0 && option <= 3)
                        {
                            if (option == 0)
                            {
                                redRouteList = new RedRouteTicket("Under 5", time, date);
                            } else if (option == 1)
                            {
                                redRouteList = new RedRouteTicket("Under 18", time, date);
                            } else if (option == 2)
                            {
                                redRouteList = new RedRouteTicket("Adult", time, date);
                            } else if (option == 3)
                            {
                                redRouteList = new RedRouteTicket("Pensioner", time, date);
                            }

                            // if a space is blank
                            displayLabelRedRoute[i].setText(redRouteList.toString());
                            updateTotalCostRedRouteAdd();
                            break;

                        } else
                        {
                            cancelMessage();
                        }
                        // if no space is blank and user tries to buy another ticket
                    } else if (!displayLabelRedRoute[0].getText().isEmpty())
                    {
                        messageDialogBox("Full! Can't Buy Another Red Ticket");
                        break;
                    }
                }
            }
        });

        // blue tickets
        btnBlueRoute = new JButton("Blue Route Ticket");
        btnBlueRoute.setBackground(btn);
        btnBlueRoute.setForeground(text);
        btnBlueRoute.setFont(font);
        btnBlueRoute.setFocusPainted(false);
        btnBlueRoute.setBorder(whiteLine);
        // action listener for blue route
        btnBlueRoute.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for (int i = 0; i < displayLabelBlueRoute.length; i++)
                {
                    // if a blue space is free
                    if (displayLabelBlueRoute[i].getText().isEmpty())
                    {
                        // get time that user enters
                        LocalTime time = getTimeEntered();
                        // get date that user enters
                        LocalDate date = getDateEntered();

                        // prompt user to select a ticket type
                        int option = optDialogOptionPassengerType("Choose A Ticket Type", "Please Select An Option");
                        // validate they havent pressed x
                        option = validateOptionPressedPassengerType(option);

                        if (option >= 0 && option <= 3)
                        {
                            if (option == 0)
                            {
                                blueRouteList = new BlueRouteTicket("Under 5", time, date);
                            } else if (option == 1)
                            {
                                blueRouteList = new BlueRouteTicket("Under 18", time, date);
                            } else if (option == 2)
                            {
                                blueRouteList = new BlueRouteTicket("Adult", time, date);
                            } else if (option == 3)
                            {
                                blueRouteList = new BlueRouteTicket("Pensioner", time, date);
                            }

                            // if a blue space is free display the ticket
                            displayLabelBlueRoute[i].setText(blueRouteList.toString());
                            updateTotalCostBlueRouteAdd();
                            break;

                        } else
                        {
                            cancelMessage();
                        }
                        // if not space is free and user tries to buy another blue ticket
                    } else if (!displayLabelBlueRoute[0].getText().isEmpty())
                    {
                        messageDialogBox("Full! Can't Buy Another Blue Ticket");
                        break;
                    }
                }
            }
        });

        // green tickets
        btnGreenRoute = new JButton("Green Route Ticket");
        btnGreenRoute.setBackground(btn);
        btnGreenRoute.setForeground(text);
        btnGreenRoute.setFont(font);
        btnGreenRoute.setFocusPainted(false);
        btnGreenRoute.setBorder(whiteLine);
        // action listener for green tickets
        btnGreenRoute.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for (int i = 0; i < displayLabelGreenRoute.length; i++)
                {
                    if (displayLabelGreenRoute[i].getText().isEmpty())
                    {
                        // get time that user enters
                        LocalTime time = getTimeEntered();
                        // get date that user enters
                        LocalDate date = getDateEntered();

                        int option = optDialogOptionPassengerType("Choose A Ticket Type", "Please Select An Option");
                        option = validateOptionPressedPassengerType(option);

                        if (option >= 0 && option <= 3)
                        {
                            if (option == 0)
                            {
                                greenRouteList = new GreenRouteTicket("Under 5", time, date);
                            } else if (option == 1)
                            {
                                greenRouteList = new GreenRouteTicket("Under 18", time, date);
                            } else if (option == 2)
                            {
                                greenRouteList = new GreenRouteTicket("Adult", time, date);
                            } else if (option == 3)
                            {
                                greenRouteList = new GreenRouteTicket("Pensioner", time, date);
                            }
                            // if a space is free
                            displayLabelGreenRoute[i].setText(greenRouteList.toString());
                            updateTotalCostGreenRouteAdd();
                            break;

                        } else
                        {
                            cancelMessage();
                        }
                        // if no space is free
                    } else if (!displayLabelGreenRoute[0].getText().isEmpty())
                    {
                        messageDialogBox("Full! Can't Buy Another Blue Ticket");
                        break;
                    }
                }
            }
        });

        // total cost
        btnTotalCost = new JButton("Total Cost");
        btnTotalCost.setBackground(btn);
        btnTotalCost.setForeground(text);
        btnTotalCost.setFont(font);
        btnTotalCost.setFocusPainted(false);
        btnTotalCost.setBorder(whiteLine);
        btnTotalCost.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // user selects an option
                int opts = optDialogOption("Do You Want To View Current Total", "Please Select An Option");

                // yes
                if (opts == 0)
                {
                    messageDialogBox("Current Total Is: £" + totalCost);
                } // no
                else if (opts == 1)
                {
                    cancelMessage();
                }
            }
        });

        // clear app of all current tickets
        btnClear = new JButton("Clear App");
        btnClear.setBackground(btn);
        btnClear.setForeground(text);
        btnClear.setFont(font);
        btnClear.setFocusPainted(false);
        btnClear.setBorder(whiteLine);
        btnClear.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ex)
            {
                int clearApp = optDialogOption("Do You Want To Clear The App", "Please Select An Option");

                if (clearApp == 0)
                {
                    for (int i = 0; i < 1; i++)
                    {
                        redRouteList = null;
                        redRouteFirstClass = null;
                        redRouteEntertainment = null;
                        redRouteWifi = null;
                        redRouteNewspaper = null;
                        redRouteRefreshment = null;
                        redRouteNewspaper2 = null;
                        redRouteRefreshment2 = null;

                        blueRouteList = null;
                        blueRouteFirstClass = null;
                        blueRouteEntertainment = null;
                        blueRouteWifi = null;
                        blueRouteNewspaper = null;
                        blueRouteRefreshment = null;
                        blueRouteNewspaper2 = null;
                        blueRouteRefreshment2 = null;

                        greenRouteList = null;
                        greenRouteFirstClass = null;
                        greenRouteEntertainment = null;
                        greenRouteWifi = null;
                        greenRouteNewspaper = null;
                        greenRouteRefreshment = null;

                        displayLabelRedRoute[i].setText(null);
                        displayLabelBlueRoute[i].setText(null);
                        displayLabelGreenRoute[i].setText(null);

                    }
                    totalCost = 0;
                    messageDialogBox("Successfully Cleared App");
                } else
                {
                    cancelMessage();
                }
            }
        });
    }

    /**
     * method to add all buttons to the panels
     */
    public final void addButtons()
    {
        panelButtons.add(btnRedRoute);
        panelButtons.add(btnBlueRoute);
        panelButtons.add(btnGreenRoute);
        panelButtons.add(btnTotalCost);
        panelButtons.add(btnClear);
    }

    /**
     * method to add panels to the overall panel
     */
    public final void addPanels()
    {
        this.add(panelButtons, BorderLayout.SOUTH);
        this.add(panelDisplay, BorderLayout.CENTER);
    }

    /**
     * method adds red ticket to total cost
     */
    public void updateTotalCostRedRouteAdd()
    {
        // if tr is empty
        if (redRouteList == null)
        {
            return;
        } else
        {
            // add the charge onto overall and current total
            totalCost += redRouteList.getCost();
        }
    }

    /**
     * method minuses red ticket from total cost
     */
    public void updateTotalCostRedRouteMinus()
    {
        if (redRouteList == null)
        {
            return;
        } else
        {
            // minus from total cost
            totalCost -= redRouteList.getCost();
        }
    }

    /**
     * method adds blue ticket to total cost
     */
    public void updateTotalCostBlueRouteAdd()
    {
        if (blueRouteList == null)
        {
            return;
        } else
        {
            // add charge from total cost 
            totalCost += blueRouteList.getCost();
        }
    }

    /**
     * method minus blue ticket from total cost
     */
    public void updateTotalCostBlueRouteMinus()
    {
        if (blueRouteList == null)
        {
            System.out.print("");
        } else
        {
            totalCost -= blueRouteList.getCost();
        }
    }

    /**
     * method adds green ticket cost to total cost
     */
    public void updateTotalCostGreenRouteAdd()
    {
        if (greenRouteList == null)
        {
            System.out.println("");
        } else
        {
            totalCost += greenRouteList.getCost();
        }
    }

    /**
     * method minuses green ticket cost from total cost
     */
    public void updateTotalCostGreenRouteMinus()
    {
        if (greenRouteList == null)
        {
            System.out.println("");
        } else
        {
            totalCost -= greenRouteList.getCost();
        }
    }

    /**
     * method that displays the red route ticket and places it on the red routes
     * jtextfield
     *
     */
    public void displayRedRouteText()
    {
        for (int i = 0; i < displayLabelRedRoute.length; i++)
        {
            displayLabelRedRoute[i].setText(redRouteList.toString());
        }
    }

    /**
     * method that displays the blue route ticket and places it on the blue
     * routes jtextfield
     *
     */
    public void displayBlueRouteText()
    {
        for (int i = 0; i < displayLabelBlueRoute.length; i++)
        {
            displayLabelBlueRoute[i].setText(blueRouteList.toString());
        }
    }

    /**
     * method that displays the green route ticket and places it on the green
     * routes jtextfield
     *
     */
    public void displayGreenRouteText()
    {
        for (int i = 0; i < displayLabelGreenRoute.length; i++)
        {
            displayLabelGreenRoute[i].setText(greenRouteList.toString());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // BLANK
    }

    /**
     * when ticket is pressed it will perform an action if the ticket is empty,
     * it produces a message telling the user its empty if the ticket contains
     * details, it will ask the user what upgrade they would like to apply to
     * the ticket
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me)
    {
        if (SwingUtilities.isLeftMouseButton(me))
        {
            for (int i = 0; i < displayLabelRedRoute.length; i++)
            {
                if (me.getSource() == displayLabelRedRoute[i])
                {
                    if (!displayLabelRedRoute[i].getText().isEmpty())
                    {
                        int upgradeOption = optDialogOptionUpgrade("Choose An Upgrade", "Please Select An Option");

                        if (me.getSource() == displayLabelRedRoute[i])
                        {
                            // option first class
                            if (upgradeOption == 0)
                            {
                                // if user has already upgraded first class
                                if (redRouteFirstClass != null)
                                {
                                    messageDialogBox("Can't add a second First Class Upgrade");
                                    break;
                                }

                                // if fc is null
                                updateTotalCostRedRouteMinus();
                                redRouteList = new FirstClassUpgrade(redRouteList);
                                //redRouteList = redRouteFirstClass;

                                // option entertainment
                            } else if (upgradeOption == 1)
                            {
                                // if entertainment has already been selected
                                if (redRouteEntertainment != null)
                                {
                                    messageDialogBox("Can't add a second Entertainment Upgrade");
                                    break;
                                }

                                // is e is null
                                updateTotalCostRedRouteMinus();
                                redRouteList = new EntertainmentUpgrade(redRouteList);
                                //redRouteList = redRouteEntertainment;

                                // newspaper upgrade
                            } else if (upgradeOption == 2)
                            {
                                // newspaper object 1 is null
                                if (redRouteNewspaper == null)
                                {
                                    updateTotalCostRedRouteMinus();
                                    redRouteNewspaper = new NewspaperUpgrade(redRouteList);
                                    redRouteList = redRouteNewspaper;

                                    // newspaper object 1 is not null and newspaper 2 is null
                                } else if (redRouteNewspaper != null && redRouteNewspaper2 == null)
                                {
                                    updateTotalCostRedRouteMinus();
                                    redRouteNewspaper2 = new NewspaperUpgrade(redRouteList);
                                    redRouteList = redRouteNewspaper2;

                                    // if both are not null
                                } else
                                {
                                    messageDialogBox("Can't add third Newspaper Upgrade");
                                    break;
                                }

                                // refreshment upgrade
                            } else if (upgradeOption == 3)
                            {
                                // refreshment upgrade 1 is null
                                if (redRouteRefreshment == null)
                                {
                                    updateTotalCostRedRouteMinus();
                                    redRouteRefreshment = new RefreshmentUpgrade(redRouteList);
                                    redRouteList = redRouteRefreshment;

                                    // refreshment 1 is not empty and refreshment 2 is null
                                } else if (redRouteRefreshment != null && redRouteRefreshment2 == null)
                                {
                                    updateTotalCostRedRouteMinus();
                                    redRouteRefreshment2 = new RefreshmentUpgrade(redRouteList);
                                    redRouteList = redRouteRefreshment2;

                                    // both not null display this
                                } else
                                {
                                    messageDialogBox("Can't add a third Refreshment Upgrade");
                                    break;
                                }

                                // wifi upgrade selected
                            } else if (upgradeOption == 4)
                            {
                                // if wifi is not null
                                if (redRouteWifi != null)
                                {
                                    messageDialogBox("Can't add a second Entertainment Upgrade");
                                    break;
                                }

                                // is w is null
                                updateTotalCostRedRouteMinus();
                                redRouteWifi = new WifiUpgrade(redRouteList);
                                redRouteList = redRouteWifi;

                            } else
                            {
                                cancelMessage();
                            }

                            updateTotalCostRedRouteAdd();
                            displayRedRouteText();
                            break;
                        }
                        // if space is blank and no ticket is there
                    } else if (displayLabelRedRoute[i].getText().isEmpty())
                    {
                        messageDialogBox("This Red Ticket Is Blank");
                        break;
                    }
                }
            }

            for (int i = 0; i < displayLabelBlueRoute.length; i++)
            {
                if (me.getSource() == displayLabelBlueRoute[i])
                {
                    if (!displayLabelBlueRoute[i].getText().isEmpty())
                    {
                        int upgradeOption = optDialogOptionUpgrade("Choose An Upgrade", "Please Select An Option");
                        if (me.getSource() == displayLabelBlueRoute[i])
                        {
                            // first class upgrade
                            if (upgradeOption == 0)
                            {
                                if (blueRouteFirstClass != null)
                                {
                                    messageDialogBox("Can't add a second First Class Upgrade");
                                    break;
                                }

                                updateTotalCostBlueRouteMinus();
                                blueRouteFirstClass = new FirstClassUpgrade(blueRouteList);
                                blueRouteList = blueRouteFirstClass;

                                // entertainment upgrade
                            } else if (upgradeOption == 1)
                            {
                                if (blueRouteEntertainment != null)
                                {
                                    messageDialogBox("Can't add a second Entertainment Upgrade");
                                    break;
                                }

                                updateTotalCostBlueRouteAdd();
                                blueRouteEntertainment = new EntertainmentUpgrade(blueRouteList);
                                blueRouteList = blueRouteEntertainment;

                                // newspaper upgrade
                            } else if (upgradeOption == 2)
                            {
                                if (blueRouteNewspaper == null)
                                {
                                    updateTotalCostBlueRouteMinus();
                                    blueRouteNewspaper = new NewspaperUpgrade(blueRouteList);
                                    blueRouteList = blueRouteNewspaper;
                                } else if (blueRouteNewspaper != null && blueRouteNewspaper2 == null)
                                {
                                    updateTotalCostBlueRouteMinus();
                                    blueRouteNewspaper2 = new NewspaperUpgrade(blueRouteList);
                                    blueRouteList = blueRouteNewspaper2;
                                } else
                                {
                                    messageDialogBox("Can't add a third Newspaper Upgrade");
                                    break;
                                }

                                // refreshment upgrade
                            } else if (upgradeOption == 3)
                            {
                                if (blueRouteRefreshment == null)
                                {
                                    updateTotalCostBlueRouteMinus();
                                    blueRouteRefreshment = new RefreshmentUpgrade(blueRouteList);
                                    blueRouteList = blueRouteRefreshment;
                                } else if (blueRouteRefreshment != null && blueRouteRefreshment2 == null)
                                {
                                    updateTotalCostBlueRouteMinus();
                                    blueRouteRefreshment2 = new RefreshmentUpgrade(blueRouteList);
                                    blueRouteList = blueRouteRefreshment2;
                                } else
                                {
                                    messageDialogBox("Can't add a third Refreshment Upgrade");
                                    break;
                                }

                                // wifi upgrade
                            } else if (upgradeOption == 4)
                            {
                                if (blueRouteWifi != null)
                                {
                                    messageDialogBox("Can't add a second Wifi Upgrade");
                                }

                                updateTotalCostBlueRouteMinus();
                                blueRouteWifi = new WifiUpgrade(blueRouteList);
                                blueRouteList = blueRouteWifi;

                                // cancel message
                            } else
                            {
                                cancelMessage();
                            }

                            updateTotalCostBlueRouteAdd();
                            displayBlueRouteText();
                            break;
                        }
                    } else if (displayLabelBlueRoute[i].getText().isEmpty())
                    {
                        messageDialogBox("This Blue Ticket Is Blank");
                        break;
                    }
                }
            }

            for (int i = 0; i < displayLabelGreenRoute.length; i++)
            {
                if (me.getSource() == displayLabelGreenRoute[i])
                {
                    if (!displayLabelGreenRoute[i].getText().isEmpty())
                    {
                        int upgradeOption = optDialogOptionUpgrade("Choose An Upgrade", "Please Select An Option");

                        if (me.getSource() == displayLabelGreenRoute[i])
                        {
                            // first class
                            if (upgradeOption == 0)
                            {
                                if (greenRouteFirstClass != null)
                                {
                                    messageDialogBox("Can't add a second First Class Upgrade");
                                }

                                updateTotalCostGreenRouteMinus();
                                greenRouteFirstClass = new FirstClassUpgrade(greenRouteList);
                                greenRouteList = greenRouteFirstClass;

                                // entertainment
                            } else if (upgradeOption == 1)
                            {
                                if (greenRouteEntertainment != null)
                                {
                                    messageDialogBox("Can't add a second Entertainment Upgrade");
                                }

                                updateTotalCostGreenRouteMinus();
                                greenRouteEntertainment = new EntertainmentUpgrade(greenRouteList);
                                greenRouteList = greenRouteEntertainment;

                                // Newspaper 
                            } else if (upgradeOption == 2)
                            {
                                if (greenRouteNewspaper == null)
                                {
                                    updateTotalCostGreenRouteMinus();
                                    greenRouteNewspaper = new NewspaperUpgrade(greenRouteList);
                                    greenRouteList = greenRouteNewspaper;
                                } else if (greenRouteNewspaper != null && greenRouteNewspaper2 == null)
                                {
                                    updateTotalCostGreenRouteMinus();
                                    greenRouteNewspaper2 = new NewspaperUpgrade(greenRouteList);
                                    greenRouteList = greenRouteNewspaper2;
                                } else
                                {
                                    messageDialogBox("Can't add a third Newspaper Upgrade");
                                }
                                // refreshment 
                            } else if (upgradeOption == 3)
                            {
                                if (greenRouteRefreshment == null)
                                {
                                    updateTotalCostGreenRouteMinus();
                                    greenRouteRefreshment = new RefreshmentUpgrade(greenRouteList);
                                    greenRouteList = greenRouteRefreshment;
                                } else if (greenRouteRefreshment != null && greenRouteRefreshment2 == null)
                                {
                                    updateTotalCostGreenRouteMinus();
                                    greenRouteRefreshment2 = new RefreshmentUpgrade(greenRouteList);
                                    greenRouteList = greenRouteRefreshment2;
                                } else
                                {
                                    messageDialogBox("Can't add a third Refreshment Upgrade");
                                }
                            } else if (upgradeOption == 4)
                            {
                                if (greenRouteWifi != null)
                                {
                                    messageDialogBox("Can't add a second Wifi Upgrade");
                                }

                                updateTotalCostGreenRouteMinus();
                                greenRouteWifi = new WifiUpgrade(greenRouteList);
                                greenRouteList = greenRouteWifi;
                            } else
                            {
                                cancelMessage();
                            }

                            updateTotalCostGreenRouteAdd();
                            displayGreenRouteText();
                            break;
                        }
                    } else if (displayLabelGreenRoute[i].getText().isEmpty())
                    {
                        messageDialogBox("This Green Ticket Is Blank");
                        break;
                    }
                }
            }
            // remove layer / upgrade a ticket

            /**
             * I believe that this solution isn't the best as it't been more
             * hard coded in and not as dynamic as it could be a better way
             * would be by adding a method in the TramUpgrade class called
             * getPreviousLayer that returns the previous layer from there i
             * could keep removing layer by layer until i get to the bottom
             * layer then re-add each layer that the user previously selected
             */
        } else if (SwingUtilities.isRightMouseButton(me))
        {
            for (int i = 0; i < displayLabelRedRoute.length; i++)
            {
                if (me.getSource() == displayLabelRedRoute[i])
                {
                    if (!displayLabelRedRoute[i].getText().isEmpty())
                    {
                        int upgradeOption = optDialogOption("Would you like to remove the previous layer?", "Please Select An Option");

                        if (me.getSource() == displayLabelRedRoute[i])
                        {
                            redRouteList = redRouteList.getPreviousLayer();
                            totalCost = redRouteList.getCost();
                        }
                        displayRedRouteText();
                    }
                }
            }
            for (int i = 0; i < displayLabelBlueRoute.length; i++)
            {
                if (me.getSource() == displayLabelBlueRoute[i])
                {
                    if (!displayLabelBlueRoute[i].getText().isEmpty())
                    {
                        int upgradeOption = optDialogOptionUpgrade("Choose An Option To Remove", "Please Select An Option");
                        if (me.getSource() == displayLabelBlueRoute[i])
                        {
                            blueRouteList = blueRouteList.getPreviousLayer();
                            totalCost = blueRouteList.getCost();
                        }
                        displayBlueRouteText();
                    }
                }
            }

            for (int i = 0; i < displayLabelGreenRoute.length; i++)
            {
                if (me.getSource() == displayLabelGreenRoute[i])
                {
                    if (!displayLabelGreenRoute[i].getText().isEmpty())
                    {
                        int upgradeOption = optDialogOptionUpgrade("Choose An Option To Remove", "Please Select An Option");

                        if (me.getSource() == displayLabelGreenRoute[i])
                        {
                            greenRouteList = greenRouteList.getPreviousLayer();
                            totalCost = greenRouteList.getCost();
                        }
                        displayGreenRouteText();
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e
    )
    {
        // BLANK
    }

    @Override
    public void mouseEntered(MouseEvent e
    )
    {
        // BLANK
    }

    @Override
    public void mouseExited(MouseEvent e
    )
    {
        //BLANK
    }

    /**
     * show a message dialog box
     *
     * @param message
     */
    public void messageDialogBox(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     *
     * show a option dialog box with options for passenger types
     *
     * @param title
     * @param message
     * @return
     */
    public int optDialogOptionPassengerType(String title, String message)
    {
        String[] options
                =
                {
                    "Under 5", "Under 18", "Adult", "Pensioner"
                };

        // ask user what type of passenger they are 
        int varMessage = JOptionPane.showOptionDialog(null,
                title,
                message,
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        return varMessage;
    }

    /**
     *
     * show a option dialog box with options for ticket upgrades
     *
     * @param title
     * @param message
     * @return
     */
    public int optDialogOptionUpgrade(String title, String message)
    {
        String[] options
                =
                {
                    "First Class", "Entertainment", "Newspaper", "Refreshment", "Wifi", "None"
                };

        // ask user what type of upgrade they want
        int varMessage = JOptionPane.showOptionDialog(null,
                title,
                message,
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        return varMessage;
    }

    /**
     *
     * ask the user to select a departure time
     *
     * @param title
     * @param message
     * @return
     */
    public String optDialogOptionDepartureTime(String title, String message)
    {
        String[] times =
        {
            "08:00", "08:30", "09:00", "09:30", "10:00", "10:30",
            "11:00", "11:30", "12:00", "13:00", "14:00", "15:00", "16:00",
            "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "21:00"
        };
        JFrame frame = new JFrame("Input A Time");
        String time = (String) JOptionPane.showInputDialog(frame,
                title,
                message,
                JOptionPane.QUESTION_MESSAGE,
                null,
                times,
                times[0]);

        return time;
    }

    /**
     *
     * yes, no option dialog box
     *
     * @param j
     * @param k
     * @return
     */
    public int optDialogOption(String j, String k)
    {
        String[] opts
                =
                {
                    "Yes", "No"
                };

        int varOpt = JOptionPane.showOptionDialog(
                null,
                j,
                k,
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opts,
                opts[0]);

        return varOpt;
    }

    /**
     *
     * @param i
     * @return var
     */
    public String optDialogInput(String i)
    {
        String var = JOptionPane.showInputDialog(i);
        return var;
    }

    /**
     *
     * displays a cancel message
     *
     */
    public void cancelMessage()
    {
        messageDialogBox("Cancelled");
    }

    /**
     * get what date the user has entered
     *
     * @return date
     */
    public LocalDate getDateEntered()
    {
        int x = 1;
        LocalDate date = null;
        String inputDate = optDialogInput("Please Enter A Valid Date yyyy-MM-dd");

        do
        {
            try
            {
                date = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
                if (date.isBefore(LocalDate.now()))
                {
                    x = 1;
                    inputDate = optDialogInput("Please Re-enter A Valid Date yyyy-MM-dd");
                } else if (date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now()))
                {
                    x = 2;
                }
            } catch (Exception ex)
            {
                inputDate = optDialogInput("Please Re-enter A Valid Date yyyy-MM-dd");
            }
        } while (x == 1);

        return date;
    }

    /**
     * get what time the user has selected
     *
     * @return time
     */
    public LocalTime getTimeEntered()
    {

        int x = 1;
        String departureOption = optDialogOptionDepartureTime("Choose A Time To Depart", "Plese Select An Option");
        LocalTime time = null;
        do
        {
            try
            {
                time = LocalTime.parse(departureOption, DateTimeFormatter.ISO_LOCAL_TIME);
                x = 2;
            } catch (Exception exception)
            {
                departureOption = optDialogOptionDepartureTime("Re-Choose A Time To Depart", "Plese Select An Option");
            }
        } while (x == 1);

        return time;
    }

    /**
     * method that validates if the x button has been pressed. Stops the user
     * from pressing the x button
     *
     * @param option
     * @return
     */
    public int validateOptionPressedPassengerType(int option)
    {
        while (option == JOptionPane.CLOSED_OPTION)
        {
            option = optDialogOptionPassengerType("Can't Press X Button, Choose A Ticket Type", "Please Select An Option");
        }

        return option;
    }
}
