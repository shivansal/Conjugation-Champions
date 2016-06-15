//Shiv Ansal and Surya Konkimalla
//Conjugation Champions game

import java.awt.*; //import awt and swing libraries, Action and Adjustment listeners
import javax.swing.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

public class ConjugationChampions extends JFrame { //class header of frame
	public int x;
	public int indicatorY = 541;
	public HolderPanel hp;  //instantiate the holder panel
	private Image background = Toolkit.getDefaultToolkit().getImage("forest1.jpg"); //background image

	public static void main (String [] args){ //main method
		ConjugationChampions cc = new ConjugationChampions();//instantiate ConjugationChampions
	}

	public ConjugationChampions() { //constructor
		super("Conjugation Champions");	//set title ConjugationChampions
		setSize(1300,800); //set size to 1000 X 1000
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		hp = new HolderPanel();
		setContentPane(hp); //set content pane
		setVisible(true); //set visible
		setLocation(0,0); //set location to (0,0)
		setResizable(true); //set resizable to false
	}


	class HolderPanel extends JPanel{ //holder panel

		public CardLayout cards;
		private Font font3 = new Font("Corsiva", Font.BOLD, 20);	//make font

		public HolderPanel(){ //constructor
			setBackground(Color.GRAY); //set color
			cards = new CardLayout();//make an instance of CardLayout
			setLayout(cards);//set layout to CardLayout

			StartPanel stp = new StartPanel();//instantiate other game panels
			ExplanationPanel ep = new ExplanationPanel();
			SongPanel sop = new SongPanel();
			InstructionPanel ip = new InstructionPanel();
			GameplayPanel gp = new GameplayPanel();

			add(stp, "start panel");//add cards to card panel
			add(ep, "explanation panel");
			add(sop, "song panel");
			add(ip, "instruction panel");
			add(gp, "gameplay panel");
		}

		public void paintComponent(Graphics g) {//paint component
			super.paintComponent(g);
		}

		class StartPanel extends JPanel implements MouseListener{//start panel

				public StartPanel() {//constructor
					setBackground(Color.GRAY);//set background color
					addMouseListener(this);
				}

				public void paintComponent(Graphics g) { //paint component
					super.paintComponent(g);

					g.drawImage(background,0,-100,this);

					g.setColor(Color.WHITE);
					Font font1 = new Font("Corsiva", Font.BOLD, 75);	//make title font
					g.setFont(font1);	//set font
					g.drawString("Conjugation Champions", 150, 100);//draw game title
					Font font2 = new Font("Corsiva", Font.BOLD, 20); //make text font
					g.setFont(font2);	//set font
					g.drawString("FOR SPANISH VERBS",495, 150);
					g.drawString("Click on the screen to begin.", 460,200); //draw first command
				}
				public void mouseClicked(MouseEvent e){	//mouse handler events
					cards.next(hp); //display next panel
				}

				public void mouseExited(MouseEvent e){}
				public void mouseEntered(MouseEvent e){}
				public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e){}


		}

		 class ExplanationPanel extends JPanel implements MouseListener{ //explanation panel

			private boolean painter1 = true; //decides which text block to draw and only displays that one

				public ExplanationPanel() { //constructor
					setBackground(Color.GRAY);//set background color
					addMouseListener(this); //add mouse listener
				}

				public void paintComponent(Graphics g) {
					super.paintComponent(g);

					g.drawImage(background,0,-100,this); //draw background

					g.setColor(Color.WHITE);
					g.setFont(font3); //set font
					if(painter1=true){ //draw the explanation text
						g.drawString("Welcome! To become a conjugation champion, you must first find your way through the Maze of Conjugations.",0,250);
						g.drawString("At the end of the maze, you will find the crown that will make you a champion.",0, 275);
						g.drawString("Beware, you must choose the correct pathways to make it to the end successfully. To do so, you must know how to conjugate.",0,300);//display the explanations and introduction to game using drawString()
						g.drawString("Click on the screen to continue.", 0,325);
					}
				}

