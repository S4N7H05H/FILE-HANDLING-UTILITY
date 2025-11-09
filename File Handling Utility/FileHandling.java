import java.util.*;
import java.io.*;

public class FileHandling {
    public static void Write(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("**Successfully written to file " + filename);
        } catch (IOException e) {
            System.out.println("**Error while writing: " + e.getMessage());
        }
    }

    public static void Read(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("**Reading the file "+filename);
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
            System.out.println("----------------------------------------");
        } catch (FileNotFoundException e) {
            System.out.println("**File not found : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("**Error while reading: "+e.getMessage());
        }
        
    }
    
    public static void Append(String filename,String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("\n"+content);
            System.out.println("**Content appended Successfully to "+filename);
        } catch (IOException e) {
            System.out.println("**Error while appending: "+e.getMessage());
        }
    }

    public static void Delete(String filename) {
        File file = new File(filename);
        if(file.delete())
            System.out.println("**File deleted Successfully");
        else{
            System.out.println("**Error in deleting the file.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename,content;

        System.out.println(" ***FILE HANDLING UTILITY*** ");
        while (true) {
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Append to File");
            System.out.println("4. Delete File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Enter the filename (with extension) :");
                    filename = sc.nextLine();

                    System.out.print("Enter the content to write in the file :");
                    content = sc.nextLine();
                    Write(filename, content);
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.print("Enter the filename (with extension) : ");
                    filename = sc.nextLine();
                    Read(filename);
                }
                
                case 3 -> {
                    sc.nextLine();
                    System.out.print("Enter the filename (with extension) :");
                    filename = sc.nextLine();

                    System.out.print("Enter the content to append in the file :");
                    content = sc.nextLine();
                    Append(filename, content);
                }
                case 4 -> {
                    sc.nextLine();
                    System.out.print("Enter the file name to delete (with extension) :");
                    filename = sc.nextLine();
                    Delete(filename);
                }
                case 5 ->{
                    System.out.println("Exiting Program..");
                    System.out.println("--------------------------------------------");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("Enter the valid choice....");
            }
        }  
    }
}