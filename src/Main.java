import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        System.out.println("My Hash Table");

        Random random = new Random();
        for(int i = 0; i < 100000; i++) {
            int randomId = random.nextInt(10000);
            String randomName = "KeyName" + i + "_" + random.nextInt(10000);

            MyTestingClass key = new MyTestingClass(randomId, randomName);

            int studentId = i + 1;
            String studentName = "Student" + i;
            int studentAge = 14 + random.nextInt(38);

            Student value = new Student(studentId, studentName, studentAge);
            table.put(key, value);
        }

        table.printBucketSizes();
        System.out.println("HashTable size: " + table.size());

        System.out.println();
        System.out.println("Testing Hash Table");

        MyHashTable<MyTestingClass, Student> smallTable = new MyHashTable<>();
        MyTestingClass key1 = new MyTestingClass(8, "M");
        MyTestingClass key2 = new MyTestingClass(23, "N");

        Student student1 = new Student(100, "Madina", 18);
        Student student2 = new Student(101, "Gulnaz", 19);

        smallTable.put(key1, student1);
        smallTable.put(key2, student2);

        System.out.println("Search by key1: " + smallTable.get(key1));
        System.out.println("Check student1: " + smallTable.contains(student1));
        System.out.println("Find key of student2: " + smallTable.getKey(student2));

        smallTable.remove(key1);

        System.out.println("Removed key1");
        System.out.println("Search key1 again: " + smallTable.get(key1));
        System.out.println("Size now: " + smallTable.size());

        System.out.println();
        System.out.println("BST Test");

        BST<Integer, Student> tree = new BST<>();

        tree.put(81, new Student(102, "Asel", 26));
        tree.put(18, new Student(103, "Nurasyl", 15));
        tree.put(16, new Student(104, "Dilnaz", 17));
        tree.put(44, new Student(105, "Dias", 19));
        tree.put(63, new Student(106, "Medina", 30));

        System.out.println("BST size: " + tree.size());
        System.out.println("Value for key 63: " + tree.get(63));

        System.out.println();
        System.out.println("In-order traversal: ");

        for(var elem: tree) {
            System.out.println("key is " + elem.getKey() + " and value is " + elem.getValue());
        }

        tree.delete(63);

        System.out.println();
        System.out.println("After deleting key 63:");
        System.out.println("BST size now: " + tree.size());

        for(var elem : tree) {
            System.out.println("Key: " + elem.getKey() + ", Value: " + elem.getValue());
        }
    }
}
