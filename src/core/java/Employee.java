package core.java;

/**
 *
 * @author eric
 */
public class Employee implements Measurable, Comparable<Employee>{
    
    private String name;
    private double salary;
    
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public double getMeasure(){
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", salary=" + salary + '}';
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.getSalary());
    }    
}
