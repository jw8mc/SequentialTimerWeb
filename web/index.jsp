<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/27/2015
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <c:import url="/imports/head.jsp" />
        <title>Sequential Timer Hub</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <!-- TIMER COLUMN -->
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

                <!-- CLOCK and TASK COLUMN -->
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

                <!-- CALENDAR COLUMN -->
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
