import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {

    private String filename;
    private String parent_path;
    private String text;
    private String Cleaned_text;
    public HashMap<String, Integer> map;

    public TextAnalyzer(String textPath) throws IOException{

        File f = new File(textPath);

        String[] parts = f.getName().split("\\.");

        if (!parts[parts.length - 1].equals("txt")){
            throw new IOException("file is not a text file");
        }

        try{


            this.filename = parts[parts.length - 2];
            this.parent_path = f.getParent();

            Scanner reader = new Scanner(f);

            text = "";
            while (reader.hasNextLine()) {
                text += reader.nextLine() + "\n";
            }
            reader.close();

        }catch (FileNotFoundException e) {
            throw new IOException("file not found");
        }


    }

    public void cleanText() throws CleanFailException{

        File f = new File(this.parent_path + "/" + this.filename + "Normalize.txt");

        try{

            if (!f.createNewFile()) {
                throw new CleanFailException("CleanFailException: file \"" + f.getAbsolutePath() + "\" already exist");
            }

            FileWriter out = new FileWriter(f);

            String output = text.replaceAll("-", " ");

            output = output.replaceAll("[^a-zA-Z \\t\\n]", "");

            output = output.replaceAll("[ ]{2,}", " ");

            output = output.toLowerCase(Locale.ENGLISH);

            out.write(output);
            out.close();

            Cleaned_text = output;

            remove_stop_words();

        } catch (IOException e) {
            f.delete();
            throw new CleanFailException(e.getMessage());
        }




    }

    public void remove_stop_words() throws IOException {

        File cleaned_file = new File(this.parent_path + "/" + this.filename + "Clean.txt");

        try {

            File stop_words = new File(this.parent_path + "/" + "stopWords.txt");

            if (!stop_words.exists()) {
                throw new CleanFailException("file \"" + stop_words.getAbsolutePath() + "\" doesn't exist");
            }

            if (!cleaned_file.createNewFile()) {
                throw new CleanFailException("file \"" + cleaned_file.getAbsolutePath() + "\" already exist");
            }

            FileWriter output = new FileWriter(cleaned_file);

            Scanner reader = new Scanner(stop_words);

            String result = Cleaned_text;


            while (reader.hasNextLine()) {

                String word = reader.nextLine();

                result = result.replaceAll("^" + word + " ", "");
                result = result.replaceAll(" " + word + " ", " ");
                result = result.replaceAll(" " + word + "$", "");
            }


            output.write(result);
            reader.close();
            output.close();

        }catch(IOException e){
            cleaned_file.delete();
            throw new CleanFailException(e.getMessage());
        }

    }

    public void countWords() throws CountFailException{

        map = new HashMap<>();

        File cleaned_file = new File(this.parent_path + "/" + this.filename + "Clean.txt");

        try{


            Scanner reader = new Scanner(cleaned_file);

            text = "";
            while (reader.hasNextLine()) {
                String[] words = reader.nextLine().split(" ");
                for(int i = 0 ; i < words.length ; i ++){
                    if(map.containsKey(words[i])){
                        map.put(words[i] , map.get(words[i]) + 1 );
                    }else{
                        map.put(words[i], 1);
                    }
                }

            }
            reader.close();

        }catch (FileNotFoundException e) {
            throw new CountFailException("file not found");
        }


    }

    public void generateStatistics() throws GenerationFailException{

        File stat_file = new File(this.parent_path + "/" + this.filename + "Stat.txt");

        try {

            if (!stat_file.createNewFile()) {
                throw new CleanFailException("file \"" + stat_file.getAbsolutePath() + "\" already exist");
            }

            FileWriter output = new FileWriter(stat_file);

            int count = 0;
            int unq_count = 0;

            for (String key : map.keySet()){
                unq_count ++;
                count += map.get(key);
            }



            HashMap.Entry<String, Integer> maxEntry = null;

            for (HashMap.Entry<String, Integer> entry : map.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }

            int[] words_starts_with = new int[26];

            String[] words = new String[unq_count];


            int k = 0;
            for (String key : map.keySet()){
                words[k] = key;
                k ++;
                int index = ( (int) key.charAt(0) ) - 97;
                words_starts_with[index] = words_starts_with[index] + 1 ;
            }

            output.write("Total words: "+ count + "\n");
            output.write("Total unique  words: "+ unq_count + "\n");
            output.write("Most occurred word: "+ maxEntry.getKey() + "\n");

            for(int i = 0 ; i < 26 ; i ++){
                char letter = (char)(i + 65);
                output.write(letter+ ": "+ words_starts_with[i] + "\n");
            }

            output.write("Word count:\n" +
                    "Word\t\t\tcount\t\t% from total\n" +
                    "---------------------------------------------------\n");

            Arrays.sort(words);

            for(int i = 0 ; i < unq_count ; i ++){
                int occurenesses = map.get(words[i]);
                double prcntg = occurenesses / (double) count;

                Formatter fmt = new Formatter();

                output.write(String.valueOf(fmt.format("%-19s %-3s %-3s %n", words[i], occurenesses, prcntg)));
            }


            output.close();

        }catch(IOException e){
            stat_file.delete();
            throw new GenerationFailException(e.getMessage());
        }

    }



}

