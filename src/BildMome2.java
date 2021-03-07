import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.Normalizer;

public class BildMome2 {

    BufferedImage img = null;

    public BildMome2(String fileName) {
        try {
            img = ImageIO.read(new File(fileName));
            System.out.println("Img Read");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void save(String fileName) {
        try {
            ImageIO.write(img, "tif", new File(fileName));
            System.out.println("New Img Created");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void changeBrightness(double factor) throws Exception {
        if (factor < 0) {
            throw new Exception("Input needs to be a positive number");
        }

        for (int x = 0; x < img.getWidth(); x++) {

            for (int y = 0; y < img.getHeight(); y++) {


                int pixValue = img.getRGB(x, y);
                Color color = new Color(pixValue);

                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();

                Color updatedColor = new Color(normalise(r * factor), normalise(g * factor), normalise(b * factor));

                img.setRGB(x, y, updatedColor.getRGB());
            }

        }

    }

    private int normalise(int value) {
        return Math.max(Math.min(value, 255), 0);
    }

    private int normalise(double value) {
        return (int) Math.max(Math.min(value, 255), 0);
    }


    void changeChannel(ColorChannel channel, int value) {

        for (int x = 0; x < img.getWidth(); x++) {

            for (int y = 0; y < img.getHeight(); y++) {

                int pixValue = img.getRGB(x, y);
                Color color = new Color(pixValue);

                Color updatedColor = color;

                switch (channel) {
                    case RED -> {
                        int r = normalise(color.getRed() + value);

                        updatedColor = new Color(r, color.getGreen(), color.getBlue());
                        break;
                    }

                    case GREEN -> {
                        int g = normalise(color.getGreen() + value);

                        updatedColor = new Color(color.getRed(), g, color.getBlue());
                        break;
                    }

                    case BLUE -> {
                        int b = normalise(color.getBlue() + value);

                        updatedColor = new Color(color.getRed(), color.getGreen(), b);
                        break;
                    }
                }
                img.setRGB(x, y, updatedColor.getRGB());

            }

        }
    }


}
