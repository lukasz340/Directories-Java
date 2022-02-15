import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main
{
    public static void main(String[] Args)
    {
        File file = new File(Args[0]);
        if(!file.isDirectory()|| !( Args[1].equals("Nazwa")
                || Args[1].equals("Rozmiar")))
        {
            System.out.println("Niewlasciwe dane");
            System.out.println(Args[1]);
            return;
        }

        printt.print(Args[0]);

        System.out.format( Args[0], Args[1]);

        DiskDirectory disk = null;
        if(Args[1].equals("Nazwa"))
            disk = new DiskDirectory(Args[0], null);
         else if(Args[1].equals("Rozmiar"))
            disk = new DiskDirectory(Args[0], new DiskComparator());

         if (disk != null)
            disk.print();

    }
}

class printt{
    public static void print(String path)
    {
        for(File file : Objects.requireNonNull(new File(path).listFiles()))
        {
            Date data = new Date(file.lastModified());
            String formatted;
            formatted = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(data);
            int size = (int) file.length();
            String sizeLength = null;
            if (size < 1024)
                sizeLength=" B ";
            else if (size < 1024*1024){
                sizeLength=" kB ";
                size/=1024;
            }
            else if (size < 1024*1024*1024){
                sizeLength=" MB ";
                size/=(1024*1024);

            }

            System.out.format("%-24s %c %s,%s,%s%n", file.getName(), (file.isDirectory() ? 'K' : 'P'),size,sizeLength, formatted);
        }
    }
}