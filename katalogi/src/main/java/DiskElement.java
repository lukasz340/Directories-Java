import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DiskElement implements java.lang.Comparable<DiskElement>
{
    protected File file;
    protected int size;
    protected abstract void print(int depth);

    protected String format(int depth)
    {
        StringBuilder name;
        name = new StringBuilder();

        var append = name.append("-".repeat(Math.max(0, depth)));

        name.append(file.getName());

        Date data;
        data = new Date(file.lastModified());
        String formatted = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(data);
        size = (int) this.getFile().length();
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

        return String.format("%-24s %c %s %s" , name.toString(), (file.isDirectory() ? 'K' : 'P'), size+sizeLength, formatted);
    }

    public File getFile()
    {
        return file;
    }

    public void print()
    {
        print(0);
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiskElement that = (DiskElement) o;

        if (size != that.size) return false;
        return file == null || o.equals(that.file);
    }

    @Override
    public int hashCode() {
        int result = file != null ? file.hashCode() : 0;
        result = 31 * result + size;
        return result;
    }
    @Override
    public int compareTo(DiskElement o1)
    {
        return this.getFile().getName().length() - o1.getFile().getName().length();

    }
}
