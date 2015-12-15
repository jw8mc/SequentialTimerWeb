<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
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
        <!-- ALARM ALERT MODAL -->
        <div class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">${alarmName}</h4>
                    </div>
                    <div class="modal-body">
                        <h1>${alarmName}</h1>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-lg" data-dismiss="modal">Got It!</button>
                        <button type="button" class="btn btn-lg" data-dismiss="modal">Snooze</button>
                        <button type="button" class="btn btn-lg" data-dismiss="modal">Cancel All Alarms</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- ACTUAL FRONT PAGE CODE -->
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
                        <div class="col-xs-4 col-xs-offset-2">
                            <button class="btn btn-success btn-sm btn-block"
                                    onclick="window.open('addSequentialTimer.jsp');">New Timer</button>
                        </div>
                        <div class="col-xs-4"><button class="btn btn-danger btn-sm btn-block">Modify/Delete Timer</button></div>
                    </div>
                    <hr />
                    <c:import url="/imports/timerColumn.jsp" />
                </div>

                <!-- CLOCK and TASK COLUMN -->
                <div class="col-xs-4 main">
                    <div class="row" style="border-bottom: solid 10px black;">
                        <!-- CLOCK BOX -->
                        <div id="clockDiv" class="col-xs-12">
                            <div class="col-xs-12 centered">
                                <%
                                    Date today = new Date();
                                    DateFormat format = new SimpleDateFormat("EEEE, MMMM dd yyyy");
                                    String formattedToday = format.format(today);
                                    pageContext.setAttribute("date", formattedToday);
                                %>
                                <h3>${date}</h3>
                            </div>
                            <div class="clock centered"></div>

                            <script type="text/javascript">

                                $(document).ready(function() {
                                    var clock;

                                    // Instantiate a counter
                                    clock = new FlipClock($('.clock'), {
                                        clockFace: 'TwentyFourHourClock'
                                    });
                                });

                            </script>
                        </div>
                    </div>
                    <div class="row">
                        <!-- KITTEN BOX -->
                        <div>
                            <c:import url="/imports/RESTfulKittens.jsp" />
                        </div>
                    </div>
                </div>

                <!-- CALENDAR COLUMN -->
                <div class="col-xs-4 main">
                    <h3 class="centered">EVENTS</h3>
                    <hr />
                    <div class="row">
                        <div class="col-xs-4 col-xs-offset-4">
                            <button class="btn btn-success btn-sm btn-block" onclick="window.open('https://calendar.google.com/calendar/');">Your Calendar</button>
                        </div>
                    </div>
                    <hr />
                    <c:import url="/imports/CalendarColumn.jsp" />
                </div>
            </div>
        </div>
    </body>
</html>
