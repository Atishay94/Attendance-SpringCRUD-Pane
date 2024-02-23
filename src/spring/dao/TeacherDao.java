package spring.dao;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import spring.dto.Teacher;

public class TeacherDao {

    private HibernateTemplate template;    //helper class that is used to simplify the data access code

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
//    public void InsertRecord(Teacher student){
//        template.execute(new HibernateCallback<Object>(){
//            @Override
//            public Object doInHibernate(Session sn) throws HibernateException, SQLException {
//                sn.save(student);
//                return null;
//            }
//            
//        });
//    }
    // --------> Use lambda expression

    public void InsertRecord(Teacher student) {
        template.execute((Session sn) -> {
            sn.save(student);
            return null;
        });
    }

    public void showAllRecord() {
        template.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session sn) throws HibernateException {
                Criteria crite = sn.createCriteria(Teacher.class);
                List<Teacher> uShow = crite.list();
                if (uShow == null) {
                    JOptionPane.showMessageDialog(null, "no Record found!");
                } else {
                    for (Teacher student2 : uShow) {
                        JOptionPane.showMessageDialog(null, "\n Student Name: \n" + student2.getName() + "\n Student Roll number is: \n" + student2.getRollNo());
//                  "\n Student Class name is: \n"+ student.getClassName() + "\n Status is:/t \n"+ student.getStatus()
                    }
                }
                return null;

            }
        });
    }

    public void searchRecord(Teacher student1) {
        template.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(org.hibernate.Session session) throws org.hibernate.HibernateException, SQLException {
                Teacher student = (Teacher) session.load(Teacher.class, student1.getRollNo());
                if (student == null) {
                    System.out.println("no record found !");
                } else {
                    JOptionPane.showMessageDialog(null, "Student Name: \n" + student.getName() + "\n Student Roll number is: \n" + student.getRollNo()
                            + "\n Student Class name is: \n" + student.getClassName() + "\n Status is:/t \n" + student.getStatus());
                }

                return null;
            }
        });
    }

    public void updateRecord(Teacher student) {
        template.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session sn) throws HibernateException, SQLException {
                Teacher teach = (Teacher) sn.load(Teacher.class, student.getRollNo());
                if (teach == null) {
                    System.out.println("no record found !");
                } else {
//                         JOptionPane.showMessageDialog(null, "Student Name: \n"+ student.getName() +"\n Student Roll number is: \n"+ student.getRollNo() +
//                        "\n Student Class name is: \n"+ student.getClassName() + "\n Status is:/t \n"+ student.getStatus());

                    byte choice = Byte.parseByte(JOptionPane.showInputDialog(" ----------- List for Update Data ---------------- \n\n "
                            + "1) Student Name ! \n"
                            + "2) Student Class Name !\n"
                            + " 3) Student Status ! \n"
                            + "\n6) exit ! \n"
                            + "Only Choose out in given Numbers !!"));

                            String rollNo = JOptionPane.showInputDialog("Enter Student Roll Number !");
                    switch (choice) {
                        case 1:
                            if (rollNo == student.getRollNo()) {
                                String name = JOptionPane.showInputDialog("Enter Student New name for updating");
                                teach.setName(name);
                            } else {
                                JOptionPane.showMessageDialog(null, "no data Found !");
                            }
                            break;

                        case 2:
                            //rollNo = JOptionPane.showInputDialog("Enter Student Roll Number !");
                            if (rollNo == student.getRollNo()) {
                                String className = JOptionPane.showInputDialog("Enter Student New Class Name for updating");
                                teach.setClassName(className);
                            } else {
                                JOptionPane.showMessageDialog(null, "no data Found !");
                            }
                            break;

                        case 3:
                            //rollNo = JOptionPane.showInputDialog("Enter Student Roll Number !");
                            if (rollNo == student.getRollNo()) {
                                String status = JOptionPane.showInputDialog("Enter  Status for updating !");
                                teach.setStatus(status);
                            } else {
                                JOptionPane.showMessageDialog(null, "no data Found !");
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Invalid choice. Please choose a valid option. !");
                            break;
                    }
                }
                return null;
            }
        });

    }

    public void deleteRecord(Teacher student) {
        template.execute((Session sn) -> {
            sn.delete(student);
            return null;
        });

//            template.execute(new HibernateCallback<Object>() {
//                @Override
//                public Object doInHibernate(Session sn) throws HibernateException, SQLException {
//                    Teacher teach1 = (Teacher)sn.delete(Teacher.class, student.getRollNo());
//                     if(teach1 == null){
//                        System.out.println("no record found !");
//                    }else{
////                         JOptionPane.showMessageDialog(null, "Student Name: \n"+ student.getName() +"\n Student Roll number is: \n"+ student.getRollNo() +
////                        "\n Student Class name is: \n"+ student.getClassName() + "\n Status is:/t \n"+ student.getStatus());
//
//                              byte choice = Byte.parseByte(JOptionPane.showInputDialog(" ----------- List for Update Data ---------------- \n\n "
//                + "1) Student Name ! \n"
//                 + "2) Student Class Name !\n"
//                 + " 3) Student Status ! \n"
//                 + "\n6) exit ! \n"
//                 + "Only Choose out in given Numbers !!"));
//                              String rollNo;
//                              
//                              switch(choice){
//                                  case 1:
//                                      rollNo = JOptionPane.showInputDialog("Enter Student Roll Number !");
//                                      if(rollNo == student.getRollNo()){
//                                          String name = JOptionPane.showInputDialog("Enter Student New name for updating");
//                                          teach.setName(name); 
//                                      }
//                                      else{
//                                          JOptionPane.showMessageDialog(null, "no data Found !");
//                                      }
//                                          break;
//                                          
//                                          case 2: 
//                                           rollNo = JOptionPane.showInputDialog("Enter Student Roll Number !");
//                                      if(rollNo == student.getRollNo()){
//                                            String className = JOptionPane.showInputDialog("Enter Student New Class Name for updating");
//                                            teach.setClassName(className);
//                                      }else{
//                                          JOptionPane.showMessageDialog(null, "no data Found !");
//                                      }
//                                      break;
//                                      
//                                          case 3: 
//                                           rollNo = JOptionPane.showInputDialog("Enter Student Roll Number !");
//                                      if(rollNo == student.getRollNo()){
//                                            String status = JOptionPane.showInputDialog("Enter  Status for updating !");
//                                            teach.setStatus(status);
//                                      }else{
//                                          JOptionPane.showMessageDialog(null, "no data Found !");
//                                      }
//                                      break;
//                              }
//                    }
//                    return null;
//                }
//            });
    }

}