				public void mouseClicked(MouseEvent e){ //mouse handler events
					painter1 = false; //do not draw first text block when clicked on
					repaint();
					cards.next(hp); //display next panel
				}
				public void mouseExited(MouseEvent e){}
				public void mouseEntered(MouseEvent e){}
				public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e){}
		}

		 class SongPanel extends JPanel implements MouseListener{//song panel

				public SongPanel() {//constructor
					setBackground(Color.GRAY);//set background color
					addMouseListener(this); //add mouse listener
				}

				public void paintComponent(Graphics g) {//paint component
					super.paintComponent(g);

					g.drawImage(background,0,-100,this); //draw background

					g.setColor(Color.WHITE);
					g.setFont(font3); //set font
					g.drawString("Remember this song, which includes the conjugation endings:",0,200);//display the song lyrics using drawString()
					g.drawString("-o, -as, -a, -amos, -an",0,225);
					g.drawString("Let's go over an example:", 0,275);
					g.drawString("HABLAR", 0,300);
					g.drawString("hablo", 25,325);
					g.drawString("hablas", 25,350);
					g.drawString("habla", 25,375);
					g.drawString("hablamos", 25,400);
					g.drawString("hablan", 25,425);
					g.drawString("Click on the screen to continue.", 0,475);



				}

				public void mouseClicked(MouseEvent e){ //mouse handler events
					cards.next(hp); //display next panel
				}
				public void mouseExited(MouseEvent e){}
				public void mouseEntered(MouseEvent e){}
				public void mouseReleased(MouseEvent e){}
				public void mousePressed(MouseEvent e){}
		}

		 class InstructionPanel extends JPanel implements MouseListener{//instruction panel

			public InstructionPanel() {//constructor
				setBackground(Color.GRAY);//set background color
				addMouseListener(this); //add mouse listener

			}

			public void paintComponent(Graphics g) {//paint component
				super.paintComponent(g);

				g.drawImage(background,0,-100,this); //draw background

				g.setColor(Color.WHITE);
				g.setFont(font3); //set font
				g.drawString("Press the up and down arrow keys to move your character.",0,525);//display the instructions using drawString()
				g.drawString("Guide your character into the pathway containing the correct conjugation.", 0,550); 
				g.drawString("Make sure your character is between one set of yellow platforms.",0,575);
				g.drawString("If you chose the correct conjugation, the progress bar will change" + 
				" and tell you how close you are to being a conjugation champion.",0,600);
				g.drawString("Remember the conjugation song!",0,625);
				g.drawString("Click on the screen to continue.", 0,650);
			}

			public void mouseClicked(MouseEvent e){ //mouse handler events
					cards.next(hp); //display next panel
			}
			public void mouseExited(MouseEvent e){}
			public void mouseEntered(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			public void mousePressed(MouseEvent e){}

		}

		class GameplayPanel extends JPanel{//game play panel
			private String [] englishPhrases =  {"I talk", "you talk", "he talks", "we talk", "they talk", "I jump", "you jump", "he jumps", "we jump", "they jump", "I dance", "you dance", "he dances", "we dance", "they dance", "I wash", "you wash","he washes", "we wash", "they wash","I take","you take","he takes","we take","they take","I help","you help","he help","we help","they help"}; //create arrays for english phrases
			private String [] spanishPhrases = {"hablo", "hablas", "habla", "hablamos", "hablan", "salto", "saltas", "salta", "saltamos", "saltan", "bailo", "bailas", "baila", "bailamos", "bailan","lavo","lavas","lava","lavamos","lavan","saco","sacas","saca","sacan","ayudo","ayudas","ayuda","ayudamos","ayudan"};//create arrays for spanish conjugations
			private PlayPanel pp;
			public LevelIndicatorPanel lip = new LevelIndicatorPanel();
			private Image J;

			public GameplayPanel() {//constructor
				setBackground(Color.BLUE);
				setLayout(new BorderLayout());//set borderlayout
				pp = new PlayPanel();//instantiate play panel and level indicator panel

				add(pp, BorderLayout.CENTER);//add actual play panel center
				add(lip, BorderLayout.EAST);//add level indicator panel east

			}

			public void paintComponent(Graphics g) {//paint component
				super.paintComponent(g);
				g.setColor(Color.WHITE);//set color
			}

			 class LevelIndicatorPanel extends JPanel{ //level indicator panel


				public LevelIndicatorPanel() {//constructor
					setBackground(Color.GRAY);//set color
					int x = 0;
					int y = 100;
					J = Toolkit.getDefaultToolkit().getImage("forest1.jpg"); //background
					setPreferredSize(new Dimension(200,100));
				}

				public void paintComponent(Graphics g){ //paintComponent()
					super.paintComponent(g);

					g.drawImage(J,0,0,this);
					g.fillRect(0,0,2,800); //border
					g.fillRect(75,30,50,700);//middle
					g.setColor(Color.GRAY);
					g.fillRect(50,indicatorY,100,18);

					g.setColor(Color.BLUE);
					g.setFont(font3);
					g.drawString("START", 70, 750);//set text start, w/ coodinates
					g.drawString("FINISH", 70, 24);//set text finish, w/ coordinates
					g.drawString("Level 1", 0, 575); //all levels (1,2,3)
					g.drawString("Level 2", 0, 375);
					g.drawString("Level 3", 0, 175);

				}

			}

			class PlayPanel extends JPanel implements KeyListener, ActionListener, MouseListener{//play panel

				public LevelIndicatorPanel lp;
				private int randNum;
				private boolean up;
				private boolean down;
				private Timer timer = new Timer(10, this);
				private int y;
				private int a;
				private int b;
				private boolean clicktrue = true;
				private boolean runanimation = false;
				private int measureSide = 400;
				private int measureMid = 500;
				private boolean correct;
				private int numCorrect = 0;
				private int xCoord;
				private int yCoord;
				private int rectstarter=500;
				private int measureEnd;
				private int setterY = 0;
				private boolean upper = true;
				private Font font4 = new Font("Corsiva", Font.BOLD, 30);

				public PlayPanel() {//constructor
					lp = new LevelIndicatorPanel();

					addKeyListener(this); //add listeners
					addMouseListener(this);
					setBackground(Color.WHITE);//set color
					x=0;
					y=375;
					a=100;
					b=375;
					correct=false;
					generateRandNum(); //make a new random number
				}

				public void paintComponent(Graphics g) {//paintComponent()
					super.paintComponent(g);

					J = Toolkit.getDefaultToolkit().getImage("forest1.jpg"); //background
					g.drawImage(J,0-(x/4),0,this); //draw background

					if(clicktrue){
					g.setColor(Color.RED); //direct user to start game with click
					g.setFont(font4);
					g.drawString("Click the screen to start!",100,100);
					}

					if(runanimation){ //draw boost symbol is left arrow pressed
					g.setColor(Color.RED); //symbol
					g.fillRect(a-10,b,20,10); //appears right behind character
					g.setColor(Color.WHITE);
					g.fillRect(a-10,b+5,20,10);
					}

					g.setColor(Color.BLUE);
					g.fillRect(a,b,20,20); //draw the character
					g.setColor(Color.WHITE);
					g.fillRect(a+10,b,5,5);
					g.setColor(Color.BLACK);

					measureMid=(rectstarter)-x*2;
					measureSide=(rectstarter-100)-x*2;
					measureEnd=(measureSide+1000);

					if(a==measureEnd){ //continue game if answer is correct
						if (correct) {
							indicatorY=indicatorY-27; //indicate change in progress bar
					        numCorrect++;
                            lip.repaint();
                            generateRandNum();
							correct=false;

						}
						else { //stop game with pop-up if answer is wrong
							g.setColor(Color.WHITE);
							timer.stop();
							g.setColor(Color.GRAY);
							g.fillRect(300,200,485,200); //draw pop-up
							g.setColor(Color.GREEN);
							g.setFont(font3); //draw explanation
							g.drawString("'" + englishPhrases[randNum] + "'" + " in Spanish is actually " + "'" + spanishPhrases[randNum] + "'",310,240);
							g.drawString("Let's try again...",310,320);

							timer.setInitialDelay(3000); //stop game to allow user to see explanation
							generateRandNum();
							timer.restart(); //start game again
						}
					}

					if(a==measureEnd){
						rectstarter=rectstarter+1500;
						measureEnd=measureEnd+1500;
						setterY=(int)(Math.random()*2+1);
						if(setterY==1)
							setterY=-100;
						else if(setterY==2)
							setterY=100;
					}

					g.setColor(Color.ORANGE);

					g.fillRect(measureSide,400+setterY,800,20);
					g.fillRect(measureMid,300+setterY,800,20);
					g.fillRect(measureSide,200+setterY,800,20);

					g.setColor(Color.GREEN);
					g.setColor(Color.BLACK);

					if(!clicktrue){
					g.setColor(Color.BLACK);
					g.setFont(font4);
					g.drawString(englishPhrases[randNum],measureSide,150+setterY);//drawString() in array at index of random number
					g.setColor(Color.BLUE);
						if(upper){
							g.drawString(spanishPhrases[randNum],measureSide,250+setterY);
							g.drawString(spanishPhrases[randNum+1],measureSide,350+setterY);
						}
						else if(!upper){
							g.drawString(spanishPhrases[randNum+1],measureSide,250+setterY);
							g.drawString(spanishPhrases[randNum],measureSide,350+setterY);
						}
					}

					if(numCorrect==7){ //pops up when user finished level 1
						g.setColor(Color.GRAY); //create the pop-up
						g.fillRect(0,0,1300,800);
						g.setColor(Color.GREEN); //draw the text
						g.setFont(font3);
						g.drawString("Congratulations! You have completed level 1, -ar verbs.",225,300); //congratulate the user
						g.drawString("You are on your way to becoming a conjugation champion.",225,400);
						g.drawString("Now we will begin level 2, where you will learn to conjugate -er verbs.",180,500); //notify level 2 will start
						timer.stop(); //stop the game

					}
				}

				public void generateRandNum() {//generateRandNum()
					randNum = (int)(Math.random()*23 + 0);//start value of 1, range equal to number of conjugations in array

                    if(randNum%2==0) //conjugation is drawn in top path
						upper=true;
					else if(randNum%2!=0) //conjugation is drawn in bottom path
						upper=false;

				}

				/*	public void music(){
					AudioPlayer audioGetter = AudioPlayer.player;
					AudioStream backgroundMusic;
					AudioData musicData;
					ContinuousAudioDataStream loop = null;

					try{
						backgroundMusic = new AudioStream(new FileInputStream("spanishsong.mp3"));
						musicData = backgroundMusic.getData();
						loop = new ContinuousAudioDataStream(musicData);
					}catch(IOException error) {}
						audioGetter.start(loop);
				} */

				public void mousePressed(MouseEvent e) { //mouse handler events

				}
				public void mouseReleased(MouseEvent e) {

				}
				public void mouseClicked(MouseEvent e) {
					requestFocus();
					timer.start(); //start the timer
					clicktrue=false;

				}
				public void mouseEntered(MouseEvent e) { //mouse entered method

				}
				public void mouseExited(MouseEvent e) { //mouse exited method

				}

				public void	keyTyped(KeyEvent e) {}//key event handlers

				public void keyReleased(KeyEvent e) {}

				public void keyPressed(KeyEvent e) {	//key pressed

					int keyCode = e.getKeyCode();

					if(keyCode == KeyEvent.VK_UP){ //if up arrow is pressed, move up by 30
							if(a<measureMid&&(b-30)>=200+setterY)
								b-=30;
							else{
								if((b-30)>=300+setterY){
									b-=30;
								}
								else if((b-30)>=200+setterY&&b<=300+setterY)
									b-=30;
					}
						repaint();
					}
					else if(keyCode == KeyEvent.VK_DOWN) { //if down arrow is pressed, move down by 30
						if(a<measureMid&&(b+30)<=400+setterY)
							b+=30;
							else{
								if((b+30)<=300+setterY)
							b+=30;
							else if((b+30)<=400+setterY&&b>=300+setterY)
							b+=30;
					}
						repaint();
					}
					else if(keyCode == KeyEvent.VK_RIGHT){
						runanimation=true;
					}

				}

				public void actionPerformed(ActionEvent e) {
					 if(e.getSource()==timer){
							x+=1;
						if(x%5==0)
						runanimation=false;
						if(a>measureMid){
							if(upper){ //if-else block decides if answer is correct
								if(200+setterY<b&&b<300+setterY){
									correct=true;
								}
								else if(300+setterY<b&&b<400+setterY)
									correct=false;
								}
							else if(!upper){
								if(200+setterY<b&&b<300+setterY){
									correct=false;
								}
								else if(300+setterY<b&&b<400+setterY)
									correct=true;
								}
							}
						repaint();// this will call at every s seconds
					 }
				}
			}

		}
	}
}
