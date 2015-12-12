<%@ page import="com.google.api.services.calendar.model.Event" %>
<%@ page import="sequentialTimer.services.GoogleCalendarConsumer" %>
<%@ page import="com.google.api.client.util.DateTime" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 12/8/2015
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Event> events = GoogleCalendarConsumer.retrieveCalendarEvents();
    pageContext.setAttribute("events", events);

    for (Event e : events) {
        DateTime start = e.getStart().getDateTime();
        if (start == null) {
            start = e.getStart().getDate();
        }
        String desc = e.getSummary();
        pageContext.setAttribute("time", start);
        pageContext.setAttribute("desc", desc);
%>

    <div class="row">
        <div class="col-xs-3">
            ${time}
        </div>
        <div class="col-xs-9">
            ${desc}
        </div>
    </div>

<%
    }
%>