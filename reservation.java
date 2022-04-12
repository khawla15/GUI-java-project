//khawla hassan Alqarni -1914906- -M-
package guiproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class reservation  extends JFrame{
    
    JPanel p1 = new JPanel();
    JRadioButton swim_but,basket_but,fot_but,volley_but;
    ButtonGroup radioGroup;
  
    JLabel qr_code,label,label2 ,title,subtitle;
   
    JTextArea info;
    JComboBox <String> swimCoatch , fotCoatch,basketCoatch , volleyCoatch;
    JButton ok , save;
    static String sport , coach;
    String[] S_coatch={"Bob Bowman","Teri Mckeever","Mike Bottom"};
    String[] B_coatch={"Gregg Popovich","Phil Jackson","Pat Riley"};
    String[] F_coatch={"Joachim Low","Mauricio Pochettino","Tite"};
    String[] V_coatch={"Bernardo Rezende","Jose Roberto","Nikolay Karpol"};
    mainClass mainCls = new mainClass();
    JButton dark = mainCls.Dark;
    JButton light = mainCls.light;
    validation valid = new validation();
    static String fname, phone,lname,email;
    mainClass minc = new mainClass();
    
    public reservation(String Fname,String Lname,String phone,String email){
    this.fname = Fname;
    this.lname=Lname;
    this.phone=phone;
    this.email=email;
    
    }//end constructor with args
  public reservation(){
      
      setVisible(true);
      setTitle("Reservation System");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
      mode m = new mode(); //Background panel
      m.setLayout(null);
      getContentPane().add(m);
      
    

      setSize(900,500);
      setResizable(true);
      
      
      
      //Mode  
      dark.setBounds(mainCls.Dark.getBounds());
      light.setBounds(mainCls.light.getBounds());
      m.add(dark);
      m.add(light); 


//Dark action ,same action in mainClass
      dark.addActionListener(new ActionListener(){
      @Override
          public void actionPerformed(ActionEvent e) {
                mainCls.Dark.getActionListeners();
                m.c1=new Color(81, 113, 112, 225);
                m.c2=new Color(58, 43, 69);
                m.repaint();
                m.setVisible(true);
                light.setVisible(true);
               dark.setVisible(false);

              }
              });
//Light action
      light.addActionListener(new ActionListener(){
      @Override
          public void actionPerformed(ActionEvent e) {
                mainCls.light.getActionListeners(); 
                  m.c1=new Color(95, 191, 188, 225);
               m.c2=new Color(118, 86, 158);
               m.repaint();
               light.setVisible(false);
               dark.setVisible(true);

               }
              });
      

      title = new JLabel();
      title.setFont(new Font("SansSerif",Font.BOLD,40));
      title.setForeground(new Color(61,61,113));
      title.setText(" Complete your registration ");
      title.setBounds(350, -120,800, 300);//-120
      m.add(title);

      subtitle = new JLabel();
      subtitle.setFont(new Font("SansSerif",Font.BOLD,22));
      subtitle.setForeground(new Color(66, 59, 88));
      subtitle.setBounds(180, 10, 700, 200);
      subtitle.setBackground(null);
      subtitle.setText("Choose one from below: ");
      m.add(subtitle);
    
      //TextArea
     info = new JTextArea();
     info.setBounds(850, 200, 400, 150);
     
     

      swim_but = new JRadioButton("Swimming",false);
      swim_but.setFont(new Font("SansSerif",Font.BOLD,16));
      swim_but.setBounds(80,145,130,20);
      swim_but.setBackground(null);
      swim_but.setContentAreaFilled(false);

      basket_but = new  JRadioButton("Basketball",false);
      basket_but.setFont(new Font("SansSerif",Font.BOLD,16));
      basket_but.setBounds(80,225,130,20);
      basket_but.setContentAreaFilled(false);

      fot_but = new  JRadioButton("Fotball",true);
      fot_but.setFont(new Font("SansSerif",Font.BOLD,16));
      fot_but.setBounds(80,305,130,20);
      fot_but.setContentAreaFilled(false);

      volley_but = new  JRadioButton("Volleyball",false);
      volley_but.setFont(new Font("SansSerif",Font.BOLD,16));
      volley_but.setBounds(80,385,130,20);
      volley_but.setContentAreaFilled(false);
      save= new JButton("SAVE");
      save.setBounds(130,580,120,30);
      save.setFont(new Font("SansSerif",Font.BOLD,16));
      save.setForeground(new Color(107,45,103));
      //add(ok);

      //add buttons
      m.add( swim_but);
      m.add(basket_but);
      m.add(fot_but);
      m.add(volley_but);

    //  m.add(p1);
      //add buttons in group
      radioGroup = new ButtonGroup();
      radioGroup.add(swim_but);
      radioGroup.add(basket_but);
      radioGroup.add(fot_but);
      radioGroup.add(volley_but);


      //fill ComboBox with list of Coatch
      swimCoatch = new JComboBox(S_coatch);  swimCoatch.setVisible(false);
      swimCoatch.setFont(new Font("SansSerif",Font.BOLD,16));
      swimCoatch.setBackground(null);
      fotCoatch = new JComboBox(F_coatch);   fotCoatch.setVisible(true);
      fotCoatch.setFont(new Font("SansSerif",Font.BOLD,16));
      fotCoatch.setBackground(null);
      basketCoatch = new JComboBox(B_coatch); basketCoatch.setVisible(false);
      basketCoatch.setFont(new Font("SansSerif",Font.BOLD,16));
      basketCoatch.setBackground(null);
      volleyCoatch = new JComboBox(V_coatch); volleyCoatch.setVisible(false);
      volleyCoatch.setFont(new Font("SansSerif",Font.BOLD,16));
      volleyCoatch.setBackground(null);
     

      swim_but.addItemListener(new ItemListener(){
          @Override
          public void itemStateChanged(ItemEvent e) {
              if(swim_but.isSelected())
              {
                  sport=(swim_but.getText());
                  swimCoatch.setBounds(80,460,200,30);
                  m.add(swimCoatch);
                  swimCoatch.setVisible(true);
                  fotCoatch.setVisible(false);
                  basketCoatch.setVisible(false);
                  volleyCoatch.setVisible(false);
                 

              }
              swimCoatch.addItemListener(new ItemListener(){

                  @Override
                  public void itemStateChanged(ItemEvent e) {
                      if (e.getStateChange()== ItemEvent.SELECTED)
                          coach = (String)swimCoatch.getSelectedItem();
                          }
              });
          }
      });
      //------------------------------------------------
      basket_but.addItemListener(new ItemListener(){

          @Override
          public void itemStateChanged(ItemEvent e) {
              if(basket_but.isSelected())
              {
                  sport=(basket_but.getText());
                  basketCoatch.setBounds(80,460,200,30);
                  m.add(basketCoatch);
                  swimCoatch.setVisible(false);
                  fotCoatch.setVisible(false);
                  basketCoatch.setVisible(true);
                  volleyCoatch.setVisible(false);
              }
              basketCoatch.addItemListener(new ItemListener(){

                  @Override
                  public void itemStateChanged(ItemEvent e) {
                      if (e.getStateChange()== ItemEvent.SELECTED)
                          coach = (String) basketCoatch.getSelectedItem(); }

              });
          }//itemStateChanged
      });//end

      //--------------------------------
      fot_but.addItemListener(new ItemListener(){
          @Override
          public void itemStateChanged(ItemEvent e) {
              if(fot_but.isSelected())  {
                  sport=fot_but.getText();
                  fotCoatch.setBounds(80,460,200,30);
                  m.add(fotCoatch);
                  swimCoatch.setVisible(false);
                  fotCoatch.setVisible(true);
                  basketCoatch.setVisible(false);
                  volleyCoatch.setVisible(false); }
                  fotCoatch.addItemListener(new ItemListener(){

                  @Override
                  public void itemStateChanged(ItemEvent e) {

                      if (e.getStateChange()== ItemEvent.SELECTED)
                         coach=(String) fotCoatch.getSelectedItem(); }
              });
          }
      });
      volley_but.addItemListener(new ItemListener(){
          @Override
          public void itemStateChanged(ItemEvent e) {
              if(volley_but.isSelected())  {
                  sport=(volley_but.getText());
                  volleyCoatch.setBounds(80,460,200,30);
                  m.add(volleyCoatch);
                  swimCoatch.setVisible(false);
                  fotCoatch.setVisible(false);
                  basketCoatch.setVisible(false);
                  volleyCoatch.setVisible(true);}
                 volleyCoatch.addItemListener(new ItemListener(){

                  @Override
                  public void itemStateChanged(ItemEvent e) {
                      if (e.getStateChange()== ItemEvent.SELECTED)
                          coach= (String) volleyCoatch.getSelectedItem();
                    //  m.add(label2);
                  }

              });}//itemStateChnged
      });//itemListener end
      m.add(save);
      save.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              if(sport == null || coach == null){
            JOptionPane.showMessageDialog(null, "You must Choose one from Sport and Coach! ","Reservation",JOptionPane.WARNING_MESSAGE);
                 
              }
              else{
                  info.setVisible(true);
                  info.setFont(new Font ("Times New Roman", 1, 18));
                  info.setEditable(false);
                  info.setBackground(new Color(244,244,244));
                  info.setForeground(new Color(150,107,147));
                  m.add(info);
                  info.setText("Your Name is:  "+fname +" "+lname+"\n"
                           +  "Your Phone number is:   "+phone+"\n"
                           + "Your Email is:  "+email+"\n"
                           + "The Sport you want:   "+sport+"\n"
                           +  "The Coach you choose is:   "+coach+"\n");
                  ok = new JButton("Confirm");
                  m.add(ok);
                  ok.setBounds(1000, 410, 150, 30);
                  ok.setFont(new Font("SansSerif",Font.BOLD,18));
                  ok.setForeground(new Color(107,45,103));
                    
                    ok.addActionListener(new ActionListener(){ 

                      @Override
                      public void actionPerformed(ActionEvent e) {
                       dispose();
                       writeReadFile file = new writeReadFile(sport,coach);
                       writeReadFile f = new writeReadFile();
                //setVisible(false);
                             }
                        
                    });
                  
                 }

          }//actionPerformed

      });//actionlistener ok

     


  }//constructor



}//end reservation Class
