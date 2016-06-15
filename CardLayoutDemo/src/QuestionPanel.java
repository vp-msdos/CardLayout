import java.awt.BorderLayout;

import javax.swing.*;

public class QuestionPanel extends JPanel
{
    private QuestionSamplePOJO pojo;

    private JLabel questionLabel;

    JRadioButton option1;

    JRadioButton option2;

    JRadioButton option3;

    ButtonGroup btnGrp;
    

    public QuestionPanel( QuestionSamplePOJO pojo )
    {
        this.pojo = pojo;
        init();
    }

    private void init()
    {
        //this.setLayout( new BorderLayout() );
        questionLabel = new JLabel( this.pojo.getQuestion() );
        option1 = new JRadioButton( this.pojo.getOptions().get( 0 ) );
        option2 = new JRadioButton( this.pojo.getOptions().get( 1 ) );
        option3 = new JRadioButton( this.pojo.getOptions().get( 2 ) );
        btnGrp = new ButtonGroup();
        btnGrp.add( option1 );
        btnGrp.add( option2 );
        btnGrp.add( option3 );
        this.add( questionLabel );
        this.add( option1 );
        this.add( option2 );
        this.add( option3 );
        this.setVisible( true );
        this.setSize( 500,500 );
    }

}
