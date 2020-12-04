package Comparator;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author amuxiaowu
 */
public class CommentGroupComparator extends WritableComparator {

    protected CommentGroupComparator() {
        super(Text.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        Text text1 = (Text) a;
        Text text2 = (Text) b;
        int i = text1.toString().compareTo(text2.toString());
        return i;
    }
}
