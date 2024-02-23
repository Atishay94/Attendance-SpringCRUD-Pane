package attenndancem_spring;

import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.dao.TeacherDao;
import spring.dto.Teacher;

public class AttenndanceM_Spring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("TeacherSpringXML.xml");
        TeacherDao teacherDao = (TeacherDao)context.getBean("Guru");
        
        JOptionPane.showMessageDialog(null, " -----------------Index--------------------"
                + "\n\n Press Enter and see Options");
        
         byte choice = Byte.parseByte(JOptionPane.showInputDialog("1)/t Insert Data ! \n"
                + "2) Search Record ! \n"
                 + "3) Show All Records !\n"
                 + " 4) Update Record ! \n"
                 + " 5) Delect Record ! \n"
                 + "\n6) exit ! \n"
                 + "Only Choose out in given Numbers !!"));
         
         switch(choice){
             case 1:
                 String name =  JOptionPane.showInputDialog("Enter Student Name");
                 String rollNo =  JOptionPane.showInputDialog("Enter Student Roll/Enrollment Number");
                 String className =  JOptionPane.showInputDialog("Enter Student Branch/Class");
                 String status =  JOptionPane.showInputDialog("Enter Student Status (Present ->\t P or\n Absent ->\n A)");
                 Teacher teach = new Teacher(rollNo, name, className, status);
                 teacherDao.InsertRecord(teach);
                 break;
                 
             case 2:
                 String rollNo1 = JOptionPane.showInputDialog("Enter Student Roll/ Enrollment Number");
                 Teacher teach2 = new Teacher();
                 teach2.setRollNo(rollNo1);
                 teacherDao.searchRecord(teach2);
                 break;
//                 if(rollNo == null){
//                     JOptionPane.showMessageDialog(null, "no record found !");
//                 }else{
//                     teacherDao.showAllRecord();
//                 }
//                 teacherDao.showAllRecord();
//                 break;
                 
             case 3:
                 teacherDao.showAllRecord();
                 break;
                 
             case 4:
                  String rollNo2 = JOptionPane.showInputDialog("Enter Student Roll/ Enrollment Number");
                 Teacher teach3 = new Teacher();
                 teach3.setRollNo(rollNo2);
                 teacherDao.updateRecord(teach3);
                 break;
                 
             case 5:
                 String rollNo3 =  JOptionPane.showInputDialog("Enter Student Roll/Enrollment Number");
                  Teacher teach4 = new Teacher();
                 if(rollNo3 == teach4.getRollNo()){
                     
                 teacherDao.deleteRecord(teach4);
                 }
                 
                  case 6:
                      System.exit(0);
                 
         }
    }
    
}
