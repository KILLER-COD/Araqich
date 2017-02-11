package Aplication_methods;

import javax.swing.*;

/**
 * Created by CODE on 08.02.2017.
 */
public class Conf_Jlabel extends JLabel {


    public Conf_Jlabel(String name, int x, int y, int width, int height) {
       super(name);
       setBounds(x,y,width,height);
    }
    public Conf_Jlabel (){
        new JLabel();
    }
}
