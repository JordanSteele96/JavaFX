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
import javax.swing.*;
import javax.imageio.ImageIO;

public class Main {
	JLabel counterLabel, clickDamageLabel, monsterHealthLabel, userGoldLabel, upgradeOneText, upgradeTwoText,upgradeFourText,
			upgradeThreeText;
	JButton upgradeOne, upgradeTwo, upgradeThree, upgradeFour, clickButton;
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
	Font font3, font2, font1;

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
		font3 = new Font("Helvetica", Font.PLAIN, 16);

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
		upgradePanel.add(upgradeOne);

		upgradeOneText = new JLabel();
		upgradeOneText.setText("Increase click damage by:" + upgradedOne + "This costs:" + costOfUpgradeOne);
		upgradeOneText.setForeground(Color.white);
		upgradeOneText.setFont(font3);
		upgradeOne.add(upgradeOneText);

		JButton upgradeTwo = new JButton();
		upgradeTwo.setBackground(Color.cyan);
		upgradeTwo.addActionListener(theUpgradeTwo);
		upgradePanel.add(upgradeTwo);

		upgradeTwoText = new JLabel();
		upgradeTwoText.setText("Increase click damage by:" + upgradedTwo + "This costs:" + costOfUpgradeTwo);
		upgradeTwoText.setForeground(Color.white);
		upgradeTwoText.setFont(font3);
		upgradeTwo.add(upgradeTwoText);

		JButton upgradeThree = new JButton();
		upgradeThree.setBackground(Color.red);
		upgradeThree.addActionListener(theUpgradeThree);

		upgradePanel.add(upgradeThree);

		upgradeThreeText = new JLabel();
		upgradeThreeText.setText("Increase click damage by:" + upgradedThree + "This costs:" + costOfUpgradeThree);
		upgradeThreeText.setForeground(Color.white);
		upgradeThreeText.setFont(font3);
		upgradeThree.add(upgradeThreeText);

		JButton upgradeFour = new JButton();
		upgradeFour.setBackground(Color.black);
		upgradeFour.addActionListener(theUpgradeFour);
	
		upgradePanel.add(upgradeFour);
		
		upgradeFourText = new JLabel();
		upgradeFourText.setText("Increase click damage by:" + upgradedFour + "This costs:" + costOfUpgradeFour);
		upgradeFourText.setForeground(Color.white);
		upgradeFourText.setFont(font3);
		upgradeFour.add(upgradeFourText);
		

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
				userGoldAmount = (int) userGoldAmount * 1.25;
				userGoldLabel.setText((int) userGoldAmount + " " + "Gold");
			}
		}
	}

	public class ClickUpgradeOne implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (userGoldAmount >= costOfUpgradeOne) {
				amountOfUpgradedOne++;
				upgradedOne = (int) (upgradedOne * 1.5);
				clickDamage = clickDamage + upgradedOne;
				clickDamageLabel.setText(clickDamage + " " + "Click Damage");
				userGoldAmount = userGoldAmount - costOfUpgradeOne;
				userGoldLabel.setText((int) userGoldAmount + " " + "Gold");
				costOfUpgradeOne = (int) (costOfUpgradeOne * 1.5);
				upgradeOneText.setText("Increase click damage by:" + upgradedOne + "This costs:" + costOfUpgradeOne);

			}
		}
	}

	public class ClickUpgradeTwo implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (userGoldAmount >= costOfUpgradeTwo) {
				amountOfUpgradedTwo++;
				upgradedTwo = (int) (upgradedTwo * 1.5);
				clickDamage = clickDamage + upgradedTwo;
				clickDamageLabel.setText(clickDamage + " " + "Click Damage");
				userGoldAmount = userGoldAmount - costOfUpgradeTwo;
				userGoldLabel.setText((int) userGoldAmount + " " + "Gold");
				costOfUpgradeTwo = (int) (costOfUpgradeTwo * 1.5);
				upgradeTwoText.setText("Increase click damage by:" + upgradedTwo + "This costs:" + costOfUpgradeTwo);

			}
		}
	}

	public class ClickUpgradeThree implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (userGoldAmount >= costOfUpgradeThree) {
				amountOfUpgradedThree++;
				upgradedThree = (int) (upgradedThree * 1.5);
				clickDamage = clickDamage + upgradedThree;
				clickDamageLabel.setText(clickDamage + " " + "Click Damage");
				userGoldAmount = userGoldAmount - costOfUpgradeThree;
				userGoldLabel.setText((int) userGoldAmount + " " + "Gold");
				costOfUpgradeThree = (int) (costOfUpgradeThree * 1.5);
				upgradeThreeText
						.setText("Increase click damage by:" + upgradedThree + "This costs:" + costOfUpgradeThree);

			}
		}
	}

	public class ClickUpgradeFour implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (userGoldAmount >= costOfUpgradeFour) {
				amountOfUpgradedFour++;
				upgradedFour = (int) (upgradedFour * 1.5);
				clickDamage = clickDamage + upgradedFour;
				clickDamageLabel.setText(clickDamage + " " + "Click Damage");
				userGoldAmount = userGoldAmount - costOfUpgradeFour;
				userGoldLabel.setText((int) userGoldAmount + " " + "Gold");
				costOfUpgradeFour = (int) (costOfUpgradeFour * 1.5);
				upgradeFourText.setText("Increase click damage by:" + upgradedFour + "This costs:" + costOfUpgradeFour);

			}
		}
	}
}