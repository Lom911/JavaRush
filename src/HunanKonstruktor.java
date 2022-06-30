public class HunanKonstruktor {



    public static class Human {
        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human () {
            System.out.println("gthdsq");
        }

        public Human (byte age, String name, String secondName, String favoriteSport) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
            this.favoriteSport = favoriteSport;
            String str = String.format("%d %s %s %s", age, name, secondName, favoriteSport);
            System.out.println(str);

        }

        public Human (byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }

    }
    public static void main(String[] args) {
        Human ivan = new Human();
        Human sergey = new Human((byte) 25, "Sergey", "Nemchinov", "Sport");
        Human andrey = new Human((byte) 34, "Andrey", "Kulek");
        System.out.println(andrey.name + sergey.secondName + ivan.age);
    }

} // конец
