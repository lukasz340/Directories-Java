import java.io.File;
import java.util.*;

public class DiskDirectory extends DiskElement
{
    Set<DiskElement> element;
    Comparator<DiskElement> comparator;

    public DiskDirectory(File file, Comparator<DiskElement> cmp)
    {
        this.file = file;
        if(cmp == null)
            this.element = new TreeSet<DiskElement>();
        else
            this.element = new TreeSet<DiskElement>(cmp);

        this.comparator = cmp;

        for(File f : file.listFiles())
        {
            if(f.isDirectory() == true)
                this.element.add(new DiskDirectory(f, cmp));
            else if(f.isFile() == true)
                this.element.add(new DiskFile(f));
        }
    }

    public DiskDirectory(String path, Comparator<DiskElement> comparator)
    {
        this(new File(path), comparator);
    }

    protected void print(int depth)
    {
        System.out.println(this.format(depth));

        for(DiskElement e : this.element)
            e.print(depth + 1);
    }




}

