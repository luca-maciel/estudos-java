import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

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
                System.out.println(member);
            }
        }

    }

    void addMember(People newMember){
        this.members.add(newMember);
    }

}

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void Menu(){

        System.out.println("Hello! What you wanna do?\n[1] - See all group members");
    }

    public static void main(String[] args) {
        Group testGroup = new Group("Test group");
        int chose = 99;
        while (chose != 0){
            Main.Menu();
            chose = input.nextInt();
            if (chose == 1){
                testGroup.showMembers();
            }
        }

    }
}