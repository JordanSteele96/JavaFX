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

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Main {
	JLabel counterLabel, clickDamageLabel, monsterHealthLabel, userGoldLabel, upgradeOneText;
	JButton upgradeOne, upgradeTwo, upgradeThree, upgradeFour;
	JPanel userGold, clickObject, counter, upgradePanel, monsterHealthPanel;

	int numberOfClicks;
	int clickDamage;

	int amountOfUpgradedOne;
	int amountOfUpgradedTwo;
	int amountOfUpgradedThree;
	int amountOfUpgradedFour;
	double userGoldAmount;

	int upgradedOne;
	int upgradedTwo;
	int upgradedThree;
	int upgradedFour;

	int costOfUpgradeOne;
	int newCostOfUpgradeOne;
	int costOfUpgradeTwo;
	int costOfUpgradeThree;
	int costOfUpgradeFour;

	double startingMonsterLife;
	double monsterLife;
	Font font2, font1;

	ClickHandler handler = new ClickHandler();
	ClickUpgradeOne theUpgradeOne = new ClickUpgradeOne();
	ClickUpgradeTwo theUpgradeTwo = new ClickUpgradeTwo();
	ClickUpgradeThree theUpgradeThree = new ClickUpgradeThree();
	ClickUpgradeFour theUpgradeFour = new ClickUpgradeFour();

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		numberOfClicks = 0;
		clickDamage = 1;
		amountOfUpgradedOne = 0;
		amountOfUpgradedTwo = 0;
		amountOfUpgradedThree = 0;
		amountOfUpgradedFour = 0;
		userGoldAmount = 0;

		upgradedOne = 2; // Damage of the upgrade
		upgradedTwo = 5;
		upgradedThree = 15;
		upgradedFour = 50;

		costOfUpgradeOne = 5;
		newCostOfUpgradeOne = 0; // cost of the upgrade
		costOfUpgradeTwo = 25;
		costOfUpgradeThree = 50;
		costOfUpgradeFour = 100;

		monsterLife = 10;
		startingMonsterLife = 10;
		createFont();
		createUI();

	}

	public void createFont() {
		font1 = new Font("Helvetica", Font.PLAIN, 32);
		font2 = new Font("Helvetica", Font.PLAIN, 16);

	}

	public void createUI() {

		JFrame window = new JFrame();
		window.setSize(1000, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLayout(null);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\jorda\\git\\JavaFX\\IncrementalGame\\res\\backgroundSpace.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		window.setContentPane(new JLabel(imageIcon));

		JPanel clickObject = new JPanel(); // JPanel for the click object
		clickObject.setBounds(50, 275, 320, 320);
		clickObject.setBackground(Color.blue);
		clickObject.setOpaque(false);
		window.add(clickObject);

		ImageIcon bear = new ImageIcon(getClass().getClassLoader().getResource("clickObject.png"));
		JButton clickButton = new JButton();
		clickButton.setBackground(Color.blue);
		clickButton.setFocusPainted(false);
		clickButton.setBorder(null);
		clickButton.setIcon(bear);
		clickButton.setOpaque(false);
		clickButton.addActionListener(handler);
		clickObject.add(clickButton);

		JPanel counter = new JPanel(); // JPanel for click amount and damage
		counter.setBounds(100, 100, 350, 100);
		counter.setLayout(new GridLayout(2, 1));
		counter.setBackground(Color.blue);
		counter.setOpaque(false);
		window.add(counter);

		counterLabel = new JLabel(numberOfClicks + " " + "Damage Dealt");
		counterLabel.setForeground(Color.white);
		counterLabel.setFont(font1);
		counter.add(counterLabel);

		clickDamageLabel = new JLabel(clickDamage + " " + "Click Damage");
		clickDamageLabel.setForeground(Color.white);
		clickDamageLabel.setFont(font2);
		counter.add(clickDamageLabel);

		JPanel upgradePanel = new JPanel(); // JPanel for upgrade bar
		upgradePanel.setBounds(550, 100, 350, 475);
		upgradePanel.setLayout(new GridLayout(4, 1));
		upgradePanel.setBackground(Color.blue);
		window.add(upgradePanel);

		JButton upgradeOne = new JButton();
		upgradeOne.setBackground(Color.green);
		upgradeOne.addActionListener(theUpgradeOne);
		upgradeOne.setText("Increase click damage by 2 this costs:" + costOfUpgradeOne);
		upgradePanel.add(upgradeOne);

		JButton upgradeTwo = new JButton();
		upgradeTwo.setBackground(Color.cyan);
		upgradeTwo.addActionListener(theUpgradeTwo);
		upgradeTwo.setText("Increase click damage by 5");
		upgradePanel.add(upgradeTwo);

		JButton upgradeThree = new JButton();
		upgradeThree.setBackground(Color.red);
		upgradeThree.addActionListener(theUpgradeThree);
		upgradeThree.setText("Increase click damage by 15");
		upgradePanel.add(upgradeThree);

		JButton upgradeFour = new JButton();
		upgradeFour.setBackground(Color.black);
		upgradeFour.addActionListener(theUpgradeFour);
		upgradeFour.setText("Increase click damage by 50");
		upgradePanel.add(upgradeFour);

		JPanel monsterHealthPanel = new JPanel(); // JPanel for monster life
		monsterHealthPanel.setBounds(135, 200, 350, 100);
		monsterHealthPanel.setLayout(new GridLayout(1, 1));
		monsterHealthPanel.setOpaque(false);
		monsterHealthPanel.setBackground(Color.blue);
		window.add(monsterHealthPanel);

		monsterHealthLabel = new JLabel((int) monsterLife + " " + "Health");
		monsterHealthLabel.setForeground(Color.white);
		monsterHealthLabel.setFont(font1);
		monsterHealthPanel.add(monsterHealthLabel);

		JPanel userGold = new JPanel();
		userGold.setBounds(695, 40, 150, 50);
		userGold.setLayout(new GridLayout(1, 1));
		userGold.setOpaque(false);
		userGold.setBackground(Color.blue);
		window.add(userGold);

		userGoldLabel = new JLabel((int) userGoldAmount + " " + "Gold");
		userGoldLabel.setForeground(Color.white);
		userGoldLabel.setFont(font1);
		userGold.add(userGoldLabel);

		window.setVisible(true);
	}

	public class ClickHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			numberOfClicks = numberOfClicks + clickDamage;
			monsterLife = (int) monsterLife - clickDamage;
			counterLabel.setText(numberOfClicks + " " + "Damage Dealt");
			monsterHealthLabel.setText((int) monsterLife + " " + "Health");

			if (clickDamage > monsterLife) { // if the object dies respawn new enemy with more life and add gold to
												// counter
				startingMonsterLife = startingMonsterLife * 1.15;
				monsterLife = startingMonsterLife;
				monsterHealthLabel.setText((int) monsterLife + " " + "Health");
				userGoldAmount++;
				userGoldAmount = (int) userGoldAmount * 1.2;
				userGoldLabel.setText((int) userGoldAmount + " " + "Gold");
			}
		}
	}

	public class ClickUpgradeOne implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (userGoldAmount >= costOfUpgradeOne) {
				amountOfUpgradedOne++;
				
				clickDamage = clickDamage + upgradedOne;
				clickDamageLabel.setText(clickDamage + " " + "Click Damage");
				userGoldAmount = userGoldAmount - costOfUpgradeOne;
				userGoldLabel.setText((int) userGoldAmount + " " + "Gold");
				
			} else {
				upgradeOne.setText("New button code");
		}
	}

	public class ClickUpgradeTwo implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			amountOfUpgradedTwo++;

			clickDamage = clickDamage + upgradedTwo;
			clickDamageLabel.setText(clickDamage + " " + "Click Damage");
		}
	}

	public class ClickUpgradeThree implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			amountOfUpgradedThree++;
			clickDamage = clickDamage + upgradedThree;
			clickDamageLabel.setText(clickDamage + " " + "Click Damage");
		}
	}

	public class ClickUpgradeFour implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			amountOfUpgradedFour++;
			clickDamage = clickDamage + upgradedFour;
			clickDamageLabel.setText(clickDamage + " " + "Click Damage");
		}
	}
}