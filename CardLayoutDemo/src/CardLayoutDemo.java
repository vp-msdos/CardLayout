/*
 * CardLayoutDemo.java
 *
 */
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CardLayoutDemo implements ActionListener
{
    JPanel cards; //a panel that uses CardLayout

    final static String BUTTONPANEL = "Card with JButtons";

    final static String TEXTPANEL = "Card with JTextField";

    public void addComponentToPane( Container pane )
    {
        JButton next = new JButton("Next");
        next.addActionListener(this );
        //Create the "cards".
        QuestionSamplePOJO pojo1 = new QuestionSamplePOJO();
        pojo1.setQuestion( "Who is PM of India ?" );
        List<String> options1 = new ArrayList<String>();
        options1.add( 0,"Namo" );
        options1.add(1,"MS");
        options1.add(2,"IG");
        pojo1.setOptions( options1 );
        JPanel card1 = new QuestionPanel(pojo1);
        
        QuestionSamplePOJO pojo2 = new QuestionSamplePOJO();
        pojo2.setQuestion( "Who is Captain of India ?" );
        List<String> options2 = new ArrayList<String>();
        options2.add( 0,"Dhoni" );
        options2.add(1,"Virat");
        options2.add(2,"None");
        pojo2.setOptions( options2 );
        JPanel card2 = new QuestionPanel(pojo2);
        

        //Create the panel that contains the "cards".
        cards = new JPanel( new CardLayout() );
        cards.add( card1, BUTTONPANEL );
        cards.add( card2, BUTTONPANEL );

        //pane.add( comboBoxPane, BorderLayout.PAGE_START );
        pane.add( cards, BorderLayout.PAGE_START );
        pane.add( next, BorderLayout.CENTER );
    }

    public void actionPerformed(ActionEvent e)
    {
        CardLayout cl = ( CardLayout ) ( cards.getLayout() );
        cl.next(cards);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be invoked from the event dispatch thread.
     */
    private static void createAndShowGUI()
    {
        //Create and set up the window.
        JFrame frame = new JFrame( "CardLayoutDemo" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        //Create and set up the content pane.
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane( frame.getContentPane() );
        frame.setSize( 800, 800 );

        //Display the window.
        frame.pack();
        frame.setVisible( true );
    }

    public static void main( String[] args )
    {
        /* Use an appropriate Look and Feel */
        try
        {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel( "javax.swing.plaf.metal.MetalLookAndFeel" );
        }
        catch( UnsupportedLookAndFeelException ex )
        {
            ex.printStackTrace();
        }
        catch( IllegalAccessException ex )
        {
            ex.printStackTrace();
        }
        catch( InstantiationException ex )
        {
            ex.printStackTrace();
        }
        catch( ClassNotFoundException ex )
        {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put( "swing.boldMetal", Boolean.FALSE );

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        } );
    }
}
