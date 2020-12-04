package Partition;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


public class CommentPartition extends Partitioner<Text, IntWritable> {
    @Override
    public int getPartition(Text text, IntWritable intWritable, int i) {
        String num = text.toString();
        if (num.startsWith("220201")) {
            return 0;
        } else if (num.startsWith("220202")) {
            return 1;
        } else if (num.startsWith("3")) {
            return 2;
        } else {
            return 3;
        }
    }
}
