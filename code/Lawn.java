import java.io.*;
import java.awt.*;
import java.awt.event.*; // For the sake of action listeners
import java.awt.Color.*;
import java.awt.Window.*;
import javax.swing.*;
import java.util.Random;
import javax.sound.sampled.*;
import java.util.concurrent.TimeUnit;


class Lawn extends JFrame {
    private static int level = 0;
    private static  Integer red_score =0, blue_score =0;
    private static Clip clip1, clip2, clip3 ;
    public static JFrame winDow ;
    public static JFrame frmobj;
    public static JFrame title;
    public static Integer[] moves = {0, 1, 2, 3};
    public static Integer move=0;

    public static ImageIcon logo = new ImageIcon("Resources/BattleSnakesLogo.png");
    // Image logoTemp1 = logo.getImage();
    // Image logoTemp2 = logoTemp1.getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
    // logo = new ImageIcon(logoTemp2);
      
    public static void Music1() {
	try{
	    File soundFile1 = new File("Resources/DURDEN_-_Paper_Planes_-_Durden_ft._Airtone.au"); 
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile1);
	    clip1 = AudioSystem.getClip();
	    clip1.open(audioIn);
	    try{
		TimeUnit.MILLISECONDS.sleep(300);
	    } catch(Exception here) {
		new BattleSnakes(here, 02);
	    }
	    clip1.start();
	    //    if( level == 8)
	    //	clip1.close();
	} catch(UnsupportedAudioFileException e) {
	    // e.printStackTrace();
	    new BattleSnakes(e, 03);
	} catch(IOException e) {
	    //e.printStackTrace();
	    new BattleSnakes(e, 04);
	} catch(LineUnavailableException e) {
	    //e.printStackTrace();
	    new BattleSnakes(e, 05);
	}
    }

    public static void Music2() {
	try{
	    File soundFile2 = new File("Resources/JeffSpeed68_-_Guitalele_s_Happy_Place.au"); 
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile2);
	    clip2 = AudioSystem.getClip();
	    clip2.open(audioIn);
	    clip2.start();
	    //    if( level == 8)
	    //	clip1.close();
	} catch(UnsupportedAudioFileException e) {
	    //e.printStackTrace();
	    new BattleSnakes(e, 06);
	} catch(IOException e) {
	    //e.printStackTrace();
	    new BattleSnakes(e, 07);
	} catch(LineUnavailableException e) {
	    //e.printStackTrace();
	    new BattleSnakes(e, 016);
	}
    }

    public static void Music3() {
	try{
	    File soundFile2 = new File("Resources/cdk_-_Like_Music_(cdk_Mix)_1.au"); 
	    AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile2);
	    clip3 = AudioSystem.getClip();
	    clip3.open(audioIn);
	    clip3.start();
	    //    if( level == 8)
	    //	clip1.close();
	} catch(UnsupportedAudioFileException e) {
	    // e.printStackTrace();
	    new BattleSnakes(e, 017);
	} catch(IOException e) {
	    //e.printStackTrace();
	    new BattleSnakes(e, 010);
	} catch(LineUnavailableException e) {
	    //e.printStackTrace();
	    new BattleSnakes(e, 011);
	}
    }

    public static void getTitled() {
	Music3();
	// Dealing with the image
	try{
	    ImageIcon img2 = new ImageIcon("Resources/playerImage.png");
	
	    Image image = img2.getImage();
	    Image img1 = image.getScaledInstance(600, 800, java.awt.Image.SCALE_SMOOTH);
	    img2 = new ImageIcon(img1);
	
	    title = new JFrame(" Battle Snakes ");
	    title.setResizable(false);
	    title.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    title.setLayout( new FlowLayout());
	    JLabel pnltitle = new JLabel();
	    JPanel holder = new JPanel();
	    pnltitle.setLayout( new BorderLayout());
	    holder.setLayout( new BoxLayout( holder , BoxLayout.Y_AXIS));

	    JButton starter = new JButton();
	    starter.setBackground(Color.BLACK);
	    starter.setForeground(Color.WHITE);
	    starter.setBorder( BorderFactory.createLineBorder(Color.YELLOW, 1) );
	    // JButton options = new JButton();
	    // options.setBackground(Color.BLACK);
	    // options.setForeground(Color.WHITE);
	    // options.setBorder( BorderFactory.createLineBorder(Color.YELLOW, 1) );
	    JButton creditor = new JButton();
	    creditor.setBackground(Color.BLACK);
	    creditor.setForeground(Color.WHITE);
	    creditor.setBorder( BorderFactory.createLineBorder(Color.YELLOW, 1) );
	    JButton helper = new JButton();
	    helper.setBackground(Color.BLACK);
	    helper.setForeground(Color.WHITE);
	    helper.setBorder( BorderFactory.createLineBorder(Color.YELLOW, 1) );


	    // Instantiate buttons
	    starter.setFont(new Font("Serif", Font.BOLD, 22));
	    // options.setFont(new Font("Serif", Font.BOLD, 22));
	    creditor.setFont(new Font("Serif", Font.BOLD, 22));
	    helper.setFont(new Font("Serif", Font.BOLD, 22));
	    
	    starter.setHorizontalAlignment( SwingConstants.CENTER);
	    // options.setHorizontalAlignment( SwingConstants.CENTER);
	    creditor.setHorizontalAlignment( SwingConstants.CENTER);
	    helper.setHorizontalAlignment( SwingConstants.CENTER);
	    
	    starter.setText(" Start ");
	    // options.setText(" Options ");
	    creditor.setText(" Credits ");
	    helper.setText(" Help ");


	    // Listen to me
	    starter.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent sta){
			clip3.close(); 
			title.dispose();
			if (!(title.isShowing())) {
			    gameStarts();
			    frmobj.setVisible(true);
			    
			}
		    }
		});

	    // options.addActionListener(new ActionListener(){
	    // 	    public void actionPerformed(ActionEvent opt){
	    // 		try {
	    // 		    ImageIcon img15 = new ImageIcon("Resources/Help.png");
	    // 		    Image imageOptions = img15.getImage();
	    // 		    Image img16 = imageOptions.getScaledInstance(600, 800, java.awt.Image.SCALE_SMOOTH);
	    // 		    img15 = new ImageIcon(img16);
			    
	    // 		    //System.out.println(" are we in");
	    // 		    JFrame options = new JFrame(" Options & Settings ");
	    // 		    options.setLayout( new FlowLayout());
	    // 		    options.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    // 		    options.setResizable(false);
	    // 		    // JLabel pico = new JLabel();
	    // 		    // pico.setIcon(img15);
	    // 		    // pico.setVisible(true);

	    // 		    JToggleButton soundSwitch = new JToggleButton(" ON ");
	    // 		    soundSwitch.addActionListener(new ActionListener( ) {
	    // 			    public void actionPerformed(ActionEvent sou) {
	    // 				AbstractButton abstractButton = (AbstractButton) sou.getSource();
	    // 				boolean isPlayingMusic = abstractButton.getModel().isSelected();
	    // 				if(isPlayingMusic) {
	    // 				    // sound musicians = new sound();
	    // 				    // musicians.setVolume(0);
					    
	    // 				    Mixer.Info[] infos = AudioSystem.getMixerInfo();
	    // 				    for (Mixer.Info info: infos) {
	    // 					Mixer mixer = AudioSystem.getMixer(info);
	    // 					Line[] lineArray = mixer.getSourceLines();
	    // 					for(Line line: lineArray) {
	    // 					BooleanControl bc = (BooleanControl) line.getControl(BooleanControl.Type.MUTE);
	    // 					if (bc != null) {
	    // 					    bc.setValue(true); // true to mute the line, false to unmute
	    // 					}
	    // 					}
						
	    // 				    }
	    // 				}
				    
	    // 			    }
	    // 			});
			
	    // 		soundSwitch.setVisible(true);
			
	    // 		options.add(soundSwitch);
	    // 		// options.add(pico);
	    // 		options.pack();
	    // 		options.setIconImage(logo.getImage());
	    // 		options.setLocationRelativeTo(null);
	    // 		options.setVisible(true);
	    // 		}
	    // 		catch(Exception erh) {
	    // 		    //System.out.println(erh);
	    // 		    new BattleSnakes(erh, 013);
	    // 		}
	    // 	    }
	    // 	});
	
	
	creditor.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent cre){
		    try {
			ImageIcon img3 = new ImageIcon("Resources/Credits1.png");
			Image imag3 = img3.getImage();
			Image img4 = imag3.getScaledInstance(600, 800, java.awt.Image.SCALE_SMOOTH);
			img3 = new ImageIcon(img4);
			
			    ImageIcon img7 = new ImageIcon("Resources/Credits2.png");
			    Image imag7 = img7.getImage();
			    Image img8 = imag7.getScaledInstance(600, 800, java.awt.Image.SCALE_SMOOTH);
			    img7 = new ImageIcon(img8);
			    
			    //System.out.println(" are we in");
			    JFrame credit = new JFrame(" Credits ");
			    credit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    credit.setResizable(false);
			    credit.setLayout( new FlowLayout());
			    JLabel pic = new JLabel();
			    JLabel pic2 = new JLabel();
			    pic.setIcon(img3);
			    pic2.setIcon(img7);
			    pic.setVisible(true);
			    pic2.setVisible(true);
			    credit.add(pic);
			    credit.add(pic2);
			    credit.pack();
			    credit.setIconImage(logo.getImage());
			    credit.setLocationRelativeTo(null);
			    credit.setVisible(true);
			} catch(Exception ery) {
			    //System.out.println(ery);
			    new BattleSnakes(ery, 012 );
			}
		    }
		});
	    
	    helper.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent hel){
			try {
			    ImageIcon img5 = new ImageIcon("Resources/Help.png");
			    Image imag = img5.getImage();
			    Image img6 = imag.getScaledInstance(600, 800, java.awt.Image.SCALE_SMOOTH);
			    img5 = new ImageIcon(img6);
			    
			    //System.out.println(" are we in");
			    JFrame help = new JFrame(" Help ");
			    help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    help.setResizable(false);
			    JLabel pich = new JLabel();
			    pich.setIcon(img5);
			    pich.setVisible(true);
			    help.add(pich);
			    help.pack();
			    help.setIconImage(logo.getImage());
			    help.setLocationRelativeTo(null);
			    help.setVisible(true);
			} catch(Exception erh) {
			    //System.out.println(erh);
			    new BattleSnakes(erh, 013);
			}
		    }
		});

	pnltitle.setIcon(img2);
	holder.add(starter);
	// holder.add(options);
	holder.add(creditor);
	holder.add(helper);
	holder.setOpaque(false);
	pnltitle.add(holder, BorderLayout.SOUTH );
	pnltitle.setOpaque(false);
	starter.setOpaque(true);
	creditor.setOpaque(true);
	helper.setOpaque(true);


	title.add(pnltitle, BorderLayout.CENTER);
	title.pack();
	title.setIconImage(logo.getImage());
	title.setLocationRelativeTo(null);
	title.setVisible(true);
	} catch(Exception eror) {
	    new BattleSnakes(eror, 021);
	}
    }
	
    
    protected static void gameStarts() {
	try {
	    Music1();
	    frmobj = new JFrame(" Battle Snakes ");
	    frmobj.setLayout( new BorderLayout());
	    frmobj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	    // Initializing the possible requirement of variables
	    String s=" Game starts, a sweet breeze blows ...  ", s1=" ", s2=" ";
	    Color darkBlue = new Color(0, 0, 245);
	    Color lightBlue = new Color(76, 222, 245);
	    Color darkRed = new Color(245, 0, 0);
	    Color lightRed = new Color(250, 124, 146);
	    Color asYellow = new Color(247, 206, 62);
	    Color asGreen = new Color(136, 211, 23);
	    Color asBlack = new Color(238, 238, 238);
	    Color wood = new Color(102, 51, 0);
	    Random r1 = new Random();
	    int[][] f = new int[11][2];
	    for(int i=0; i<11; i++) {
		for(int k=0; k<2; k++) {
		    f[i][k] = r1.nextInt(54) + 1;
		}
	    }
	    
	    // Introducing Panel 1
	    JPanel pnlobj1 = new Panel1();
	    JLabel txtobj = new JLabel();
	    txtobj.setText(s);
	    txtobj.setFont(new Font("Monospaced", Font.BOLD, 22));
	    txtobj.setForeground(Color.BLACK);
	    txtobj.setOpaque(false);
	    txtobj.setFocusable(false);
	    // txtobj.setBackground(wood);
	    // txtobj.setOpaque(true);
	    // pnlobj1.setBorder(BorderFactory.createTitledBorder(  BorderFactory.createLineBorder(asGreen, 5) , " Commentatory "));
	    
	    //Introducing Panel 2
	    JPanel pnlobj2 = new JPanel(new GridLayout(11,1));
	    JLabel[][] lbl = new JLabel[11][2];
	    for ( int i=0; i<11; i++) {
		    lbl[i][0] = new JLabel();
		    lbl[i][0].setVisible(true);
		    lbl[i][0].setForeground(darkRed);
	    }
	    lbl[9][0].setText("    ");
	    pnlobj2.setBorder( BorderFactory.createLineBorder(darkRed, 5) );
	    
	    //Introducing Panel 4
	    JPanel pnlobj4 = new JPanel(new GridLayout(11,1));
	    for ( int i=0; i<11; i++) {
		    lbl[i][1] = new JLabel();
		    lbl[i][1].setVisible(true);
		    lbl[i][1].setForeground(darkBlue);
	    }
	    lbl[9][1].setText("    ");
	    pnlobj4.setBorder(BorderFactory.createLineBorder(darkBlue, 5));
	    
	    // Introucing Panel 5
	    JPanel pnlobj5 = new Panel5();

	    JLabel lblobjr = new JLabel();
	    lblobjr.setFont(new Font("Monospaced", Font.BOLD, 20));
	    lblobjr.setForeground(asYellow);
	    lblobjr.setText( Integer.toString(red_score));
	    
	    JLabel lblobj = new JLabel("-");
	    lblobj.setFont(new Font("Monospaced", Font.BOLD, 20));
	    lblobj.setForeground(asYellow);
	    
	    JLabel lblobjb = new JLabel();
	    lblobjb.setFont(new Font("Monospaced", Font.BOLD, 20));
	    lblobjb.setForeground(asYellow);
	    lblobjb.setText( Integer.toString(blue_score));

	    // pnlobj5.setBorder(BorderFactory.createTitledBorder(  BorderFactory.createLineBorder(asGreen, 5) ," Results "));
	    
	    // Introducing our workers i.e. panel 3
	    JPanel pnlobj3 = new Panel3();
	    Snake redSnake = new Snake();
	    Snake blueSnake = new Snake();
	    JButton[][] btn = new JButton[55][55];
	    for ( int i=0; i<55; i++) {
		for ( int j=0; j<55; j++) {
		    btn[i][j] = new JButton();
		    btn[i][j].setVisible(false);
		}
	    }

	    // Initialize Snakes
	    btn[redSnake.initHeady(1)][redSnake.initHeadx(1)].setVisible(true);
	    btn[redSnake.initHeady(1)][redSnake.initHeadx(1)].setBackground(darkRed);
	    btn[blueSnake.initHeady(2)][blueSnake.initHeadx(2)].setVisible(true);
	    btn[blueSnake.initHeady(2)][blueSnake.initHeadx(2)].setBackground(darkBlue);
	    btn[redSnake.initTaily(1)][redSnake.initTailx(1)].setVisible(true);
	    btn[redSnake.initTaily(1)][redSnake.initTailx(1)].setBackground(lightRed);
	    btn[blueSnake.initTaily(2)][blueSnake.initTailx(2)].setVisible(true);
	    btn[blueSnake.initTaily(2)][blueSnake.initTailx(2)].setBackground(lightBlue);

	    // Keeping a food
	    btn[f[0][1]][f[0][0]].setVisible(true);
	    btn[f[0][1]][f[0][0]].setBackground(Color.GREEN);
	    btn[f[0][1]][f[0][0]].setOpaque(true);
	    Timer blinkTimer = new Timer(500, new ActionListener() {
		    boolean on=false;
		    public void actionPerformed(ActionEvent blink) {
			// blink the button background on and off
			btn[f[0][1]][f[0][0]].setBackground( on ? Color.GREEN : asYellow);
			on = !on;
		    }
		});
	    blinkTimer.start();
	    
	    // Use action Listeners
	    pnlobj3.setFocusable(true);
	    pnlobj3.addKeyListener( new KeyListener(){
		    public void keyPressed(KeyEvent e) {

			if(level == 10 ) {
			    try {
				
				TimeUnit.SECONDS.sleep(3);
				clip1.close(); 
				frmobj.dispose();
				if (!(frmobj.isShowing())) {
				    gameEnds(red_score,blue_score);
				    winDow.setVisible(true);
				}
			    } catch (Exception ed) {
				//System.out.println(ed);
				new BattleSnakes(ed, 02);
			    }
			  
			}
			

			Okay : {
			      // Winner checks
			      if(winCheck(redSnake.getHeadx(), redSnake.getHeady(),f[level][0], f[level][1]) ) {
				  txtobj.setText("Red gets to eat this piece ");
				  lbl[level][1].setForeground(darkRed);
				  lbl[level][0].setForeground(asGreen);
				  lbl[level][0].setText("X");
				  lbl[level][1].setText("O");
				  level++;
				  btn[f[level][1]][f[level][0]].setOpaque(true);
				  btn[f[level][1]][f[level][0]].setVisible(true);
				  Timer blinkTimerRunning = new Timer(500, new ActionListener() {
					  boolean on=false;
					  public void actionPerformed(ActionEvent e) {
					      // blink the button background on and off
					      btn[f[level][1]][f[level][0]].setBackground( on ? Color.GREEN : asYellow);
					      on = !on;
					  }
				      });
				  blinkTimerRunning.start();
				  red_score++;
				  
				  if(level==10) {
				      txtobj.setText(" This is where it all ends ... ");
				      lblobjr.setText(Integer.toString(red_score));
				      lblobjb.setText(Integer.toString(blue_score));
				  }
				  
				  break Okay;
			       }
			      
			       else if(winCheck(blueSnake.getHeadx(), blueSnake.getHeady(),f[level][0], f[level][1])) {
			       	  txtobj.setText("Blue gets to eat this piece ");
			       	  lbl[level][1].setForeground(asGreen);
			       	  lbl[level][0].setForeground(darkBlue);
			       	  lbl[level][0].setText("O");
			       	  lbl[level][1].setText("X");
			       	  level++;
				  btn[f[level][1]][f[level][0]].setOpaque(true);
				  btn[f[level][1]][f[level][0]].setVisible(true);
				  Timer blinkTimerRunning = new Timer(500, new ActionListener() {
					  boolean on=false;
					  public void actionPerformed(ActionEvent e) {
					      // blink the button background on and off
					      btn[f[level][1]][f[level][0]].setBackground( on ? Color.GREEN : asYellow);
					      on = !on;
					  }
				      });
				  blinkTimerRunning.start();
			       	  blue_score++;
				  
				  if(level==10) {
				      txtobj.setText(" This is where it all ends ... ");
				      lblobjr.setText(Integer.toString(red_score));
				      lblobjb.setText(Integer.toString(blue_score));
				  }
				  
				  break Okay;
			      }
			      else
				  txtobj.setText(" They are in for a haul ");

			      if( level == 5 && red_score > blue_score)
				  txtobj.setText(" Red seems to have the upper hand ");

			      else if( level == 5 && blue_score > red_score)
				  txtobj.setText(" Blue seems to have the upper hand ");
			      
			      if( level == 7)
				  txtobj.setText(" There is definite stiffness in the moment ");

			      // btn[f[level][1]][f[level][0]].setVisible(true);
			      // btn[f[level][1]][f[level][0]].setBackground(Color.GREEN);
			      
			      btn[redSnake.getHeady()][redSnake.getHeadx()].setVisible(true);
			      btn[redSnake.getTaily()][redSnake.getTailx()].setVisible(true);
			      btn[blueSnake.getHeady()][blueSnake.getHeadx()].setVisible(true);
			      btn[blueSnake.getTaily()][blueSnake.getTailx()].setVisible(true);
			      
			      btn[redSnake.getHeady()][redSnake.getHeadx()].setBackground(darkRed);
			      btn[redSnake.getTaily()][redSnake.getTailx()].setBackground(lightRed);
			      btn[blueSnake.getHeady()][blueSnake.getHeadx()].setBackground(darkBlue);
			      btn[blueSnake.getTaily()][blueSnake.getTailx()].setBackground(lightBlue);
			      
			      // irrespective of key press
			      lblobjr.setText(Integer.toString(red_score));
			      lblobjb.setText(Integer.toString(blue_score));

			}
			
		    }
		    public void keyTyped(KeyEvent e) {
		    }
		    public void keyReleased(KeyEvent e) {

			//keys
			int id = e.getKeyCode();
			btn[redSnake.getHeady()][redSnake.getHeadx()].setVisible(false);
			btn[redSnake.getTaily()][redSnake.getTailx()].setVisible(false);
			btn[blueSnake.getHeady()][blueSnake.getHeadx()].setVisible(false);
			btn[blueSnake.getTaily()][blueSnake.getTailx()].setVisible(false);
			
			switch(id) {
			    // A is pressed
			case KeyEvent.VK_A :
			    if(isPossible('A', redSnake, blueSnake)) {
				redSnake.goLeft();
				break;
			    }
			    else {
				break;
			    }
			    
			    //D is pressed 
			case KeyEvent.VK_D :
			    if(isPossible('D', redSnake, blueSnake)) {
				redSnake.goRight();
				break;
			    }
			    else {
				break;
			    }
			    
			    // W is pressed
			case KeyEvent.VK_W :
			    if(isPossible('W', redSnake, blueSnake)) {	
				redSnake.goUp();
				break;
			    }
			    else {
				break;
			    }
			    
			    // S is pressed
			case KeyEvent.VK_S :
			    if(isPossible('S', redSnake, blueSnake)) {
				redSnake.goDown();
				break;
			    }
			    else {
				break;
			    }
			    
			    // Left is pressed 
			case KeyEvent.VK_LEFT :
			    if(isPossible('a', redSnake, blueSnake)) {
				blueSnake.goLeft();
				break;
			    }
			    else {
				break;
			    }
			    
			    // Right is pressed 
			case KeyEvent.VK_RIGHT :
			    if(isPossible('d', redSnake, blueSnake)) {
				blueSnake.goRight();
				break;
			    }
			    else {
				break;
			    }
			    
			    //  Up is pressed
			case KeyEvent.VK_UP :
			    if(isPossible('w', redSnake, blueSnake)) {
				blueSnake.goUp();
				break;
			    }
			    else {
				break;
			    }
			    
			    // Down is pressed
			case KeyEvent.VK_DOWN :
			    if(isPossible('s', redSnake, blueSnake)) {
				blueSnake.goDown();
				break;
			    }
			    else {
				break;
			    }
			    
			default :
			    if(isPossible('e', redSnake, blueSnake)) {
				txtobj.setText("You said something, or did you just fart !!");
			    }
			    else {
				break;
			    }
			}
			
			
			btn[redSnake.getHeady()][redSnake.getHeadx()].setVisible(true);
			btn[redSnake.getTaily()][redSnake.getTailx()].setVisible(true);
			btn[blueSnake.getHeady()][blueSnake.getHeadx()].setVisible(true);
			btn[blueSnake.getTaily()][blueSnake.getTailx()].setVisible(true);
			
			btn[redSnake.getHeady()][redSnake.getHeadx()].setBackground(darkRed);
			btn[redSnake.getTaily()][redSnake.getTailx()].setBackground(lightRed);
			btn[blueSnake.getHeady()][blueSnake.getHeadx()].setBackground(darkBlue);
			btn[blueSnake.getTaily()][blueSnake.getTailx()].setBackground(lightBlue);
			
			
		    }
		});

	    // Add array Buttons n labels back in panel
	    for ( int i=0; i<55; i++) {
		for ( int j=0; j<55; j++) {
		    pnlobj3.add(btn[i][j]);
		}
	    }
	    for ( int i=0; i<11; i++) {
		    pnlobj2.add(lbl[i][0]);
	    }
	    for ( int i=0; i<11; i++) {
		    pnlobj4.add(lbl[i][1]);
	    }
	    txtobj.setOpaque(false);
	    
	    // Packing panels
	    pnlobj1.add(txtobj);
	    pnlobj5.add(lblobjr);
	    pnlobj5.add(lblobj);
	    pnlobj5.add(lblobjb);
	    pnlobj3.requestFocusInWindow();
	    pnlobj2.setVisible(true);
	    pnlobj4.setVisible(true);
	    pnlobj5.setVisible(true);
	    pnlobj1.setVisible(true);
	    pnlobj1.setFocusable(false);
	    
	    // Packing up the frame
	    frmobj.add(pnlobj1, BorderLayout.NORTH);
	    frmobj.add(pnlobj2,BorderLayout.WEST);
	    frmobj.add(pnlobj3,BorderLayout.CENTER);
	    frmobj.add(pnlobj4,BorderLayout.EAST);
	    frmobj.add(pnlobj5, BorderLayout.SOUTH);

	    frmobj.pack();
	    frmobj.setIconImage(logo.getImage());
	    frmobj.setExtendedState( JFrame.MAXIMIZED_BOTH);
	    pnlobj3.requestFocusInWindow();    
	    frmobj.setVisible(true);
	    
	}  catch(Exception err) {
	    // // Creating exception class
	    // System.out.println(" This exception : " + err);
	    new BattleSnakes(err, 014);
	    
	}
    }



    private static boolean winCheck(int Hx, int Hy, int Fx, int Fy) {
	if(Hx == Fx && Hy == Fy) {
	    return true;
	}
	else
	    return false;
    }

    private static boolean isPossible(char code, Snake redDevil, Snake blueDevil) {

	// if level is not present
	if(level==11)
	    return false;
	
	// if they reach boundaries 
	switch(code) {
	    // Red's
	case 'A' :
	    if(redDevil.getHeadx() == 0) 
			return false;
	    break;
	    
	case 'W' :
	     if(redDevil.getHeady() == 0) 
			return false;
	    break;

	case 'D' :
	    if(redDevil.getHeadx() == 54) 
		return false;
	    break; 

	case 'S' :
	    if(redDevil.getHeady() == 54) 
		return false;
	    break;

	    // Blue's
	case 'a' :
	    if(blueDevil.getHeadx() == 0) 
		return false;
	    break;

	case 'w' :
	     if(blueDevil.getHeady() == 0) 
		 return false;
	     break;
	     
	case 'd' :
	    if(blueDevil.getHeadx() == 54) 
		return false;
	    break; 

	case 's' :
	    if(blueDevil.getHeady() == 54) 
		return false;
	    break;
	    
	case 'e' :
	default :
	    return false;
	}

	return true;
	    
    }

    // Trophy Distribution
    public static void gameEnds(int reds, int blues) {
    
	try {
	    Music2();
	    // Get Trophy image
	    // ImageIcon img = new ImageIcon( "Resources/Trophy.png");

	    ImageIcon img10 = new ImageIcon("Resources/Trophy.png");
	
	    Image imageEndGame = img10.getImage();
	    Image img9 = imageEndGame.getScaledInstance(600, 800, java.awt.Image.SCALE_SMOOTH);
	    img10 = new ImageIcon(img9);


	    Color bluec = new Color(89, 171, 227);
	    Color redc = new Color(210, 77, 87);
	    
	    winDow = new JFrame(" Congrats");
	    winDow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    winDow.setResizable(false);
	    winDow.requestFocusInWindow();
	    winDow.setFocusable(true);

	    // JLabel auxLbl = new JLabel();
	    // auxLbl.setLayout(new BorderLayout());
	    JPanel panel = new JPanel();
	    panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS));
	    
	    JLabel label = new JLabel();
	    JLabel scrboard = new JLabel();
	    JLabel txtbox = new JLabel();
	    
	    txtbox.setIcon(img10);
	    scrboard.setFont(new Font("Serif", Font.BOLD, 22));
	    label.setHorizontalAlignment( SwingConstants.CENTER);
	    scrboard.setHorizontalAlignment( SwingConstants.CENTER);
	    
	    if(reds > blues) { 
		label.setFont(new Font("Serif", Font.BOLD, 22));
		label.setForeground(redc);
		label.setText("\t \t Congrats Red, You Won \t \t");
		scrboard.setText( " \t \t " +Integer.toString(reds) + "\t   -   \t " + Integer.toString(blues) + " \t \t ");
		scrboard.setForeground(redc);
		
	    }
	    
	    else if( blues > reds) {
		label.setFont(new Font("Serif", Font.BOLD, 22));
		label.setForeground(bluec);
		label.setText("\t \t Congrats Blue, You Won \t \t ");
		scrboard.setText( "\t \t" + Integer.toString(reds) + "\t   -  \t " + Integer.toString(blues) + "\t  \t");
		scrboard.setForeground(bluec);
		
	    }
	    
	    else {
		label.setFont(new Font("Serif", Font.BOLD, 22));
		label.setForeground(Color.GREEN);
		scrboard.setForeground(Color.GREEN);
		label.setText("\t \t Well, that would be a tie \t \t ");
		scrboard.setText("\t \t  Care for a rematch \t \t " );
	    }
	    
	    panel.add(label);
	    panel.add(txtbox);
	    panel.add(scrboard);

	    // auxLbl.add(panel);
	    // auxLbl.setIcon(img10);
	    
	    winDow.add(panel);
	    winDow.pack();
	    winDow.setIconImage(logo.getImage());
	    winDow.setLocationRelativeTo(null);
	    winDow.setVisible(true);

	} catch (Exception e) {
	    // System.out.println(e);
	    new BattleSnakes(e, 015);
	}
    }

     // End of Lawn class
}    
