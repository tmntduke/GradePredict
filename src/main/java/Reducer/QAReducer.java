package Reducer;

import Model.QAInfo;
import Model.TmpInfo;
import Util.GsonUtil;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;

public class QAReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        QAInfo info = new QAInfo();
        info.setId(key.toString());
        ArrayList<QAInfo.CommentsBean> commentsBeans = new ArrayList<>();
        int count = 1;
        for (Text t : values) {
            QAInfo.CommentsBean commentsBean = new QAInfo.CommentsBean();
            commentsBean.setC_id(String.valueOf(count));
            commentsBean.setComment(t.toString());
            count++;
            commentsBeans.add(commentsBean);
        }
        info.setCount(count-1);
        info.setComments(commentsBeans);
        String s = GsonUtil.object2json(info);
        context.write(key, new Text(s));
    }
}
