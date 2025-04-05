class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class Record1 {
    Student head;

    Record1() {
        head = null;
    }

    void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newStudent;
    }

    void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position == 0) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of range");
                return;
            }
            current = current.next;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    void deleteByRollNumber(int rollNumber) {
        Student current = head;
        if (current != null && current.rollNumber == rollNumber) {
            head = current.next;
            return;
        }
        Student prev = null;
        while (current != null && current.rollNumber != rollNumber) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Student not found");
            return;
        }
        prev.next = current.next;
    }

    Student searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    void updateGrade(int rollNumber, String newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        } else {
            System.out.println("Student not found");
        }
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No records available");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Record1 recordManager = new Record1();

        recordManager.addAtBeginning(1, "Harshi", 20, "B");
        recordManager.addAtEnd(2, "Hari", 22, "A");
        recordManager.addAtPosition(1, 3, "Ram", 21, "B+");

        System.out.println("All Student Records:");
        recordManager.displayAll();

        Student student = recordManager.searchByRollNumber(2);
        if (student != null) {
            System.out.println("Found: " + student.name + ", Grade: " + student.grade);
        } else {
            System.out.println("Student not found");
        }

        recordManager.updateGrade(2, "A+");

        System.out.println("\nUpdated Student Records:");
        recordManager.displayAll();

        recordManager.deleteByRollNumber(1);

        System.out.println("\nStudent Records After Deletion:");
        recordManager.displayAll();
    }
}