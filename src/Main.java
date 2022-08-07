import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        String path1 = new String("C:\\Games\\src");
        String path2 = new String("C:\\Games\\res");
        createNewFolder("C:\\Games\\res");
        createNewFolder("C:\\Games\\src");
        createNewFolder("C:\\Games\\savegames");
        createNewFolder("C:\\Games\\temp");
        createNewFolder("C:\\Games\\src\\main");
        createNewFolder("C:\\Games\\src\\test");
        createNewFile("C:\\Games\\src\\main\\Main.java");
        createNewFile("C:\\Games\\src\\main\\Utils.java");
        createNewFolder("C:\\Games\\res\\drawables");
        createNewFolder("C:\\Games\\res\\vectors");
        createNewFolder("C:\\Games\\res\\icons");
        createNewFile("C:\\Games\\temp\\temp.txt");
        writeIn("C:\\Games\\temp\\temp.txt", builder.toString());
    }

    public static boolean createNewFolder(String path) {
        File dir = new File(path);
        if (dir.mkdir()) {
            builder.append(path + " был создан " + data());
            builder.append(System.getProperty("line.separator"));
            return true;
        } else {
            builder.append("Не удалось создать каталог по адресу " + path);
            builder.append(System.getProperty("line.separator"));
            return false;
        }
    }

    public static boolean createNewFile(String name) {
        File dir1 = new File(name);
        try {
            if (dir1.createNewFile()) {
                builder.append("Файл " + dir1.getName() + " был создан " + data());
                builder.append(System.getProperty("line.separator"));
                return true;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static String data() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:S dd-MM-yyyy");
        Calendar calendar = new GregorianCalendar();
        return formatter.format(calendar.getTime());
    }

    public static void writeIn(String file, String text) {

        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}