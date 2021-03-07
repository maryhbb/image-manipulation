import java.io.*;

public class Bild {

    static int byteIndex = 0;

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("src/Ax.tif");
            ByteArrayInputStream bais = new ByteArrayInputStream(fis.readAllBytes());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("src/Ax2.tif")));

            int count = fis.available();
            byte[] array = new byte[count];
            bais.read(array);

            for (byte bt : array) {
                System.out.println(bt);
            }

            int inputByte;
            while ((inputByte = bais.read()) != -1) {
                byteIndex++;
                if (byteIndex > 8 && byteIndex % 7 == 0 && inputByte > 50) {
                    inputByte -= 50;
                }
                bos.write(inputByte);
            }

            fis.close();
            bais.close();
            bos.flush();
            bos.close();


        } catch (Exception e) {
            System.out.print(e);
        }


    }


}
