

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class flafla extends JFrame  implements ActionListener {

        public JLabel fc,nf1,nf2,result1,result2;
        public JTextField n1,n2;
        public JButton b;

        public ImageIcon fl;
        public JPanel p1,r1;
    flafla(){



        fl=new ImageIcon("C:\\Users\\slaha\\IdeaProjects\\FLAMES CALUCATOR\\flameslogo");
        fc=new JLabel("  F.L.A.M.E.S  ");
        nf1=new JLabel("Enter name 1 ");
        nf2=new JLabel("Enter name 2 ");
        p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        r1=new JPanel(new FlowLayout(FlowLayout.CENTER));
        fc.setFont(new Font("a song for jennifer",Font.PLAIN,60));
        fc.setIcon(fl);
        n1=new JTextField(30);
        n2=new JTextField(30);
        b= new JButton("FLAME!");
        result1=new JLabel("\n--------",SwingConstants.CENTER);
        result2=new JLabel("\n-------",SwingConstants.CENTER);
        result1.setFont(new Font("a song for jennifer",Font.PLAIN,30));
        result2.setFont(new Font("a song for jennifer",Font.PLAIN,20));
        p1.setSize(370,400);
        p1.add(fc);
        p1.add(nf1);
        p1.add(n1);
        p1.add(nf2);
        p1.add(n2);
        p1.add(b);
        b.addActionListener(this);
        r1.add(result1);
        r1.add(result2);
        r1.setLayout(new GridLayout(2,1));
        r1.setBounds(0,400,400,100);
        add(p1);
        add(r1);
        setLayout(new GridLayout(2,1));
        setResizable(false);
        setSize(400,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public String rel(){
        int[] freq1 = new int[30];
        int[] freq2 = new int[30];
        for(int i=0;i<30;i++) {
            freq1[i]=0;
        }

        for(int i=0;i<30;i++){
            freq2[i]=0;
        }

        String s1=n1.getText().toLowerCase();
        String s2=n2.getText().toLowerCase();

        for(int i=0;i<s1.length();i++ ){
           char op=s1.charAt(i);
          freq1[((int)op)-97]++;

        }
        for(int i=0;i<s2.length();i++ ){
            char op=s2.charAt(i);
            freq2[((int)op)-97]++;

        }
        int flcount=0;
        for(int i=0;i<30;i++){
            if(freq1[i]!=0||freq2[i]!=0){
                flcount+=Math.abs(freq1[i]-freq2[i]);
            }
        }


        char[] flame = new char[flcount];
        flame[0]='f';
        for(int i=1;i<flcount;i++){
            if(flame[i-1]=='f'){
                flame[i]='l';
            }
            if(flame[i-1]=='l'){
                flame[i]='a';
            }
            if(flame[i-1]=='a'){
                flame[i]='m';
            }
            if(flame[i-1]=='m'){
                flame[i]='e';
            }
            if(flame[i-1]=='e'){
                flame[i]='s';
            }
            if(flame[i-1]=='s'){
                flame[i]='f';
            }

        }
        char fllet=flame[flcount-1];
        if (fllet == 'f') {
            return "FRIENDSHIP";
        } else if (fllet == 'l') {
            return "LOVE";
        } else if (fllet == 'a') {
            return "AFFECTIONATE";
        } else if (fllet == 'm') {
            return "MARRIAGE";
        } else if (fllet == 'e') {
            return "ENEMY";
        } else if (fllet == 's') {
            return "SIBLINGS";
        }
        return " ";
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String name_1=n1.getText();
        String name_2=n2.getText();
        result1.setText(name_1+" X "+name_2);
        result2.setText(rel());
       /* result2.setText("FRIENDS");*/
    }
}





