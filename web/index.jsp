<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/27/2015
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <!-- BOOTSTRAP CDN LINKS -->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
        <style>
            .centered {
                text-align: center;
            }
            div.main {
                border: solid 5px black;
                height: 100%;
            }
            div.clock {
                height: 200px;
            }
        </style>
        <title>Sequential Timer Hub</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-4 main">
                    <div class="row">
                        <div class="col-xs-12">
                            <h3 class="centered">TIMERS</h3>
                            <hr />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4"><button class="btn btn-success btn-sm btn-block">New Timer</button></div>
                        <div class="col-xs-4"><button class="btn btn-warning btn-sm btn-block">Edit Current Timer</button></div>
                        <div class="col-xs-4"><button class="btn btn-danger btn-sm btn-block">Delete Timer</button></div>
                    </div>
                    <hr />
                    <div class="row">
                        <div class="col-xs-12"><h4 class="centered">anchor alarm</h4></div>
                    </div>
                    <div class="row"> <!-- REPEAT FOR EACH SEQUENTIAL TIMER -->
                        <div class="col-xs-2">time</div><div class="col-xs-10">label</div>
                    </div>
                </div>
                <div class="col-xs-4 main">
                    <div class="row" style="border-bottom: solid 10px black;">
                        <div class="col-xs-12 clock">
                            <h3 class="centered">CLOCK</h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <h3 class="centered">TASKS</h3>
                            <hr />
                            <div class="row">
                                <div class="col-xs-4"><button class="btn btn-success btn-sm btn-block">New Task</button></div>
                                <div class="col-xs-4"><button class="btn btn-warning btn-sm btn-block">Edit Task</button></div>
                                <div class="col-xs-4"><button class="btn btn-danger btn-sm btn-block">Delete Task</button></div>
                            </div>
                            <hr />
                            <div class="row"> <!-- REPEAT FOR EACH TASK -->
                                <div class="col-xs-2">checkbox</div><div class="col-xs-10">label</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4 main">
                    <h3 class="centered">EVENTS</h3>
                    <hr />
                    <div class="row">
                        <div class="col-xs-4"><button class="btn btn-success btn-sm btn-block">New Event</button></div>
                        <div class="col-xs-4"><button class="btn btn-warning btn-sm btn-block">Edit Event</button></div>
                        <div class="col-xs-4"><button class="btn btn-danger btn-sm btn-block">Delete Event</button></div>
                    </div>
                    <hr />
                    <div class="row"> <!-- REPEAT FOR EACH EVENT -->
                        <div class="col-xs-2">time</div><div class="col-xs-10">label</div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
