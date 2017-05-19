
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;

/**
 *
 * @author holls9719
 */
public class A8Q1 extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // GAME VARIABLES WOULD GO HERE
    //mouseX
    int mouseX = MouseInfo.getPointerInfo().getLocation().x;
    //mouseY
    int mouseY = MouseInfo.getPointerInfo().getLocation().y;
    //theta
    double T = Math.atan((mouseY - 260) / (mouseX - 260));
    //left eye
    int leftX = (int) (15 * Math.cos(T));
    int leftY = (int) (15 * Math.sin(T));
    //right eye
    int rightX = (int) (15 * Math.cos(T));
    int rightY = (int) (15 * Math.sin(T));
 
    // GAME VARIABLES END HERE   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        //drawing a face
        //set the color to skin tone
        Color skin = new Color(237, 219, 166);
        g.setColor(skin);

        //draw a circle for the background of the face
        g.fillOval(70, 70, 500, 500);


        //set the color to darkGreen
        //  Color eyes = new Color(42, 128, 42);
        g.setColor(Color.WHITE);
        g.fillOval(200, 200, 80, 80);
        g.fillOval(400, 200, 80, 80);

        //set the color to black
        g.setColor(Color.BLACK);

        //drawing the eyes
        //left
        g.fillOval(215 + leftX, 215 + leftY, 50, 50);
        //right
        g.fillOval(415 + rightX, 215 + rightY, 50, 50);

        // g.fillOval(mouseX, mouseY, 50, 50);
        // g.fillOval(mouseY, mouseX, 50, 50);

        //mouth
        g.setColor(Color.BLACK);
        g.fillArc(200, 400, 200, 50, -15, 30);

        //nose
        g.drawArc(310, 270, 50, 100, 210, 115);

        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE

            //getting the cordinates that the mouse is at
            mouseX = MouseInfo.getPointerInfo().getLocation().x;
            mouseY = MouseInfo.getPointerInfo().getLocation().y;


            //in the case theta = pi/2, pi, 3pi/2,2pi
            if (mouseX == 220 && mouseY > 220) {
                leftX = 0;
                leftY = 15;
            }
            if (mouseX == 220 && mouseY < 220) {
                leftX = 0;
                leftY = -15;
            }
            if (mouseY == 220 && mouseX > 220) {
                leftX = 15;
                leftY = 0;
            }
            if (mouseY == 220 && mouseX < 220) {
                leftX = -15;
                leftY = 0;
            }

            //tantheta-for all values other than pi/2, pi, 3pi/2,2pi
            if (!(mouseX == 220 || mouseY == 220)) {
                T = (mouseY - 220) / (mouseX - 220);

                //related acute angle
                double beta = Math.atan(T);
                //figuring out theta based on the quadrent
                if (mouseX > 220 && mouseY < 220) {
                    leftX = (int) (15 * Math.cos(beta));
                    leftY = (int) (15 * Math.sin(beta));
                }
                if (mouseX < 220 && mouseY < 220) {
                    leftX = (int) (-1 * (15 * Math.cos(beta)));
                    leftY = (int) (-1 * (15 * Math.sin(beta)));
                }
                if (mouseX < 220 && mouseY > 220) {
                    leftX = (int) (-1 * (15 * Math.cos(beta)));
                    leftY = (int) (-1 * (15 * Math.sin(beta)));
                }
                if (mouseX > 220 && mouseY > 220) {
                    leftX = (int) (15 * Math.cos(beta));
                    leftY = (int) (15 * Math.sin(beta));
                }
            }
            
            //in the case theta = pi/2, pi, 3pi/2,2pi
            if (mouseX == 420 && mouseY > 220) {
                rightX = 0;
                rightY = 15;
            }
            if (mouseX == 420 && mouseY < 220) {
                rightX = 0;
                rightY = -15;
            }
            if (mouseY == 220 && mouseX > 420) {
                rightX = 15;
                rightY = 0;
            }
            if (mouseY == 220 && mouseX < 420) {
                rightX = -15;
                rightY = 0;
            }

            //tantheta-for all values other than pi/2, pi, 3pi/2,2pi
            if (!(mouseX == 420 || mouseY == 220)) {
                T = (mouseY - 220) / (mouseX - 420);

                //related acute angle
                double beta = Math.atan(T);
                //figuring out theta based on the quadrent
                if (mouseX > 420 && mouseY < 220) {
                    rightX = (int) (15 * Math.cos(beta));
                    rightY = (int) (15 * Math.sin(beta));
                }
                if (mouseX < 420 && mouseY < 220) {
                    rightX = (int) (-1 * (15 * Math.cos(beta)));
                    rightY = (int) (-1 * (15 * Math.sin(beta)));
                }
                if (mouseX < 420 && mouseY > 220) {
                    rightX = (int) (-1 * (15 * Math.cos(beta)));
                    rightY = (int) (-1 * (15 * Math.sin(beta)));
                }
                if (mouseX > 420 && mouseY > 220) {
                    rightX = (int) (15 * Math.cos(beta));
                    rightY = (int) (15 * Math.sin(beta));
                }
            }
            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        A8Q1 game = new A8Q1();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());

        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
