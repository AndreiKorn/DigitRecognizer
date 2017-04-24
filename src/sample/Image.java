package sample;

/**
 * Created by KORN on 28.03.2017.
 */

public class Image {

    //Размер изображения:
    final static private int IMAGE_WIDTH = 28;
    final static private int IMAGE_HEIGHT = 28;
    //Массив для хранения пикселей
    int[] pixels;
    //Искомое изображение или нет?:
    boolean isSoughtFor;
    String label;

    //Инициализатор
    Image() {
        this.pixels = new int[Image.size()];
    }

    public Image(int[] pixels, boolean isSoughtFor) {
        this.pixels = pixels;
        this.isSoughtFor = isSoughtFor;
    }

    public Image(int[] pixels, String label) {
        this.pixels = pixels;
        this.label = label;
    }

    //Возвращаем размер изображения
    static int size() {
        return IMAGE_HEIGHT * IMAGE_WIDTH;
    }
}
