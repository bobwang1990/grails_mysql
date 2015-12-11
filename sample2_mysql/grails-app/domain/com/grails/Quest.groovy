package com.grails

class Quest {
	String name
	Date startDate = new Date()
	
	//static searchable = true
	static hasMany = [tasks:Task]
	
    static constraints = {
		name blank:false
    }
}
