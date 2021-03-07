public class Main {
    public static void main(String[] args) throws Exception {
        BildMome2 bild = new BildMome2("src/Ax.tif");

       // bild.changeChannel(ColorChannel.RED, -500);
       // bild.changeChannel(ColorChannel.GREEN, 0);
       // bild.changeChannel(ColorChannel.BLUE, 0);



        bild.changeBrightness(-2.7);
        bild.save("src/felan.tif");

    }
}
