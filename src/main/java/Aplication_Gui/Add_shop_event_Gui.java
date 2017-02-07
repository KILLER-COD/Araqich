
package Aplication_Gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Add_shop_event_Gui extends JFrame {

    private static ArrayList<Zakaz_data> zakaz = Zakaz_data_read.getZakaz_data();
    private static String[] shops = Shop_names_reader.read_Shop_name();
    private Shop_date shop_dates;

    private String[] month = new String[]{"Հունվար", "Փետրվար", "Մարտ", "Ապրիլ", "Մայիս", "Հունիս", "Հուլիս", "Օգոստոս", "Սեպտեմբեր", "Հոկտեմբեր", "Նոյեմբեր", "Դեկտեմբեր"};
    private Integer[] day = new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(19), Integer.valueOf(20), Integer.valueOf(21), Integer.valueOf(22), Integer.valueOf(23), Integer.valueOf(24), Integer.valueOf(25), Integer.valueOf(26), Integer.valueOf(27), Integer.valueOf(28), Integer.valueOf(29), Integer.valueOf(30), Integer.valueOf(31)};
    private Integer[] year = new Integer[]{Integer.valueOf(2017), Integer.valueOf(2018), Integer.valueOf(2019), Integer.valueOf(2020), Integer.valueOf(2021), Integer.valueOf(2022)};

    private JPanel panel = new JPanel();
    private JTable table = new JTable();
    private JScrollPane pane;

    private JButton btn_add;
    private JButton btn_Excel;

    /*-----------------------------*/
    private JLabel JT_id_label;
    private JLabel JT_goods_label;
    private JLabel JT_count_label;
    private JLabel JT_sort_label;
    private JLabel Jt_price_label;

    private JTextField JT_id;
    private JTextField JT_goods;
    private JTextField JT_count;
    private JTextField JT_sort;
    private JTextField Jt_price;
    /*-----------------------------*/

    /*-----------------------------*/
    private JLabel Jt_Shop_name_label;
    private JLabel Jt_Shop_year_label;
    private JLabel Jt_Shop_day_label;
    private JLabel Jt_Shop_month_label;

    private JComboBox Shop_name;
    private JComboBox Shop_year;
    private JComboBox Shop_day;
    private JComboBox Shop_month;
   /*-----------------------------*/

    private int shop_name = 1;

    public Add_shop_event_Gui(String ident) {

        if(ident.equals("show")) {
            Zakaz_data_read.read_Zakaz_data();
        }

        /*--------------------------------------------------------------*/
        Jt_Shop_name_label = new JLabel("Shop name");
        Jt_Shop_year_label = new JLabel("Year");
        Jt_Shop_day_label = new JLabel("Day");
        Jt_Shop_month_label = new JLabel("Month");

        Jt_Shop_name_label.setBounds(10, 20, 100, 20);
        Jt_Shop_month_label.setBounds(320, 20, 50, 20);
        Jt_Shop_year_label.setBounds(470, 20, 50, 20);
        Jt_Shop_day_label.setBounds(620, 20, 50, 20);
        /*--------------------------------------------------------------*/

        /*--------------------------------------------------------------*/
        Shop_name = new JComboBox(shops);
        Shop_year = new JComboBox(year);
        Shop_day = new JComboBox(day);
        Shop_month = new JComboBox(month);

        Shop_name.setBounds(100, 20, 200, 20);
        Shop_month.setBounds(370, 20, 90, 20);
        Shop_year.setBounds(530, 20, 70, 20);
        Shop_day.setBounds(670, 20, 70, 20);
        /*--------------------------------------------------------------*/

        /*--------------------------------------------------------------*/
        JT_id_label = new JLabel("Id");
        JT_goods_label = new JLabel("Goods name");
        JT_count_label = new JLabel("Count");
        JT_sort_label = new JLabel("Sort");
        Jt_price_label = new JLabel("Price");

        JT_id_label.setBounds(10, 50, 150, 20);
        JT_goods_label.setBounds(10, 80, 150, 20);
        JT_count_label.setBounds(10, 110, 150, 20);
        JT_sort_label.setBounds(10, 140, 150, 20);
        Jt_price_label.setBounds(10, 170, 150, 20);
        /*--------------------------------------------------------------*/

        /*--------------------------------------------------------------*/
        JT_id = new JTextField(20);
        JT_goods = new JTextField(20);
        JT_count = new JTextField(20);
        JT_sort = new JTextField(20);
        Jt_price = new JTextField(20);

        JT_id.setBounds(130, 50, 150, 20);
        JT_goods.setBounds(130, 80, 150, 20);
        JT_count.setBounds(130, 110, 150, 20);
        JT_sort.setBounds(130, 140, 150, 20);
        Jt_price.setBounds(130, 170, 150, 20);
        /*--------------------------------------------------------------*/

        /*--------------------------------------------------------------*/
        btn_add = new JButton("ADD");
        btn_Excel = new JButton("UPDATE");

        btn_add.setBounds(300, 80, 100, 20);
        btn_Excel.setBounds(300, 130, 100, 20);
        /*--------------------------------------------------------------*/

        /*---------------------------Add info in table start-----------------------------------*/
            Object[][] zakaz_info = new Object[Add_shop_event_Gui.zakaz.size()][6];

            for(int columnNames = 0; columnNames <= zakaz_info.length - 1; ++columnNames) {
                Object[] model = zakaz_info[columnNames];
                model[0] = ((Zakaz_data) Add_shop_event_Gui.zakaz.get(columnNames)).getId();
                model[1] = ((Zakaz_data) Add_shop_event_Gui.zakaz.get(columnNames)).getGoods_name();
                model[2] = "";
                model[3] = ((Zakaz_data) Add_shop_event_Gui.zakaz.get(columnNames)).getSort();
                model[4] = ((Zakaz_data) Add_shop_event_Gui.zakaz.get(columnNames)).getPrice();
            }

            String[] strings = new String[]{"ID", "Goods_name", "Counts", "Sort", "Price"};
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setDataVector(zakaz_info, strings);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        /*---------------------------Add info in table end-----------------------------------*/

        pane = new JScrollPane(table);
        pane.setBounds(10, 200, 760, 650);

        panel.setBounds(10, 10, 760, 700);
        panel.setLayout((LayoutManager)null);

        add(panel);

        panel.add(Jt_Shop_name_label);
        panel.add(Shop_name);

        panel.add(Jt_Shop_month_label);
        panel.add(Shop_month);

        panel.add(Jt_Shop_year_label);
        panel.add(Shop_year);

        panel.add(Jt_Shop_day_label);
        panel.add(Shop_day);

        panel.add(JT_id_label);
        panel.add(JT_id);

        panel.add(JT_goods_label);
        panel.add(JT_goods);

        panel.add(JT_count_label);
        panel.add(JT_count);

        panel.add(JT_sort_label);
        panel.add(JT_sort);

        panel.add(Jt_price_label);
        panel.add(Jt_price);

        panel.add(btn_add);
        panel.add(btn_Excel);

        panel.add(pane);

        /*---------------------------JFrame configuration start-----------------------------------*/
            setDefaultCloseOperation(3);
            Color c = Color.decode("#bdb76b");
            getContentPane().setBackground(c);
            setLocation(600, 50);
            setSize(800, 900);
            setVisible(true);
        /*---------------------------JFrame configuration start-----------------------------------*/

        zakaz.clear();

        /*--------------------------- Table row select Listener start-----------------------------------*/
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    int i = table.getSelectedRow();
                    JT_id.setText((String)model.getValueAt(i, 0));
                    JT_goods.setText((String)model.getValueAt(i, 1));
                    JT_count.setText((String)model.getValueAt(i, 2));
                    JT_sort.setText((String)model.getValueAt(i, 3));
                    Jt_price.setText((String)model.getValueAt(i, 4));
                }
            });
        /*---------------------------Add table row select Listener end-----------------------------------*/

        /*---------------------------Add goods info ib file - Listener start-----------------------------------*/
            btn_add.addActionListener((e) -> {
                String filename = "test.txt";

                try {
                    PrintWriter br = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/" + Shop_name.getSelectedItem() + "_" + filename), true)));
                    if(shop_name == 1) {
                        shop_dates = new Shop_date();
                        shop_dates.setName((String)Shop_name.getSelectedItem());
                        shop_dates.setMonth((String)Shop_month.getSelectedItem());
                        shop_dates.setDay(((Integer)Shop_day.getSelectedItem()).intValue());
                        shop_dates.setYear(((Integer)Shop_year.getSelectedItem()).intValue());
                    }

                    br.println(JT_id.getText() + "," + JT_goods.getText() + "," + JT_count.getText() + "," + JT_sort.getText() + "," + Jt_price.getText());
                    br.flush();
                    br.close();
                    JOptionPane.showMessageDialog((Component)null, "Avelacva& e");
                    int i = table.getSelectedRow();
                    model.setValueAt(JT_count.getText(), i, 2);
                    shop_name = 0;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            });
        /*---------------------------Add goods info ib file - Listener end-----------------------------------*/


        /*--------------------------- Shop Excel file creating - Listener start-----------------------------------*/
            int[] a = new int[]{1};
            btn_Excel.addActionListener((e) -> {
                if(a[0] == 1) {
                    (new Excel_add()).esim(shop_dates);
                    a[0] = 0;
                }
            });
        /*--------------------------- Shop Excel file creating - Listener end-----------------------------------*/

    }
}
