package task1;

public class Employee {
    //imię;nazwisko;pesel;dział;pensja
    private String firstName;
    private String lastName;
    private String pesel;
    private String dep;
    private String salary;

    public Employee(String firstName, String lastName, String pesel, String dep, String salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.dep = dep;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "task1.Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dep='" + dep + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
