package task2;

import java.io.*;

public class Calculations {
    public static void main(String[] args) {
        File file = new File("Dzialania.txt");
        File file2 = new File("Obliczenia.txt");
        ReadWriteFileAndCalculations(file, file2);
    }

    private static void WriteToFileLine(File file2, String[] wyraz,double wynik) {

        try (FileWriter fileWriter = new FileWriter(file2, true);
             BufferedWriter bfw = new BufferedWriter(fileWriter);) {
            bfw.write(wyraz[0] + " " + wyraz[1] + " " + wyraz[2] + " = " + wynik);
            bfw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ReadWriteFileAndCalculations(File file, File file2) {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);){
            String line= null;
            String[] wyraz = null;
            double wynik = 0;
            int i = 0;
            while((line= bufferedReader.readLine()) != null) {
                wyraz = line.split(" ");
                switch (wyraz[1]) {
                    case "+" :
                        wynik = (Double.parseDouble(wyraz[0]) + Double.parseDouble(wyraz[2]));
                        break;
                    case "-" :
                        wynik = (Double.parseDouble(wyraz[0]) - Double.parseDouble(wyraz[2]));
                        break;
                    case "*" :
                        wynik = (Double.parseDouble(wyraz[0]) * Double.parseDouble(wyraz[2]));
                        break;
                    case "/" :
                        wynik = (Double.parseDouble(wyraz[0]) / Double.parseDouble(wyraz[2]));
                        break;
                    default:
                        System.out.println("nieznana operacja");

                }
                System.out.println(wyraz[0] + " " + wyraz[1] + " " + wyraz[2] + " = " + wynik);
                i++;

                WriteToFileLine(file2, wyraz, wynik);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
