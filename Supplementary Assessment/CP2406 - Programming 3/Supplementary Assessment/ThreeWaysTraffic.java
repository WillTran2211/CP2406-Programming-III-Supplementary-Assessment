import javax.swing.*;
import java.awt.*;

public class ThreeWaysTraffic extends JPanel {
    private VehicleMoving car3;
    private VehicleMoving car4;
    private VehicleMoving car5;
    private VehicleMoving car6;
    private VehicleMoving car7;
    private VehicleMoving car8;

    ThreeWaysTraffic() {
        setFocusable(true); // is false by default...
        setPreferredSize(new Dimension(800,200));
        setBackground(new Color(220,200,250));

    }

    void setCar3(VehicleMoving car3){this.car3 = car3;}
    void setCar4(VehicleMoving car4){this.car4 = car4;}
    void setCar5(VehicleMoving car5){this.car5 = car5;}
    void setCar6(VehicleMoving car6){this.car6 = car6;}
    void setCar7(VehicleMoving car7){this.car7 = car7;}
    void setCar8(VehicleMoving car8){this.car8 = car8;}

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        car3.draw(graphics);
        car4.draw(graphics);
        car5.draw(graphics);
        car6.draw(graphics);
        car7.draw(graphics);
        car8.draw(graphics);

        new Road().paintThreeways(graphics);
        new TrafficLight().paint(graphics);

    }

}