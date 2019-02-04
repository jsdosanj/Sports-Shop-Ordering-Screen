// Jasvant Singh Dosanjh
/*  Write an application that presents a colorful ordering screen for Lonny’s Lucky Logos Inc.
    which sells selected items with team logos to sports arena shops    */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Project8 extends JFrame
{
    private final double tPrice = 2.0;
    private final double lPrice = 3.0;
    private final double pPrice = 4.0;
    private final double rPrice = 5.0;
    private final double sCost = 15.0;
    private final double capcost = 10.0;
    private final double sweatercost = 20.0;
    private JLabel headerUpper;
    private JLabel headerLower;
    private JLabel footerupper;
    private JLabel footermiddle;
    private JLabel footerlower;
    private JButton tigers;
    private JButton lions;
    private JButton pistons;
    private JButton redwings;
    private JButton donebutton;
    private JButton clearButton;
    private JCheckBox cbTeeshirt;
    private JCheckBox cbCap;
    private JCheckBox cbSweatshirt;
    private JTextField orders;
    private int numOrdered = 0;
    private double cost = 0.0;
    private double costItem = 0.0;
    private String strMsg = null;
    private String strCap = null;
    private String strShirt = null;
    private String strSweat = null;
    private ImageIcon lionlogo = new ImageIcon("lionsp7.png.gif");
    private ImageIcon pistonlogo = new ImageIcon("pistonsp7.png.gif");
    private ImageIcon redwinglogo = new ImageIcon("redwingsp7.png.gif");
    private ImageIcon tigerlogo = new ImageIcon("tigersp7.png.gif");
    private NumberFormat dollarFormat = NumberFormat.getCurrencyInstance();
    private Font fontBig = new Font("serif", Font.BOLD, 72);
    private Font fontSmall = new Font("serif", Font.BOLD, 60);
    private Font fontSmallest = new Font("serif", Font.BOLD, 40);
    private Container mainContainer = getContentPane(); // content pane
    public static void main(String[] args)
    {
        Project8 app = new Project8();
        app.setSize(800, 450);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
    private void addTeamButton(String team, double price, ImageIcon logo)
    {
        JButton button = new JButton(team + " @ " + dollarFormat.format(price), logo);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        mainContainer.add(button);
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                cost = price;
                strMsg = team + " @ " + dollarFormat.format(price);
            }
        });
    }
    public Project8()
    {
        ButtonListener buttonlistener = new ButtonListener();
        CBListen cbListener = new CBListen();
        mainContainer.setLayout(new FlowLayout());
        headerUpper = new JLabel("Lonny's Lucky Logos");
        headerUpper.setFont(fontBig);
        mainContainer.add(headerUpper);
        headerLower = new JLabel(">>> Choose only one team <<<");
        headerLower.setFont(fontSmall);
        mainContainer.add(headerLower);
        addTeamButton("Tigers", tPrice, tigerlogo);
        addTeamButton("Lions", lPrice, lionlogo);
        addTeamButton("Pistons", pPrice, pistonlogo);
        addTeamButton("Redwings", rPrice, redwinglogo);
        footerupper = new JLabel("Choose as many sides by clicking JButton(s)");
        footerupper.setFont(fontSmallest);
        mainContainer.add(footerupper);
        cbTeeshirt = new JCheckBox("Tee shirt @ " + dollarFormat.format(sCost));
        mainContainer.add(cbTeeshirt);
        cbCap = new JCheckBox("Cap @ " + dollarFormat.format(capcost));
        mainContainer.add(cbCap);
        cbSweatshirt = new JCheckBox("Sweatshirt @ " + dollarFormat.format(sweatercost));
        mainContainer.add(cbSweatshirt);
        cbTeeshirt.addItemListener(cbListener);
        cbCap.addItemListener(cbListener);
        cbSweatshirt.addItemListener(cbListener);
        footermiddle = new JLabel("How many orders do you want?");
        mainContainer.add(footermiddle);
        orders = new JTextField(10);
        mainContainer.add(orders);
        orders.addActionListener(buttonlistener);
        footerlower = new JLabel("Press the Done Button below to complete your order");
        mainContainer.add(footerlower);
        donebutton = new JButton("Done");
        mainContainer.add(donebutton);
        clearButton = new JButton("Clear");
        mainContainer.add(clearButton);
        donebutton.addActionListener(buttonlistener);
        clearButton.addActionListener(buttonlistener);
    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String strFinalMsg = "";
            if (e.getSource() == tigers)
            {
                cost = tPrice;
                strMsg = "Tigers @ " + dollarFormat.format(tPrice);
            } else if (e.getSource() == lions)
            {
                cost = lPrice;
                strMsg = "Lions @ " + dollarFormat.format(lPrice);
            } else if (e.getSource() == pistons)
            {
                cost = pPrice;
                strMsg = "Pistons @ " + dollarFormat.format(pPrice);
            } else if (e.getSource() == redwings)
            {
                cost = rPrice;
                strMsg = "Redwings @ " + dollarFormat.format(rPrice);
            }
            if (e.getSource() == donebutton)
            {
                if (isInteger() == true)
                {
                    if (strShirt == null)
                    {
                        strShirt = "";
                    }
                    if (strCap == null)
                    {
                        strCap = "";
                    }
                    if (strSweat == null)
                    {
                        strSweat = "";
                    }
                    numOrdered = Integer.parseInt(orders.getText());
                    strFinalMsg = strMsg + strShirt + strCap + strSweat + "\nTotal cost for " + numOrdered
                            + " orders: " + dollarFormat.format((costItem + cost) * numOrdered);
                    JOptionPane.showMessageDialog(null, strFinalMsg, "Total Bill", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if (e.getSource() == clearButton)
            {
                orders.setText("");
                cbTeeshirt.setSelected(false);
                cbCap.setSelected(false);
                cbSweatshirt.setSelected(false);
                strShirt = null;
                strCap = null;
                strSweat = null;
                costItem = 0.0;
                cost = 0.0;
                mainContainer.repaint();
            }
        }
        private boolean isInteger()
        {
            try
            {
                Integer.parseInt(orders.getText());
            } catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null, "Enter a valid number of orders.");
                return false;
            }
            return true;
        }
    }
    private class CBListen implements ItemListener
    {
        public void itemStateChanged(ItemEvent ie)
        {
            if (ie.getSource() == cbTeeshirt)
            {
                if (ie.getStateChange() == ItemEvent.SELECTED)
                {
                    costItem += sCost;
                    strShirt = "\nTee Shirt @ " + dollarFormat.format(sCost);
                } else
                {
                    costItem -= sCost;
                    strShirt = null;
                }
            }
            if (ie.getSource() == cbCap)
            {
                if (ie.getStateChange() == ItemEvent.SELECTED)
                {
                    costItem += capcost;
                    strCap = "\nCap @ " + dollarFormat.format(capcost);
                } else
                {
                    costItem -= capcost;
                    strCap = null;
                }
            }
            if (ie.getSource() == cbSweatshirt)
            {
                if (ie.getStateChange() == ItemEvent.SELECTED)
                {
                    costItem += sweatercost;
                    strSweat = "\nSweatshirt @ " + dollarFormat.format(capcost);
                } else
                {
                    costItem -= sweatercost;
                    strSweat = null;
                }
            }
        }
    }
}