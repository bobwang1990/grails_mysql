<%@ page import="com.grails.Quest" %>



<div class="fieldcontain ${hasErrors(bean: questInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="quest.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${questInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: questInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="quest.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${questInstance?.startDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: questInstance, field: 'tasks', 'error')} ">
	<label for="tasks">
		<g:message code="quest.tasks.label" default="Tasks" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${questInstance?.tasks?}" var="t">
    <li><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="task" action="create" params="['quest.id': questInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'task.label', default: 'Task')])}</g:link>
</li>
</ul>


</div>

