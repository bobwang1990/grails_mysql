<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Form</title>
	</head>
	<body>
        <g:form controller="person" action="save">
            <label>First Name: </label>
            <g:textField name="firstName"/><br/>
            <label>Last Name: </label>
            <g:textField name="lastName"/><br/>
            <label>Salary: </label>
            <g:textField name="salary"/><br/>
            <g:actionSubmit value="Save"/>
        </g:form>
	</body>
</html>