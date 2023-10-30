package sample.gehealthcare;

import java.util.Comparator;

public class ComparatorExample implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		int nameCompare = o1.getName().compareTo(o2.getName());
        if(nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(o1.getAge(), o2.getAge());
	}
	
	//Usage
	//Collections.sort(l1,comparatorExample);
	//OR
	//l1.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge);

}
