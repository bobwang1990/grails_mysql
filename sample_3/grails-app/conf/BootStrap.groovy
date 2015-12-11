import com.grails.sample3.Person;

class BootStrap {

	def init = { servletContext ->
		//if(Person.count == 0){
			new Person(firstName: 'John', lastName: 'Smith', salary: 2000).save()
			new Person(firstName: 'Scott', lastName: 'Robinson', salary: 2700).save()
		//}
	}
	def destroy = {
	}
}
