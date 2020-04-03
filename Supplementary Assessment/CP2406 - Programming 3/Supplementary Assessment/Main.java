import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class Main{
    JFrame frame = new JFrame("Traffic Simulator");
    FourWaysTraffic FourWays = new FourWaysTraffic();
    ThreeWaysTraffic ThreeWays = new ThreeWaysTraffic();
    OneWayTraffic OneWay = new OneWayTraffic();

    JPanel trafficBoard = new JPanel();
    JPanel trafficBoard2 = new JPanel();
    JLabel countdownText = new JLabel();
    JPanel buttonPanel = new JPanel();

    JButton OneWayTraffic = new JButton("One Way Traffic");
    JButton ThreeWaysTraffic = new JButton("Three Ways Traffic");
    JButton FourWaysTraffic = new JButton("Four Ways Traffic");
    final Color[] color = {new Color(0, 255, 0)};

    public void FourWays(){
        frame.remove(OneWay);
        frame.remove(ThreeWays);
        frame.remove(trafficBoard);
        frame.remove(trafficBoard2);
        VehicleMoving car9 = new VehicleMoving(500, 510, 35, 70, Color.cyan);
        VehicleMoving car10 = new VehicleMoving(585, -160, 35, 70, Color.magenta);
        VehicleMoving car11 = new VehicleMoving(180, 200, 70, 35, Color.lightGray);
        VehicleMoving car12 = new VehicleMoving(100, 200, 70, 35, Color.gray);
        VehicleMoving car13 = new VehicleMoving(500, 600, 35, 70, Color.green);
        VehicleMoving car14 = new VehicleMoving(585, -80, 35, 70, Color.darkGray);
        VehicleMoving car15 = new VehicleMoving(20,200,70,35,Color.yellow);

//      VehicleMoving car16 = new VehicleMoving(500,520,35,70,Color.cyan);
//      VehicleMoving car9 = new VehicleMoving()

        FourWays.setCar9(car9);
        FourWays.setCar10(car10);
        FourWays.setCar11(car11);
        FourWays.setCar12(car12);
        FourWays.setCar13(car13);
        FourWays.setCar14(car14);
        FourWays.setCar15(car15);

//      FourWays.setCar16(car16);

        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300, 80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);
        frame.add(trafficBoard, BorderLayout.NORTH);

        trafficBoard2.setFocusable(true);
        trafficBoard2.setPreferredSize(new Dimension(80, 600));
        trafficBoard2.setBackground(Color.GREEN);

//      trafficBoard2.add(countdownText);

        frame.add(trafficBoard2, BorderLayout.EAST);

        java.util.Timer timer2 = new java.util.Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            Color light_color = Color.GREEN;
            int countDown = 3;

            @Override
            public void run() {
                countDown = countDown - 1;
                switch (countDown) {
                    case -1:
                        light_color = Color.red;
                        trafficBoard.setBackground(light_color);
                        countDown = 14;
                        break;
                    case 7:
                        light_color = Color.GREEN;
                        trafficBoard.setBackground(light_color);
                        new TrafficLight().repaint();
                        break;

                }

                if (Color.red.equals(light_color)) {
                    car9.stop();
                    car10.stop();
                    car11.set_xDir();
                    car12.set_xDir();
                    car11.move(FourWays.getSize());
                    car12.moveToRightAndBottom(FourWays.getSize());
                    car13.stop();
                    car14.stop();

//                  car16.stop();

                }

                else if (Color.GREEN.equals(light_color)) {
                    car9.set_yDir();
                    car9.moveToTop(FourWays.getSize());
                    car10.set_yDir2();
                    car10.moveToBottom(FourWays.getSize());
                    car13.set_yDir2();
                    car13.moveToTopAndLeft(FourWays.getSize());
                    car14.set_yDir();
                    car14.moveToBottonAndLeft(FourWays.getSize());
                    car15.set_xDir();
                    car15.moveToLeft(FourWays.getSize());

//                  car16.set_yDir2();
//                  car16.moveToTopAndRight(fourWays.getSize());
//                  car11.stop();
//                  car12.stop();

                }

                countdownText.setText(String.valueOf(countDown));

            }

        }, 0, 1000);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car9.moveToTop(FourWays.getSize());
                car10.moveToBottom(FourWays.getSize());
                car11.move(FourWays.getSize());
                car12.moveToRightAndBottom(FourWays.getSize());
                car13.moveToTopAndLeft(FourWays.getSize());
                car14.moveToBottonAndLeft(FourWays.getSize());
                car15.moveToLeft(FourWays.getSize());

//              car16.moveToTopAndRight(fourWays.getSize());

                FourWays.repaint();

            }

        });

        timer.start();
        frame.add(FourWays, BorderLayout.CENTER);

    }

    public void ThreeWays() {
        frame.remove(OneWay);
        frame.remove(FourWays);
        frame.remove(trafficBoard);
        frame.remove(trafficBoard2);
        VehicleMoving car3 = new VehicleMoving(500, 510, 35, 70, Color.RED);
        VehicleMoving car4 = new VehicleMoving(585, -160, 35, 70, Color.BLUE);
        VehicleMoving car5 = new VehicleMoving(180, 200, 70, 35, Color.yellow);
        VehicleMoving car6 = new VehicleMoving(100, 200, 70, 35, Color.orange);
        VehicleMoving car7 = new VehicleMoving(500, 600, 35, 70, Color.cyan);
        VehicleMoving car8 = new VehicleMoving(585, -80, 35, 70, Color.pink);
        ThreeWays.setCar3(car3);
        ThreeWays.setCar4(car4);
        ThreeWays.setCar5(car5);
        ThreeWays.setCar6(car6);
        ThreeWays.setCar7(car7);
        ThreeWays.setCar8(car8);

        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300, 80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);
        frame.add(trafficBoard, BorderLayout.NORTH);

        trafficBoard2.setFocusable(true);
        trafficBoard2.setPreferredSize(new Dimension(80, 600));
        trafficBoard2.setBackground(Color.GREEN);

