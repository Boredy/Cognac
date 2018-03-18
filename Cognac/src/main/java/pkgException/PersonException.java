package pkgException;
import com.cisc181.core.*;

public class PersonException extends Exception{
	private Person Person;
	
	public PersonException(String args, Person p) {
		super(args);
		this.Person = p;
	}

	public Person getPerson() {
		return Person;
	}
	
}
