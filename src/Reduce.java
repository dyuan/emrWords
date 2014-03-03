import java.io.IOException;
import java.util.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class Reduce extends Reducer<Text, Text, Text, Text> {
    
    public void reduce(Text key, Iterable<Text> values, Context context)
    throws IOException, InterruptedException {
        HashMap <String, Integer> result = new HashMap<String, Integer>();
        for (Text val : values) {
        	String s=val.toString();
        	if (result.containsKey(s)){
        		result.put(s, new Integer(result.get(s).intValue()+1));
        	}
        	else{
        		result.put(s, new Integer(1));
        	}
        }
        context.write(key, new Text(result.toString()));
    }
}