package sample;

import sample.Image;

/**
 * Created by KORN on 28.03.2017.
 */
public class Network {
    //Массивы:
    private float[] weights; //хранение весов
    private Image[] imagesForLearning; //хранение обучающей выборки
    private Image[] imagesForTesting; //хранение тестовой выборки

    //Пороговое значение
    final private static float THRESHOLD = 0.5f;

    //Инициализатор сети с генерацией весов
    Network() {
        this.weights = new float[Image.size()];

        for (int i = 0; i < weights.length; i++) {
            weights[i] = (float) (Math.random() - Math.random()); //-1;
            System.out.println(weights[i]);
        }

        imagesForLearning = new Image[] {
                new Image(new int[] {0, 1, 0, 0, 1, 0, 0, 1, 0}, true),
                new Image(new int[] {0, 0, 0, 1, 1, 1, 0, 0, 0}, false),
                new Image(new int[] {0, 0, 1, 1, 0, 0, 0, 1, 0}, false)
        };

        imagesForTesting = new Image[] {
                new Image(new int[] {0, 1, 0, 0, 1, 0, 0, 1, 0}, true),
                new Image(new int[] {0, 0, 1, 1, 0, 0, 0, 1, 0}, false),
                new Image(new int[] {1, 0, 1, 1, 0, 0, 0, 1, 1}, false)
        };
    }

    //Перцептрон сумматор
    float sum(Image image) {
        float sum = 0;

        for (int i = 0; i < image.pixels.length; i++) {
            sum += image.pixels[i] * weights[i];
        }

        return sum;
    }

    //Обучение
    void train() {
        boolean isDone = true;

        //Установка весов в цикле до тех пор, пока правильное изображение не будет получать верный результат
        //А неверное изображение не будет получать неправильный результат

        do  {
            isDone = true;
            for (Image image : imagesForLearning) {
                if (sum(image) < THRESHOLD && image.isSoughtFor == true) {
                    for (int i = 0; i < image.pixels.length; i++) {
                        if (image.pixels[i] == 1) {
                            weights[i] += 0.5;
                        }
                    }
                    isDone = false;
                } else if (sum(image) >= THRESHOLD && image.isSoughtFor == false) {
                    for (int i = 0; i < image.pixels.length; i++) {
                        if (image.pixels[i] == 1) {
                            weights[i] -= 0.5;
                        }
                    }
                    isDone = false;
                }
            }
        } while (!isDone);
    }

    void check() {
        //Установка весов в цикле до тех пор, пока правильное изображение не будет получать верный результат
        //А неверное изображение не будет получать неправильный результат
        for (Image image : imagesForLearning) {
            if (sum(image) >= THRESHOLD && image.isSoughtFor == true) {
                System.out.println("Found");
            }
            if (sum(image) >= THRESHOLD && image.isSoughtFor == false) {
                System.out.println("Mistake");
            }
        }

        for (int i = 0; i < weights.length; i++) {
            System.out.println(weights[i]);
        }
    }
}
