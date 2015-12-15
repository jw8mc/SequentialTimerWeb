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
<!-- Added from index.js -->
<script>
    var timerIterator;
    var start;
    var timers;
    var formattedStart;
    var alarmDate;

    $('document').ready(function() {
        timerIterator = 0;
        start = '${start}';
        console.log("start " + start );

        timers = JSON.parse('${jsonTimers}');
        console.log("timers " + timers );
        formattedStart = start.replace(":", ", ");
        console.log("formattedStart " + formattedStart );

        alarmDate = new Date();
        alarmDate.setHours(formattedStart);

        setTimeout(firstTimeout, alarmDate.getTime() - new Date().getTime());
    });

    function firstTimeout() {
        console.log("in the first timeout function");
        $('.alarm-name').text("ALARM");
        //check snooze for button disable
        $('#alarm-modal').modal('toggle');
    }

    function nextAlarm() {
        console.log("in the nextAlarm() function");
        console.log("timerIterate " + timerIterator );
        console.log("$(timers).size() " + $(timers).size() );
        // changed from (!timerIterator > timers.size)
        if (timerIterator < $(timers).size()){
            console.log("in the nextAlarm loop for iterator " + timerIterator);
            console.log("name for current iterator " + timers[timerIterator].timerName);
            console.log("duration for current iterator " + timers[timerIterator].duration * 1000);
            console.log("snooze length for current iterator " + timers[timerIterator].snoozeLength * 1000);
            setTimeout(function() {
                console.log("in the nextAlarm's timeout function");
                $('.alarm-name').text(timers[timerIterator].timerName);
                if(timers[timerIterator].snoozeLength <= 0) {
                    console.log("disable snooze button");
                    $('#alarm-snooze').attr("class", "btn btn-lg disabled").attr("onclick", "#");
                } else {
                    console.log("enable snooze button");
                    $('#alarm-snooze').attr("class", "btn btn-lg").attr("onclick", "snooze();");
                }
                $('#alarm-modal').modal('toggle');
            }, timers[timerIterator].duration * 1000);
            timerIterator++;
        }
    }

    function snooze() {
        console.log("in the snooze() function");
        console.log("timerIterate " + timerIterator );
        console.log("$(timers).size() " + $(timers).size() );
        if (timerIterator < $(timers).size()){
            console.log("in the snooze loop for iterator " + timerIterator);
            console.log("name for current iterator " + timers[timerIterator].timerName);
            console.log("duration for current iterator " + timers[timerIterator].duration * 1000);
            console.log("snooze length for current iterator " + timers[timerIterator].snoozeLength * 1000);
            setTimeout(function() {
                console.log("in the snooze's timeout function");
                $('.alarm-name').text(timers[timerIterator].timerName);
                if(timers[timerIterator].snoozeLength <= 0) {
                    console.log("disable snooze button");
                    $('#alarm-snooze').attr("class", "btn btn-lg disabled").attr("onclick", "#");
                } else {
                    console.log("enable snooze button");
                    $('#alarm-snooze').attr("class", "btn btn-lg").attr("onclick", "snooze();");
                }
                $('#alarm-modal').modal('toggle');
            }, timers[timerIterator].snoozeLength * 1000);
        }
    }

    function clear() {
        var highestTimeout = setTimeout(";");
        for (var i = 0; i < highestTimeoutId; i++) {
            clearTimeout(i);
        }
    }
</script>