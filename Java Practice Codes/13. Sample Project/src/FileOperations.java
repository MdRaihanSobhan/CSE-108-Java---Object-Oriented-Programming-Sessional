import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    private static final String INPUT_FILE_NAME = "in.txt";
    private static final String OUTPUT_FILE_NAME = "out.txt";

    public static List<Student> readFromFile() throws Exception {
        List<Student> studentList = new ArrayList();
        // var studentList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        // var br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Student s = new Student();
            s.setId(Integer.parseInt(tokens[0]));
            s.setName(tokens[1]);
            s.setMobileNo(tokens[2]);
            s.setCreditCompleted(Integer.parseInt(tokens[3]));
            studentList.add(s);
        }
        br.close();
        return studentList;
    }

    public static void writeToFile(List<Student> studentList) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        // var bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (Student s : studentList) {
            bw.write(s.getId() + "," + s.getName() + "," + s.getMobileNo() + "," + s.getCreditCompleted());
            bw.write("\n");
        }
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        List<Student> studentList = readFromFile();
        for (Student s : studentList) {
            System.out.println(s.getId() + ", " + s.getName() + ", " + s.getMobileNo() + ", " + s.getCreditCompleted());
        }
        writeToFile(studentList);
    }
}