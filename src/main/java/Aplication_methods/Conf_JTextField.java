package Aplication_methods;

import javax.swing.*;

/**
 * Created by CODE on 08.02.2017.
 */
public class Conf_JTextField extends JTextField {
    public Conf_JTextField(int collnum, String name, int x, int y, int width, int height) {
        super(name);
        setColumns(collnum);
        setBounds(x, y, width, height);
    }
    public Conf_JTextField(int collnum, int x,int y,int width,int height){
        setColumns(collnum);
        setBounds(x,y,width,height);
    }
}
