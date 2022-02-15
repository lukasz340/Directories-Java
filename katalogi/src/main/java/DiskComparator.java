import java.util.Comparator;

public class DiskComparator implements Comparator<DiskElement> {

        public int compare(DiskElement x1, DiskElement x2)
        {
            return (int) (x1.getFile().length() - x2.getFile().length());
        }
}
