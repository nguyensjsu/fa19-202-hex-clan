import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

import java.awt.*;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.awt.Color;


/**
 * Write a description of class ChartWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChartWorld extends World {

    private Button exitHelpScreen;

    //private static final String newLine = System.getProperty("line.separator");
    public ChartWorld() {
        super(1000, 680, 1);
        getBackground().setColor(Color.WHITE);
        getBackground().fill();


        List<Point> listpoints = new ArrayList<Point>();
        List<Integer> listscores = new ArrayList<Integer>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get("Scores.txt"))) {
            int count = 1;
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {

                listpoints.add(new Point(count++, Integer.parseInt(line)));
                listscores.add(Integer.parseInt(line));

            }

        } catch (Exception e) {
            getBackground().drawImage(new GreenfootImage("Error in File Retriveing . PLease Try Again Later", 35, Color.RED, new Color(0, 0, 0, 0)), 300, 600);
        }

        Point[] points = listpoints.toArray(new Point[0]);

        int[] scores = listscores.stream().mapToInt(i -> i).toArray();
        int sum = 0;
        for (int k = 0; k < scores.length; k++) {
            sum += scores[k];
        }

        int averagevalue = (sum / scores.length);
        List<Integer> topfivescore = listscores;
        Collections.sort(topfivescore);
        topfivescore = topfivescore.subList(Math.max(topfivescore.size() - 5, 0), topfivescore.size());

        int[] topfive = topfivescore.stream().mapToInt(i -> i).toArray();
        getBackground().drawImage(new GreenfootImage("STATISTICS", 60, Color.BLACK, new Color(0, 0, 0, 0)), 400, 15);
        getBackground().drawImage(createLineChart(1000, points, 700, 250, Color.WHITE, Color.RED, Color.BLACK, 5), 120, 80);
        getBackground().drawImage(new GreenfootImage("Top 5 Scores", 30, Color.BLUE, new Color(0, 0, 0, 0)), 130, 420);

        for (int i = 0, j = 4; i < topfive.length && j >= 0; i++, j--)
            getBackground().drawImage(new GreenfootImage(Integer.toString(topfive[j]), 30, Color.BLACK, new Color(0, 0, 0, 0)), 180, 470 + i * 40);

        getBackground().drawImage(new GreenfootImage("AVERAGE SCORE :", 30, Color.BLACK, new Color(0, 0, 0, 0)), 500, 470);
        getBackground().drawImage(new GreenfootImage(Integer.toString(averagevalue), 30, Color.BLACK, new Color(0, 0, 0, 0)), 800, 470);
        getBackground().drawImage(new GreenfootImage("NUMBER OF GAMES :", 30, Color.BLACK, new Color(0, 0, 0, 0)), 500, 510);
        getBackground().drawImage(new GreenfootImage(Integer.toString(scores.length), 30, Color.BLACK, new Color(0, 0, 0, 0)), 800, 510);

        exitHelpScreen = new Button(Button.Type.CONTINUE);
        addObject(exitHelpScreen, 600, 600);
        IMenuCommand exitCommand = new MenuCommand();
        exitCommand.setReceiver(new IMenuReceiver() {
            @Override
            public void performAction() {
                Greenfoot.setWorld(new MenuWorld());
            }
        });

        exitHelpScreen.setMenuCommand(exitCommand);
    }


    public GreenfootImage createLineChart(double maxValue, Point[] absoluteValues, int width, int height, Color backgroundColor, Color lineColor, Color frameColor, int frameWidth) {
        GreenfootImage img;
        GreenfootImage lineChart;
        double maxValueX = absoluteValues[absoluteValues.length - 1].getX() + 0.1 * absoluteValues[absoluteValues.length - 1].getX();
        double maxValueXnames = absoluteValues.length;
        //width=width+30;
        lineChart = new GreenfootImage(width + 50, height + 35);
        lineChart.setColor(Color.BLACK);
        lineChart.fillRect(25, 10, width + 2, height + 2);
        lineChart.setColor(Color.WHITE);
        lineChart.fillRect(27, 10, width, height);

        for (int i = 0; i < 5; i++) {
            lineChart.setColor(Color.BLACK);
            lineChart.drawLine(25, height - height / 4 * i + 10, width + 27, height - height / 4 * i + 10);
            lineChart.drawImage(new GreenfootImage(Integer.toString((int) Math.round(maxValue / 4 * i)), 18, Color.BLACK, new Color(0, 0, 0, 0)), 0, height - height / 4 * i + 3);
            lineChart.drawLine(27 + width / 4 * i, 10, 27 + width / 4 * i, height + 10);
            lineChart.drawImage(new GreenfootImage((Integer.toString((int) Math.round(maxValueXnames / 4 * i))), 18, Color.BLACK, new Color(0, 0, 0, 0)), width / 4 * i + 15, height + 15);
        }

        GreenfootImage imgscore = new GreenfootImage("Score", 20, Color.BLACK, new Color(0, 0, 0, 0));

        int w = imgscore.getWidth();
        int h = imgscore.getHeight();
        imgscore.scale(w, w);
        imgscore.rotate(-90);
        imgscore.scale(h, w);
        imgscore.setColor(Color.GREEN);

        GreenfootImage imgscore1 = new GreenfootImage("Games Played", 20, Color.BLACK, new Color(0, 0, 0, 0));

        img = new GreenfootImage(width + 70 + frameWidth * 2, height + 55 + frameWidth * 2);
        img.setColor(frameColor);
        img.fill();
        img.setColor(backgroundColor);
        img.fillRect(frameWidth, frameWidth, img.getWidth() - (frameWidth * 2), img.getHeight() - (frameWidth * 2));
        //lineChart.setColor(lineColor);
        lineChart.setColor(Color.BLUE);
        for (int i = 0; i < absoluteValues.length - 1; i++) {
            lineChart.drawLine((int) (absoluteValues[i].getX() * (width / maxValueXnames) + 27), (int) (height + frameWidth + 5 - ((height / maxValue) * absoluteValues[i].getY())),
                    (int) (absoluteValues[i + 1].getX() * (width / maxValueXnames) + 27), (int) (height + frameWidth + 5 - ((height / maxValue) * absoluteValues[i + 1].getY())));

        }
        img.drawImage(lineChart, frameWidth + 20, frameWidth);
        img.drawImage(imgscore, frameWidth, frameWidth + 120);
        img.drawImage(imgscore1, width / 2 - 20, height + 40);
        return img;
    }


}