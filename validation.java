//khawla hassan Alqarni -1914906- -M-
package guiproject;

public class validation {
    String Fname;
    String Lname;
    String phone;
    String email;
    boolean fn ,ln,ph,eml;

    public validation(){  }
    public validation(String Fname,String Lname,String phone,String email){
        this.Fname=Fname;
        this.Lname=Lname;
        this.phone=phone;
        this.email=email;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        fn=false; //validation Fname to one character or more
        if (fname.matches("[A-Z]*[a-z]+")){
            Fname = fname;
             fn=true;
        }

          //
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        ln=false; //validation Lname to one character or more
        if (lname.matches("[A-Z]*[a-z]+")){
            Lname = lname;
             ln=true;
        }

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        ph=false; //validation phone to start with 05 and 10numbers not more or less
        if(phone.matches("[0][5]+\\d{8}")){
            this.phone = phone;
             ph=true;
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        eml=false; //validation email 
        if(email.matches("[A-Za-z0-9._%+-]+@[a-z][a-z][a-z]+[.](com)")){
            this.email = email;
             eml = true;
        }

    }
}//end class
