Problem: 

Design a Low latency Logging Framework

Logger Design

LogManager - Manages Logs (Singleton)

Logger - Logger instance.  (One per name)

Formatter - Log message format

Appender - writeLog

LoggingLevel - INFO, ERROR, WARNING etc. 

LogRecord - Contains log message and other info. (log context like caller etc...)


LogManager <Singleton>
-----------------------
map<String, Logger> loggerMap
Formatter formatter
LoggingLevel loggingLevel
----------------------------
getLogManager() <-- Returns Instance
getLogger(String name)
setFormatter(Formatter formatter)
getFormatter()
setLevel(LoggingLevel level)
getLevel()
=================================



Logger
------
String name
LoggingLevel level
Formatter formatter
List<Appender> appenders
--------------------
LOG(LoggingLevel level, String message)
INFO(String message)
DEBUG(String message)
WARNING(String message)
ERROR(String message)
addAppender(Appender appender)
========================================

Formatter
---------
---------
String format(LogRecord record)


Appender
-------
Formatter formatter
-------
void appendLog(LogRecord record)


LogRecord
---------
String message
String threadId
LoggingLevel level
String time;




How can we make it multithreaded?  Use Async publish to Appenders