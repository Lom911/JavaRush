package Ucheba;

public class Human {
    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    //    public Human(String n){
//        name = n;
//    }
    private String name = "Kolya";
    protected String name2 = "Vasia";
    protected static int salary = 150;
    protected void work (){
        System.out.println("Rabotat");
    }
    public static void rest (){
        System.out.println("Otdihat");
    }
}

class Student extends Human{
    public static void main(String[] args) {
        Student st = new Student();
        System.out.println(st.getName());
        System.out.println(st.name2);
        System.out.println(Student.salary);
        st.work();
        Student.rest();
    }

}

class  Test{
    public static void main(String[] args) {
        Student str = new Student();
        Student.rest();

    }
}
