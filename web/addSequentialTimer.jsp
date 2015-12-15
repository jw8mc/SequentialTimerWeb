<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 12/14/2015
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Sequential Timer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

</head>
<body>
  <form class="form-horizontal" role="form" action="addnewtimer" method="post">
      <div class="form-group">
          <label class="control-label col-xs-2" for="username">Username:</label>
          <div class="col-xs-6">
              <input type="text" class="form-control" id="username" name="username" />
          </div>
      </div>
      <div class="form-group">
          <label class="control-label col-xs-2" for="name">Timer Name:</label>
          <div class="col-xs-6">
              <input type="text" class="form-control" id="name" name="name" />
          </div>
      </div>
      <div class="form-group">
          <label class="control-label col-xs-2" for="duration">Duration (minutes):</label>
          <div class="col-xs-6">
              <input type="text" class="form-control" id="duration" name="duration" />
          </div>
      </div>
      <div class="form-group">
          <label class="control-label col-xs-2" for="snooze">Snooze:</label>
          <div class="col-xs-6">
              <input type="text" class="form-control" id="snooze" name="snooze" />
          </div>
      </div>
      <div class="form-group">
          <div class="col-xs-offset-2 col-xs-2">
              <input type="submit" class="btn btn-default" value="Add Timer" />
          </div>
      </div>
  </form>
</body>
</html>
