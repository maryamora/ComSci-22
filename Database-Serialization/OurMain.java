import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

/**
 * Created by Danielle98 on 10/13/2016.
 */
public class OurMain {
  
  private static final String FILE_NAME = "Data.ser";

    public static void main(String[] args){
        

      FileOutputStream fos = null;
      ObjectOutputStream oos = null;
      FileInputStream fis = null;
      ObjectInputStream ois= null;
      List<Student> students = new ArrayList<Student>();
      
      try{
        fis = new FileInputStream(FILE_NAME);
           ois = new ObjectInputStream(fis);
           try{
             if (ois.read() == -1){
               students = (List<Student>) ois.readObject();
             }
             ois.close();
           }catch (EOFException e){
          
           }catch (ClassNotFoundException ce) {
            // this might be thrown by ois.readObject()
            ce.printStackTrace();
        } 
          } catch (IOException e) {
            // standard file handling exception
            e.printStackTrace();
        }  

        System.out.println("\t\t\tMENU");
        System.out.println("1. Add a student\n2. Remove a student\n3. View data\n4. Save data and access previous data\n5. Exit");
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        s.nextLine();

        int flag = 1;

     do {
             if (choice == 1) {
             System.out.print("Enter Student Number: ");
             String sn = s.nextLine();

                 for (Student toCheck : students) {
                     if ((toCheck.getStudentNumber()).equals(sn)) {
                         System.out.println("A Student with the same student number already exist");
                         flag = 0;
                     }
                 }
             if(flag == 0){ break; }
             System.out.print("Enter First Name: ");
             String fn = s.nextLine();
             System.out.print("Enter Middle Initial: ");
             String mi = s.nextLine();
             System.out.print("Enter Last Name: ");
             String ln = s.nextLine();
             System.out.print("Enter Course: ");
             String course = s.nextLine();
             System.out.print("Enter year level: ");
             String tempyl = s.nextLine();
             int yl = Integer.parseInt(tempyl);
             System.out.print("Enter crush name: ");
             String cn = s.nextLine();
             System.out.print("Enter favorite course: ");
             String fc = s.nextLine();
             System.out.print("Your favorite course's description: ");
             String description = s.nextLine();


             Student bago = new Student(sn, fn, mi.charAt(0), ln, course, yl, cn, new Course(fc, description));
             students.add(bago);
             System.out.println("Done");
         } else if (choice == 2) {
             System.out.println("Enter Student Number of the Student you want to remove: ");
             String snRemoved = s.next();
             for (Student toBeRemoved : students) {
                 if (toBeRemoved.getStudentNumber().equals(snRemoved)) {
                     students.remove(toBeRemoved);
                     break;
                 }
             }
             System.out.println("Done");
         } else if (choice == 3) {
             int flager = 1;
             System.out.println("Enter Student Number of the Student you want to view: ");
             String snToView = s.next();
               for (Student toView : students) {
                 if ((toView.getStudentNumber()).equals(snToView)) {
                     System.out.println(String.format("Student Number: %s\nFirst Name: %s\nMiddle Initial: %c\nLast Name: %s\nCourse: %s\nYear Level: %d\nFavorite Course: %s\nCrush Name: %s\n",toView.getStudentNumber(),toView.getFirstName(),toView.getMiddleInitial(),toView.getLastName(),toView.getCourse(),toView.getYearLevel(),toView.getFavoriteCourse(),toView.getCrushName()));
                     flager = 0;
                 }
             }
             if(flager == 1){
                 System.out.println("Student is not enrolled or has been removed");
             }
             System.out.println("Done");
         } else if (choice == 4) {
           
           try{
           fos = new FileOutputStream(FILE_NAME);
           oos = new ObjectOutputStream(fos);
           oos.writeObject(students);
           oos.close();
           
           
           } catch (IOException e) {
            // standard file handling exception
            e.printStackTrace();
        }  finally {

            // make sure to close the files!
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         }

         System.out.println("Would you like to choose again?\n1. Add a student\n2. Remove a student\n3. View data\n4. Save data\n5. Exit");
         choice = s.nextInt();
     }while(choice != 5);

    }

}