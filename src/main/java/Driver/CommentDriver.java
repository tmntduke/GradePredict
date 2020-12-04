package Driver;

import Builder.JobBuilder;
import Comparator.IntValueComparator;
import Mapper.CommentMapper;
import Partition.CommentPartition;
import Reducer.CommentReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class CommentDriver {
    public static void main(String[] args) {
        JobBuilder.newInstance()
                .setMapReduceClass(CommentMapper.class, CommentReducer.class)
                .setMapOutputClass(Text.class, IntWritable.class)
                .setJarClass(CommentDriver.class)
                .setOutputClass(Text.class, IntWritable.class)
                .setPartitionClass(CommentPartition.class)
                .setMapreduceNum(4)
                .setFormatPath("/Users/amuxiaowu/Desktop/mooc_python/qian_id/all.txt", "/Users/amuxiaowu/Desktop/mooc_python/qian_id/output")
                .execute();
    }
}
