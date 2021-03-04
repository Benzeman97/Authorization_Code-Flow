<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Get Employees</title>
</head>
<body>
<h3 style="color: red;">Get Employee Info</h3>

<div id="getEmployees">
    <form:form action="http://localhost:9090/oauth/authorize"
               method="post">
    <p>
        <label>Get Auth Token</label>
        <br/>
        <input type="text" name="response_type" value="code" />
        <input type="text" name="client_id" placeholder="Enter client Id"/>
        <input type="SUBMIT" value="Get Employee info" />
        </form:form>
</div>
</body>
</html>