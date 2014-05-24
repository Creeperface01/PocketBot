package legendofmcpe.fakeclient.android;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import android.content.Context;

public class Console{
	public final Context ctx;
	public final File log;
	protected final OutputStreamWriter out;
	protected String[] readLog = {};
	protected String[] unreadLog = {};
	public Console(Context ctx, File log) throws FileNotFoundException{
		this.log = log;
		this.ctx = ctx;
		this.out = new OutputStreamWriter(new FileOutputStream(log));
	}
	public void write(String line){
		unreadLog[unreadLog.length] = line;
	}
	public String[] readLog(){
		return readLog(unreadLog.length);
	}
	public String[] readLog(int length){
		String[] output = {};
		for(int i = 0; i < length; i++){
			output[output.length] = readLog[readLog.length] = unreadLog[i];
		}
		String[] newUnread = {};
		for(int j = length; j < unreadLog.length; j++){
			newUnread[newUnread.length] = unreadLog[j];
		}
		unreadLog = newUnread;
		return output;
	}
}
