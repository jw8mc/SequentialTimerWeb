<%@ page import="sequentialTimer.persistence.TimerSequenceDAO" %>
<%@ page import="sequentialTimer.processing.AllTimerProcessing" %>
<%@ page import="sequentialTimer.processing.TimerSequenceForJSON" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.GsonBuilder" %>
<%@ page import="sequentialTimer.entity.SequentialTimer" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int TEMPORARY_USER_ID_FOR_TESTING_ONLY = 1;
    AllTimerProcessing atp = new AllTimerProcessing(TEMPORARY_USER_ID_FOR_TESTING_ONLY);
    atp.processSequences();

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();

    List<TimerSequenceForJSON> sequences = new ArrayList<TimerSequenceForJSON>();
    sequences = atp.getAllSequencesJSONable();

    pageContext.setAttribute("jsonArray", sequences);
    //for testing purposes, the page is only processing the first sequence for today
    //unfortunately, it'll give an index out of bounds if there are no sequences today
    pageContext.setAttribute("start", sequences.get(0).getStart());
    pageContext.setAttribute("timers", sequences.get(0).getTimers());
    pageContext.setAttribute("jsonTimers", gson.toJson(sequences.get(0).getTimers()));

    for (TimerSequenceForJSON tsJSON : sequences) {
        pageContext.setAttribute("start", tsJSON.getStart());
%>
<div class="row" style="text-align: center; font-weight: bold;">
    <div class="col-xs-12"><h2>${start}</h2></div>
</div>
<%    for (SequentialTimer st : tsJSON.getTimers()) {
    pageContext.setAttribute("interval", st.getDuration());
    pageContext.setAttribute("label", st.getTimerName()); %>
<div class="row">
    <div class="col-xs-2">${interval}</div><div class="col-xs-10">${label}</div>
</div> <%
        }
    } %>
<pre>${jsonTimers}</pre>