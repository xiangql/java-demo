package com.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class TaskController {
    public int ttype;
    public String tname;
    public String tshell;
    public List<String> tparams;
    public int tpid;
    public int tstate;

    public void run() throws IOException, InterruptedException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        //System.out.println(isWindows);
        String homeDirectory = String.format("%s\\src\\main\\java\\com\\monitor\\", System.getProperty("user.dir"));
        System.out.println(homeDirectory);
        Process process;
        Runtime rt = Runtime.getRuntime();
        if (isWindows) {
            String[] cmd = {"cmd","/C", String.format("python %shello.py", homeDirectory)};
            process = rt.exec(cmd);
            InputStream fs = process.getInputStream();
            InputStreamReader ret = new InputStreamReader(fs);
            BufferedReader str = new BufferedReader(ret);
            String line = null;
            while ((line=str.readLine())!=null){
                System.out.println(line);
            }
        } else {
            process = rt.exec("dir");
        }
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        TaskController controller = new TaskController();
        controller.run();
    }
}
