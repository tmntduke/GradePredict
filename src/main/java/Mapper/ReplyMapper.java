package Mapper;

import Model.TmpInfo;
import Util.StringUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplyMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        GsonBuilder gsonBuilder;
        Gson gson = new GsonBuilder().create();
        TmpInfo tmpInfo = gson.fromJson(value.toString(), TmpInfo.class);
        String person = StringUtil.getStuId(tmpInfo.getPid());
        context.write(new Text(person), new Text(tmpInfo.getHtml()));
    }
}
