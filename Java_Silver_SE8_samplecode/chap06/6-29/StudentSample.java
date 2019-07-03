class Student {
    int no;
    String name;
    
    Student(int no, String name) { 
        this.no = no;
        this.name = name;
    }
    int getNo() {
        return no;
    }
    String getName() {
        return name;
    }
    void output() {
        System.out.println(no + " : " + name);
    }
}
class StudentSample {
    public static void main(String[] args) {
        Student s = new Student(100, "Test");
        s.output();
    }
}