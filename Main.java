import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame
{
    public static void main(String[] args) throws IOException
    {
        JFrame frame = new JFrame ("BMI Calculator");
        frame.setVisible(true);
        Dimension frameSize = new Dimension(500,500);
        frame.setSize(frameSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setBounds(0,0,500,500);
        panel.setLayout(new GridLayout(3,2));
        frame.add(panel);

        JLabel text1 = new JLabel("BMI Calculator",SwingConstants.CENTER);
        panel.add(text1);

        JLabel text2 = new JLabel("This app calculate Body mass index");
        panel.add(text2);

        JButton button1 = new JButton("Start");
        panel.add(button1);

        BufferedImage Pic = ImageIO.read(new File("download.png"));
        JLabel picLabel = new JLabel(new ImageIcon(Pic));
        panel.add(picLabel);

        JPanel winnerPanel = new JPanel();
        winnerPanel.setLayout(new GridLayout(4,2));

        JLabel text3 = new JLabel("Enter Height(m):");
        winnerPanel.add(text3);

        JTextField textField1 = new JTextField();
        winnerPanel.add(textField1);

        JLabel text4 = new JLabel("Enter Weight(kg):");
        winnerPanel.add(text4);

        JTextField textField2 = new JTextField();
        winnerPanel.add(textField2);

        JButton button3 = new JButton("Back");
        winnerPanel.add(button3);

        JButton button2 = new JButton("Calculate");
        winnerPanel.add(button2);

        JLabel result = new JLabel("");
        winnerPanel.add(result);

        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                winnerPanel.setBounds(0,0,500,500);
                winnerPanel.setBackground(Color.gray);
                frame.remove(panel);
                frame.add(winnerPanel);
                frame.revalidate();
                frame.repaint();
            }
        });
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                float BMI, Weight, Height;
                Height = Float.parseFloat(textField1.getText());
                Weight = Float.parseFloat(textField2.getText());
                BMI = Weight / (Height * Height);
                result.setText("Your BMI is: " + String.format("%.2f",BMI));
                frame.repaint();
                frame.revalidate();
            }
        });
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.remove(winnerPanel);
                frame.add(panel);
                frame.revalidate();
                frame.repaint();
            }
        });

    frame.add(panel);

    frame.setVisible(true);
    }
}
