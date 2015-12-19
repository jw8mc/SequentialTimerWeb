var timerIterator;
var start;
var timers;
var formattedStart;
var alarmDate;

//initialization method, called when page loads
//accesses the page variable containing timers as JSON objects and processes them
$('document').ready(function() {
    console.log("In document ready!");

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

//creates the initial alarm
function firstTimeout() {
    console.log("in the first timeout function");
    $('.alarm-name').replaceWith("ALARM");
    $('#alarm-modal').modal('toggle');
}

//called by onclick event on alarm modal
//sets an alarm for the duration of the next sequential timer and changes the modal title to match
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
        }, timers[timerIterator].duration * 60 * 1000);
        timerIterator++;
    }
}

//called by onclick event on alarm modal button
//this button is disabled if snooze duration = 0 (but clicking on it anyways will break the timers, oops)
//sets an alarm for the current alarm title, delayed for the snooze duration
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
        }, timers[timerIterator].snoozeLength * 60 * 1000);
    }
}

//called by onclick event on alarm modal
//cancels all timers for that day - I'd like this to only be the current sequence but the code now does not
//permit that
function clear() {
    var highestTimeout = setTimeout(";");
    for (var i = 0; i < highestTimeoutId; i++) {
        clearTimeout(i);
    }
}