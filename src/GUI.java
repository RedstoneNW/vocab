import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GUI {
    private static JLabel label;
    private JTextField input;
    private static Vokabelliste vokabelliste;
    public GUI() {
        JFrame frame = new JFrame("Vokabel Trainer");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        label = new JLabel("");
        JButton button = new JButton();
        button.setText("Bestätigen");
        JButton lang = new JButton();
        lang.setText("Ask for DE");
        input = new JTextField();
        input.setPreferredSize(new Dimension(200,100));
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals("Correct") || input.getText().equals("WRONG")) {
                    input.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
        lang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vokabelliste.setAskForGerman();
            }
        });
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        panel.add(input);
        panel.add(button);
        panel.add(lang);
        frame.add(panel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
        vokabelliste = new Vokabelliste();
        List<String> de1 = new List<String>();
        de1.append("Hallo");
        List<String> en1 = new List<String>();
        en1.append("Hi");
        Vocab v1 = new Vocab(en1,de1);
        List<String> de2 = new List<String>();
        de2.append("Guten Morgen");
        de2.append("Guten Abend");
        List<String> en2 = new List<String>();
        en2.append("Good Morning");
        en2.append("Good Evening");
        Vocab v2 = new Vocab(en2,de2);
        vokabelliste.add(v1);
        vokabelliste.add(v2);

        List<String> nextVocabList = vokabelliste.getNext();
        nextVocabList.toFirst();
        String nextVocab = "";
        while (nextVocabList.hasAccess()) {
            System.out.println(nextVocab);
            nextVocab = nextVocab + "  " + nextVocabList.getContent();
            nextVocabList.next();
        }
        label.setText(nextVocab);
    }

    public void check() {
        if (vokabelliste.checkVocab(input.getText())) {
            input.setText("Correct");
        } else {
            input.setText("WRONG");
        }
        List<String> nextVocabList = new List<>();
        nextVocabList = vokabelliste.getNext();
        nextVocabList.toFirst();
        String nextVocab = "";
        while (nextVocabList.hasAccess()) {
            nextVocab = nextVocab + "  " + nextVocabList.getContent();
            nextVocabList.next();
        }
        label.setText(nextVocab);
    }
}
