import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    // List of images TODO: Generalize
    ArrayList<BufferedImage> carImages = new ArrayList<>();
    // To keep track of a single car's position
    ArrayList<Point> carPoints = new ArrayList<>();

    // TODO: Make this general for all cars
    void moveit(int index, int x, int y) {
        carPoints.get(index).x = x;
        carPoints.get(index).y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, boolean carChoice) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
            if (carChoice) {
                carImages.add(ImageIO.read(
                        DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")
                ));
            } else {
                carImages.add(ImageIO.read(
                        DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")
                ));
            }
            carPoints.add(new Point());

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < carImages.size(); i++) {
            Point p = carPoints.get(i);
            g.drawImage(carImages.get(i), p.x, p.y, null); // see javadoc for more info on the parameters
        }
    }
}
