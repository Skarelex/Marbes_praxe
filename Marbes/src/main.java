import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class main {
     public static String sourceFile;
    public static void existVerification() throws IOException {
        boolean isExisting = false;
        System.out.println("Enter source to file please!");
        String source;

        while(!isExisting){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            source = br.readLine();
            File numbers = new File(source);

            if(numbers.exists()) {
                BufferedReader bf = new BufferedReader(new FileReader(new File(source)));
                sourceFile = source;
                String line = bf.readLine();
                while(line != null){
                    //System.out.println(line);
                    line = bf.readLine();
                }
                break;
            }else {
                System.out.println("Wrong source to file or file does not exist");
            }
        }
    }
    public static void max(int numOption) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(sourceFile)));
        String line = br.readLine();
        while(line != null){
            int tmp = Integer.parseInt(line);
            numbers.add(tmp);
            line = br.readLine();
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - 1 -i;j++){
                if(numbers.get(j) < numbers.get(j+1)){
                    int tmp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j+1, tmp);
                }
            }
        }
        System.out.println("The biggest " + numOption + " numbers:");
        for (int i = 0; i < numOption; i++) {
            System.out.print(numbers.get(i) + ";");
        }
        System.out.println();
    }
    public static void avg() throws IOException {
        int finalvalue = 0;
        int numbersInFile = 0;
        BufferedReader br = new BufferedReader(new FileReader(new File(sourceFile)));
        String line = br.readLine();
        while(line != null){
            int tmp = Integer.parseInt(line);
            finalvalue += tmp;
            numbersInFile++;
            line = br.readLine();
        }
        System.out.println("Average value is: " + finalvalue/numbersInFile);
    }
    public static void write(int numOptionWrite) throws IOException {
        try(FileWriter fw = new FileWriter(sourceFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(numOptionWrite);
        } catch (IOException e) {
            System.out.println("Something went wrong :/");
        }
    }

    public static String option() throws IOException {
        String option;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        option = br.readLine();
        return option;
    }
    public static void main(String[] args) throws IOException {
        existVerification();
        boolean finished = false;
        while(!finished) {
            System.out.println("------Please enter what you need------\n" +
                                "MAX\n"  +
                                "AVG\n"  +
                                "WRITE\n"  +
                                "EXIT\n"  +
                                "---------------------------------------");
            switch(option()){
                case "MAX" :
                    System.out.println("Enter amount please");
                    int numOption = Integer.parseInt(option());
                    max(numOption);
                    break;
                case "AVG":
                    avg();
                    break;
                case "WRITE":
                    System.out.println("Enter value please");
                    int numOptionWrite = Integer.parseInt(option());
                    write(numOptionWrite);
                    break;
                case "EXIT":
                    finished = true;
                    break;
                default:
                    System.out.println("Something went wrong, please try again");
            }
        }
    }
}

