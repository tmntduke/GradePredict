package Driver;

import Builder.JobBuilder;
import Mapper.ReplyMapper;
import Reducer.ReplyDeducer;
import org.apache.hadoop.io.Text;

public class ReplyDriver {
    public static void main(String[] args) {
        JobBuilder.newInstance()
                .setJarClass(ReplyDriver.class)
                .setMapReduceClass(ReplyMapper.class, ReplyDeducer.class)
                .setMapOutputClass(Text.class,Text.class)
                .setOutputClass(Text.class,Text.class)
                .setFormatPath("/Users/amuxiaowu/Desktop/mooc_python/qian_id/ping.json","/Users/amuxiaowu/Desktop/mooc_python/qian_id/out2")
                .execute();
    }
}
