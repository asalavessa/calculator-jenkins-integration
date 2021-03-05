import java.util.Arrays;

public class Calc {

    public static void main(String[] args) {

        String operation = args[0];
        double var1 = Double.parseDouble(args[1]);
        double var2 = Double.parseDouble(args[2]);
        
        switch(operation) {
            case ("sum"):
                System.out.println(var1 + var2); break;
            case ("sub"):
                System.out.println(var1 - var2); break;
            case ("times"):
                System.out.println(var1 * var2); break;
            case ("division"):
                System.out.println(var1 / var2); break;
            default:
                System.out.println("Invalid Operation");
        }
    }
}