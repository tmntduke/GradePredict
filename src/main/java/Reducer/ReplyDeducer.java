package Reducer;

import Model.ReplyInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class ReplyDeducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int count = 1;
        ArrayList<ReplyInfo> infos = new ArrayList<>();
        for (Text t : values) {
            ReplyInfo info = new ReplyInfo();
            info.setCount(count);
            info.setReply(t.toString());
            infos.add(info);
            count++;
        }
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String s = gson.toJson(infos);
        context.write(key, new Text(s));

    }
}
