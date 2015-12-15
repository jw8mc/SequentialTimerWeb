var timerIterator;
var start;
var timers;
var formattedStart;
var alarmDate;

$('document').ready(function() {
    timerIterator = 0;
    start = "${start}";
    console.log("start " + start );

    timers = "${jsonTimers}";
    console.log("timers " + timers );
    formattedStart = start.replace(":", ", ");
    console.log("formattedStart " + formattedStart );

    alarmDate = new Date();
    alarmDate.setHours(formattedStart);

    setTimeout(firstTimeout, alarmDate.getTime() - new Date().getTime());
});

function firstTimeout() {
    console.log("in the first timeout function");
    $('.alarm-name').replaceWith("ALARM");
    $('#alarm-modal').modal('toggle');
}

function nextAlarm() {
    console.log("in the nextAlarm() function");
    console.log("timerIterate " + timerIterator );
    console.log("timers.size " + timers.size );
    if (!timerIterator > timers.size){
        console.log("in the nextAlarm loop for iterator " + timerIterator);
        setTimeout(function() {
            console.log("in the nextAlarm's timeout function");
            $('.alarm-name').replaceWith(timers[timerIterator].timerName);
            $('#alarm-modal').modal('toggle');
        }, timers[timerIterator].length);
        timerIterator++;
    }
}

function clear() {
    var highestTimeout = setTimeout(";");
    for (var i = 0; i < highestTimeoutId; i++) {
        clearTimeout(i);
    }
}