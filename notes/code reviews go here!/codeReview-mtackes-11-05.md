### Team Day's Code Review Checklist

Review by Michael Tackes  
November 5, 2015 ([point-in-time snapshot](https://github.com/jw8mc/SequentialTimerWeb/tree/4a4897320c068401c90c2443225ee863a0b207ca))

### Project Structure
| Metric | Measurement | Notes |
| :---------- | :----------: | :---------- |
| Classes are single-purpose | All |  |
| Proper file structure | Yes |  |
| Proper implementation of industry-standard high-level structure (or, appropriate separation of concerns) | Excellent | Not much to check on, but what's there is good. |

### Code Structure and Style
| Metric | Measurement | Notes |
| :---------- | :----------: | :---------- |
| No duplicate code | No | Timers share many common properties. Might be a good case for class hierarchy? |
| No dead/useless/lazy/unreachable code | No | Not everything is used yet, but that's mostly because of incomplete state of project. |
| Variables and methods have appropriate access modifiers | Yes |  |
| No hardcoded variables/magic numbers/strings | Yes | DAO/SQL stuff is hard coded, but I'm pretty sure a properties file isn't the right spot for it. |
| Readability | Excellent | Nothing difficult to understand so far. |
| Full, complete Javadoc for all classes and methods | most | Missing simple docs for getters/setters, `SessionFactoryProvider`. |
| Appropriate and descriptive variable and function names | good | Many DAO objects methods use two-letter variables. |
| Consistent formatting | Yes |  |
| Methods are concise and single-purpose | All | Not much code to check on so far. |
| Class constructors are present and appropriately implemented | All |  |

### Testing
| Metric | Measurement | Notes |
| :---------- | :----------: | :---------- |
| Code compiles with no errors or warnings | Yes |  |
| Appropriate use of logging | Poor | No logging at the moment. |
| No System.out.println use | Yes | |
| Testing for positive results | No | |
| Testing for negative resuts | No | |
| Testing for errors and exceptions | No | |
| Code coverage with tests | None |  |
