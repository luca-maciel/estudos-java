import java.util.ArrayList;
import java.util.Scanner;

class People{
    String name;
    int age;
    public People(String name, int age){
        this.name = name;
        this.age = age;
    }
}

class Group{
    String group_name;
    ArrayList<People> members = new ArrayList<>();

    public Group(String group_name){
        this.group_name = group_name;
    }

    void showMembers(){
        if (this.members.isEmpty()){
            System.out.println("This group is empty.");
        }
        else{
            for(People member : this.members){
                System.out.println(member.name);
            }
        }

    }

    void addMember(People newMember){
        this.members.add(newMember);
    }

    void removeMember(People member){
        this.members.remove(member);
    }

}

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void Menu(){
        System.out.println("Hello! What you wanna do?\n[1] - See all group members\n[2] - Add member to group\n[3] - Remove member from group");
    }

    public static void main(String[] args) {
        Group testGroup = new Group("Test group");
        int chose = 99;
        while (chose != 0){
            Main.Menu();
            chose = input.nextInt();
//            if (chose == 1){
//                testGroup.showMembers();
//            }
            switch (chose){
                case 1:
                    testGroup.showMembers();
                    break;
                case 2:
                    input.nextLine();
                    System.out.print("Enter the name of the new member: ");
                    String name = input.nextLine();
                    System.out.print("Enter the new member age: ");
                    int age = input.nextInt();
                    input.nextLine();
                    People newMember = new People(name, age);
                    testGroup.addMember(newMember);
                    break;
            }
        }

    }
}