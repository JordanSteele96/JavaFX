package IncrementalGame;

import java.awt.Color;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	JLabel counterLabel;
	JLabel clickDamageLabel;
	int numberOfClicks;
	int clickDamage;
	Font font2;
	Font font1;
	ClickHandler handler = new ClickHandler();

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		numberOfClicks = 0;
		clickDamage = 1;
		createFont();
		createUI();
	}

	public void createFont() {
		font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
		font2 = new Font("Comic Sans MS", Font.PLAIN, 16);
	}

	public void createUI() {

		JFrame window = new JFrame();
		window.setSize(1000, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLayout(null);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/jorda/eclipse-workspace/IncrementalGame/res/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		window.setContentPane(new JLabel(imageIcon));

		JPanel clickObject = new JPanel();
		clickObject.setBounds(50, 250, 320, 320);
		clickObject.setBackground(Color.blue);
		clickObject.setOpaque(false);
		window.add(clickObject);

		ImageIcon bear = new ImageIcon(getClass().getClassLoader().getResource("bear.png"));
		JButton clickButton = new JButton();
		clickButton.setBackground(Color.blue);
		clickButton.setFocusPainted(false);
		clickButton.setBorder(null);
		clickButton.setIcon(bear);
		clickButton.setOpaque(false);
		clickButton.addActionListener(handler);
		clickObject.add(clickButton);

		JPanel counter = new JPanel();
		counter.setBounds(100, 100, 350, 100);
		counter.setLayout(new GridLayout(2, 1));
		counter.setBackground(Color.blue);
		counter.setOpaque(false);
		window.add(counter);

		counterLabel = new JLabel(numberOfClicks + " " + "Clicks");
		counterLabel.setForeground(Color.white);
		counterLabel.setFont(font1);
		counter.add(counterLabel);

		clickDamageLabel = new JLabel(clickDamage + " " + "Click Damage");
		clickDamageLabel.setForeground(Color.white);
		clickDamageLabel.setFont(font2);
		counter.add(clickDamageLabel);

		JPanel upgradePanel = new JPanel();
		upgradePanel.setBounds(550, 100, 350, 475);
		upgradePanel.setLayout(new GridLayout(4, 1));
		upgradePanel.setBackground(Color.blue);
		window.add(upgradePanel);

		JButton upgradeOne = new JButton();
		upgradeOne.setBackground(Color.green);
		upgradeOne.setText("Upgrade One");
		upgradePanel.add(upgradeOne);

		JButton upgradeTwo = new JButton();
		upgradeTwo.setBackground(Color.cyan);
		upgradeTwo.setText("Upgrade Two");
		upgradePanel.add(upgradeTwo);

		JButton upgradeThree = new JButton();
		upgradeThree.setBackground(Color.red);
		upgradeThree.setText("Upgrade Three");
		upgradePanel.add(upgradeThree);

		JButton upgradeFour = new JButton();
		upgradeFour.setBackground(Color.black);
		upgradeFour.setText("Upgrade Four");
		upgradePanel.add(upgradeFour);

		window.setVisible(true);

	}

	public class ClickHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			numberOfClicks++;
			counterLabel.setText(numberOfClicks + " " + "Clicks");
		}
	}
}