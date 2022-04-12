//khawla hassan Alqarni -1914906- -M-
package guiproject;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;  
import javax.swing.*;
public class mainClass extends JFrame {

     //initialize variables
    Icon QR;
    writeReadFile f;
    reservation r;
    JPanel p1 ,p3,signup , bkground ;
    JLabel title ,subtitle1,subtitle2, Fname,Lname,phone,email;
    public static JTextField Fname_txt,Lname_txt,phone_txt,email_txt;
    JButton Dark,light,SignUp;
    String[] sportLabel={" Swimming"," Basketball","   Fotball"," Volleyball"};
    JLabel[] lbl=new JLabel[4];
    String[] coach = {"Bob Bowman","Gregg Popovich","Joachim Low","Bernardo Rezende",
            "Teri Mckeever","Phil Jackson", "Mauricio Pochettino","Jose Roberto","Mike Bottom",
            "Pat Riley","Tite","Nikolay Karpol"};
    //names of photos
    String[] photos = {"swim1.jpg","basketball1.jpg","fotball1.jpeg","volleyball1.jpg",
            "swim2.jpg","basketball2.jpg","fotball2.jpeg","volleyball2.jpg",
            "swim3.jpg","basketball3.jpg","fotball3.jpeg","volleyball3.jpg"};
    //labels
    String[] labels = {"swim1pic","basketball1pic","fotball1pic","volleyball1pic",
            "swim2pic","basketball2pic","fotball2pic","volleyball2pic",
            "swim3pic","basketball3pic","fotball3pic","volleyball3pic"};
    
    JLabel[] jLabels = new JLabel[12];
    ImageIcon[] s =new ImageIcon[12] ;
    String[] tooloTip = new String[12];
    URL[] imgUrl = new URL[12];
    mode m = new mode(); //Background panel
    validation validate = new validation(); //obj from validation

    //constructor
   public mainClass(){
       setSize(1000,800);
       m.setLayout(null);
       getContentPane().add(m);

       title = new JLabel();
       title.setFont(new Font("SansSerif",Font.BOLD,40));
       title.setForeground(new Color(61,61,113));
       title.setBounds(350, -120,800, 300);
       title.setText("Sports Trainers Reservation Program");
       m.add(title);

       Dark = new JButton();
       Dark.setFont(new Font("SansSerif",Font.BOLD,15));
       Dark.setBounds(10,10,80,30);
       Dark.setText("Dark");


       light = new JButton();
       light.setFont(new Font("SansSerif",Font.BOLD,15));
       light.setText(("Light"));
       light.setBounds(10,10,80,30);
       m.add(light);
       light.setVisible(false);
       m.add(Dark);
       Dark.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               m.c1=new Color(81, 113, 112, 225);
               m.c2=new Color(58, 43, 69);
               m.repaint();
               m.setVisible(true);
               light.setVisible(true);
               Dark.setVisible(false);
           };
       });  //end ActionListener for dark
       light.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {

               m.c1=new Color(95, 191, 188, 225);
               m.c2=new Color(118, 86, 158);
               m.repaint();
               light.setVisible(false);
               Dark.setVisible(true);
           }

       }); //end ActionListener for light


       //display a brief describtion about program
       subtitle1 = new JLabel();
       subtitle1.setFont(new Font("SansSerif",Font.ITALIC,18));
       subtitle1.setForeground(new Color(255,255,255,160));
       subtitle1.setBounds(180, 10, 700, 200);
       subtitle1.setText("If you like sports,this program for YOU!");
       subtitle2 = new JLabel();
       subtitle2.setFont(new Font("SansSerif",Font.ROMAN_BASELINE,18));
       subtitle2.setForeground(new Color(255,255,255,160));
       subtitle2.setText("choose your coach & go ahead!");
       subtitle2.setBounds(200 , 35, 700, 200);
       m.add(subtitle1); m.add(subtitle2);

       //for loop to display JButtons (sports)
       int x =140; //initialize value of x before loop
       try {
           for (int i = 0; i < 4; i++) {
               lbl[i] = new JLabel(sportLabel[i]);
               lbl[i].setForeground(new Color(22, 48, 64));
               lbl[i].setBounds(x, 180, 80, 20);
               //increment position of x
               x += 108;
               lbl[i].setFont(new Font("SansSerif", Font.BOLD, 14));
               lbl[i].setBorder(BorderFactory.createDashedBorder(new Color(255, 255, 255, 200)));
               m.add(lbl[i]);
           }//end for loop
       }catch(NullPointerException e){
           JOptionPane.showMessageDialog(null,
                   "Error: Something went wrong");
       }//end catch block

        //panel contain photos for coachs
       p3 = new JPanel(new GridLayout(3,4,30,0));
       p3.setSize(600,500);
       p3.setBounds(140, 180, 400, 500);
       p3.setBackground(new Color(0,0,0,0));
       m.add(p3);
       //for loop to add photos in panel
       try {
           for (int i = 0; i < 12; i++) {
               imgUrl[i] = getClass().getResource(photos[i]);
               s[i] = new ImageIcon(imgUrl[i]);
               jLabels[i] = new JLabel(s[i]);
              // String tool = coach[i];
              // tooloTip[i] = tool;
               
               jLabels[i].setToolTipText(tooloTip[i]);
               p3.add((jLabels[i]));
           }//end for loop
       }catch(NullPointerException e){
           JOptionPane.showMessageDialog(null,
                   "Error: Photos not found ");
       }//end catch block
       SignUp=new JButton("click to Sign Up");
       SignUp.setFont(new Font("SansSerif",Font.BOLD,18));
       SignUp.setForeground(new Color(107,45,103));
       SignUp.setBounds(890, 300, 200, 40);
       m.add(SignUp);
       Handler handlerSignUp = new Handler();
       SignUp.addActionListener(handlerSignUp);



   }//constructor



