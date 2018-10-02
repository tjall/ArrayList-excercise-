package hw;
import java.util.List;
import java.util.ArrayList;

public class ArrayListExercise {
	public static void main(String[] args) {
		//for testing allStringSizeOf
		List<String> wordsAndStuff = new ArrayList<>();
		wordsAndStuff.add("yo");
		wordsAndStuff.add("hey");
		wordsAndStuff.add("bod");
		wordsAndStuff.add("Tod");
		wordsAndStuff.add("Howard");
		System.out.println(allStringSizeOf(wordsAndStuff,3));
		
		
		// test for multiples
		List<Integer> numbersAndStuff = new ArrayList<>();
		numbersAndStuff.add(16);
		numbersAndStuff.add(4);
		numbersAndStuff.add(6);
		numbersAndStuff.add(36);
		numbersAndStuff.add(19);
		System.out.println(mutiples(numbersAndStuff,4));
		
		// test for the unique method
		List<String> list = new ArrayList<>();
		list.add("killer");
		list.add("of");
		list.add("Queens");
		System.out.println("Is this list unique: "+unique(list));
		
		// This second array list was made to test the permutation  
		List<String> words = new ArrayList<>(); 
		words.add("of");
		words.add("Queens");
		words.add("killer");
		System.out.println(permutation(list,words));
		
		
		// This takes a string and sends it to the stringToListOfWords to turn it into a list of words
		System.out.println(stringToListOfWords("Tyler is a Dingo!"));
		
		
		// This code makes a new arraylist specifically for removing items from the list
		List<Integer> forremove = new ArrayList<>(); 
		forremove.add(8);
		forremove.add(9);
		forremove.add(8);
		forremove.add(7);
		removeAllInstances(forremove,8);
		System.out.println(forremove);
	}
	
	
	// uses nested for loop to determine if every item in the array is unique and only occurs once
	public static <E> boolean unique(List<E> list) {
		for(int i = 0; i < list.size();i++) {
			for(int j = 0; j < list.size();j++) {
				E the_i = list.get(i);
				E the_j = list.get(j);
				if(i==j) {
					continue;
				}
				if(the_i.equals(the_j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//it goes through the one of the list once and checks to see if an element of one list is contained in the other
	// in the end a variable keeps track of how many time is found in both and if it equals their size() then its a permutation
	public static <E extends Comparable> boolean permutation(List<E>list_1, List<E> list_2) {// if the list are not the same size then it is not a permutation
		get_in_order(list_1);
		get_in_order(list_2);
		if(list_1.size() < list_2.size() || list_1.size() > list_2.size()){
			return false;
		}
		int imKeepingCountOfYou = 0;
		for(int i = 0; i < list_1.size();i++) {
			if(list_1.get(i).equals(list_2.get(i))) {
				imKeepingCountOfYou++;
				
			}
			
		}
		if(imKeepingCountOfYou == list_1.size()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//using the split method of String I create an array  so that I can copy the different parts of the string to an array list 
	public static List<String> stringToListOfWords(String i){
		String[] parts = i.split(" ");
		List<String> i_hold_stuff = new ArrayList<>();
		for(int j = 0; j < parts.length; j++) {
			i_hold_stuff.add(parts[j]);
		}
		return i_hold_stuff;
	}
	
	//since the size is always changing the best thing to do is use a recursive method, pass it the new list that has one instance
	// of the item being removed and repeat the process until all occurances of the item are no longer in the list
	public static<E> void removeAllInstances(List<E> list, E item) {
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).equals(item)) {
				list.remove(i);
				removeAllInstances(list, item);
			}
		}
	}
	
	
	public static List<String> allStringSizeOf(List<String> list, int lengthTarget){
		   List <String> meets_length = new ArrayList<>();
		   for(int i = 0 ;i<list.size(); i++){
		       if(list.get(i).length() == lengthTarget){
		           meets_length.add(list.get(i));

		       }
		   }
		   return meets_length;
		}
	
	
	public static List<Integer> mutiples(List<Integer> list, int What_I_want_mutiples_of){
		   List <Integer> multiples = new ArrayList<>();
		   for(int i = 0;i < list.size();i++){
		       int place_holder = list.get(i);
		       if(place_holder % What_I_want_mutiples_of == 0 ){
		           multiples.add(place_holder);

		       }
		   }
		   return multiples;
		}
	public static <E extends Comparable> void get_in_order(List<E> b){
		E tmp;
		E temp_;
		for(int i = 0;i < b.size();i++){
			for(int j = 1;j < b.size();j++){
				if(b.get(i).compareTo(b.get(j)) > 0){
					tmp = b.get(j);
					temp_ = b.get(i);
					b.set(j, temp_);
					b.set(i, tmp);
				}
			}
		}

	}

}
