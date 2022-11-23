import java.util.*;

class AttendanceRecord
{
    String name;
    double percentage;
    int periodsPresent,totalPeriods;
    HashMap<String,String> dayAttendance;

    public AttendanceRecord(String name)
    {
        this.name=name;
        percentage=0;
        periodsPresent=0;
        totalPeriods=0;
        dayAttendance=new HashMap<String,String>();
    }

    public void updateTodaysAttendance(String date, String dailyAttendance)
    {
        dayAttendance.put(date,dailyAttendance);
        for(int i=0;i<dailyAttendance.length();i++)
        {
            if(dailyAttendance.charAt(i)=='P')
            {
                periodsPresent++;
            }
            totalPeriods++;
        }
        percentage = ((double)periodsPresent/totalPeriods)*100;
        percentage = Math.round(percentage*100.0)/100.0; // rounds to two decimal places
    }

    public void displayRecord()
    {
        System.out.println("Name : "+name);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|    Date    | Period-1 | Period-2 | Period-3 | Period-4 | Period-5 |");
        System.out.println("---------------------------------------------------------------------");
        for(Map.Entry<String,String> e :  dayAttendance.entrySet())
        {
            System.out.print("| "+e.getKey()+" |");
            for(int i=0;i<e.getValue().length();i++)
            {
                System.out.print((e.getValue().charAt(i)=='P')?"  Present |":"  Absent  |");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Total Periods : "+totalPeriods);
        System.out.println("Periods Present : "+periodsPresent);
        System.out.println("Percentage : "+percentage);
        System.out.println("Remarks : "+((percentage>=75)?"Good":"In risk of detention"));
        System.out.println("********************************************************************************************");
    }
}

class AMS
{
    static Scanner sc=new Scanner(System.in);
    static int userChoice()
    {
        System.out.println("\n--------------------- M E N U ---------------------");
        System.out.println("1. Add new student to record");
        System.out.println("2. Update today's attendance");
        System.out.println("3. Display a student's attendance record");
        System.out.println("4. Display attendance statistics of all students"); 
        System.out.println("5. Delete existing student from record");
        System.out.println("6. Exit");
        System.out.println("--------------------- * * * * ---------------------\n");
        System.out.print("Enter opcode : ");
        return sc.nextInt();
    }

    public static void main(String[] args) 
    {
        HashMap<Integer,AttendanceRecord> register = new HashMap<Integer,AttendanceRecord>();
        int rno;
        while(true)
        {
            switch(userChoice())
            {
                case 1: 
                    System.out.print("\nEnter Roll Number : ");
                    rno=sc.nextInt();
                    if(register.containsKey(rno))
                    {
                        System.out.println("Roll number already exists");
                        System.out.println("\nOperation unsuccessful\n");
                    }
                    else
                    {
                        System.out.print("Enter Name : ");
                        String n =sc.nextLine();n =sc.nextLine();
                        AttendanceRecord ar=new AttendanceRecord(n);
                        register.put(rno, ar);
                        System.out.println("\nOperation Successful\n");
                    }
                    break;

                case 2: 
                    System.out.print("\nEnter Roll Number : ");
                    rno=sc.nextInt();
                    if(!register.containsKey(rno))
                    {
                        System.out.println("Roll number doesn't exist");
                        System.out.println("\nOperation unsuccessful\n");
                    }
                    else
                    {
                        System.out.println("Enter a string in which P->Present and A->Absent");
                        System.out.print("Enter Date (DD-MM-YYYY) : ");
                        sc.nextLine();String date=sc.nextLine();
                        System.out.print("Enter Attendance : ");
                        String p =sc.nextLine();
                        // sc.nextLine();
                        if(p.length()!=5)
                        {
                            System.out.println("Attendance should be provided for five periods");
                            System.out.println("\nOperation unsuccessful\n");
                        }
                        else
                        {
                            register.get(rno).updateTodaysAttendance(date,p);
                            System.out.println("\nOperation Successful\n");
                        }
                    }
                    break;

                case 3: 
                    System.out.print("\nEnter Roll Number : ");
                    rno=sc.nextInt();
                    if(!register.containsKey(rno))
                    {
                        System.out.println("Roll number doesn't exist");
                        System.out.println("\nOperation unsuccessful\n");
                    }
                    else
                    {
                        System.out.println("********************************************************************************************");
                        register.get(rno).displayRecord();
                        System.out.println("\nOperation Successful\n");
                    }
                    break;

                case 4: 
                    for(Map.Entry<Integer,AttendanceRecord> e : register.entrySet())
                    {
                        System.out.println("********************************************************************************************");
                        System.out.println("Roll Number : "+e.getKey());
                        register.get(e.getKey()).displayRecord();
                    }
                    System.out.println("\nOperation Successful\n");
                    break;
                case 5: 
                    System.out.print("\nEnter Roll Number : ");
                    rno=sc.nextInt();
                    if(!register.containsKey(rno))
                    {
                        System.out.println("Roll number doesn't exist");
                        System.out.println("\nOperation unsuccessful\n");
                    }
                    else
                    {
                        register.remove(rno);
                        System.out.println("\nOperation Successful\n");
                    }
                    break;
                case 6: 
                    System.out.print("Thank you!");
                    System.exit(0); 
                    break;
                default: 
                    System.out.print("Error!");
                    break;
            }
        }
    }
}