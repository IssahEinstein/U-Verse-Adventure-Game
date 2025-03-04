

import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Visuals extends JFrame {
	

	// Initiation of visual pieces
//		 private static final long serialVersionUID = 1L;
		private CardLayout Cards = new CardLayout();
		private JPanel CardHolder;
		private JTextField Characters, Majors, Settings, VSets;
		private JLabel CharSelect;
		private JTextField CharInput;
		private JLabel Uni;
		private JTextField UniInput;
		public String selectedMajor = "";
		public Image backgroundImage;
		public Image tutorialImage;
		public Image universe;

		
		 // Creating the frame & setting constraints
		public Visuals() {
			backgroundImage = new ImageIcon("src/home page.png").getImage();

			FrameInit();
			MMCard();
			CharCard();
			OrientCard(); 
			MajorsCard();
			TutorialCard();
			SettingsCard(); }
			
			
		public void FrameInit() {
			
			// Size & exit on close
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(500,500);
			setVisible(true);
			
			
			// Panel for holding the cards for the screens
			CardHolder = new JPanel(Cards) {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	            }
	        };
	        setContentPane(CardHolder);
			
		}
		
		// back button
	    public void addBackButton(JPanel panel, String previousCard) {
	        JButton backButton = new JButton("Back");
	        backButton.addActionListener(e -> Cards.show(CardHolder, previousCard));
	        panel.add(backButton, BorderLayout.NORTH);
	    }
			
		// Method for Main Menu Card & Components
		public void MMCard() {
			
			// Main menu card setup
			JPanel MainMenuCard = new JPanel(new BorderLayout()) {
				@Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	            }
			};
			CardHolder.add(MainMenuCard, "Main Menu");
			
			GridBagLayout gbl_MainMenuCard = new GridBagLayout();
			gbl_MainMenuCard.columnWidths = new int[]{72, 282, 72, 0};
			gbl_MainMenuCard.rowHeights = new int[] {126, 0, 0, 0, 0};
			gbl_MainMenuCard.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_MainMenuCard.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			MainMenuCard.setLayout(gbl_MainMenuCard);
			

			JButton SetsB = new JButton();
			SetsB.setForeground(Color.BLACK);
			SetsB.setFont(new Font("Courier New", Font.PLAIN, 13));
			SetsB.setBackground(new Color(207, 217, 170));
			
			SetsB.setContentAreaFilled(false);
			
	// input tutorial button
			String MPath2 = "src/settings button.png";
			ImageIcon MPic2 = new ImageIcon(MPath2);
			Image MScaled2 = MPic2.getImage().getScaledInstance(170, 60,  Image.SCALE_SMOOTH);
			SetsB.setIcon(new ImageIcon(MScaled2));
			
			GridBagConstraints gbc_SetsB = new GridBagConstraints();
			gbc_SetsB.weighty = 2.0;
			gbc_SetsB.weightx = 2.0;
			gbc_SetsB.ipadx = 15;
			gbc_SetsB.ipady = 15;
			gbc_SetsB.insets = new Insets(30, 0, 30,220);
			gbc_SetsB.gridx = 1;
			gbc_SetsB.gridy = 1;
			
			MainMenuCard.add(SetsB, gbc_SetsB);
			SetsB.addActionListener(SetB -> Cards.show(CardHolder, "Settings"));
			
			universe = new ImageIcon("src/uni-verse.png").getImage();
			// Text Field for the game title (U-Verse) -> formatting & adding to the card holder
			JButton GameTitle = new JButton() {
				@Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(universe, 0, 0, getWidth(), getHeight(), this);
	            }
			};

			
			GridBagConstraints gbc_GameTitle = new GridBagConstraints();
			gbc_GameTitle.weightx = 1.0;
			gbc_GameTitle.weighty = 1.0;
			gbc_GameTitle.fill = GridBagConstraints.BOTH;
			gbc_GameTitle.insets = new Insets(50, 0, 50, 5);
			gbc_GameTitle.gridx = 1;
			gbc_GameTitle.gridy = 0;

			MainMenuCard.add(GameTitle, gbc_GameTitle);
			
			// Tutorial Button set up & action listeners
			JButton TutorialB = new JButton();
			TutorialB.setFont(new Font("Courier New", Font.PLAIN, 11));
			TutorialB.setBackground(new Color(0, 0, 0));
			TutorialB.setContentAreaFilled(false);
			
	// input tutorial button
			String MPath = "src/tutoriao button.png";
			ImageIcon MPic = new ImageIcon(MPath);
			Image MScaled = MPic.getImage().getScaledInstance(130, 60,  Image.SCALE_SMOOTH);
			TutorialB.setIcon(new ImageIcon(MScaled));

			GridBagConstraints gbc_TutorialB = new GridBagConstraints();
			gbc_TutorialB.weightx = 1.0;
			gbc_TutorialB.weighty = 1.0;
			gbc_TutorialB.ipady = 15;
			gbc_TutorialB.ipadx = 15;
			gbc_TutorialB.insets = new Insets(30,220,30,5);
			gbc_TutorialB.gridx = 1;
			gbc_TutorialB.gridy = 1;
			
			MainMenuCard.add(TutorialB, gbc_TutorialB);
			
			TutorialB.addActionListener(TB -> Cards.show(CardHolder, "Tutorial"));
			
			// Start Button set up & action listeners
			JButton StartB = new JButton();
			StartB.setFont(new Font("Courier New", Font.PLAIN, 13));
			StartB.setBackground(new Color(205, 148, 169));
			StartB.setContentAreaFilled(false);
			
	// input Start button
			String MPath1 = "src/start button.png";
			ImageIcon MPic1 = new ImageIcon(MPath1);
			Image MScaled1 = MPic1.getImage().getScaledInstance(170, 60,  Image.SCALE_SMOOTH);
			StartB.setIcon(new ImageIcon(MScaled1));
			
			GridBagConstraints gbc_StartB = new GridBagConstraints();
			gbc_StartB.weightx = 2.0;
			gbc_StartB.weighty = 2.0;
			gbc_StartB.ipadx = 25;
			gbc_StartB.ipady = 25;
			gbc_StartB.anchor = GridBagConstraints.NORTH;
			gbc_StartB.insets = new Insets(30, 30, 30, 30);
			gbc_StartB.gridx = 1;
			gbc_StartB.gridy = 2;
			
			MainMenuCard.add(StartB, gbc_StartB);
			
			StartB.addActionListener(SB -> Cards.show(CardHolder, "Characters")); 
			
		}
			
		public void SettingsCard() {
			
			JPanel SetsCard = new JPanel(new BorderLayout()) {
				@Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	            }
			};
			CardHolder.add(SetsCard, "Settings");
			SetsCard.setLayout(null);
			
			JCheckBox MToggle = new JCheckBox("Music ( On / Off )");
			MToggle.setSelected(true);
			MToggle.setFont(new Font("Courier New", Font.PLAIN, 11));
			MToggle.setBounds(44, 211, 142, 23);
			SetsCard.add(MToggle);
			
			Settings = new JTextField();
			Settings.setEditable(false);
			Settings.setBounds(44, 71, 396, 51);
			Settings.setText("Settings");
			Settings.setHorizontalAlignment(SwingConstants.CENTER);
			Settings.setFont(new Font("Courier New", Font.BOLD, 37));
			Settings.setColumns(10);
			SetsCard.add(Settings);
			
			JSlider Volume = new JSlider();
			Volume.setFont(new Font("Courier New", Font.PLAIN, 11));
			Volume.setSnapToTicks(true);
			Volume.setPaintTicks(true);
			Volume.setBounds(44, 241, 142, 26);
			SetsCard.add(Volume);
			
			VSets = new JTextField();
			VSets.setHorizontalAlignment(SwingConstants.CENTER);
			VSets.setEditable(false);
			VSets.setText("Volume");
			VSets.setFont(new Font("Courier New", Font.BOLD, 14));
			VSets.setBounds(44, 171, 142, 33);
			SetsCard.add(VSets);
			VSets.setColumns(10); }
		
		
		public void CharCard() {
			
			// Character Card creation
			JPanel CharCard = new JPanel(new BorderLayout()) {
				@Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	            }
			};
			CardHolder.add(CharCard, "Characters");
			
			GridBagLayout gbl_CharCard = new GridBagLayout();
			gbl_CharCard.columnWidths = new int[]{72, 282, 72, 0};
			gbl_CharCard.rowHeights = new int[]{126, 0, 0, 0};
			gbl_CharCard.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_CharCard.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0};
			CharCard.setLayout(gbl_CharCard);
			
			
			
		
			// Text field for the screen heading -> Characters
			Characters = new JTextField();
			Characters.setEditable(false);
			Characters.setHorizontalAlignment(SwingConstants.CENTER);
			Characters.setFont(new Font("Courier New", Font.PLAIN, 37));
			Characters.setText("Characters");
			GridBagConstraints gbc_characters = new GridBagConstraints();
			gbc_characters.fill = GridBagConstraints.BOTH;
			gbc_characters.insets = new Insets(0, 0, 5, 5);
			gbc_characters.gridx = 1;
			gbc_characters.gridy = 0;
			CharCard.add(Characters, gbc_characters);
			Characters.setColumns(10);
			
			
			JButton Male = new JButton("Male");
			Male.setForeground(Color.BLACK);
			Male.setBackground(new Color(207, 217, 170));
			Male.setFont(new Font("Courier New", Font.PLAIN, 13));



			Male.addActionListener(M -> {
				Cards.show(CardHolder, "Majors");
				final String CC = "Male";});

			
			GridBagConstraints gbc_Male = new GridBagConstraints();
			gbc_Male.ipadx = 15;
			gbc_Male.ipady = 15;
			gbc_Male.insets = new Insets(30, 0, 30, 220);
			gbc_Male.weighty = 2.0;
			gbc_Male.weightx = 2.0;
			gbc_Male.gridx = 1;
			gbc_Male.gridy = 1;
			CharCard.add(Male, gbc_Male);
			
			
			String MPath = "src/male freshman and sophomore.png";
			ImageIcon MPic = new ImageIcon(MPath);
			Image MScaled = MPic.getImage().getScaledInstance(70, 70,  Image.SCALE_SMOOTH);
			Male.setIcon(new ImageIcon(MScaled));
			
			
			JButton Female = new JButton("Female");
			Female.setBackground(new Color(151, 198, 215));
			Female.setFont(new Font("Courier New", Font.PLAIN, 13));
			
			Female.addActionListener(F -> {
				Cards.show(CardHolder, "Majors");
				final String CC = "Female"; });
			


			
			GridBagConstraints gbc_Female = new GridBagConstraints();
			gbc_Female.ipadx = 15;
			gbc_Female.ipady = 15;
			gbc_Female.weightx = 1.0;
			gbc_Female.weighty = 1.0;
			gbc_Female.insets = new Insets(30, 220, 30, 5);
			gbc_Female.gridx = 1;
			gbc_Female.gridy = 1;
			CharCard.add(Female, gbc_Female);
			
			String FPath = "src/female freshman.png";
			ImageIcon FPic = new ImageIcon(FPath);
			Image FScaled = FPic.getImage().getScaledInstance(70, 70,  Image.SCALE_SMOOTH);
			Female.setIcon(new ImageIcon(FScaled));
			
			
			JButton Other = new JButton("Other");
			Other.setFont(new Font("Courier New", Font.PLAIN, 13));
			
			
			Other.addActionListener(O -> {
				Cards.show(CardHolder, "Majors");
				final String CC = "Other"; });

			
			GridBagConstraints gbc_Other = new GridBagConstraints();
			gbc_Other.anchor = GridBagConstraints.NORTH;
			gbc_Other.ipady = 25;
			gbc_Other.ipadx = 25;
			gbc_Other.insets = new Insets(30, 30, 30, 30);
			gbc_Other.weighty = 2.0;
			gbc_Other.weightx = 2.0;
			gbc_Other.gridx = 1;
			gbc_Other.gridy = 2;
			CharCard.add(Other, gbc_Other);
			
			
			String OPath = "src/third character.png";
			ImageIcon OPic = new ImageIcon(OPath);
			Image OScaled = OPic.getImage().getScaledInstance(70, 70,  Image.SCALE_SMOOTH);
			Other.setIcon(new ImageIcon(OScaled)); 
			
		}
			
		public void OrientCard() {
			
			
			JPanel Orientation = new JPanel(new BorderLayout()) {
				@Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	            }
			};
			CardHolder.add(Orientation, "Orientation");
			Orientation.setLayout(null);
			
			
			CharSelect = new JLabel("Enter Character Name: ");
			CharSelect.setFont(new Font("Courier New", Font.PLAIN, 13));
			CharSelect.setText("Enter Character Name: ");
			CharSelect.setBounds(28, 25, 196, 26);
			Orientation.add(CharSelect);
			
			CharInput = new JTextField();
			CharInput.setFont(new Font("Courier New", Font.PLAIN, 13));
			CharInput.setColumns(10);
			CharInput.setBounds(221, 25, 249, 26);
			Orientation.add(CharInput);
			
			Uni = new JLabel("Enter University Name: ");
			Uni.setFont(new Font("Courier New", Font.PLAIN, 13));
			Uni.setText("Enter University Name: ");
			Uni.setVisible(false);
			Uni.setBounds(26, 117, 198, 26);
			Orientation.add(Uni);
			
			UniInput = new JTextField();
			UniInput.setFont(new Font("Courier New", Font.PLAIN, 13));
			UniInput.setVisible(false);
			UniInput.setColumns(10);
			UniInput.setBounds(221, 116, 249, 26);
			Orientation.add(UniInput);
			
			
			JTextArea OBlurb = new JTextArea();
			OBlurb.setFont(new Font("Courier New", Font.PLAIN, 13));
			OBlurb.setVisible(false);
			OBlurb.setEditable(false);
			OBlurb.setLineWrap(true);
			OBlurb.setWrapStyleWord(true);
			OBlurb.setBounds(32, 221, 438, 165); 
			Orientation.add(OBlurb);
			
			JButton Submit2 = new JButton("Submit");
			Submit2.setFont(new Font("Courier New", Font.PLAIN, 13));
			Submit2.setVisible(false);
			Submit2.setBounds(162, 154, 117, 29);
			
			
			Submit2.addActionListener(S2 -> {

				String UniName = UniInput.getText().trim();

				if (UniName.isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Please enter a university name!", "Error", JOptionPane.ERROR_MESSAGE); 
					
				}
				
				else {
					
			OBlurb.setText("Hello, " + CharInput.getText().trim() + "! Welcome to " + UniName + "! "
					+ "We're so excited to watch you embark on an unforgettable journey filled with discovery,"
					+ " lifelong friendships, and memorable experiences! Over the next year, you'll meet incredible people, "
					+ "uncover hidden corners of campus, and learn all the tips and tricks to make your time here amazing. "
					+ "Whether you're here to explore new passions, chase big dreams, or invest in yourself and your future, "
					+ "we've got your back! So take a deep breath, soak it all in, and get ready for the journey of a lifetime."
					+ " Welcome to the family! <3");
			
			OBlurb.setVisible(true); } } );
			
	
			Orientation.add(Submit2);
			
			JButton Submit1 = new JButton("Submit");
			Submit1.setFont(new Font("Courier New", Font.PLAIN, 13));
			Submit1.setBounds(162, 63, 117, 29);
			
			Submit1.addActionListener(S1 -> {
				String CharName = CharInput.getText().trim();

				
				if (CharName.isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Please enter a character name!", "Error", JOptionPane.ERROR_MESSAGE); }
			
			else {
				Uni.setVisible(true);
				UniInput.setVisible(true);
				Submit2.setVisible(true);  } } );

			
			Orientation.add(Submit1);
			
			JButton Continue = new JButton("Continue");
			Continue.setFont(new Font("Courier New", Font.PLAIN, 13));
			Continue.setBounds(162, 412, 117, 29);
			Orientation.add(Continue);
//			JButton Continue = new JButton("Continue");
			Orientation.add(Continue, BorderLayout.SOUTH);
			
			
			
	        Continue.addActionListener(e -> {
//	        	String selectedMajor = MajorsCard();
	            switch (MajorsCard()) {
	                case "CS":
	                    new CSfreshman(); // Assuming CSfreshman is a JFrame
	                    break;
	                case "Business":
	                    new Busfreshman(); // Assuming Game3 is a JFrame
	                    break;
	                case "Biology":
	                    new Biofreshman(); // Assuming Game2 is a JFrame
	                    break;
	                default:
	                    JOptionPane.showMessageDialog(null, "No major selected!");
	            }
	        });

	        		
		}
		
	
			public String MajorsCard() {
			
			
			// Major options card
			JPanel MajorsCard = new JPanel(new BorderLayout()) {;
			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
			};
			GridBagLayout gbl_MajorsCard = new GridBagLayout();
			gbl_MajorsCard.columnWidths = new int[]{72, 282, 72, 0};
			gbl_MajorsCard.rowHeights = new int[]{126, 0, 0, 0, 0};
			gbl_MajorsCard.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_MajorsCard.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			MajorsCard.setLayout(gbl_MajorsCard);

			// Specs of the "Major" page title
			Majors = new JTextField();
			Majors.setText("Majors");
			Majors.setHorizontalAlignment(SwingConstants.CENTER);
			Majors.setFont(new Font("Courier New", Font.PLAIN, 37));
			Majors.setEditable(false);
			Majors.setColumns(10);
			Majors.setBackground(Color.LIGHT_GRAY);
			
			GridBagConstraints gbc_Majors = new GridBagConstraints();
			gbc_Majors.weighty = 1.0;
			gbc_Majors.weightx = 1.0;
			gbc_Majors.fill = GridBagConstraints.BOTH;
			gbc_Majors.insets = new Insets(50, 0, 50, 5);
			gbc_Majors.gridx = 1;
			gbc_Majors.gridy = 0;
			
			MajorsCard.add(Majors, gbc_Majors);
			
			CardHolder.add(MajorsCard, "Majors");
			
			

			// CS major button
			JButton CS = new JButton("Comp Sci");
			CS.setFont(new Font("Courier New", Font.PLAIN, 13));
			CS.setBackground(new Color(141, 198, 215));
			
			GridBagConstraints gbc_CS = new GridBagConstraints();
			gbc_CS.weighty = 1.0;
			gbc_CS.weightx = 1.0;
			gbc_CS.ipady = 15;
			gbc_CS.ipadx = 15;
			gbc_CS.insets = new Insets(30, 220, 30, 5);
			gbc_CS.gridx = 1;
			gbc_CS.gridy = 1;
			
			
			CS.setContentAreaFilled(false);
			String MPat7 = "src/cs button.png";
			ImageIcon MPi7 = new ImageIcon(MPat7);
			Image MScaled7 = MPi7.getImage().getScaledInstance(170, 60,  Image.SCALE_SMOOTH);
			CS.setIcon(new ImageIcon(MScaled7));

//			
			MajorsCard.add(CS, gbc_CS);

	        CS.addActionListener(e -> {
	            selectedMajor = "CS";
	            Cards.show(CardHolder, "Orientation");
	        });
						

			
			// Biology Major button
			JButton Biology = new JButton("Biology");
			Biology.setForeground(Color.BLACK);
			Biology.setFont(new Font("Courier New", Font.PLAIN, 13));
			Biology.setBackground(new Color(207, 217, 170));
			
			GridBagConstraints gbc_Biology = new GridBagConstraints();
			gbc_Biology.weighty = 2.0;
			gbc_Biology.weightx = 2.0;
			gbc_Biology.ipady = 15;
			gbc_Biology.ipadx = 15;
			gbc_Biology.insets = new Insets(30, 0, 30, 220);
			gbc_Biology.gridx = 1;
			gbc_Biology.gridy = 1;

			
			Biology.setContentAreaFilled(false);
			String MPath3 = "src/bio button.png";
			ImageIcon MPic3 = new ImageIcon(MPath3);
			Image MScaled3 = MPic3.getImage().getScaledInstance(170, 60,  Image.SCALE_SMOOTH);
			Biology.setIcon(new ImageIcon(MScaled3));
//			
			MajorsCard.add(Biology, gbc_Biology);
			Biology.addActionListener(e -> {
	            selectedMajor = "Biology";
	            Cards.show(CardHolder, "Orientation");
	        });
				
	
			// Business major button
			JButton Business = new JButton("Business");
			Business.setFont(new Font("Courier New", Font.PLAIN, 13));
			Business.setBackground(new Color(205, 148, 169));
			
			GridBagConstraints gbc_Business = new GridBagConstraints();
			gbc_Business.weighty = 2.0;
			gbc_Business.weightx = 2.0;
			gbc_Business.ipady = 25;
			gbc_Business.ipadx = 25;
			gbc_Business.anchor = GridBagConstraints.NORTH;
			gbc_Business.insets = new Insets(30, 30, 30, 30);
			gbc_Business.gridx = 1;
			gbc_Business.gridy = 2;
			
			Business.setContentAreaFilled(false);
			String MPath8 = "src/buss button.png";
			ImageIcon MPic8 = new ImageIcon(MPath8);
			Image MScaled8 = MPic8.getImage().getScaledInstance(170, 60,  Image.SCALE_SMOOTH);
			Business.setIcon(new ImageIcon(MScaled8));
			
			MajorsCard.add(Business, gbc_Business);
			Business.addActionListener(e -> {
	            selectedMajor = "Business";
	            Cards.show(CardHolder, "Orientation");
	        });
			// back button
//			addBackButton(MajorsCard, "Characters");
			
			return selectedMajor;
			
}
			
			
		public void TutorialCard() {

			
			
			tutorialImage = new ImageIcon("src/tutorial image.png").getImage();
			
			JPanel TutorialCard = new JPanel(new BorderLayout()) {
				@Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                g.drawImage(tutorialImage, 0, 0, getWidth(), getHeight(), this);
	            }
			};
			
			GridBagLayout gbl_TutorialCard = new GridBagLayout();
			gbl_TutorialCard.columnWidths = new int[]{0};
			gbl_TutorialCard.rowHeights = new int[]{0};
			gbl_TutorialCard.columnWeights = new double[]{Double.MIN_VALUE};
			gbl_TutorialCard.rowWeights = new double[]{Double.MIN_VALUE};
			TutorialCard.setLayout(gbl_TutorialCard);
			
			CardHolder.add(TutorialCard, "Tutorial");
//			addBackButton(TutorialCard, "MMCard");
			
		}
			
			

			
		
		public static void main(String[] args) {
		    SwingUtilities.invokeLater(() -> new Visuals());

		}
			
			
		}
		
	
