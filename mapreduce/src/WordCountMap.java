
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class WordCountMap extends Mapper<LongWritable,Text,Text,IntWritable>{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        super.map(key, value, context);
        String line = value.toString(); // 读取一行数据
        String str[] = line.split("");

        for(String s: str) {  //循环迭代字符串，将单词编程<key,value>形式，以及<"hello",1>
            context.write(new Text(s),new IntWritable());
        }
    }
}
