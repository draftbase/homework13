package task1;

import java.io.*;

public class Pliki {
    public static void main(String[] args) {
        File plik = new File("Dane.txt");
        Employee[] employees = new Employee[4];
        int[] empAll = new int[3];

        double salaryAvg = 0;
        try (
             FileReader fileReader = new FileReader(plik);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             ) {

            readFile(employees, bufferedReader);
            countEmployee(employees,empAll);

            System.out.println("Srednia wyplata: " + calcAvg(employees));
            System.out.println("Najmniejsza wypłata: " + salaryMin(employees));
            System.out.println("Największa wypłata: " + salaryMax(employees));
            System.out.println("Łączna liczba pracowników: " + employees.length);
            System.out.println("Liczba pracowników w dziale IT: " + empAll[0]);
            System.out.println("Liczba pracowników w dziale Management: " + empAll[2]);
            System.out.println("Liczba pracowników w dziale Support: " + empAll[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static int salaryMin(Employee[] employees) {
        int salaryMin = 0;
        for(int i = 0; i<employees.length; i++) {
            if (salaryMin == 0 || salaryMin > Integer.parseInt(employees[i].getSalary())) {
                salaryMin = Integer.parseInt(employees[i].getSalary());
            }
        }
        return salaryMin;
    }

    private static int salaryMax(Employee[] employees) {
        int salaryMax = 0;
        for(int i = 0; i<employees.length; i++) {
            if (salaryMax == 0 || salaryMax < Integer.parseInt(employees[i].getSalary())) {
                salaryMax = Integer.parseInt(employees[i].getSalary());
            }
        }
        return salaryMax;
    }

    private static void countEmployee(Employee[] employees, int[] empAll) {
        for (int i = 0; i<employees.length; i++){
            switch (employees[i].getDep()) {
                case "it" :
                    //employeeIT += 1;
                    empAll[0] += 1;
                    break;
                case "Support" :
                    empAll[1] += 1;
                    break;
                case "Management" :
                    empAll[2] += 1;
                    break;
            }
        }
    }

    private static double calcAvg(Employee[] employees) {
        double sum = 0;
        int i = 0;
        for(int j = 0; j<employees.length; j++){
            sum += Double.parseDouble(employees[j].getSalary());
        }
        sum /= employees.length;
        return sum;
    }

    private static void readFile(Employee[] employees, BufferedReader bufferedReader) throws IOException {
        String line= null;
        String[] wyraz = null;
        int i = 0;
        while((line= bufferedReader.readLine()) != null) {
            wyraz = line.split(";");
            employees[i] = new Employee(wyraz[0],wyraz[1],wyraz[2],wyraz[3],wyraz[4]);
            i++;
        }
    }
}
