# simpleCleanTimer
This is a Java project which is based on creation of timers in the database and then using it later on for keeping a track of the cleaning activities.

The Api's that have been included in the project are:
1) /check/id
This endpint will fetch the Timer info as a TimerResponse object. The Object contains startVal (the counter value), stepVal(After how many seconds the counter should increment) and createTime (The time of creation of the timer).

2) /check 
This endpint will fetch all the Timers and their information from the database for the unique entries present in the database.
This response will be in a set of TimerResponse objects. The timer response object will be the same as the previous one i.e it will have startVal (the counter value), stepVal(After how many seconds the counter should increment) and createTime (The time of creation of the timer).

3) /pause/id
This endpint will pause the timer by changing the timer's pause_ind in the database to be true.
Once a timer is paused the mdified_time column corresponding to it, gets updated with the current timestamp.

4) /clear/id
This endpint will delete the timer from the database based on the id provided.

For designing the counter functionality, I have used triggers in the backend on insert and update queries.
For maintaining a record of the deleted timers, I have placed a trigger on the table. So before the delete operation happens the trigger will make sure that the timer entry is saved in another table.
I have implemented a sleep logic in the trigger itself so that every step_val seconds, the value of the row will be incremented.
