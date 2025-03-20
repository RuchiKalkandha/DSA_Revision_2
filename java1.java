public class java1{
    static class Student{
        static String School = "IPS";
        String name;
    }
    public static void main(String args[]){
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name ="tutu";
        s1.School = "JPSC";
        System.out.print(s1.School);
        System.out.print(s2.School);

    }
}