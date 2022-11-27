package com.rbu;

import lombok.Builder;
import lombok.Data;

//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Value
//Generates a lot of code which fits with a class that is a representation 
//of an immutable entity. 

//Equivalent to @Getter @FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE) @AllArgsConstructor @ToString @EqualsAndHashCode. 

//@Data
//@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode. 
@Builder
@Data
public class Course {

	private int courseid;
	private String coursename;
	private String duration;
	

	

}
