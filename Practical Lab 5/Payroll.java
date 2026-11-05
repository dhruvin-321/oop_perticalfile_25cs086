abstract class Employee
{
    int id;
    String name;
    Employee(int id,String name)
    {
        this.id = id;
        this.name = name;
    }
    abstract public int monthlySalary();
}
class FullTime extends Employee
{
     
    int salary;
    FullTime(int salary,int id,String name)
    {
        super(id,name);
        this.salary=salary;
    }
    public int monthlySalary()
    {
        return salary;
    }
}
class PartTime extends Employee
{
    int hours;
    int rate;
    PartTime(int hours,int rate,String name,int id)
    {
        super(id, name);
        this.hours=hours;
        this.rate=rate;
    }
    public int monthlySalary()
    {
        return hours*rate;
    }
}
class Intern extends Employee
{
    int stipend;
    Intern(int stipend,String name,int id)
    {
        super(id, name);
        this.stipend=stipend;
    }
    public int monthlySalary()
    {
        return stipend;
    }
}
public class Payroll 
{
    public static void main(String[] args) {
        Employee[] employees={
            new FullTime(5000, 1, "ABC"),
            new PartTime(8, 100, "XYZ", 2),
            new Intern(2000, "PQR", 3)
        };
        for(Employee e:employees)
        {
            System.out.println(e.monthlySalary());
            if(e instanceof Intern)
            {
                System.out.println("interns dont have salary they have stipend");
            }
        }
    }    
}

