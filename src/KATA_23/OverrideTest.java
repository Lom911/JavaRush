package KATA_23;

public class OverrideTest {
    public static void main(String[] args) {
        Employee sam = new Employee("Sam", "Microsoft");
        sam.display();
        sam.work();
    }
}

        class Person {

            String name;

            public String getName() {
                return name;
            }
            public Person(String name) {

            this.name = name;
            }

            public void display(){

                System.out.println("Name: " + name);
            }
        }


        class Employee extends Person {
            String company;

            public Employee(String name, String company) {
                super(name);
                this.company = company;
            }

            public void work() {
                System.out.printf("%s works in %s \n", getName(), company);
            }
            @Override
            public void display(){
               super.display();
                System.out.printf("Works in %s \n", company);
            }
        }


