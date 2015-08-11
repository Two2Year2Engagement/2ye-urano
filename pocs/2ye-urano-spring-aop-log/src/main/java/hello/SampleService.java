package hello;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

	public void echo() {

		System.out.println("Must have an log before  this statement.");
	}

}
