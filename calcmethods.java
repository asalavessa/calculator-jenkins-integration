import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class calcmethods {

    static Scanner scanner = new Scanner(System.in);

    public static int sum(int algarismoA, int algarismoB) { 
        int soma = algarismoA+algarismoB;
        return soma;

    }



    public static int sub(int algarismoC, int algarismoD) { 
        int soma = algarismoC-algarismoD;
        return soma;
    }



    public static int mult(int algarismoE, int algarismoF) { 
        int soma = algarismoE*algarismoF;
        return soma;
    }



    public static int div(int algarismoG, int algarismoH) { 
     
        int soma = algarismoG/algarismoH;
        return soma;
              
              
    }



    public static void menu(){
        System.out.println("----------OPCOES----------");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Ver Histórico de Operações");
        System.out.println("0 - Sair");
        System.out.println("Escolha uma operação: ");
    }

    

    public static void verificarOpcao(int opcao) {


        if( opcao < 0 || opcao > 5 ) {
        System.out.println("Opcao invalida. Selecione outra opcao.");

        }
    }



    public static void executarOpcao(int opcao) throws FileNotFoundException {
        switch(opcao) {
            case 1: 
              
            
            System.out.print("Insira o primeiro número:");
            int algarismoA = scanner.nextInt();
    
            System.out.print("Insira o segundo número:");
            int algarismoB = scanner.nextInt();

            System.out.print("-------RESULTADO-------\n");
            System.out.println("Soma = " + calcmethods.sum(algarismoA, algarismoB));


                try 
                    (FileWriter f = new FileWriter("historico.txt", true);
                    BufferedWriter b = new BufferedWriter(f);
                    PrintWriter p = new PrintWriter(b);) {

                        p.println(algarismoA + " + " + algarismoB + " = " + calcmethods.sum(algarismoA, algarismoB));
                        System.out.println("Operação guardada no ficheiro " + "historico.txt");

                    } catch (IOException i) {
                        i.printStackTrace();
                        }

                break;


            case 2:

            System.out.print("Insira o primeiro número:");
            int algarismoC = scanner.nextInt();
    
            System.out.print("Insira o segundo número:");
            int algarismoD = scanner.nextInt();

            System.out.print("-------RESULTADO-------\n");
            System.out.println("Subtração = " + calcmethods.sub(algarismoC, algarismoD));


                try 
                    (FileWriter f = new FileWriter("historico.txt", true);
                    BufferedWriter b = new BufferedWriter(f);
                    PrintWriter p = new PrintWriter(b);) {

                        p.println(algarismoC + " - " + algarismoD + " = " + calcmethods.sub(algarismoC, algarismoD));
                        System.out.println("Operação guardada no ficheiro " + "historico.txt");

                    } catch (IOException i) {
                         i.printStackTrace();
                         }

                break;

            case 3:

            System.out.print("Insira o primeiro número:");
            int algarismoE = scanner.nextInt();
    
            System.out.print("Insira o segundo número:");
            int algarismoF = scanner.nextInt();

            System.out.print("-------RESULTADO-------\n");
            System.out.println("Multiplicação = " + calcmethods.mult(algarismoE, algarismoF));


                try 
                    (FileWriter f = new FileWriter("historico.txt", true);
                    BufferedWriter b = new BufferedWriter(f);
                    PrintWriter p = new PrintWriter(b);) {

                        p.println(algarismoE + " * " + algarismoF + " = " + calcmethods.mult(algarismoE, algarismoF));
                        System.out.println("Operação guardada no ficheiro " + "historico.txt");

                    } catch (IOException i) {
                        i.printStackTrace();
                        }

                break;

            case 4:
            
            System.out.print("Insira o primeiro número:");
            int algarismoG = scanner.nextInt();
    
            System.out.print("Insira o segundo número:");
            int algarismoH = scanner.nextInt();

                if (algarismoH != 0){

                        System.out.print("-------RESULTADO-------\n");
                        System.out.println("Divisão = " + calcmethods.div(algarismoG, algarismoH));

                        try 
                            (FileWriter f = new FileWriter("historico.txt", true);
                            BufferedWriter b = new BufferedWriter(f);
                            PrintWriter p = new PrintWriter(b);) {
    
                            p.println(algarismoG + " / " + algarismoH + " = " + calcmethods.div(algarismoG, algarismoH));
                            System.out.println("Operação guardada no ficheiro " + "historico.txt");
    
                        } catch (IOException i) {
                            i.printStackTrace();
                            }

                 }else {
        
                        System.out.print("-------ERROR-------\n");
                        System.out.printf("DIVISION BY ZERO DETECTED, RESTARTING THE MATRIX.\n");
                        System.out.print("-------ERROR-------\n");
                    }

                break;

            case 5:
                    
            System.out.print("-------HISTÓRICO-------\n"); 

                try (BufferedReader br = new BufferedReader(new FileReader("historico.txt"))) {
                    String line;

                    while ((line = br.readLine()) != null) {
                         System.out.println(line);
                }

                        } catch (IOException i) {
                             i.printStackTrace();
                            }

                break;

            default:
            
        }

    }


    public static void historico(){

            
        String fileName = "historico.txt";


            try    
                (FileWriter f = new FileWriter(fileName, true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {
            
                } catch (IOException i) {
                    i.printStackTrace();
                    }


    }

}
