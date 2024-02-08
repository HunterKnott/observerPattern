package op.controller;
import java.util.List;
import java.io.*;

// A report that displays the average of all local stock prices of each snapshot, along
// with the time the snapshot was taken
public class AverageObserver implements Observer, Display {
	public AverageObserver() {
		
	}
	
	public void update(Snapshot snapshot) {
		float average = 0;
		for (List<String> line: snapshot.getData()) {
			average += Float.parseFloat(line.get(LineValues.CURRENTPRICE.getValue()));
		}
		average = average / snapshot.getData().size();
		
		String output = snapshot.getDateTime() + ", Average price: " + average;
		display(output);
	}
	
	public void display(String output) {
//		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
//			writer.println(output);
		
        // Get the package directory
        String packageDir = AverageObserver.class.getPackage().getName().replace('.', '/');
        
        // File path
        String filePath = packageDir + "/Average.dat";
        System.out.println(packageDir);

        // Write the string to file
        try {
            // Create FileOutputStream and OutputStreamWriter
            FileOutputStream fos = new FileOutputStream(filePath);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            
            // Write the string to the file
            osw.write(output);
            
            // Close the resources
            osw.close();
            fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
