import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

class People{
    String name;
    int age, id;
    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    void alterName(String newName){
        this.name = newName;
    }
    void alterAge(int newAge){
        this.age = newAge;
    }
}

class Group{
    int idCount = 1;
    String group_name;
    ArrayList<People> members = new ArrayList<>();
    public Group(String group_name){
        this.group_name = group_name;
    }

    void showMembers(){
        int pos=1;
        if (this.members.isEmpty()){
            JOptionPane.showMessageDialog(null, "This group is empty.");
            System.out.println("This group is empty.");
        }
        else{
            String membersString = "";
            for(People member : this.members){
                membersString += "ID: " + member.id + " Pos: " + pos + " - Name: " + member.name + " - Age: " + member.age + "\n";
                pos += 1;
            }
            JOptionPane.showMessageDialog(null, membersString);
        }

    }


    void addMember(People newMember){
        this.members.add(newMember);
    }

    void removeMember(People member){
        this.members.remove(member);
    }

}

class Main {
    static String menu = "What you wanna do?\n[1] - Show all members of the group\n[2] - Add new member to group\n[3] - Edit a member\n[4] - Delete a member\n[99] - Exit\n";
    static Scanner input = new Scanner(System.in);
    static String chose;
    static Group testGroup = new Group("Test group");
    public static void main(String[] args) {
        while (chose != "99"){
            chose = JOptionPane.showInputDialog(null, menu, "Menu", JOptionPane.QUESTION_MESSAGE);

            switch (Integer.parseInt(chose)){
                case 1:
                    testGroup.showMembers();
                    break;

                case 2:
                    String nameNewMember = JOptionPane.showInputDialog("Enter the name of the new member");
//                Usa o Integer.parseInt() para transformar a String em int
                    String newAge = JOptionPane.showInputDialog("Enter the age of the new member");
                    People newMember = new People(nameNewMember, Integer.parseInt(newAge));
                    newMember.id = testGroup.idCount;
                    testGroup.addMember(newMember);
                    testGroup.idCount += 1;
                    JOptionPane.showMessageDialog(null, nameNewMember + " was added to group");
                    break;

                case 3:
                    int option;
                    if (!testGroup.members.isEmpty()){
                        option = Integer.parseInt(JOptionPane.showInputDialog("Enter the position of the member that you want edit "));
                        People member = testGroup.members.get(option-1);
                        System.out.println(member.name);
                        option = Integer.parseInt(JOptionPane.showInputDialog("What information you wanna edit?\n[1] - Name\n[2] - Age"));
                        switch (option){
                            case 1:
                                String newName = JOptionPane.showInputDialog("Enter the new name for " + member.name);
                                member.alterName(newName);
                                JOptionPane.showMessageDialog(null, "Name edited.");
                                System.out.println("Name edited");
                                break;
                            case 2:
                                int age = Integer.parseInt(JOptionPane.showInputDialog("Enter the new age for " + member.name));
                                member.alterAge(age);
                                JOptionPane.showMessageDialog(null, "Age edited.");
                                System.out.println("Age edited.");
                                break;

                        }

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "This action is impossible to be executed because this group is empty.");
                    }
                    break;
                case 4:
                    if (testGroup.members.isEmpty()){
                        JOptionPane.showMessageDialog(null, "This action is impossible to be executed because this group is empty.");
                    }
                    else{
                        int optionDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter the position of the member that you wanna delete"));
                        JOptionPane.showMessageDialog(null, testGroup.members.get(optionDelete-1).name + " Deleted");
                        testGroup.members.remove(optionDelete-1);
                    }
                    break;

                case 99:
                    System.out.println("Finished");
                    System.exit(0);
                    break;
            }
        }

    }
}