//      trafficBoard2.add(countdownText);

        frame.add(trafficBoard2, BorderLayout.EAST);

        java.util.Timer timer2 = new java.util.Timer();
        timer2.scheduleAtFixedRate(new TimerTask() {
            Color light_color = Color.GREEN;
            int countDown = 3;

            @Override
            public void run() {
                countDown = countDown - 1;
                switch (countDown) {
                    case -1:
                        light_color = Color.red;
                        trafficBoard.setBackground(light_color);
                        countDown = 14;
                        break;
                    case 7:
                        light_color = Color.GREEN;
                        trafficBoard.setBackground(light_color);
                        new TrafficLight().repaint();
                        break;

                }

                if (Color.red.equals(light_color)) {
                    car3.stop();
                    car4.stop();
                    car5.set_xDir();
                    car6.set_xDir();
                    car5.move(ThreeWays.getSize());
                    car6.moveToRightAndBottom(ThreeWays.getSize());
                    car7.stop();
                    car8.stop();

                }

                else if (Color.GREEN.equals(light_color)) {
                    car3.set_yDir();
                    car3.moveToTop(ThreeWays.getSize());
                    car4.set_yDir2();
                    car4.moveToBottom(ThreeWays.getSize());
                    car7.set_yDir2();
                    car7.moveToTopAndLeft(ThreeWays.getSize());
                    car8.set_yDir();
                    car8.moveToBottonAndLeft(ThreeWays.getSize());

//                  car5.stop();
//                  car6.stop();

                }

                countdownText.setText(String.valueOf(countDown));

            }

        }, 0, 1000);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car3.moveToTop(ThreeWays.getSize());
                car4.moveToBottom(ThreeWays.getSize());
                car5.move(ThreeWays.getSize());
                car6.moveToRightAndBottom(ThreeWays.getSize());
                car7.moveToTopAndLeft(ThreeWays.getSize());
                car8.moveToBottonAndLeft(ThreeWays.getSize());
                ThreeWays.repaint();

            }

        });

        timer.start();
        frame.add(ThreeWays, BorderLayout.CENTER);

//      timer2.cancel();
//      timer.start();

    }

    public void OneWay() {
        frame.remove(ThreeWays);
        frame.remove(FourWays);
        frame.remove(trafficBoard);
        frame.remove(trafficBoard2);

        VehicleMoving car = new VehicleMoving(100, 150, 70, 35, Color.yellow);
        VehicleMoving car2 = new VehicleMoving(850, 100, 70, 35, Color.cyan);

        //frame.add(trafficLight,BorderLayout.WEST);

        OneWay.setCar(car);
        OneWay.setCar2(car2);

        trafficBoard.setFocusable(true);
        trafficBoard.setPreferredSize(new Dimension(300, 80));
        trafficBoard.setBackground(Color.GREEN);
        trafficBoard.add(countdownText);
        frame.add(trafficBoard, BorderLayout.NORTH);

        //TrafficLight trafficLight = new TrafficLight();

        java.util.Timer timer1 = new java.util.Timer();

        timer1.scheduleAtFixedRate(new TimerTask() {
            Color light_color = Color.GREEN;
            int countdown = 3;

            @Override
            public void run() {
                countdown = countdown - 1;
                switch (countdown) {
                    case -1:
                        light_color = Color.RED;
                        trafficBoard.setBackground(light_color);
                        countdown = 14;
                        break;
                    case 7:
                        light_color = Color.GREEN;
                        trafficBoard.setBackground(light_color);
                        new TrafficLight().repaint();
                        break;

                }

                if (Color.RED.equals(light_color)) {
                    car.stop();
                    car2.stop();

                }

                else if (Color.GREEN.equals(light_color)) {
                    car.set_xDir();
                    car.oneWayMove(ThreeWays.getSize());
                    car2.set_xDir2();
                    car2.moveToLeft(ThreeWays.getSize());

                }

                countdownText.setText(String.valueOf(countdown));

            }

        }, 0, 1000);

        // frame-by-frame animation loop
        Timer timer_2 = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.oneWayMove(OneWay.getSize());
                car2.moveToLeft(OneWay.getSize());
                OneWay.repaint();

            }

        });

        timer_2.start();
        frame.add(OneWay, BorderLayout.CENTER);

//        timer1.cancel();
//        timer_2.start();

    }

    public void showGUI() {
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(OneWayTraffic);
        buttonPanel.add(ThreeWaysTraffic);
        buttonPanel.add(FourWaysTraffic);
        frame.add(buttonPanel, "South");
        OneWayTraffic.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 26));
        ThreeWaysTraffic.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 26));
        FourWaysTraffic.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 26));

        OneWayTraffic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Switch to One Way Traffic");
                OneWay();

            }

        });

        ThreeWaysTraffic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Switch to Three Way Traffic");
                ThreeWays();

            }

        });

        FourWaysTraffic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Switch to Four Ways Traffic");
                FourWays();

            }

        });

        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Main main = new Main();

//        main.OneWay();
//        main.ThreeWaysTraffic();

        main.FourWays();
        main.showGUI();

    }

}