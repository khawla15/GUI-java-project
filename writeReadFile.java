//khawla hassan Alqarni -1914906- -M-
package guiproject;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class writeReadFile extends JFrame{
   public static String fn, ln,ph , eml, sport, coach;
    Icon QR ;
    JLabel lbl1, qr_code,subtitle,lbl2;
    JScrollPane scroll;
    JButton newSign;
    mainClass minc = new mainClass();
    JTextArea reservationList;
    JButton dark , light;
    JPanel panel = new JPanel();
    String file_name="reserv.txt";
    //reservation r = new reservation();


    //1th constructor to save value of type of sport and coach
    public writeReadFile(String sp , String coch){
        this.sport=sp;
        this.coach=coch;
    }//cons with args 
    public writeReadFile(String firstN,String lastN,String phoneN ,String email){

        this.fn=firstN;
        this.ln=lastN;
        this.ph=phoneN;
        this.eml=email;}
    
        public writeReadFile(){
          mode m = new mode(); //Background panel
           setSize(1000,800);
           m.setLayout(null);
          getContentPane().add(m);
          dark=minc.Dark;
          light=minc.light;
          dark.addActionListener(new ActionListener(){
           @Override
              public void actionPerformed(ActionEvent e) {
                dark.getActionListeners();
                m.c1=new Color(81, 113, 112, 225);
                m.c2=new Color(58, 43, 69);
                m.repaint();
                m.setVisible(true);
                light.setVisible(true);
                dark.setVisible(false); } });
          light.addActionListener(new ActionListener(){
           @Override
              public void actionPerformed(ActionEvent e) {
                light.getActionListeners();
                m.c1=new Color(81, 113, 112, 225);
                m.c2=new Color(58, 43, 69);
                m.repaint();
                m.setVisible(true);
                light.setVisible(true);
                dark.setVisible(false); }});
          
          m.add(dark);
          m.add(light);
         
        lbl1=new JLabel("  List of registered clients"+"\n");
        lbl1.setFont(new Font("SansSerif",Font.BOLD,40));
        lbl1.setForeground(new Color(61,61,113));
        lbl1.setBounds(350, -120,800, 300);
        panel.setLayout(new BorderLayout()); 
        panel.setBackground(new Color(0,0,0,0));
        panel.setBounds(80, 100, 530, 520);
        m.add(panel);
        subtitle = new JLabel();
      subtitle.setFont(new Font("SansSerif",Font.BOLD,24));
      subtitle.setForeground(new Color(240,240,240));
      subtitle.setBounds(200, -10, 700, 200);
      subtitle.setBackground(null);
      subtitle.setText("                          List of reservation ");
      panel.add(subtitle,BorderLayout.NORTH);
      //text area
        reservationList = new JTextArea();
        reservationList.setSize(500,600);
        reservationList.setEditable(false);
        reservationList.setFont(new Font ("Times New Roman", 1, 18));
        reservationList.setForeground(new Color( 61 , 61, 113 ));
        reservationList.setBackground(new Color(255,255,255));
       // reservationList.setBounds(80,130,550,500);
        scroll = new JScrollPane(reservationList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(80,130,550,500);
        
        
        
        reservationList.setText(" First name"+"\t"+"Last name"+"\t"+"Phone "+"\t"+"Email"+"\t"+"sport"+"\t"+"coach"+"\n");
        m.add(lbl1);
      
         panel.add(scroll,BorderLayout.CENTER);
       

        //write on file
        try {
            FileWriter fs = new FileWriter(file_name,true);
              try (BufferedWriter out = new BufferedWriter(fs)) {
                  out.write("\n");
                  out.write(" "+fn+"\t"+ln+"\t"+ph+"\t"+eml+sport+"\t"+coach+"\t");
                  out.write("\n");
              }
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null,""+ex,"error",JOptionPane.WARNING_MESSAGE);
        }

        //Read from file
        try  {
            BufferedReader br = new BufferedReader(new FileReader(file_name));
            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
               // reservationList.setForeground(Color.BLACK);
                reservationList.append(strCurrentLine);
                reservationList.append("\n");
               
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,""+e,"error",JOptionPane.WARNING_MESSAGE);
        }
     
     
        try{
         QR = new ImageIcon(getClass().getResource("qr-codee.png"));
                    qr_code = new JLabel(QR);
                    qr_code.setBounds(930, 270, 200, 200);
                    qr_code.setBackground(new Color(255,255,255,100));
                    m.add(qr_code);
        }catch(NullPointerException e){
             JOptionPane.showMessageDialog(null,""+e,"QR code is not found!",JOptionPane.WARNING_MESSAGE);
        }//end catch block
        
        //Option to new Reservation with new Info 
          lbl2=new JLabel();
          lbl2.setFont(new Font("SansSerif",Font.BOLD,18));
          lbl2.setForeground(new Color(107,45,103)); //new Color(91,147,178)
          lbl2.setBounds(910, 200, 400, 40);
          lbl2.setBackground(null);
          lbl2.setText("Thank you, See you again :)");
          m.add(lbl2);
          newSign = new JButton("New Registration");
          newSign.setFont(new Font("SansSerif",Font.BOLD,18));
          newSign.setForeground(new Color(107,45,103));
          newSign.setBounds(930, 500, 200, 30);
          m.add(newSign);
          newSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            mainClass minC= new mainClass();
            dispose(); } });
          
                    setSize(800,800);
                    setVisible(true);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setLocationRelativeTo(null);
    }//end constructor
}
