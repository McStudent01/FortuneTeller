import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

public class FortuneTellerFrame extends JFrame
{
    private JLabel titleLabel;
    private JTextArea fortuneTextArea;
    private JButton readFortuneButton;
    private JButton quitButton;

    private ArrayList<String> fortunes;
    private int lastFortuneIndex;
}
