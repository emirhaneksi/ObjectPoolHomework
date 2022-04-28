package objectpoolhomework;

public class ObjectPoolHomework{

    
    public static final int sickCount = 15;
    
    public static void main(String[] args) {
        // TODO code application logic here

        for (int i = 0; i < sickCount ; i++) {
           Sick sick = new Sick();
           sick.start();
        }
        

    }
    
}
