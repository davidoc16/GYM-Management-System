/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymsystem;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 *
 * @author David
 */
public class GymScreen extends JFrame implements ActionListener {

    JMenu fileMenu, memberMenu, employeeMenu, equipmentMenu, fitnessClassMenu, classMenu;
    ArrayList<Member> memList;
    ArrayList<Employee> empList;
    ArrayList<Equipment> equipList;
    ArrayList<FitnessClasses> fitClassList;
    ArrayList<MemberClass> classList;
    JTextArea area;

    boolean valid;
    String searchName;
    int age, phone, classCapacity;
    double memPrice, equipmentSize, price, duration;
    char gender;
    int noOfClasses;
    boolean found = false;

    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 300;
    private static final int FRAME_X_ORIGIN = 250;
    private static final int FRAME_Y_ORIGIN = 200;

    private JLabel response;

    public static void main(String args[]) throws IOException {
        GymScreen win = new GymScreen();
        win.setVisible(true);
    }

    /**
     * Creates a new instance of <code> GymScreen </code>.
     */
    public GymScreen() {
        Container contentPane;

        //Setting the Frame Properties
        setTitle("O' Connor's GYM");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        /**
         * Creating menus and their menu items Adding the menu&menuItems to the
         * menu bar
         */
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        createFileMenu();
        bar.add(fileMenu);
        createMemberMenu();
        bar.add(memberMenu);
        createEmployeeMenu();
        bar.add(employeeMenu);
        createEquipmentMenu();
        bar.add(equipmentMenu);
        createFitnessClassMenu();
        bar.add(fitnessClassMenu);
        createClassMenu();
        bar.add(classMenu);

        memList = new ArrayList<Member>();
        empList = new ArrayList<Employee>();
        equipList = new ArrayList<Equipment>();
        fitClassList = new ArrayList<FitnessClasses>();
        classList = new ArrayList<MemberClass>();
        area = new JTextArea();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createFileMenu() {
        fileMenu = new JMenu("File");
        JMenuItem item = new JMenuItem("Load All Data");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Save All Data");
        item.addActionListener(this);
        fileMenu.add(item);

        fileMenu.addSeparator(); //ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); //EXITS THE PROGRAM
        item.addActionListener(this);
        fileMenu.add(item);

    }

    private void createMemberMenu() {
        memberMenu = new JMenu("Member");
        JMenuItem item = new JMenuItem("Add a New Member");
        item.addActionListener(this);
        memberMenu.add(item);
        
        item = new JMenuItem("Remove Member");
        item.addActionListener(this);
        memberMenu.add(item);

        item = new JMenuItem("Display All Members");
        item.addActionListener(this);
        memberMenu.add(item);

        item = new JMenuItem("Search a Member");
        item.addActionListener(this);
        memberMenu.add(item);

        item = new JMenuItem("Sort Members by Name");
        item.addActionListener(this);
        memberMenu.add(item);

        memberMenu.addSeparator(); //ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); //EXITS THE PROGRAM
        item.addActionListener(this);
        memberMenu.add(item);

    }

    private void createEmployeeMenu() {
        employeeMenu = new JMenu("Employee");
        JMenuItem item = new JMenuItem("Add a New Employee");
        item.addActionListener(this);
        employeeMenu.add(item);

        item = new JMenuItem("Remove Employee");
        item.addActionListener(this);
        employeeMenu.add(item);

        item = new JMenuItem("Display All Employees");
        item.addActionListener(this);
        employeeMenu.add(item);

        item = new JMenuItem("Search an Employee");
        item.addActionListener(this);
        employeeMenu.add(item);

        item = new JMenuItem("Sort Employees by Name");
        item.addActionListener(this);
        employeeMenu.add(item);

        employeeMenu.addSeparator(); //ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); //EXITS THE PROGRAM
        item.addActionListener(this);
        employeeMenu.add(item);

    }

    private void createEquipmentMenu() {
        equipmentMenu = new JMenu("Equipment");
        JMenuItem item = new JMenuItem("Add New Equipment");
        item.addActionListener(this);
        equipmentMenu.add(item);
        
        item = new JMenuItem("Remove Equipment");
        item.addActionListener(this);
        equipmentMenu.add(item);

        item = new JMenuItem("Display All Equipment");
        item.addActionListener(this);
        equipmentMenu.add(item);

        item = new JMenuItem("Search Equipment");
        item.addActionListener(this);
        equipmentMenu.add(item);

        item = new JMenuItem("Sort Equipment by Name");
        item.addActionListener(this);
        equipmentMenu.add(item);

        equipmentMenu.addSeparator(); //ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); //EXITS THE PROGRAM
        item.addActionListener(this);
        equipmentMenu.add(item);
    }

    private void createFitnessClassMenu() {
        fitnessClassMenu = new JMenu("Fitness Class");
        JMenuItem item = new JMenuItem("Add a New Class");
        item.addActionListener(this);
        fitnessClassMenu.add(item);
        
        item = new JMenuItem("Remove Fitness Class");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        item = new JMenuItem("Display All Classes");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        item = new JMenuItem("Search a Class");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        item = new JMenuItem("Sort Classes by Name");
        item.addActionListener(this);
        fitnessClassMenu.add(item);

        fitnessClassMenu.addSeparator(); //ADDS A HORIZONTAL SEPARATOR LINE

        item = new JMenuItem("Exit"); //EXITS THE PROGRAM
        item.addActionListener(this);
        fitnessClassMenu.add(item);

    }

    private void createClassMenu() {
        classMenu = new JMenu("Class");
        JMenuItem item = new JMenuItem("Add a Member to Class");
        item.addActionListener(this);
        classMenu.add(item);

        item = new JMenuItem("Display All Class Members");
        item.addActionListener(this);
        classMenu.add(item);
    }

    public void loadAllData() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("gymSystem.data"));
            memList = (ArrayList<Member>) is.readObject();
            empList = (ArrayList<Employee>) is.readObject();
            equipList = (ArrayList<Equipment>) is.readObject();
            fitClassList = (ArrayList<FitnessClasses>) is.readObject();
            classList = (ArrayList<MemberClass>) is.readObject();
            is.close();
            JOptionPane.showMessageDialog(null, "Data loaded");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Load Aborted");
            e.printStackTrace();
        }
    }

    public void saveAllData() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("gymSystem.data"));
            os.writeObject(memList);
            os.writeObject(empList);
            os.writeObject(equipList);
            os.writeObject(fitClassList);
            os.writeObject(classList);
            os.close();
            JOptionPane.showMessageDialog(null, "Data Saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Save Aborted");
            e.printStackTrace();
        }
    }

    public void addMember() {
        // Ask for the Member's Name
        String name = JOptionPane.showInputDialog(null, "Please enter new members name");

        do {
            valid = false;
            // Ask for Member's Age
            String ageAsString = JOptionPane.showInputDialog(null, "Please Enter Member age");

            try {

                age = Integer.parseInt(ageAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + ageAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);
        // Ask for Member's gender
        gender = JOptionPane.showInputDialog(null, "Enter gender:").charAt(0);

        String address = JOptionPane.showInputDialog(null, "Please Enter Members address");

        do {
            valid = false;
            // Ask for Member's Phone Number
            String phoneNoAsString = JOptionPane.showInputDialog(null, "Please Enter Members phone number");

            try {
                phone = Integer.parseInt(phoneNoAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + phoneNoAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch

        } while (!valid);
        // Ask for Member's Email Address
        String email = JOptionPane.showInputDialog(null, "Please enter new members email address");
        // Ask for Membership Type
        String memType = JOptionPane.showInputDialog(null, "Please enter Membership Type");
        do {
            valid = false;
            // Ask for Membership Price
            String memPriceAsString = JOptionPane.showInputDialog(null, "Please enter Membership Price");
            try {
                memPrice = Double.parseDouble(memPriceAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + memPriceAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);
        // Ask for Membership Start Date
        String startDate = JOptionPane.showInputDialog(null, "Please enter Membership Start Date in format dd//mm/yyyy");
        // Ask for Membership Finish Date
        String finishDate = JOptionPane.showInputDialog(null, "Please enter Membership Finish Date in format dd//mm/yyyy");

        memList.add(new Member(name, age, gender, address, phone, email, memType, memPrice, startDate, finishDate));

    }
    
    public void removeMember(){
        String removeName = JOptionPane.showInputDialog(null, "Please enter the Member's name you wish to remove");
        
        for (int i = 0; i < memList.size(); i++) {
            if (removeName.equals(memList.get(i).getName())) {
                memList.remove(i);
                JOptionPane.showMessageDialog(null, removeName + " has been removed from the Members List"); 
            }
        }        
    }

    public void displayMember() {
        area.setText("Member List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (Member m : memList) {
            area.append(m.toString() + "\n");
        }
        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void searchMember() {
        searchName = JOptionPane.showInputDialog("Please enter the members name that you are looking for: \n");
        for (int i = 0; i < memList.size(); i++) {
            if (searchName.equals(memList.get(i).getName())) {
                System.out.println("Found!" + memList.get(i).getName());
                found = true;
                System.out.println("Details: " + "Member ID: " + memList.get(i).getMemberID() + "\nMember's Name: " + memList.get(i).getName() + "\nMember's Age: " + memList.get(i).getAge() + "\nMember's Gender: " + memList.get(i).getGender()
                        + "\nMember's Address: " + memList.get(i).getMemberAddress() + "\nMember's Phone Number: " + memList.get(i).getMemberPhoneNo() + "\nMember's Email Address: " + memList.get(i).getMemberEmail() + "\nMembership Type: " + memList.get(i).getMemberType()
                        + "\nMembership Price: " + memList.get(i).getMembershipPrice() + "\nMembership Start Date: " + memList.get(i).getStartDate() + "\nMembership Finish Date: " + memList.get(i).getFinishDate());
            }
        }
        if (!found) {
            System.out.printf(searchName + " is not in your list of Members");
        }
    }

    public void sortMember() {
        Set<Member> sortMember = new TreeSet<Member>(new CompareNames());
        sortMember.addAll(memList);
        System.out.println("\nSorted by name\n" + sortMember);
    }

    public void addEmployee() {
        String name = JOptionPane.showInputDialog(null, "Please enter new employees name");

        do {
            valid = false;
            String ageAsString = JOptionPane.showInputDialog(null, "Please Enter Employees age");

            try {

                age = Integer.parseInt(ageAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + ageAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);

        gender = JOptionPane.showInputDialog(null, "Enter gender:").charAt(0);

        String Address = JOptionPane.showInputDialog(null, "Please Enter Employees address");

        do {
            valid = false;
            String phoneNoAsString = JOptionPane.showInputDialog(null, "Please Enter Employees phone number");

            try {
                phone = Integer.parseInt(phoneNoAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + phoneNoAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch

        } while (!valid);

        empList.add(new Employee(name, age, gender, Address, phone));
    }

    public void removeEmployee() {
        String removeName = JOptionPane.showInputDialog(null, "Please enter employees name you wish to remove");
        
        for (int i = 0; i < empList.size(); i++) {
            if (removeName.equals(empList.get(i).getName())) {
                empList.remove(i);
                JOptionPane.showMessageDialog(null, removeName + " has been removed from the Employees List");
            }
        }
    }

    public void displayEmployee() {
        area.setText("Employee List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (Employee e : empList) {
            area.append(e.toString() + "\n");
        }
        
        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void searchEmployee() {
        searchName = JOptionPane.showInputDialog("Please enter the employees name that you are looking for: \n");
        for (int i = 0; i < empList.size(); i++) {
            if (searchName.equals(empList.get(i).getName())) {
                System.out.println("Found!" + empList.get(i).getName());
                found = true;
                System.out.println("Details: " + "Employee ID: "
                        + empList.get(i).getEmployeeID() + "\nEmployee's Name: "
                        + empList.get(i).getName() + "\nEmployee's Age: "
                        + empList.get(i).getAge() + "\nEmployee's Gender: "
                        + empList.get(i).getGender()
                        + "\nEmployee's Address: "
                        + empList.get(i).getEmployeeAddress()
                        + "\nEmployee's Phone Number: "
                        + empList.get(i).getEmployeePhoneNo());
            }
        }
    }

    public void sortEmployee() {
        Set<Employee> sortEmployee = new TreeSet<Employee>(new CompareNames());
        sortEmployee.addAll(empList);
        System.out.println("\nSorted by name\n" + sortEmployee);
    }

    public void addEquipment() {
        String name = JOptionPane.showInputDialog(null, "Please enter name of new Equipment");
        String description = JOptionPane.showInputDialog(null, "Please enter a description of Equipment");

        do {
            valid = false;
            String equipmentSizeAsString = JOptionPane.showInputDialog(null, "Please Enter Equipment Size");

            try {

                equipmentSize = (double) Double.parseDouble(equipmentSizeAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + equipmentSizeAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);

        equipList.add(new Equipment(name, description, equipmentSize));
    }
    
    public void removeEquipment(){
        String removeEquipment = JOptionPane.showInputDialog(null, "Please enter the Equipment you wish to remove");
        
        for (int i = 0; i < equipList.size(); i++) {
            if (removeEquipment.equals(equipList.get(i).getEquipmentName())) {
                equipList.remove(i); 
                JOptionPane.showMessageDialog(null, removeEquipment + " has been removed from the Equipment List");
            }
        } 
    }

    public void displayEquipment() {
        area.setText("Equipment List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (Equipment e : equipList) {
            area.append(e.toString() + "\n");
        }
        
        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void searchEquipment() {
        searchName = JOptionPane.showInputDialog("Please enter the equipment name that you are looking for: \n");
        for (int i = 0; i < equipList.size(); i++) {
            if (searchName.equals(equipList.get(i).getEquipmentName())) {
                System.out.println("Found!" + equipList.get(i).getEquipmentName());
                found = true;
                System.out.println("Details: " + "Equipment Name: " + equipList.get(i).getEquipmentName() + "\nEquipment Description: " + equipList.get(i).getEquipmentDescription()
                        + "\nEquipment Size: " + equipList.get(i).getEquipmentSize());
            }
        }
    }

    public void sortEquipment() {
        JOptionPane.showMessageDialog(null, "Sorting Equipment by Name Not Implemented Yet");
        /*Set<Equipment> sortEquipment = new TreeSet<Equipment>(new CompareNames());
        sortEquipment.addAll(equipList);
        System.out.println("\nSorted by name\n" + sortEquipment);*/
    }

    public void addClass() {
        String className = JOptionPane.showInputDialog(null, "Please enter new fitness class name");
        String activity = JOptionPane.showInputDialog(null, "Please enter activity");

        do {
            valid = false;
            String classCapacityAsString = JOptionPane.showInputDialog(null, "Please enter class capacity");

            try {

                classCapacity = (int) Integer.parseInt(classCapacityAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + classCapacityAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);

        do {
            valid = false;
            String priceAsString = JOptionPane.showInputDialog(null, "Please enter class price");

            try {

                price = (double) Double.parseDouble(priceAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + priceAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);
        do {
            valid = false;
            String durationAsString = JOptionPane.showInputDialog(null, "Please enter class duration");

            try {

                duration = (double) Double.parseDouble(durationAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + durationAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);

        do {
            valid = false;
            String numberOfClassesAsString = JOptionPane.showInputDialog(null, "Please enter number of classes");

            try {

                noOfClasses = (int) Integer.parseInt(numberOfClassesAsString);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "'" + numberOfClassesAsString + "' is invalid\n"
                        + "Please enter digits only");
            } // end catch
        } while (!valid);

        fitClassList.add(new FitnessClasses(className, activity, classCapacity, price, duration, noOfClasses));
    }
    
    public void removeClass(){
         String removeClass = JOptionPane.showInputDialog(null, "Please enter the Class name you wish to remove");
        
        for (int i = 0; i < fitClassList.size(); i++) {
            if (removeClass.equals(fitClassList.get(i).getClassName())) {
                fitClassList.remove(i);
                JOptionPane.showMessageDialog(null, removeClass + " has been removed from the Class List");
            }
        }
        
    }

    public void displayClass() {
        area.setText("Fitness Classes List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (FitnessClasses c : fitClassList) {
            area.append(c.toString() + "\n");
        }
        
        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void searchClass() {
        searchName = JOptionPane.showInputDialog("Please enter the class name that you are looking for: \n");
        for (int i = 0; i < fitClassList.size(); i++) {
            if (searchName.equals(fitClassList.get(i).getClassName())) {
                System.out.println("Found!" + fitClassList.get(i).getClassName());
                found = true;
                System.out.println("Details: " + "Class Name: " + fitClassList.get(i).getClassName() + "\nClass Capacity: " + fitClassList.get(i).getClassCapacity() + "\nClass Places Taken: " + fitClassList.get(i).getPlacesTaken()
                        + "\nClass Activity: " + fitClassList.get(i).getActivity() + "\nClass Price: " + fitClassList.get(i).getPrice() + "\nClass Duration: " + fitClassList.get(i).getDuration() + "\nNumber of Classes: " + fitClassList.get(i).getNumberOfClasses());
            }
        }
    }

    public void sortClass() {
        JOptionPane.showMessageDialog(null, "Sorting Classes by Name Not Implemented Yet");
    }

    public void memberToClass() {
        // pick a member
        int memIdx = Integer.parseInt(JOptionPane.showInputDialog("Enter a member number "
                + " between 1 and " + memList.size()));
        // pick a class
        int classIdx = Integer.parseInt(JOptionPane.showInputDialog("Enter a class number "
                + " between 1 and " + fitClassList.size()));

        // create a new rental object
        MemberClass member = new MemberClass(memList.get(memIdx - 1),
                fitClassList.get(classIdx - 1));
        fitClassList.get(classIdx - 1).takeClass();
        member.setDate("Thursday");
        member.setRate(7.50);
        // add the member to the class list
        classList.add(member);
    }

    public void displayClassMembers() {
                // note that this gives a very poor display layout
        // instead of using r.toString(), a better-organised display would be needed  
        area.setText("Class List\n");
        // adding scrollbar
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (MemberClass r : classList) {
            area.append(r.toString());
            if (r.getMClass() instanceof GameClass) {
                area.append(" for Class Name: " + ((GameClass) (r.getMClass())).getClassName() + "\n\n");
            }
        }
        // setting scrollbar dimension
        scroll.setPreferredSize(new Dimension(500, 500));
        JOptionPane.showMessageDialog(null, scroll);
    }

    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        if (c.equalsIgnoreCase("Load All Data")) {
            loadAllData();
        } else if (c.equalsIgnoreCase("Save All Data")) {
            saveAllData();
        } else if (c.equalsIgnoreCase("Add a New Member")) {
            addMember();
        } else if (c.equalsIgnoreCase("Remove Member")) {
            removeMember(); 
        }else if (c.equalsIgnoreCase("Display All Members")) {
            displayMember();
        } else if (c.equalsIgnoreCase("Search a Member")) {
            searchMember();
        } else if (c.equalsIgnoreCase("Sort Members by Name")) {
            sortMember();
        } else if (c.equalsIgnoreCase("Add a New Employee")) {
            addEmployee();
        } else if (c.equalsIgnoreCase("Remove Employee")) {
            removeEmployee();
        } else if (c.equalsIgnoreCase("Display All Employees")) {
            displayEmployee();
        } else if (c.equalsIgnoreCase("Search an Employee")) {
            searchEmployee();
        } else if (c.equalsIgnoreCase("Sort Employees by Name")) {
            sortEmployee();
        } else if (c.equalsIgnoreCase("Add New Equipment")) {
            addEquipment();
        } else if (c.equalsIgnoreCase("Remove Equipment")) {
            removeEquipment();
        } else if (c.equalsIgnoreCase("Display All Equipment")) {
            displayEquipment();
        } else if (c.equalsIgnoreCase("Search Equipment")) {
            searchEquipment();
        } else if (c.equalsIgnoreCase("Sort Equipment by Name")) {
            sortEquipment();
        } else if (c.equalsIgnoreCase("Add a New Class")) {
            addClass();
        } else if (c.equalsIgnoreCase("Remove Fitness Class")) {
            removeClass();
        } else if (c.equalsIgnoreCase("Display All Classes")) {
            displayClass();
        } else if (c.equalsIgnoreCase("Search a Class")) {
            searchClass();
        } else if (c.equalsIgnoreCase("Sort Classes by Name")) {
            sortClass();
        } else if (c.equalsIgnoreCase("Add a Member to Class")) {
            memberToClass();
        } else if (c.equalsIgnoreCase("Display All Class Members")) {
            displayClassMembers();
        } else {
            System.exit(0);
        }

    }
}
