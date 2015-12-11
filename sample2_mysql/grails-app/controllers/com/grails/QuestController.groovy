package com.grails



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QuestController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Quest.list(params), model:[questInstanceCount: Quest.count()]
    }

    def show(Quest questInstance) {
        respond questInstance
    }

    def create() {
        respond new Quest(params)
    }

    @Transactional
    def save(Quest questInstance) {
        if (questInstance == null) {
            notFound()
            return
        }

        if (questInstance.hasErrors()) {
            respond questInstance.errors, view:'create'
            return
        }

        questInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'quest.label', default: 'Quest'), questInstance.id])
                redirect questInstance
            }
            '*' { respond questInstance, [status: CREATED] }
        }
    }

    def edit(Quest questInstance) {
        respond questInstance
    }

    @Transactional
    def update(Quest questInstance) {
        if (questInstance == null) {
            notFound()
            return
        }

        if (questInstance.hasErrors()) {
            respond questInstance.errors, view:'edit'
            return
        }

        questInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Quest.label', default: 'Quest'), questInstance.id])
                redirect questInstance
            }
            '*'{ respond questInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Quest questInstance) {

        if (questInstance == null) {
            notFound()
            return
        }

        questInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Quest.label', default: 'Quest'), questInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'quest.label', default: 'Quest'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
