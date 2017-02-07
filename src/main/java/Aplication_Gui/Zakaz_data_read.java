package Aplication_Gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Zakaz_data_read {
    private static final String FILENAME = "src/main/java/Parser_pahest.txt";
    private static ArrayList<Zakaz_data> Zakaz_datas = new ArrayList();

    public static ArrayList<Zakaz_data> getZakaz_data() {
        return Zakaz_datas;
    }

    public static void read_Zakaz_data() {
        try {
            BufferedReader e = new BufferedReader(new FileReader("src/main/java/Parser_pahest.txt"));
                String str;
                    while((str = e.readLine()) != null) {
                        getZakaz_data().add(Zakaz_data_Parser(str.split(",")));
                    }
        } catch (IOException var13) {
            var13.printStackTrace();
        }

    }

    public static Zakaz_data Zakaz_data_Parser(String[] list) {
        Zakaz_data zakaz_data = new Zakaz_data();
        zakaz_data.setId(list[0]);
        zakaz_data.setGoods_name(list[1]);
        zakaz_data.setCounts(list[2]);
        zakaz_data.setSort(list[3]);
        zakaz_data.setPrice(list[4]);
        return zakaz_data;
    }

    public Zakaz_data_read() {
    }
}
