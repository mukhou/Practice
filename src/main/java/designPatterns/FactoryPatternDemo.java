package designPatterns;

public class FactoryPatternDemo {
	public static void main(String args[]){
		FactoryPatternDemo factory = new FactoryPatternDemo();
		PersonEnum[] arr = PersonEnum.values();
		for(PersonEnum personEnum : arr){
			System.out.println(personEnum.chomosome());
		}
	}

}

enum PersonEnum{
	MALE{
		@Override
		public String chomosome(){
			return "Y";
		}
	},
	FEMALE{
		@Override
		public String chomosome(){
			return "X";
		}
	};

	public String chomosome(){
		throw new RuntimeException("Undefined");
	}
}

class Person {
	// name string
	public String name;
	// gender : M or F
	private String gender;

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

}

class Male extends Person {
	public Male(String fullName) {
		System.out.println("Hello Mr. " + fullName);
	}
}

class Female extends Person {
	public Female(String fullNname) {
		System.out.println("Hello Ms. " + fullNname);
	}
}