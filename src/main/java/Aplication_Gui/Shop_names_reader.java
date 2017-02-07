package Aplication_Gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Shop_names_reader {
    private static final String FILENAME = "src/main/java/Shop_names.txt";

    public Shop_names_reader() {
    }

    public static String[] read_Shop_name() {
        String[] lists = new String[170];

        try {
            BufferedReader e = new BufferedReader(new FileReader("src/main/java/Shop_names.txt"));
                String str;

                    for(int i = 0; (str = e.readLine()) != null; ++i) {
                        lists[i] = str;
                    }

        } catch (IOException var15) {
            var15.printStackTrace();
        }

        return lists;
    }
}
