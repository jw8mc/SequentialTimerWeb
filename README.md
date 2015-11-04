## Sequential Timer Application

With this individual project, I hope to create a sequential timer web application, with the goal of providing an easily configured staging environment for people who struggle with executive disfunction. This app would allow you to set alarms to go off in order, and set delay timers to give yourself time to complete the tasks before the next alarm begins.


### Planned Features
* Static (anchor) timers - set to go off at a specific time
* Sequential (achored) timers - set to go off an amount of time after a previous timer
* Snooze for all timers
* Tasks - a checkbox list of things to get done - Google Tasks API
	- add deadlines to some tasks - will create a static timer object for it
* Appointments - pull in events from Google Calendar API for today and upcoming week

### Future Goals
* Smart calculating of sequential timer snoozes - 1/5 of alloted time
* Smart recalculating of tasks lengths - can be used to adjust timer sequence if user-inputed values are way off
* One-time skip an alarm - immediately move on to next sequential alarm
* Absolute deadline alert - would replace the need for a final static alarm, instead base it off an upcoming Google event
* My own tasks functionality and along with it:
	* Saving completed tasks until end of day
	* Add tasks categories
		- shopping
		- chores
		- etc.
* Porting to other platforms (mobile, desktop)
	- Syncing between devices