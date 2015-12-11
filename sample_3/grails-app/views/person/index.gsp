<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Persons</title>
	</head>
	<body>
        <g:each in="${persons}" var="person" status="i">
            <h3>${i+1}. ${person.lastName}, ${person.firstName}</h3>
            <p>
                Salary: ${person.salary}
                DOB: ${person.dateOfBirth}
            </p>
            <br/>
        </g:each>
	</body>
</html>