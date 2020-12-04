package Mapper;

import Application.Application;
import Model.StuInfo;
import Util.GsonUtil;
import Util.StringUtil;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class QAMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s = value.toString();
        StuInfo info = (StuInfo) GsonUtil.json2object(s, StuInfo.class);
        String stuId = StringUtil.getStuId(info.getId());
        context.write(new Text(stuId), new Text(info.getAnswer()));
    }
}
