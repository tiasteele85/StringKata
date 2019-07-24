

public class Calculator {

    
    public String add(String number) {
        
    	double sum = 0.0;
    	
        if (number == null) {
            return "0.0";
        }
        
        if(number.endsWith(","))
        {
        	return "Number expected but EOF found";
        }

        if(number.startsWith("//")) {
        	String delimiter = "";
        	String[] parts;
        	if(number.contains("|"))
        	{
        		String numbers = number.substring(5);
        		parts = numbers.split("\\|");
        	}else {
	        	int position = number.indexOf("\\");
	        	delimiter += number.substring(2,position);
	        	String numbers = number.substring(position + 2);
	        	parts = numbers.split(delimiter);
        	}
            for (int i = 0; i < parts.length; i++) {
                sum += Double.parseDouble(parts[i]);
            }
            return Double.toString(sum);
        	
        }
        
        if (number.contains("\n")) {
            number = number.replace('\n', ',');
        }

        
        if (number.isEmpty()) {
            return "0.0";

        } 
        
            String[] parts = number.split(","); // String [1.1, 2.2, 1.2]
            for (int i = 0; i < parts.length; i++) {
            	if(Double.parseDouble(parts[i]) < 0) {
            		return "Negative not allowed : " + parts[i];
            	}
                sum += Double.parseDouble(parts[i]);
            }
            return Double.toString(sum);
        

    }

}