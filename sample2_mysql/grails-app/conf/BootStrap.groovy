import com.grails.Quest
import com.grails.Task

class BootStrap {

    def init = { servletContext ->
		if(Quest.count == 0){
		new Quest(name:'James')
		.addToTasks(new Task(name:'go back home', priority: 4))
		.save()
		}
    }
    def destroy = {
    }
}
