package com.grails

class Task {
	String name
	int priority
	Date startDate = new Date()
	Date endDate = new Date() + 1
	boolean finished
	
	static belongsTo = [quest:Quest] 
	
    static constraints = {
		name(blank:false)
		priority range:1..5
		startDate()
		endDate()
		finished()
		
    }
}