class Handler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        SignUp.setVisible(false); //hide button
        bkground = new JPanel();
        bkground.setBackground(new Color(157,157,189,200)); //transparency
        m.add(bkground);
        bkground.setBounds(800, 80, 100,150);
        bkground.setSize(400, 560);
        signup = new JPanel(new GridLayout(9,1,30,20));
        signup.setSize(100,800);
        signup.setBounds(300, 100, 180,600);
        signup.setBackground(new Color(6,0,0,0));

        Fname = new JLabel();

        signup.add(Fname);
        Fname.setFont(new Font("SansSerif",Font.BOLD,18));

        Fname.setText(" First Name ");
        Fname_txt = new JTextField("ex: khawla",30);      //editttt
        Fname_txt.setFont(new Font("SansSerif",Font.PLAIN,14));
        signup.add(Fname_txt);


        Lname = new JLabel();
        signup.add(Lname);
        Lname.setFont(new Font("SansSerif",Font.BOLD,18));
        Lname.setText("Last Name");


        Lname_txt = new JTextField("ex:hassan",30); //editttt
        signup.add(Lname_txt);
        Lname_txt.setFont(new Font("SansSerif",Font.PLAIN,14));
        

        phone = new JLabel();
        phone.setFont(new Font("SansSerif",Font.BOLD,18));
        phone.setText("Phone number ");
        signup.add(phone);

        phone_txt = new JTextField("ex: 05XXXXXXXX",30); //editttt
        signup.add(phone_txt);
        phone_txt.setFont(new Font("SansSerif",Font.PLAIN,14));

        email = new JLabel();
        signup.add(email);
        email.setFont(new Font("SansSerif",Font.BOLD,18));
        email.setText(" Email");
       
        email_txt = new JTextField("ex: XXX@XXX.com",30); //editttt
        signup.add(email_txt);
        email_txt.setFont(new Font("SansSerif",Font.PLAIN,14));
      
        SignUp = new JButton();
        SignUp.setFont(new Font("SansSerif",Font.BOLD,14));
        SignUp.setForeground(new Color(107,45,103));
        SignUp.setText("Sign Up");
        bkground.add(signup);
        signup.add(SignUp);
        //action listener for button Sign up
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             validate.setFname(Fname_txt.getText());
             validate.setLname(Lname_txt.getText());
             validate.setPhone(phone_txt.getText());
             validate.setEmail(email_txt.getText());
             //return true if all info is currect
             if(validate.fn && validate.ln && validate.ph && validate.eml){
     try{
         r= new reservation(Fname_txt.getText(),Lname_txt.getText(),phone_txt.getText(),email_txt.getText());
       f=new writeReadFile(Fname_txt.getText(),Lname_txt.getText(),phone_txt.getText(),email_txt.getText());
                 reservation v = new reservation();
                 v.setLocationRelativeTo(null);
                // dispose();
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null, "error occure ","error",JOptionPane.WARNING_MESSAGE);
     }
                
             }//end if 
             else{
         JOptionPane.showMessageDialog(null,"Invalid input ,Try again",
                 "ERROR",  JOptionPane.ERROR_MESSAGE);
             }//else

            }
        });

    }
}

    public static void main(String[]args){
        mainClass frame = new mainClass();
      
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//end main
}//end mainClass
