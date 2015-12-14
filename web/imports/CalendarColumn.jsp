<%@ page import="com.google.api.services.calendar.model.Event" %>
<%@ page import="sequentialTimer.services.GoogleCalendarConsumer" %>
<%@ page import="com.google.api.client.util.DateTime" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.FieldPosition" %>
<%@ page import="java.text.ParsePosition" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 12/8/2015
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="row">
        <div class="col-xs-4 centered">
            <h3>DATE</h3>
        </div>
        <div class="col-xs-2 centered">
            <h3>TIME</h3>
        </div>
        <div class="col-xs-6">
            <h3>DESCRIPTION</h3>
        </div>
    </div>
<%
    String ALL_DAY_EVENT_MESSAGE = "All Day";
    List<Event> events = GoogleCalendarConsumer.retrieveCalendarEvents();

    DateFormat formatDate = new SimpleDateFormat("EEEE, MM/dd/yy");
    DateFormat formatTime = new SimpleDateFormat("HH:mm");

    for (Event e : events) {
        DateTime start = e.getStart().getDateTime();
        String date;
        String time;
        if (start == null) {
            start = e.getStart().getDate();
            Date startDate = new Date(start.getValue());
            date = formatDate.format(startDate);
            time = ALL_DAY_EVENT_MESSAGE;
        } else {
            Date startDate = new Date(start.getValue());
            time = formatTime.format(startDate);
            date = formatDate.format(startDate);
        }
        String desc = e.getSummary();
        pageContext.setAttribute("time", time);
        pageContext.setAttribute("desc", desc);
        pageContext.setAttribute("date", date);
%>

    <div class="row">
        <div class="col-xs-4">
            ${date}
        </div>
        <div class="col-xs-2">
            ${time}
        </div>
        <div class="col-xs-6">
            ${desc}
        </div>
    </div>

<%
    }
%>