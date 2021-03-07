import java.io.*;
import java.util.Arrays;

public class BildMome {

    static int byteIndex =0;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));

        if(args.length < 4 ) {
            System.err.println(" 4ta bashe lotfan");
            System.exit(1);
        }

        String inputFileName = args[0];
        String outputFileName = args[1];
        String colorChannel = args[2];
        String colorValue = args[3];

        try{
            FileInputStream fis = new FileInputStream(inputFileName);

            ByteArrayInputStream bais = new ByteArrayInputStream(fis.readAllBytes());

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(outputFileName)));


            int count = fis.available();
            byte[] array = new byte[count];
            bais.read(array);

            for (byte bt:array) {
                System.out.println(bt);
            }

            int inputByte;
            while ((inputByte = bais.read()) != -1){
                byteIndex++;
                if (byteIndex > 8 && byteIndex %7==0 && inputByte > 50){
                    inputByte -= 50;
                }
                bos.write(inputByte);
            }

            fis.close();
            bais.close();
            bos.flush();
            bos.close();


        }catch (Exception e){
            System.out.print(e);
        }



    }


}
