package com.hadoop.join;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.Text;

import com.hadoop.join.JoinMapper;
import com.hadoop.join.JoinReducer;

public class Driver {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		// TODO Auto-generated method stub
    Configuration configuration = new Configuration();
    Job job = new Job(configuration, "MRJoin");
    job.setJarByClass(Driver.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job,new Path(args[1])); 
    job.setMapperClass(JoinMapper.class);
    job.setReducerClass(JoinReducer.class);
    //job.setOutputKeyClass(TextOutputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);
    System.exit(job.waitForCompletion(true)?0:1);
    
	}

}
