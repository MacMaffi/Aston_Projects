import java.util.ArrayList;
import java.util.Objects;

public class MyArrayList {
    public static void main(String[] args) {
        ArrayList<Employee> arrayList1 = new ArrayList<>();
        Employee emp1 = new Employee("Ivan", 30, 6.5);
        Employee emp2 = new Employee("Masha", 25, 3.6);
        Employee emp3 = new Employee("Oleg", 19, 1);
        Employee emp4 = new Employee("Elena", 23, 2.3);
        Employee emp5 = new Employee("Denis", 27, 5);
        Employee emp6 = new Employee("Alex", 18, 0.5);
        arrayList1.add(emp1);
        arrayList1.add(emp2);
        arrayList1.add(emp3);
        ArrayList<Employee> arrayList2 = new ArrayList<>();
        arrayList2.add(emp4);
        arrayList2.add(emp5);
        arrayList2.add(emp6);
        System.out.println(arrayList1.get(2));
        arrayList2.remove(emp6);
        arrayList1.addAll(arrayList2);
        System.out.println(arrayList1);
        System.out.println(arrayList1.size());
        Employee emp7 = new Employee("Denis", 27, 5);
        System.out.println(arrayList1.contains(emp7));
        bubbleSort(arrayList1);
    }

    public static void bubbleSort(ArrayList<Employee> aL){
        boolean isSorted = false;
        int n = aL.size();
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < n-1; i++){
                if(aL.get(i).compareTo(aL.get(i+1)) > 0){
                    Employee swap = aL.get(i);
                    aL.set(i, aL.get(i+1));
                    aL.set(i+1, swap);
                    isSorted = false;
                }
            }
            n--;
        }
        System.out.println(aL);
    }
}

class Employee implements Comparable<Employee>{
    String name;
    int age;
    double experience;

    public Employee(String name, int age, double experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }

    @Override
    public int compareTo(Employee e) {
        if (this.experience == e.experience){
            return 0;
        } else if (this.experience < e.experience){
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Double.compare(experience, employee.experience) == 0 && Objects.equals(name, employee.name);
    }
}