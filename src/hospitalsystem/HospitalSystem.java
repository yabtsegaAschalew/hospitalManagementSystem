package hospitalsystem;

import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String contactNumber;
    private String medicalHistory;

    // Constructor, getters, and setters
    public Patient(int id, String name, String gender, int age,   String contactNumber, String medicalHistory) {
        this.id = id;
        this.name = name;
        this.gender=gender;
        this.age=age;
        this.contactNumber=contactNumber;
        this.medicalHistory = medicalHistory;
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getGender()
    {
        return gender;
    }
     public int getAge()
    {
        return age;
    }
      public String getcontactNumber()
    {
        return contactNumber;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }
}
   
   
class Doctor {

    private int id;
    private String name;
    private String gender;
    private String specialty;
    private String contactNumber;
    private ArrayList<Patient> patients;

    // Constructor, getters, and setters
     public Doctor(int id, String name, String gender,String contactNumber, String specialty) {
        this.id = id;
        this.name = name;
        this.gender=gender;
        this.contactNumber=contactNumber;
        this.specialty = specialty;
        
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

     public String getContactNumber() {
        return contactNumber;
    }
     
    public String getSpecialty() {
        return specialty;
    }

   
}

class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private String date;
    private String time;
    private String status;

    // Constructor, getters, and setters
    public Appointment(int id, int patientId, int doctorId, String date, String time, String status)
    {
        this.id=id;
        this.patientId=patientId;
        this.doctorId=doctorId;
        this.date=date;
        this.time=time;
        this.status=status;
    }

    
    public int getId() {
        return id;
    }


    public int getPatientId() {
        return patientId;
    }

    
    public int getDoctorId() {
        return doctorId;
    }

    
    public String getDate() {
        return date;
    }

    
    public String getTime() {
        return time;
    }

    
    public String getStatus() {
        return status;
    }
    
}


public class HospitalSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
   

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Hospital Management System");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Manage Departments");
            System.out.println("5. Exit \n");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    managePatients();
                    break;
                case 2:
                    manageDoctors();
                    break;
                case 3:
                    manageAppointments();
                    break;
                
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
private static void managePatients() {
        while (true) {
            System.out.println("Hospital Management System - Manage Patients");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Return to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addPatient() {
        System.out.print("Enter patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.println("Enter patient gender: ");
        String gender=scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age=scanner.nextInt();
        System.out.print("Enter patient contact number: ");
        String contactNumber=scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter patient medical history: ");
        String medicalHistory = scanner.nextLine();
       

        Patient patient = new Patient(id, name,gender,age,contactNumber, medicalHistory);
        patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("Patients:");
            for (Patient patient : patients) {
                 System.out.println("ID: " + patient.getId());
                System.out.println("Name: " + patient.getName());
                System.out.println("Medical History: " + patient.getMedicalHistory());
            }
        }
    }

    private static void searchPatient() {
        System.out.print("Enter patient ID to search: ");
        int id = scanner.nextInt();

        for (Patient patient : patients) {
            if (patient.getId() == id) {
                System.out.println("Patient found:");
                System.out.println("ID: " + patient.getId());
                System.out.println("Name: " + patient.getName());
                System.out.println("Medical History: " + patient.getMedicalHistory());
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    private static void manageDoctors() {
        // Implement doctor management functionalities
        while (true) {
            System.out.println("Hospital Management System - Manage Doctors");
            System.out.println("1. Add Doctors");
            System.out.println("2. View Doctors");
            System.out.println("3. Search Doctors");
            System.out.println("4. Return to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addDoctors();
                    break;
                case 2:
                    viewDoctors();
                    break;
                case 3:
                    searchDoctors();
                    break;
                case 4:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static void addDoctors() {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Doctor specialty: ");
        String specialty=scanner.nextLine();
        System.out.print("Enter Doctor contact number: ");
        String contactNumber=scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender=scanner.nextLine();
         Doctor doctor = new Doctor(id, name,gender,specialty,contactNumber);
        doctors.add(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("Doctors:");
            for (Doctor doctor:doctors) {
                System.out.println("ID: " + doctor.getId());
                System.out.println("Name: "+doctor.getName());
                System.out.println("specialty "+doctor.getSpecialty());
                System.out.println("Contact Number: "+doctor.getContactNumber());
                
            }
        }
    }

    private static void searchDoctors() {
        System.out.print("Enter Doctor ID to search: ");
        int id = scanner.nextInt();

        for (Doctor doctor:doctors) {
            if (doctor.getId() == id) {
                System.out.println("Doctor found: ");
                System.out.println("ID: "+doctor.getId());
                System.out.println("Name: "+doctor.getName());
                System.out.println("Specialty: "+doctor.getSpecialty());
                System.out.println("Contact Number: "+doctor.getContactNumber());
                return;
            }
        }

        System.out.println("Doctor not found.");
    }

    

    private static void manageAppointments() 
    {
        // Implement appointment management functionalities
        while(true){
            System.out.println("ARBAMINCH HOSPITAL -   manage Appointment ");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointment");
            System.out.println("3. Search Appointment");
            System.out.println("4. Return to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

          switch (option) {
                case 1:
                    addAppointment();
                    break;
                case 2:
                    viewAppointment();
                    break;
                case 3:
                    searchAppointment();
                    break;
                case 4:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        
        }
        
        
    }
     private static void addAppointment() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId=scanner.nextInt();
        System.out.print("Enter Time(HH-MM) : ");
        String time=scanner.next();
        scanner.nextLine();
        System.out.print("Enter Date(DD-MM-YYYY): ");
        String date=scanner.nextLine();
         System.out.print("Enter status: ");
         String status=scanner.nextLine();
         Appointment appointment = new Appointment(id, patientId,doctorId,date,time,status);
        appointments.add(appointment);
        System.out.println("Appointment added successfully!");
    }
     private static void viewAppointment() {
        if (appointments.isEmpty()) {
            System.out.println("No Appointment found.");
        } else {
            System.out.println("Appointments:");
            for (Appointment appointment:appointments) {
                System.out.println("ID: " + appointment.getId());
                System.out.println("Patient with ID number "+appointment.getPatientId()+"with Doctor ID number "+appointment.getDoctorId() );
                System.out.println("DATE: "+appointment.getDate());
                System.out.println("TIME:"+appointment.getTime());
                System.out.println("Appointment Status: "+appointment.getStatus());
                
            }
        }
    }

    private static void searchAppointment() {
        System.out.print("Enter Appoinment ID to search: ");
        int id = scanner.nextInt();

          for (Appointment appointment:appointments) {
              if(appointment.getId()==id){
                System.out.println("ID: " + appointment.getId());
                System.out.println("Patient with ID number "+appointment.getPatientId()+"with Doctor ID number "+appointment.getDoctorId() );
                System.out.println("DATE: "+appointment.getDate());
                System.out.println("TIME:"+appointment.getTime());
                System.out.println("Appointment Status: "+appointment.getStatus());
                return;
            }
        }

        System.out.println("NO APPOINTMENT!");
    }

}