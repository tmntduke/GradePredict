package Driver;

import Builder.JobBuilder;
import Mapper.QAMapper;
import Reducer.QAReducer;
import org.apache.hadoop.io.Text;

public class QADriver {
    public static void main(String[] args) {
        JobBuilder.newInstance()
                .setJarClass(QADriver.class)
                .setMapReduceClass(QAMapper.class, QAReducer.class)
                .setMapOutputClass(Text.class, Text.class)
                .setOutputClass(Text.class, Text.class)
                .setFormatPath("/Users/amuxiaowu/Desktop/mooc_python/test/all_comment.json", "/Users/amuxiaowu/Desktop/mooc_python/comment_out")
                .execute();
    }
}
