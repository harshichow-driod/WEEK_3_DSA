import java.util.*;

class UserNode {
    int userID;
    String name;
    int age;
    List<Integer> friendList;
    UserNode next;

    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendList = new ArrayList<>();
        this.next = null;
    }
}

public class Frnd7 {
    UserNode head = null;

    public void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
        System.out.println("User added successfully.");
    }

    public UserNode findUserById(int id) {
        UserNode current = head;
        while (current != null) {
            if (current.userID == id)
                return current;
            current = current.next;
        }
        return null;
    }

    public void addFriend(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 != null && user2 != null) {
            if (!user1.friendList.contains(id2))
                user1.friendList.add(id2);
            if (!user2.friendList.contains(id1))
                user2.friendList.add(id1);
            System.out.println("Friend connection added.");
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void removeFriend(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 != null && user2 != null) {
            user1.friendList.remove(Integer.valueOf(id2));
            user2.friendList.remove(Integer.valueOf(id1));
            System.out.println("Friend connection removed.");
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void displayFriends(int id) {
        UserNode user = findUserById(id);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": " + user.friendList);
        } else {
            System.out.println("User not found.");
        }
    }

    public void searchUser(String keyword) {
        UserNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(keyword) ||
                Integer.toString(current.userID).equals(keyword)) {
                System.out.println("User Found: " + current.name + " (ID: " + current.userID + ") Age: " + current.age);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("User not found.");
    }

    public void countFriends(int id) {
        UserNode user = findUserById(id);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendList.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void mutualFriends(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 != null && user2 != null) {
            List<Integer> mutual = new ArrayList<>();
            for (int friend : user1.friendList) {
                if (user2.friendList.contains(friend)) {
                    mutual.add(friend);
                }
            }
            System.out.println("Mutual Friends: " + mutual);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public static void main(String[] args) {
        Frnd7 sm = new Frnd7();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add User\n2. Add Friend\n3. Remove Friend\n4. Display Friends\n5. Search User\n6. Count Friends\n7. Find Mutual Friends\n8. Exit\nEnter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Age: ");
                    sm.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter User IDs to connect: ");
                    sm.addFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter User IDs to disconnect: ");
                    sm.removeFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    sm.displayFriends(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Name or ID: ");
                    sm.searchUser(sc.next());
                    break;
                case 6:
                    System.out.print("Enter User ID: ");
                    sm.countFriends(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter two User IDs: ");
                    sm.mutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);
        sc.close();
    }
}
