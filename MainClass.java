
import java.util.Scanner;

public class MainClass {

    static Scanner scn = new Scanner(System.in);
    static Arraylist ar = new Arraylist();

    public static void main(String[] args) {

        System.out.println("\n\n\nThis is an implementation for Array List. ");
        System.out.println("Here, you have\n\t1. add(element)\n\t2. add(index, element)\n\t3. get(index)");
        System.out.println("\t4. set(index, element\n\t5. size()\n\t6. remove(element)\n\t7. remove(index)");
        System.out.println("\t8. contains(index)\n\t9. clear()\n\t10. sort()\n\t11. reverse()");
        System.out.println("\n\t12. Exit");

        System.out.print("Please enter your choice: ");
        int choice = scn.nextInt();
        scn.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter element to be added: ");
                Object element = scn.nextLine();
                ar.add(element);
                break;

            case 2:
                System.out.print("Enter index: ");
                int elementIndex = scn.nextInt();
                System.out.print("Enter element to be added: ");
                scn.nextLine();
                Object element1 = scn.nextLine();
                ar.add(elementIndex, element1);
                break;

            case 3:
                System.out.print("Enter index of an element: ");
                int elementIndex1 = scn.nextInt();
                Object element2 = ar.get(elementIndex1);
                System.out.println(element2);
                break;

            case 4:
                System.out.print("Enter index of an element: ");
                int elementIndex2 = scn.nextInt();
                System.out.print("Enter element to be set: ");
                scn.nextLine();
                Object element3 = scn.nextLine();
                ar.set(elementIndex2, element3);
                break;

            case 5:
                int size = ar.size();
                System.out.println("Size of arraylist: " + size);
                break;

            case 6:
                System.out.print("Enter element to be removed: ");
                Object element5 = scn.nextLine();
                ar.remove(element5);
                break;

            case 7:
                System.out.print("Enter index of an element to be removed: ");
                int elementIndex3 = scn.nextInt();
                ar.remove(elementIndex3);
                break;

            case 8:
                System.out.print("Enter element to be checked: ");
                Object element4 = scn.nextLine();
                boolean isContains = ar.contains(element4);
                if (isContains) {
                    System.out.println("Element " + element4 + " is present in the array");
                } else {
                    System.out.println("Element " + element4 + " is not present in the array");
                }
                break;

            case 9:
                ar.clear();
                break;

            case 10:
                ar.sort();
                break;

            case 11:
                ar.reverse();
                break;

            case 12:
                System.out.println("Exitting....");
                return;

            default:
                System.out.println("Invalid choice!!!");
        }
        main(args);

    }

}
