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

    public FortuneTellerFrame()
    {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeComponents();

        add(titleLabel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        scrollPane.setPreferredSize(new Dimension(400, 150));
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(readFortuneButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        centerOnScreen();

        initializeFortunes();
    }

    private void initializeComponents()
    {
        Font titleFont = new Font("Arial", Font.BOLD, 48);
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        Font textAreaFont = new Font("Arial", Font.PLAIN, 16);

        ImageIcon fortuneTellerIcon = new ImageIcon("images/fortune-telling.jpg");
        titleLabel = new JLabel("Fortune Teller", fortuneTellerIcon, JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setFont(titleFont);

        fortuneTextArea = new JTextArea();
        fortuneTextArea.setEditable(false);
        fortuneTextArea.setLineWrap(true);
        fortuneTextArea.setWrapStyleWord(true);
        fortuneTextArea.setFont(textAreaFont);

        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(buttonFont);
        readFortuneButton.setEnabled(true);
        readFortuneButton.addActionListener((e) -> readFortune());

        quitButton = new JButton("Quit");
        quitButton.setFont(buttonFont);
        quitButton.addActionListener((e) -> System.exit(0));
    }

    private void initializeFortunes()
    {
        fortunes = new ArrayList<>();
        Collections.addAll(fortunes,
                "You will find unexpected wealth.",
                "Good luck is in your future.",
                "Beware of high-flying ducks.",
                "You will meet someone special today.",
                "Avoid walking under ladders.",
                "An exciting opportunity awaits you.",
                "Take a leap of faith, and you'll be rewarded.",
                "Expect a pleasant surprise soon.",
                "Be cautious with your finances.",
                "A journey of a thousand miles begins with a single step.",
                "Your talents will be recognized.",
                "Today is a good day to try something new.");

        lastFortuneIndex = -1;
    }

    private void readFortune()
    {
        int newFortuneIndex;
        do {
            newFortuneIndex = (int) (Math.random() * fortunes.size());
        } while (newFortuneIndex == lastFortuneIndex);

        String newFortune = fortunes.get(newFortuneIndex);
        fortuneTextArea.append(newFortune + "\n");

        lastFortuneIndex = newFortuneIndex;
    }

    private void centerOnScreen()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        int x = (screen.width - getWidth()) / 4;
        int y = (screen.height - getHeight()) / 4;
        setLocation(x, y);
    }
}