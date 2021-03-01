import java.io.FileNotFoundException;
import java.util.Scanner;

public class exercicio6 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        int opcao = 0;

    do{
        calcmethods.menu();

        opcao = scanner.nextInt();

        calcmethods.verificarOpcao(opcao);
        calcmethods.executarOpcao(opcao);
        calcmethods.historico();



    }while(opcao != 0);

        scanner.close();


    } 
}

