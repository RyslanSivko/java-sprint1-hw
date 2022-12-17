public class Converter {
    int step = 75;
    int calories = 50;
    public void stepsToKm(double summ){
        System.out.println("пройденное расстояние в км = " + summ * step/100000);
    }
    public void stepsToKl(double summ){
        System.out.println("количество сожжённых килокалорий = "+ summ * calories/1000);
    }
}





