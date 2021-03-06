
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add New Sequential Timer</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

</head>
<body>
<form class="form-horizontal" role="form" action="addnewsequence" method="post">
  <div class="form-group">
    <label class="control-label col-xs-2" for="username">Username:</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="username" name="username" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-2" for="start">Start Time (24h time):</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="start" name="start" />
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-2">Repeat:</label>
    <div class="col-xs-6">
      <label><input type="checkbox" name="repeat" value="Sunday" />Sunday</label>
      <label><input type="checkbox" name="repeat" value="Monday" />Monday</label>
      <label><input type="checkbox" name="repeat" value="Tuesday" />Tuesday</label>
      <label><input type="checkbox" name="repeat" value="Wednesday" />Wednesday</label>
      <label><input type="checkbox" name="repeat" value="Thursday" />Thursday</label>
      <label><input type="checkbox" name="repeat" value="Friday" />Friday</label>
      <label><input type="checkbox" name="repeat" value="Saturday" />Saturday</label>
    </div>
  </div>
  <div class="form-group">
    <div class="col-xs-offset-2 col-xs-2">
      <input type="submit" class="btn btn-default" value="Add Sequence" />
    </div>
  </div>
</form>
</body>
</html>
