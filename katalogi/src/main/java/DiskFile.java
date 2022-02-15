
import java.io.File;


public class DiskFile extends DiskElement
{
    public DiskFile(File file)
    {
        this.file = file;
    }

    public DiskFile(String path)
    {
        this(new File(path));
    }

    protected void print(int depth)
    {
        System.out.println(this.format(depth));
    }
}
