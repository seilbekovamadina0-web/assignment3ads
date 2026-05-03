public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student other = (Student) obj;
        return id == other.id && age == other.age && name.equals(other.name);

    }

    @Override
    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", age = " + age + "}";
    }
}

