package com.grails.sample3

class PersonController {

   // def scaffold = Person
	//static scaffold = Person
	
	def index(){
		def persons = Person.list()
		[persons:persons]
	}
	
	def form() {
	}
	def save() {
		def person = new Person(params)
		person.save()
		render "Success!"
	}
}
