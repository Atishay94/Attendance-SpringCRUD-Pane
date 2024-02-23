package spring.dto;

public class Teacher {
    private String rollNo;    
    private String name;
    private String className;
    private String status;

    public Teacher(String rollNo, String name, String className, String status) {
        this.rollNo = rollNo;
        this.name = name;
        this.className = className;
        this.status = status;
    }

    public Teacher() {
       
    }

    public Teacher(String rollNo3) {
       
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    
}
